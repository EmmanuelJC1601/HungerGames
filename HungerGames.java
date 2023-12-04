import java.util.*;

import Distritos.Tributo;

public class HungerGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vigilante TistaCrane = new Vigilante();
        ArrayList<Tributo> juegos_del_hambre = null;
        int op=0;

        TistaCrane.presentacion();
        do {
            System.out.println("<---> Como se hara la cosecha <--->\n");
            System.out.println("1. Manual");
            System.out.println("2. Automatica (con archivos)");
            System.out.print("> Opcion: ");
            try{
                op = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcion Invalida. Intenta otra vez");
                scanner.nextLine();
            }
            switch (op) {
                case 1:
                    juegos_del_hambre = TistaCrane.cosechaManual();
                    break;
                case 2:
                    juegos_del_hambre = TistaCrane.cosecha();
                default:
                    System.out.println("Opcion Invalida. Intenta otra vez");
                    break;
            }
        } while (op!=1 && op!=2);
        
        TistaCrane.inicioJuegos(juegos_del_hambre);
        
        TistaCrane.victoria(juegos_del_hambre.get(0));
        scanner.close();
    }
}