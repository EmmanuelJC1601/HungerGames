import java.util.*;

public class HungerGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vigilante TistaCraus = new Vigilante();
        Profesional Hard;
        Tributo Easy;

        ArrayList<Tributo> juegos_del_hambre = TistaCraus.cosecha();
        int opcion = 0;

        System.out.println("<---><---><---><---><---| Vigilante |---><---><---><---><--->\n");
        System.out.println("Usted es un Vigilante, eso quiere dicir que podrá controlar");
        System.out.println("como se irá desarollandose los juegos.");

        try {
            Thread.sleep(5000);
            do {
                Random random = new Random();
                int n_tri = random.nextInt(juegos_del_hambre.size());

                if(n_tri == 0 || n_tri == 1 || n_tri == 2 || n_tri == 3 || n_tri == 6 || n_tri == 7){
                    Hard = (Profesional) juegos_del_hambre.get(n_tri);
                    Hard.seleccionarEvento();

                    if(Hard.getState() instanceof Muerto){
                        juegos_del_hambre.remove(n_tri);
                    }

                }else{
                    Easy = (Tributo) juegos_del_hambre.get(n_tri - 1);
                    Easy.seleccionarEvento();

                    if(Easy.getState() instanceof Muerto){
                        juegos_del_hambre.remove(n_tri);
                    }
                }
                juegos_del_hambre.remove(n_tri);

                
            } while (juegos_del_hambre.size() != 1);
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // do {
            
        //     // try {
        //     //     opcion = scanner.nextInt();
        //     // } catch (java.util.InputMismatchException e) {
        //     //     System.out.println("Entrada no válida. Por favor, introduce un número.");
        //     //     scanner.next(); // Limpiar el buffer del escáner
        //     //     continue;
        //     // }

        //     switch (opcion) {
        //         case 1:
        //             serEspectador();
        //             break;

        //         case 3:
        //             System.out.println("Gracias por participar en los Juegos del Hambre. ¡Hasta luego!");
        //             break;
        //         default:
        //             System.out.println("La opción seleccionada no es válida.");
        //     }
        // } while (opcion != 3);

        scanner.close();
    }
}