public class Tributo extends NameTributos{

    private State estado;
    private double vida;
    private double hambre;
    private double sed;
    // private String arma;
    // private String ubicacion;
    // private int calificacion;

    // Constructor
    public Tributo(String nombre, String genero, String distrito, double vida, double hambre, double sed) {
        super(nombre, genero, distrito);
        this.vida = vida;
        this.hambre = hambre;
        this.sed = sed;
    }

    //Patron de diseño state
    // public Tributo(){
    //     setState(new Normal());
    // }

    public void setState(State estado){
        this.estado = estado;
        this.estado.setTributo(this);
    }

    // Getters and Setters
    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getHambre() {
        return hambre;
    }

    public void setHambre(double hambre) {
        this.hambre = hambre;
    }

    public double getSed() {
        return sed;
    }

    public void setSed(double sed) {
        this.sed = sed;
    }

    // Métodos
    public void atacar() {
        
    }

    public void comer() {
        
    }

    public void curarse() {
        
    }

    public void defenderse() {
        
    }

    public void escapar() {
        
    }

    public void morir() {
        
    }
}

