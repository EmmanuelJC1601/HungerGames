public class Tributo {
    private String nombre;
    private String genero;
    private State estado;
    private double vida;
    private double hambre;
    private double sed;
    private String distrito;
    // private String arma;
    // private String ubicacion;
    // private int calificacion;

    // Constructor
    public Tributo(String nombre, String genero, double vida, double hambre, double sed, String distrito) {
        this.nombre = nombre;
        this.genero = genero;
        this.vida = vida;
        this.hambre = hambre;
        this.sed = sed;
        this.distrito = distrito;
        setState(new Normal());
    }

    //Patron de diseño state
    public Tributo(){
        setState(new Normal());
    }

    public void setState(State estado){
        this.estado = estado;
        this.estado.setTributo(this);
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

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

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

