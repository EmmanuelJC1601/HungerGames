
public interface State {

    public void atacar();

    public void morir();

    public void incendio();

    public void tormenta();
    
    public void nieblaAcida();

    public void lluviaSangre();
    
    /*public void normal();
    public void dormido();
    public void hambriento();
    public void herido();
    public void luchando();
    public void muerto();*/

    public void setTributo(Tributo tributo);
    
}
