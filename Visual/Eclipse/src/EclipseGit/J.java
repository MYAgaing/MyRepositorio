package EclipseGit;
public class J {
    public static void main(String[] args) {
        String frase = "Hola mundo, esto es un ejemplo.";

        // Separar la frase por espacios
        String[] palabras = frase.split(" ");
        
        // Verificamos que haya al menos dos espacios
        if (palabras.length < 3) {
            System.out.println("No hay suficientes palabras para encontrar el segundo espacio.");
            return;
        }

        // Calcular la posición del segundo espacio
        int posicionSegundoEspacio = 0;
        for (int i = 0; i < palabras.length - 1; i++) {
            // Sumar la longitud de la palabra y un espacio
            posicionSegundoEspacio += palabras[i].length() + 1;
        }

        // Imprimir la posición del segundo espacio
        System.out.println("La posición del segundo espacio es: " + posicionSegundoEspacio);
    }
}
