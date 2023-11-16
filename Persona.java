public class Persona {
    private String nombre;
    private String caracteristicas;

    @Override
    public String toString(){
        return "Nombre: "+ nombre+
                "\nCaracteristicas: " + caracteristicas;
    }
}
