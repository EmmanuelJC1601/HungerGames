package Distritos;
public class Profesional extends Tributo{

    public Profesional(String nombre, String genero, int distrito, int hambre) {
        super(nombre, genero, distrito, hambre);
    }

    public void atacar(Tributo enemigo){
        getState().atacar(enemigo);
    }

}
