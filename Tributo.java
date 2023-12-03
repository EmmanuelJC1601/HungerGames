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

    //Constructor implementando Abstract Factory
    /*public Tributo(TributoFactory factory, String nombre, String genero, int distrito, int vida, int hambre, int sed) {          
        Tributo nuevoTributo = factory.crearTributo(nombre, genero, distrito, vida, hambre, sed);
        this.estado = new Normal(); 
    }*/ 

    // Constructor
    public Tributo(String nombre, String genero, int distrito, int vida, int hambre, int sed) {
        this.nombre = nombre;
        this.genero = genero;
        this.distrito = distrito;
        this.vida = vida;
        this.hambre = hambre;
        this.sed = sed;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    // Métodos
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

    public void morir() {
        this.estado.morir();
    }
}

