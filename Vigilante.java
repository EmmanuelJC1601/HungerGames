import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Vigilante {

    public Map<String, ArrayList<String>> cosecha() {
        Map<String, ArrayList<String>> tributosGenero = new HashMap<>();
        List<String> mujeres = leerNombresArchivo("nombresMujeres.txt");
        List<String> hombres = leerNombresArchivo("nombresHombres.txt");
        ArrayList<String> nombreMujeres = new ArrayList<>();
        ArrayList<String> nombreHombres = new ArrayList<>();

        int distrito = 1;
        Random random = new Random();

        System.out.println("-- Iniciando cosecha --");

        for (int i = 1; i < 13; i++) {
            int num = random.nextInt(13 - i);

            System.out.println("\n-- Distrito: " + i + " --");
            
            String mujer = mujeres.get(num);
            nombreMujeres.add(mujer);
            System.out.println("Mujer: " + mujer);
            mujeres.remove(num);

            String hombre = hombres.get(num);
            nombreHombres.add(hombre);
            System.out.println("Hombre: " + hombre);
            hombres.remove(num);

            distrito++;
        }

        tributosGenero.put("mujeres", nombreMujeres);
        tributosGenero.put("hombres", nombreHombres);
        return tributosGenero;
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
        /*Random num = new Random();
        int numeroJuegos = num.nextInt(31) + 50; // Números aleatorios entre 50 y 80
        System.out.printf("\nBienvenido a los %d° juegos del hambre\n", numeroJuegos);
        System.out.println("En este día más de cien mil espectadores y patrocinadores se han reunido con tal de ver solo a los tributos\n");
        NameTributos.verArchContenido("TributosM.poo", "TributosF.poo");
        System.out.println("Les deseamos felices juegos del hambre y que la suerte esté siempre de su lado\n");*/

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