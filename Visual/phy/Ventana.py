import tkinter as tk

def sumar():
    try:
        num1 = float(entry1.get())
        num2 = float(entry2.get())
        resultado = num1 + num2
        etiqueta_resultado.config(text=f"Resultado: {resultado}")
    except ValueError:
        etiqueta_resultado.config(text="Error: Ingresa números válidos")

# Crear ventana
ventana = tk.Tk()
ventana.title("Mi primera ventana")
ventana.geometry("325x500")  # ancho x alto

entry1 = tk.Entry(ventana)
entry1.pack(pady=5)

entry2 = tk.Entry(ventana)
entry2.pack(pady=5)

# Botón de sumar
boton_sumar = tk.Button(ventana, text="Sumar", command=sumar)
boton_sumar.pack(pady=10)

# Etiqueta para mostrar el resultado
etiqueta_resultado = tk.Label(ventana, text="Resultado: ")
etiqueta_resultado.pack(pady=5)


# Mantener la ventana abierta
ventana.mainloop()
