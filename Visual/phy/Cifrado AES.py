import os
from cryptography.hazmat.primitives.ciphers.aead import AESGCM

# Contraseña
password = "MiContraseña123!"
password_bytes = password.encode()  # convierte a bytes
print(password_bytes)

clave = os.urandom(32)  # clave aleatoria de 32 bytes
print(clave)

iv = os.urandom(12)  # 12 bytes estándar para GCM
print(iv)

aesgcm = AESGCM(clave)
ciphertext = aesgcm.encrypt(iv, password_bytes, None)  # el tercer parámetro es 'associated_data', opcional
print(ciphertext)

blob = b'v10' + iv + ciphertext
print(blob)

blob_version = blob[:3]      # 'v10'
iv = blob[3:15]              # los 12 bytes siguientes
ciphertext = blob[15:]       # resto

aesgcm = AESGCM(clave)

decrypted_bytes = aesgcm.decrypt(iv, ciphertext, None)  # associated_data = None
password_original = decrypted_bytes.decode()  # convertir de bytes a string
print(password_original)
