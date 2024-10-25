import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {

        // Clase Scanner
        Scanner sc = new Scanner(System.in);

        // Asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Bucles
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("Palabra a adivinar: "+ String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor: ");
            char letra = Character.toLowerCase(sc.next().charAt(0));

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta){
                intentos++;
                System.out.println("!!Incorrecto!! Te quedan " + (intentosMaximos-intentos) + " intentos.");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Felicidades. Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }
        if (!palabraAdivinada){
            System.out.println("Te has quedado sin intentos. GAME OVER");
        }
        // Se cierra el scanner para que no se qude a la escucha
        sc.close();
    }
}