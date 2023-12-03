import java.io.*;
import java.util.*;

public class Vigilante {

    public ArrayList<Tributo> cosecha() {
        List<String> mujeres = leerNombresArchivo("nombresMujeres.txt");
        List<String> hombres = leerNombresArchivo("nombresHombres.txt");
        ArrayList<String> nombreMujeres = new ArrayList<>();
        ArrayList<String> nombreHombres = new ArrayList<>();

        ArrayList<Tributo> hunger_games = new ArrayList<Tributo>();
        TributoFactoryImplements tributoFactory = new TributoFactoryImplements();

        Random random = new Random();

        System.out.println("\n<---><---><---><---| Iniciando la Cosecha |---><---><---><--->\n");

        int numeroJuegos = random.nextInt(31) + 50; // Números aleatorios entre 50 y 80
        System.out.printf("... .... ... Bienvenido a los %d° juegos del hambre ... .... ...\n", numeroJuegos);
        System.out.println("\nEn este día más de cien mil espectadores y patrocinadores se \nhan reunido con tal de ver solo a los tributos.\n");

        for (int i = 1; i < 13; i++) {
            int num = random.nextInt(13 - i);

            //System.out.println("\n-- Distrito: " + i + " --");
            System.out.print("Representando al Distrito " + i);

            String mujer = mujeres.get(num);
            nombreMujeres.add(mujer);
            System.out.print(" tenemos a " + mujer);
            //System.out.println("Mujer: " + mujer);
            mujeres.remove(num);

            String hombre = hombres.get(num);
            nombreHombres.add(hombre);
            System.out.println(" y a " + hombre + "\n");
            //System.out.println("Hombre: " + hombre);
            hombres.remove(num);

            if(i==1 || i ==2 || i==4){
                Profesional profesional_F = tributoFactory.crearProfesional(mujer, "Femenino", i, 100, 0, 0);
                Profesional profesional_M = tributoFactory.crearProfesional(hombre, "Masculino", i, 3, 0, 0);
                hunger_games.add(profesional_F);
                hunger_games.add(profesional_M);
            }else{
                Tributo tributoMujer = tributoFactory.crearTributo(mujer, "Femenino", i, 3, 0, 0);
                Tributo tributoHombre = tributoFactory.crearTributo(hombre, "Masculino", i, 3, 0, 0);
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

    public void donacion() {
        // Implementación según sea necesario
    }

    public void mutos() {
        // Implementación según sea necesario
    }

    public void incendio() {
        // Implementación según sea necesario
    }

    public void tormenta() {
        // Implementación según sea necesario
    }

    public void nieblaAcida() {
        // Implementación según sea necesario
    }

    public void lluviaSangre() {
        // Implementación según sea necesario
    }
}