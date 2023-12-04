package Distritos;

import Distritos.State.Normal;
import Distritos.State.State;

public class Tributo {

    private State estado;
    private String nombre;
    private String genero;
    private int distrito;
    private int hambre=3;

    // Constructor
    public Tributo(String nombre, String genero, int distrito, int hambre) {
        this.nombre = nombre;
        this.genero = genero;
        this.distrito = distrito;
        this.hambre = hambre;
        setState(new Normal());
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getDistrito() {
        return distrito;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    // Métodos

    
    //Patron de diseño state
    public void setState(State estado){
        this.estado = estado;
        this.estado.setTributo(this);
    }
    
    public State getState(){
        return this.estado;
    } 

    public void sobrevivir(){
        this.estado.sobrevivir();
    }

    
    public void comer(){
        this.estado.comer();
    }

    
    public void curarse(){
        this.estado.curarse();
    }

    
    public void defenderse(Tributo enemigo){
        this.estado.defenderse(enemigo);
    }

    
    public void escapar(Tributo enemigo){
        this.estado.escapar(enemigo);
    }

    
    public void morir(){
        this.estado.morir();
    }

    public void sufrirEvento(){
        this.estado.sufrirEvento();
    }

}

