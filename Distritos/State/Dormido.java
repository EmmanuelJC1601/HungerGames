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
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
            jugador.setState(new Normal());
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void sobrevivir(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
            jugador.setState(new Normal());
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void comer(){
        int num = random.nextInt(2) + 1;
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " decidio ir a buscar comida");
            if(num==1){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " consiguio comida");
            }
            else{
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " no encontro nada");
                jugador.setState(new Hambriento());
            }
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void curarse(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
            jugador.setState(new Normal());
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void defenderse(Tributo enemigo){
        try {
            if (enemigo instanceof Profesional && jugador instanceof Profesional) {
                Thread.sleep(2000);
                System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sido traicionado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
                Thread.sleep(2000);
                System.out.println(enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" asesino a "+jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " mientras dormia ");
                jugador.setState(new Muerto());
                jugador.morir();
            }
            else {
                Thread.sleep(2000);
                System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" fue asesinado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" mientras dormia");
                jugador.setState(new Muerto());
                jugador.morir();
            }
        } catch (InterruptedException e) {
            // NADA
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
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha despertado");
            Thread.sleep(2000);
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sufrido el evento: ");
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
}
