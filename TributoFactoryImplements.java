public class TributoFactoryImplements implements TributoFactory {
    @Override
    public Tributo crearTributo(String nombre, String genero, int distrito, int vida, int hambre, int sed) {
        return new Tributo(nombre, genero, distrito, vida, hambre, sed);
    }
       
    @Override
    public Profesional crearProfesional(String nombre, String genero, int distrito, int vida, int hambre, int sed) {
        return new Profesional(nombre, genero, distrito, vida, hambre, sed);
    }
}
