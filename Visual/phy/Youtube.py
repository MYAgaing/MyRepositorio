from pytube import YouTube
import os

# Función para descargar el video de YouTube
def descargar_video(url):
    try:
        # Crear objeto YouTube
        yt = YouTube(url)
        
        # Menú para que el usuario elija qué descargar
        print("¿Qué te gustaría descargar?")
        print("1. Video completo")
        print("2. Solo audio")
        print("3. Ambos")

        eleccion = input("Introduce el número de tu elección: ")

        if eleccion == "1":
            # Descargar solo el video
            descargar_video_completo(yt)
        elif eleccion == "2":
            # Descargar solo el audio
            descargar_audio(yt)
        elif eleccion == "3":
            # Descargar ambos, video y audio
            descargar_video_completo(yt)
            descargar_audio(yt)
        else:
            print("Opción no válida.")
    
    except Exception as e:
        print(f"Ocurrió un error: {e}")

# Función para descargar solo el video
def descargar_video_completo(yt):
    try:
        print(f"Descargando video: {yt.title}")
        stream = yt.streams.get_highest_resolution()
        stream.download()
        print("Video descargado exitosamente.")
    except Exception as e:
        print(f"Ocurrió un error al descargar el video: {e}")

# Función para descargar solo el audio
def descargar_audio(yt):
    try:
        print("Extrayendo el audio...")
        # Obtener el primer stream de audio disponible
        audio_stream = yt.streams.filter(only_audio=True).first()

        if audio_stream is None:
            raise Exception("No se encontró un stream de solo audio para este video.")
        
        out_file = audio_stream.download()

        # Renombrar el archivo para que tenga la extensión .mp3
        base, ext = os.path.splitext(out_file)
        new_file = base + '.mp3'
        os.rename(out_file, new_file)
        print(f"Audio descargado como: {new_file}")
    
    except Exception as e:
        print(f"Ocurrió un error al descargar el audio: {e}")

# URL del video que deseas descargar
url_video = input("Introduce la URL del video de YouTube: ")

# Llamar a la función para descargar lo que el usuario elija
descargar_video(url_video)
