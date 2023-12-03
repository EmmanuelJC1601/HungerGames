import java.util.*;

public class Tributo {

    private State estado;
    private String nombre;
    private String genero;
    private int distrito;
    private int vida;
    private int hambre;
    private int sed;

    // private String arma;
    // private String ubicacion;
    // private int calificacion;

    // Constructor
    public Tributo(String nombre, String genero, int distrito, int vida, int hambre, int sed) {
        this.nombre = nombre;
        this.genero = genero;
        this.distrito = distrito;
        this.vida = vida;
        this.hambre = hambre;
        this.sed = sed;
        setState(new Normal());
    }

    //Patron de diseño state
    public void setState(State estado){
        this.estado = estado;
        this.estado.setTributo(this);
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getSed() {
        return sed;
    }

    public void setSed(int sed) {
        this.sed = sed;
    }

    public State getState(){
        return this.estado;
    } 

    // public void setNombre(String nombre) {
    //     this.nombre = nombre;
    // }

    // public void setGenero(String genero) {
    //     this.genero = genero;
    // }

    // public void setDistrito(int distrito) {
    //     this.distrito = distrito;
    // }

    // Métodos
    public void seleccionarEvento(){
        Random evento = new Random(123);
        int num_evento = evento.nextInt(1,6);
        
        switch (num_evento) {
            case 1:
                
                break;

            case 2:
                
                break;

            case 3:
                
                break;

            case 4:
                
                break;

            case 5:
                
                break;
        }

    }

    public void atacar() {
        this.estado.atacar();
    }

    public void comer() {
        this.estado.comer();
    }

    public void curarse() {
        this.estado.curarse();
    }

    public void defenderse() {
        this.estado.defenderse();
    }

    public void escapar() {
        this.estado.escapar();
    }
}

