/*import java.io.*;
import java.util.*;

public class NameTributos implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String genero;
    private String distrito;

    public NameTributos(String nombre, String genero, String distrito) {
        this.nombre = nombre;
        this.genero = genero;
        this.distrito = distrito;
    } 

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public String getGenero() {
        return genero;
    }
    public String getDistrito() {
        return distrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    // Información
    public void display() {
        System.out.print(this.nombre + "\t");
        System.out.print(this.genero + "\t");
        System.out.println(this.distrito + "\n");
    }

    static void verArchContenido(String archM, String archF) {
        try (ObjectInputStream TriM = new ObjectInputStream(new FileInputStream(archM));
             ObjectInputStream TriF = new ObjectInputStream(new FileInputStream(archF))) {
    
            while (true) {
                try {
                    NameTributos tributo_m = (NameTributos) TriM.readObject();
                    NameTributos tributo_f = (NameTributos) TriF.readObject();
    
                    System.out.print("Representando al " + tributo_m.getDistrito());
                    System.out.print(" tenemos a " + tributo_f.getNombre());
                    System.out.println(" y a " + tributo_m.getNombre() + "\n");
    
                } catch (EOFException e) {
                    // Se alcanzó el final del archivo
                    break;
                }
            }
    
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private static void guardarArchivoContenido(ArrayList<NameTributos> cosecha, String namearch) {
        try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(namearch))) {
            for (NameTributos tributo : cosecha) {
                fileOut.writeObject(tributo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Añadir Tributos archivo
    static void crearTributos(){

        ArrayList<NameTributos> Masculino = new ArrayList<NameTributos>();
        ArrayList<NameTributos> Femenino = new ArrayList<NameTributos>();

        NameTributos tributoMD1 = new NameTributos("Santiago", "Masculino", "Distrito 1");
        NameTributos tributoFD1 = new NameTributos("Berenice", "Femenino", "Distrito 1");
        Masculino.add(tributoMD1);
        Femenino.add(tributoFD1);

        NameTributos tributoMD2 = new NameTributos("Eduardo", "Masculino", "Distrito 2");
        NameTributos tributoFD2 = new NameTributos("Nicole", "Femenino", "Distrito 2");
        Masculino.add(tributoMD2);
        Femenino.add(tributoFD2);

        NameTributos tributoMD3 = new NameTributos("Alfonso", "Masculino", "Distrito 3");
        NameTributos tributoFD3 = new NameTributos("Melissa", "Femenino", "Distrito 3");
        Masculino.add(tributoMD3);
        Femenino.add(tributoFD3);

        NameTributos tributoMD4 = new NameTributos("Tristan", "Masculino", "Distrito 4");
        NameTributos tributoFD4 = new NameTributos("Camila", "Femenino", "Distrito 4");
        Masculino.add(tributoMD4);
        Femenino.add(tributoFD4);

        NameTributos tributoMD5 = new NameTributos("Sebastian", "Masculino", "Distrito 5");
        NameTributos tributoFD5 = new NameTributos("Flora", "Femenino", "Distrito 5");
        Masculino.add(tributoMD5);
        Femenino.add(tributoFD5);

        NameTributos tributoMD6 = new NameTributos("Christian", "Masculino", "Distrito 6");
        NameTributos tributoFD6 = new NameTributos("Leslie", "Femenino", "Distrito 6");
        Masculino.add(tributoMD6);
        Femenino.add(tributoFD6);

        NameTributos tributoMD7 = new NameTributos("Javier", "Masculino", "Distrito 7");
        NameTributos tributoFD7 = new NameTributos("Carina", "Femenino", "Distrito 7");
        Masculino.add(tributoMD7);
        Femenino.add(tributoFD7);

        NameTributos tributoMD8 = new NameTributos("Luis", "Masculino", "Distrito 8");
        NameTributos tributoFD8 = new NameTributos("Paulina", "Femenino", "Distrito 8");
        Masculino.add(tributoMD8);
        Femenino.add(tributoFD8);

        NameTributos tributoMD9 = new NameTributos("Gabriel", "Masculino", "Distrito 9");
        NameTributos tributoFD9 = new NameTributos("Renata", "Femenino", "Distrito 9");
        Masculino.add(tributoMD9);
        Femenino.add(tributoFD9);

        NameTributos tributoMD10 = new NameTributos("Diego", "Masculino", "Distrito 10");
        NameTributos tributoFD10 = new NameTributos("Cristina", "Femenino", "Distrito 10");
        Masculino.add(tributoMD10);
        Femenino.add(tributoFD10);

        NameTributos tributoMD11 = new NameTributos("Emmanuel", "Masculino", "Distrito 11");
        NameTributos tributoFD11 = new NameTributos("Lucia", "Femenino", "Distrito 11");
        Masculino.add(tributoMD11);
        Femenino.add(tributoFD11);

        NameTributos tributoMD12 = new NameTributos("David", "Masculino", "Distrito 12");
        NameTributos tributoFD12 = new NameTributos("Silvana", "Femenino", "Distrito 12");
        Masculino.add(tributoMD12);
        Femenino.add(tributoFD12);

        guardarArchivoContenido(Masculino, "TributosM.poo");
        guardarArchivoContenido(Femenino, "TributosF.poo");
    }
}*/


