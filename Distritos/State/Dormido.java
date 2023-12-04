package Distritos.State;
import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;

import Distritos.Profesional;
import Distritos.Tributo;

public class Dormido implements State{

    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
        jugador.setState(new Normal());
    }

    @Override
    public void sobrevivir(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
        jugador.setState(new Normal());
    }

    @Override
    public void comer(){
        int num = random.nextInt(2) + 1;
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " decidio ir a buscar comida");
        if(num==1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " consiguio comida");
            jugador.setState(new Normal());
        }
        else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " no encontro nada");
            jugador.setState(new Hambriento());
        }
    }

    @Override
    public void curarse(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
        jugador.setState(new Normal());
    }

    @Override
    public void defenderse(Tributo enemigo){
        if (enemigo instanceof Profesional && jugador instanceof Profesional) {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sido traicionado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            System.out.println(enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" asesino a "+jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " mientras dormia ");
            jugador.setState(new Muerto());
            jugador.morir();
        }
        else {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" fue asesinado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" mientras dormia");
            jugador.setState(new Muerto());
            jugador.morir();
        }
    }

    @Override
    public void escapar(Tributo enemigo){
    }

    @Override
    public void morir(){
    }

    @Override
    public void sufrirEvento(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sufrido el evento: ");
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }

    /*

    public void setTributo(Tributo jugador) {
        this.jugador = jugador;

        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                jugador.setState(new Normal());
            }
        }, 10000);
    }
    */

}
