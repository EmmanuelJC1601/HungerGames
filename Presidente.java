import java.io.*;
import java.util.*;

public class Presidente {
    
    public void iniciarJuegos(){
        
    }

    public void cosecha(){

        List<String> mujeres = leerNombresArchivo("nombresMujeres.txt");
        List<String> hombres = leerNombresArchivo("nombresHombres.txt");
        List<String> nombresMujeres = new ArrayList<>(mujeres);
        List<String> nombresHombres = new ArrayList<>(hombres);

        int distrito = 1;

        for (int i = 0; i < 13; i++) {

            Random random = new Random();
            int num = random.nextInt(0, 12 - i);

            System.out.println("-- Iniciando cosecha --");
            System.out.println("-- Distrito: " + distrito + " --");
            
            String mujer = mujeres.get(num);
            System.out.println("Mujer: " + mujer);
            mujeres.remove(num);

            String hombre = hombres.get(num);
            System.out.println("Hombre: " + hombre);
            hombres.remove(num);

            distrito++;
        }
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

}