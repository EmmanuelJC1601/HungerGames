
public interface TributoFactory {

    Tributo crearTributo(String nombre, String genero, int distrito, int vida, int hambre, int sed);
    Profesional crearProfesional(String nombre, String genero, int distrito, int vida, int hambre, int sed);
    
}   
