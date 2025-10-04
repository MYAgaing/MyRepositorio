from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
import os
from cryptography.hazmat.primitives.ciphers.aead import AESGCM

password = "Miconstraseña123!"
password_bytes = password.encode()

# Texto plano
plaintext = password_bytes  # debe estar en bytes


# Clave de 32 bytes
key = os.urandom(32)

# Nonce de 12 bytes
nonce = os.urandom(16)

algorithm = algorithms.ChaCha20(key, nonce)
cipher = Cipher(algorithm, mode=None, backend=default_backend())
encryptor = cipher.encryptor()

ciphertext = encryptor.update(plaintext)
print("Ciphertext:", ciphertext)

decryptor = cipher.decryptor()
decrypted = decryptor.update(ciphertext)
print("Decrypted:", decrypted.decode())
