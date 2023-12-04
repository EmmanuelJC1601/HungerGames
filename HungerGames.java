import java.util.*;

import Distritos.Tributo;

public class HungerGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vigilante TistaCrane = null;
        ArrayList<Tributo> juegos_del_hambre = null;
        int op=0;

        do {
            System.out.println("<---> Que tipo de usuario eres? <--->\n");
            System.out.println("1. Vigilante/Espectador");
            System.out.println("2. Presidente Edgar Tista");
            System.out.print("> Opcion: ");
            try{
                op = scanner.nextInt();
                switch (op) {
                case 1:
                    TistaCrane = new Vigilante();
                    break;
                case 2:
                    TistaCrane = new Presidente();
                    break;
                default:
                    System.out.println("Opcion Invalida. Intenta otra vez");
                    break;
            }
            } catch (InputMismatchException e) {
                System.out.println("Opcion Invalida. Intenta otra vez");
            }
        } while (op!=1 && op!=2);

        TistaCrane.presentacion();
        juegos_del_hambre=TistaCrane.cosecha();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TistaCrane.inicioJuegos(juegos_del_hambre);
        TistaCrane.victoria(juegos_del_hambre.get(0));
        scanner.close();
    }
}