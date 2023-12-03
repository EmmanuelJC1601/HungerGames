import java.util.Random;

public class Muerto implements State{
    
    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
    }

    @Override
    public void comer(){
    }

    @Override
    public void curarse(){
    }

    @Override
    public void defenderse(Tributo enemigo){
    }

    @Override
    public void escapar(Tributo enemigo){
    }

    @Override
    public void morir(){
    }

    @Override
    public void sufrirEvento(){
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
    /*
    public Tributo jugador;
    
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
    
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
    */
}
