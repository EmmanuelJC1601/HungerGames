package Capitolio;

import Distritos.Profesional;
import Distritos.Tributo;

public class TributoFactoryImplements implements TributoFactory {
    
    @Override
    public Tributo crearTributo(String nombre, String genero, int distrito, int hambre) {
        return new Tributo(nombre, genero, distrito, hambre);
    }
       
    @Override
    public Profesional crearProfesional(String nombre, String genero, int distrito, int hambre) {
        return new Profesional(nombre, genero, distrito, hambre);
    }
}
