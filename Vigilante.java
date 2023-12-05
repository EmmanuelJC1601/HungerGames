import java.io.*;
import java.util.*;

import Capitolio.TributoFactoryImplements;
import Distritos.Profesional;
import Distritos.Tributo;
import Distritos.State.Hambriento;
import Distritos.State.Herido;
import Distritos.State.Muerto;
import Distritos.State.Normal;

public class Vigilante {

    public void presentacion(){
        System.out.println("\nConsiderando la insurreccion y desafio a la autoridad del Capitolio\n"+
                            "(no se entregaron la practicas a tiempo), se emite este decreto \n"+
                            "inaugural con el fin de establecer un recordatorio permanente de \n"+
                            "las consecuencias de cualquier intento de rebelion. Como todos los semestres\n"+
                            "se realiza otra emision de los juegos del hambre (entrega de calificaciones).\n\n"+
                            "\tPor orden y autoridad del Capitolio\n\tPresidente Edgar Tista Garcia\n\t"+
                            "Panem hoy, Panem mañana y Panem para siempre\n");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    public void inicioJuegos(ArrayList<Tributo> juegos_del_hambre){
        ArrayList<Tributo> fallecidos= new ArrayList<>();
        Random random = new Random();
        int num=0;
        boolean muerto;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("<---><---><---><---><---| Inician los juegos |---><---><---><---><--->\n");
        
        if(this instanceof Presidente){
            System.out.println("Usted es el Presidente, eso quiere decir que podra");
            System.out.println("manipular el desarrollo de los juegos.\n");
        }
        else{
            System.out.println("Usted es un Espectador, eso quiere decir que podra");
            System.out.println("ver el desarrollo de los juegos.\n");
        }
        

        System.out.println("\nDAN COMIENZO LOS JUEGOS DEL HAMBRE.\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            for (Tributo tributo : juegos_del_hambre) {
                if (tributo.getState() instanceof Muerto);
                else{
                    int accion = random.nextInt(4) + 1;
                    switch (accion) {
                        case 1:
                            if (tributo instanceof Profesional){
                                do{
                                    num=random.nextInt(juegos_del_hambre.size());
                                    muerto=(juegos_del_hambre.get(num).getState() instanceof Muerto);
                                }while((tributo==juegos_del_hambre.get(num)) && (muerto!=true));
                                ((Profesional)tributo).atacar(juegos_del_hambre.get(num));
                            }
                            else{
                                tributo.sobrevivir();
                            }
                            break;
                        case 2:
                            tributo.comer();
                            break;
                        case 3:
                            tributo.curarse();
                            break;
                        case 4:
                            tributo.sufrirEvento();
                            evento(tributo);
                            break;
                        default:
                            System.out.println("Tributo Paseando");
                            break;
                    }
                }
            }
            
            for (Tributo tributo : juegos_del_hambre) {
                if (tributo.getState() instanceof Muerto) {
                    fallecidos.add(tributo);
                }
            }

            for (Tributo tributo : fallecidos) {
                juegos_del_hambre.remove(tributo);
            }

            System.out.println("\nQuedan "+(juegos_del_hambre.size())+" tributos vivos\n");
            if ((juegos_del_hambre.size()) < 2) {
                break;
            }
            if(this instanceof Presidente){
                ((Presidente)this).ejecutarEvento(juegos_del_hambre);
            }
            else{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void victoria(Tributo tributo){
        try {
            Thread.sleep(1500);
            System.out.println("\n\tEl tributo ganador es "+tributo.getNombre()+
            "\n\tPerteneciente al distrito "+tributo.getDistrito());
            guardarGanadores(tributo);
            System.out.println("\n\t"+tributo.getNombre()+
            " se une a la lista de vencedores\n");
            verGanadores();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void guardarGanadores(Tributo tributo){
        PrintWriter fileOut;
        String vencedor = "Nombre: "+tributo.getNombre()+" Distrito: "+tributo.getDistrito()+ " Genero: "+tributo.getGenero();
		try{
			fileOut = new PrintWriter(new FileWriter("vencedores.txt", true));
            fileOut.println(vencedor);
			fileOut.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}
        catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
    }

    public void verGanadores(){
        Scanner fileIn;
        String line;
        System.out.println("\n\tVencedores actuales:\n");
        try {
            fileIn = new Scanner(new FileReader("vencedores.txt"));
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                Thread.sleep(1500);
                System.out.println(line);
            }
            fileIn.close();
        }
        catch (FileNotFoundException | InterruptedException e){
            //System.out.println("Error: " + e.getMessage());
        }

    }

    public ArrayList<Tributo> cosecha(){
        int op=0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("<---> Como se hara la cosecha <--->\n");
            System.out.println("1. Manual");
            System.out.println("2. Automatica (con archivos)");
            System.out.print("> Opcion: ");
            try{
                op = scanner.nextInt();
                switch (op) {
                case 1:
                    return cosechaManual();
                case 2:
                    return cosechaAutomatica();
                default:
                    System.out.println("Opcion Invalida. Intenta otra vez");
                    break;
            }
            } catch (InputMismatchException e) {
                System.out.println("Opcion Invalida. Intenta otra vez");
                scanner.nextLine();
            }
        } while (op!=1 && op!=2);
        return null;
    }

    
    public ArrayList<Tributo> cosechaAutomatica() {
        List<String> mujeres = leerNombresArchivo("nombresMujeres.txt");
        List<String> hombres = leerNombresArchivo("nombresHombres.txt");

        ArrayList<Tributo> hunger_games = new ArrayList<Tributo>();
        TributoFactoryImplements tributoFactory = new TributoFactoryImplements();

        try {
            Thread.sleep(1500);
            System.out.println("\n<---><---><---><---| Iniciando la Cosecha |---><---><---><--->\n");

            Thread.sleep(1500);
            System.out.printf("... .... ... Bienvenido a los 73° juegos del hambre ... .... ...\n");
            System.out.println("\nEn este dia mas de cien mil espectadores y patrocinadores se \nhan reunido con tal de ver solo a los tributos.");

            for (int i = 1; i < 13; i++) {
                Thread.sleep(1500);
                System.out.println("\nDel Distrito " + i);
                System.out.println("Las mujeres primero, como siempre ha sido:  "+ mujeres.get(i-1));
                System.out.println("Y ahora el varon: "+hombres.get(i-1));

                if(i == 1 || i == 2 || i == 4){
                    Profesional profesional_F = tributoFactory.crearProfesional(mujeres.get(i-1), "Femenino", i, 3);
                    Profesional profesional_M = tributoFactory.crearProfesional(hombres.get(i-1), "Masculino", i, 3);
                    hunger_games.add(profesional_F);
                    hunger_games.add(profesional_M);
                }else{
                    Tributo tributoMujer = tributoFactory.crearTributo(mujeres.get(i-1), "Femenino", i, 3);
                    Tributo tributoHombre = tributoFactory.crearTributo(hombres.get(i-1), "Masculino", i, 3);
                    hunger_games.add(tributoMujer);
                    hunger_games.add(tributoHombre);
                }
            }
            Thread.sleep(1500);
            System.out.println("\nLes deseamos felices juegos del hambre y que la suerte esté \nsiempre de su lado\n");
        } catch (InterruptedException e) {
            // NADA
        }
        return hunger_games;
    }

    public ArrayList<Tributo> cosechaManual() {
        ArrayList<Tributo> hunger_games = new ArrayList<Tributo>();
        TributoFactoryImplements tributoFactory = new TributoFactoryImplements();
        String tributoM;
        String tributoH;

        Scanner input = new Scanner(System.in);

        System.out.println("\n<---><---><---><---| Iniciando la Cosecha |---><---><---><--->\n");

        System.out.printf("... .... ... Bienvenido a los 73° juegos del hambre ... .... ...\n");
        System.out.println("\nEn este dia mas de cien mil espectadores y patrocinadores se \nhan reunido con tal de ver solo a los tributos.\n");

        for (int i = 1; i < 13; i++) {
            System.out.println("Registra los tributos Del Distrito " + i);
            System.out.print("Las mujeres primero, como siempre ha sido:  ");
            tributoM = input.nextLine();
            System.out.print("Y ahora el varon: ");
            tributoH = input.nextLine();

            if(i==1 || i ==2 || i==4){
                Profesional profesional_F = tributoFactory.crearProfesional(tributoM, "Femenino", i, 3);
                Profesional profesional_M = tributoFactory.crearProfesional(tributoH, "Masculino", i, 3);
                hunger_games.add(profesional_F);
                hunger_games.add(profesional_M);
            }else{
                Tributo tributoMujer = tributoFactory.crearTributo(tributoM, "Femenino", i, 3);
                Tributo tributoHombre = tributoFactory.crearTributo(tributoH, "Masculino", i, 3);
                hunger_games.add(tributoMujer);
                hunger_games.add(tributoHombre);
            }
        }
        System.out.println("Les deseamos felices juegos del hambre y que la suerte esté siempre de su lado\n");
        return hunger_games;
    }

    // Método para leer nombres desde un archivo y almacenarlos en una lista
    private static List<String> leerNombresArchivo(String nombreArchivo) {
        List<String> tributos = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(nombreArchivo))) {
            String lineaNombre;
            while ((lineaNombre = read.readLine()) != null) {
                tributos.add(lineaNombre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tributos;
    }

    public void evento(Tributo tributo) {
        try {
            int event = new Random().nextInt(6)+1;
            switch (event) {
                case 1:
                    donacion(tributo);
                    break;
                case 2:
                    mutos(tributo);
                    break;
                case 3:
                    incendio(tributo);
                    break;
                case 4:
                    tormenta(tributo);
                    break;
                case 5:
                    nieblaAcida(tributo);
                    break;
                case 6:
                    lluviaSangre(tributo);
                    break;
                default:
                    Thread.sleep(2000);
                    System.out.println("Ha pasado algo en la arena");
                    break;
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void donacion(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Ha recibido un arma por patrocinadores");
            }
            else if (tributo.getState() instanceof Hambriento){
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " ha comido gracias a un patrocinador.");
                tributo.setState(new Normal());
            }
            else if (tributo.getState() instanceof Herido){
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " se ha curado gracias a un patrocinador.");
                tributo.setState(new Normal());
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " fue despertado por el patrocinador.");
                tributo.setState(new Normal());
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void mutos(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Fue atacado por mutos, se encuentra herido");
                tributo.setState(new Herido());
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " no pudo huir de los mutos.");
                tributo.setState(new Muerto());
                tributo.morir();
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void incendio(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Sufrio quemaduras escapando del incendio, se encuentra herido");
                tributo.setState(new Herido());
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " no pudo huir del fuego.");
                tributo.setState(new Muerto());
                tributo.morir();
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void tormenta(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Fue afectado por la lluvia, se encuentra hambriento");
                tributo.setState(new Hambriento());
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " le impacto un rayo cerca, esta herido");
                tributo.setState(new Herido());
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void nieblaAcida(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Pudo escapar de la niebla acida");
                tributo.setState(new Herido());
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " no pudo huir de la niebla acida.");
                tributo.setState(new Muerto());
                tributo.morir();
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public void lluviaSangre(Tributo tributo) {
        try {
            if (tributo.getState() instanceof Normal){
                Thread.sleep(2000);
                System.out.println("Esta lleno de sangre pero es por la lluvia");
            }
            else{
                Thread.sleep(2000);
                System.out.println(tributo.getNombre() + " del Distrito: " + tributo.getDistrito() + " esta herido por el trauma de la sangre.");
                tributo.setState(new Herido());
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }
}