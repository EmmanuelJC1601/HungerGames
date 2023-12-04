

import java.io.*;
import java.util.*;

import Capitolio.TributoFactoryImplements;
import Distritos.Profesional;
import Distritos.Tributo;

public class Vigilante {

    public ArrayList<Tributo> cosecha() {
        List<String> mujeres = leerNombresArchivo("nombresMujeres.txt");
        List<String> hombres = leerNombresArchivo("nombresHombres.txt");

        ArrayList<Tributo> hunger_games = new ArrayList<Tributo>();
        TributoFactoryImplements tributoFactory = new TributoFactoryImplements();

        Random random = new Random();

        System.out.println("\n<---><---><---><---| Iniciando la Cosecha |---><---><---><--->\n");

        int numeroJuegos = random.nextInt(24) + 51; // Números aleatorios entre 51 y 74
        System.out.printf("... .... ... Bienvenido a los %d° juegos del hambre ... .... ...\n", numeroJuegos);
        System.out.println("\nEn este dia mas de cien mil espectadores y patrocinadores se \nhan reunido con tal de ver solo a los tributos.\n");

        for (int i = 1; i < 13; i++) {
            System.out.println("Del Distrito " + i);
            System.out.println("Las mujeres primero, como siempre ha sido:  "+ mujeres.get(i-1));
            System.out.println("Y ahora el varon: "+hombres.get(i-1));

            if(i==1 || i ==2 || i==4){
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
        System.out.println("\nLes deseamos felices juegos del hambre y que la suerte esté \nsiempre de su lado\n");

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