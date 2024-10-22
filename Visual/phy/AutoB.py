import pyautogui
import keyboard
import time

# Mantener la tecla 'b' pulsada continuamente
def mantener_tecla_b():
    while True:
        # Si se presiona "Enter", se inicia o detiene el bucle
        if keyboard.is_pressed('space'):
            print("Bucle iniciado. Manteniendo 'b' pulsada.")
            while True:
                pyautogui.keyDown('b')  # Simula que la tecla 'b' está siendo presionada
                time.sleep(1)  # Mantiene la tecla 'b' pulsada (ajusta el tiempo si es necesario)

                # Si se presiona "Enter" nuevamente, se sale del bucle
                if keyboard.is_pressed('space'):
                    pyautogui.keyUp('b')  # Suelta la tecla 'b'
                    print("Bucle detenido.")
                    break  # Rompe el bucle interno y espera nueva pulsación de "Enter"

        time.sleep(1)  # Espera para evitar una sobrecarga de la CPU

# Llamada a la función
mantener_tecla_b()
def mantener_tecla_a():
    while True:
        # Si se presiona "Enter", se inicia o detiene el bucle
        if keyboard.is_pressed('space'):
            print("Bucle iniciado. Manteniendo 'a' pulsada.")
            while True:
                pyautogui.keyDown('a')  # Simula que la tecla 'b' está siendo presionada
                time.sleep(1)  # Mantiene la tecla 'b' pulsada (ajusta el tiempo si es necesario)

                # Si se presiona "Enter" nuevamente, se sale del bucle
                if keyboard.is_pressed('space'):
                    pyautogui.keyUp('a')  # Suelta la tecla 'b'
                    print("Bucle detenido.")
                    break  # Rompe el bucle interno y espera nueva pulsación de "Enter"

        time.sleep(1)  # Espera para evitar una sobrecarga de la CPU

# Llamada a la función
mantener_tecla_a()