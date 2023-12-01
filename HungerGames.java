import java.util.Scanner;

public class HungerGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NameTributos.crearTributos();
        Vigilante laCosecha = new Vigilante();
        laCosecha.cosecha();

        int opcion = 0;

        do {
            System.out.println("¿Cómo desea interactuar?");
            System.out.println("[1] Ser espectador");
            System.out.println("[2] Ser vigilante");
            System.out.println("[3] Salir de los Juegos");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer del escáner
                continue;
            }

            switch (opcion) {
                case 1:
                    serEspectador();
                    break;
                case 2:
                    serVigilante();
                    break;
                case 3:
                    System.out.println("Gracias por participar en los Juegos del Hambre. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void serEspectador() {
        // Implementa la lógica del espectador según sea necesario
        System.out.println("Eres un espectador. ¡Disfruta de los juegos!");
    }

    private static void serVigilante() {
        // Implementa la lógica del vigilante según sea necesario
        System.out.println("Eres un vigilante. ¡Controla los juegos!");
    }
}