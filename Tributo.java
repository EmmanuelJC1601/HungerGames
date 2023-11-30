public class Tributo extends Persona{
    private State estado;
    private double vida;
    private double hambre;
    private double sed;
    private String distrito;
    //private String arma;
    //private String ubicacion;
    //private int calificacion;

    //Patron de diseño state
    public Tributo(){
        setState(new Normal());
    }

    public void setState(State estado){
        this.estado = estado;
        this.estado.setTributo(this);
    }

    // Constructor
    public Tributo(State estado, double vida, double hambre, double sed, String distrito) {
        this.estado = estado;
        this.vida = vida;
        this.hambre = hambre;
        this.sed = sed;
        this.distrito = distrito;
    }

    // Setters
    public void setEstado(State estado) {
        this.estado = estado;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setHambre(double hambre) {
        this.hambre = hambre;
    }

    public void setSed(double sed) {
        this.sed = sed;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    // Getters
    public State getEstado() {
        return estado;
    }

    public double getVida() {
        return vida;
    }

    public double getHambre() {
        return hambre;
    }

    public double getSed() {
        return sed;
    }

    public String getDistrito() {
        return distrito;
    }
}
