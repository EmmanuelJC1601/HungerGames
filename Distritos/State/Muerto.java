package Distritos.State;
import Distritos.Tributo;

public class Muerto implements State{
    
    private Tributo jugador;

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
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha muerto");
    }

    @Override
    public void sufrirEvento(){
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
}
