
public interface State {

    public void atacar();
    public void comer();
    public void curarse();
    public void defenderse();
    public void escapar();
    public void morir();

    public void setTributo(Tributo jugador);
    
}