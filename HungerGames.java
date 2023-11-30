import java.util.Scanner;

public class HungerGames {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Presidente laCosecha = new Presidente();
        laCosecha.cosecha();

        int opcion;

        do {
            System.out.println("¡Bienvenido a los septuagésimo cuartos Juegos del Hambre!");
            System.out.println("1. Ser espectador");
            System.out.println("2. Ser vigilante");
            System.out.println("3. Salir de los Juegos");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    
                    break;
                case 2:
                    
                    
                    break;
                case 3:
                    
                    
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

}