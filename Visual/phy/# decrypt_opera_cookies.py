# decrypt_opera_cookies.py
import os
import json
import base64
import sqlite3
from Crypto.Cipher import AES
import win32crypt    # pywin32

def get_master_key(local_state_path):
    with open(local_state_path, 'r', encoding='utf-8') as f:
        local_state = json.load(f)
    enc_key_b64 = local_state["os_crypt"]["encrypted_key"]
    enc_key = base64.b64decode(enc_key_b64)
    # En Chromium el prefijo suele ser "DPAPI"
    if enc_key.startswith(b"DPAPI"):
        enc_key = enc_key[5:]
    # Desencriptar la clave maestra con DPAPI (Windows)
    master_key = win32crypt.CryptUnprotectData(enc_key, None, None, None, 0)[1]
    return master_key

def decrypt_encrypted_value(encrypted_value, master_key):
    if encrypted_value.startswith(b'v10'):
        iv = encrypted_value[3:15]  # 12 bytes nonce
        ciphertext = encrypted_value[15:]  # ciphertext + tag
        cipher = AES.new(master_key, AES.MODE_GCM, nonce=iv)
        try:
            decrypted = cipher.decrypt_and_verify(ciphertext[:-16], ciphertext[-16:])
            return decrypted.decode('utf-8', errors='replace')
        except Exception as e:
            return f"[ERROR decrypt v10] {e}"
    else:
        try:
            return win32crypt.CryptUnprotectData(encrypted_value, None, None, None, 0)[1].decode()
        except Exception as e:
            return f"[ERROR DPAPI] {e}"

def main():
    # ⚠️ Cambia esta ruta a la carpeta donde guardaste tu copia
    profile_folder = r"C:\Users\nicol\Documents\SQL\Cookies"
    
    local_state = os.path.join(profile_folder, "Local State")
    cookies_db = os.path.join(profile_folder, "Cookies")

    if not os.path.exists(local_state) or not os.path.exists(cookies_db):
        print("❌ No encontré Local State o Cookies en la ruta indicada.")
        print("Ruta usada:", profile_folder)
        return

    master_key = get_master_key(local_state)
    print("✅ Master key obtenida (longitud):", len(master_key))

    conn = sqlite3.connect(cookies_db)
    cursor = conn.cursor()
    try:
        cursor.execute("SELECT host_key, name, value, encrypted_value, path, expires_utc FROM cookies")
    except sqlite3.OperationalError as e:
        print("❌ Error abriendo tabla cookies:", e)
        return

    for host, name, value, encrypted_value, path, expires in cursor.fetchall():
        if value:
            val = value
        else:
            val = decrypt_encrypted_value(encrypted_value, master_key)
        print(f"{host} | {name} -> {val}  (path: {path}, exp: {expires})")

    conn.close()

if __name__ == "__main__":
    main()