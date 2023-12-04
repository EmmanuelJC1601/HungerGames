package Capitolio;

import Distritos.Profesional;
import Distritos.Tributo;

public interface TributoFactory {

    Tributo crearTributo(String nombre, String genero, int distrito, int hambre);
    Profesional crearProfesional(String nombre, String genero, int distrito, int hambre);
    
}   
