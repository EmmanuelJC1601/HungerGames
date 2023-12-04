import java.util.*;

import Distritos.Tributo;

public class Presidente extends Vigilante {
    public void ejecutarEvento(ArrayList<Tributo> juegos_del_hambre){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int op=0;
        do {
            System.out.println("\n<---> Quiere ejecutar un evento aleatorio? <--->\n");
            System.out.println("1. SI");
            System.out.println("2. NO");
            System.out.print("> Opcion: ");
            try{
                op = scanner.nextInt();
                switch (op) {
                case 1:
                    int num=random.nextInt(juegos_del_hambre.size());
                    Tributo tributo = juegos_del_hambre.get(num);
                    tributo.sufrirEvento();
                    evento(tributo);
                    System.out.println("\n\n");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion Invalida. Intenta otra vez");
                    break;
            }
            } catch (InputMismatchException e) {
                System.out.println("Opcion Invalida. Intenta otra vez");
                scanner.nextLine();
            }
        } while (op!=1 && op!=2);
    }
}
