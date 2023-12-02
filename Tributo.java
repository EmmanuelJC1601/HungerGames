public class Tributo extends NameTributos{

    private State estado;
    private int vida;
    private int hambre;
    private int sed;
    // private String arma;
    // private String ubicacion;
    // private int calificacion;

    // Constructor
    public Tributo(String nombre, String genero, String distrito, int vida, int hambre, int sed) {
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

