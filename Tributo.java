import java.util.*;

public class Tributo {

    private State estado;
    private String nombre;
    private String genero;
    private int distrito;
    private int vida=3;
    private int hambre=3;
    private int sed=3;

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

    public void atacar(Tributo enemigo){
        this.estado.atacar(enemigo);
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

    /* 

    public void seleccionarEvento(){
        Random evento = new Random(123);
        int num_evento = evento.nextInt(1,6);
        
        switch (num_evento) {
            case 1: // atacar
                estado.atacar();
                break;

            case 2: // comer
                estado.comer();
                break;

            case 3: // curarse
                if(estado instanceof Normal){
                    System.out.println("Tiene la salud máxima");
                }else{
                    System.out.println("Se está recuperando");
                }
                break;

            case 4: // defenderse
                
                break;

            case 5: //escapar
                
                break;
        }

    }
    */
}

