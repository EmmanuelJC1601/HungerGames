import java.util.*;

public class HungerGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //NameTributos.crearTributos();
        Vigilante laCosecha = new Vigilante();

        Map<String, ArrayList<String>> listasTributos = laCosecha.cosecha();
        ArrayList<String> mujeres = listasTributos.get("mujeres");
        ArrayList<String> hombres = listasTributos.get("hombres");

        TributoFactoryImplements tributoFactory = new TributoFactoryImplements();

        // Itera sobre la lista de nombres de mujeres y crea objetos Tributo
        for (String nombreMujer : mujeres) {
            int i = 1;
            if(i==1 || i ==2 || i==4){
                Profesional profesional = tributoFactory.crearProfesional(nombreMujer, "Femenino", i, 100, 0, 0);
            }else{
                Tributo tributoMujer = tributoFactory.crearTributo(nombreMujer, "Femenino", i, 3, 0, 0);
            }
            i++;
        }

        // Itera sobre la lista de nombres de hombres y crea objetos Tributo
        for (String nombreHombre : hombres) {
            int i = 1;
            if(i==1 || i ==2 || i==4){
                Profesional profesional = tributoFactory.crearProfesional(nombreHombre, "Masculino", i, 3, 0, 0);
            }else{
                Tributo tributoHombre = tributoFactory.crearTributo(nombreHombre, "Masculino", i, 3, 0, 0);
            }
            i++;
        }

        int opcion = 0;

        do {
            System.out.println("<---><---><---><---><---| M E N U |---><---><---><---><--->\n");
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
        System.out.println("Eres un espectador. ¡Disfruta de los juegos!");
    }

    private static void serVigilante() {
        System.out.println("Eres un vigilante. ¡Controla los juegos!");
    }
}