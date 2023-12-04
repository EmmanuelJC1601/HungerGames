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
    public void comer(){
        int num = random.nextInt(2) + 1;
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " decidio ir a buscar comida");
        if(num==1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " consiguio comida");
        }
        else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " no encontro nada");
            jugador.setState(new Hambriento());
        }
    }

    @Override
    public void curarse(){
    }

    @Override
    public void defenderse(Tributo enemigo){
        if (enemigo instanceof Profesional) {
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
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }

    /*
    public void atacar() {
        int num = random.nextInt(2) + 1;
        
        if(num == 1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue asesinado por otro tributo mientra dormía");
            jugador.setState(new Muerto());
        }else{
            System.out.println("Le robaron comida y agua a " + jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " mientras dormía");
            jugador.setState(new Hambriento());
        }
    }

    public void comer() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " está dormido");
    }

    public void curarse() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " está dormido");
        //jugador.setState(new Normal());
    }

    public void defenderse() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " está dormido");
    }

    public void escapar() {
        int num = random.nextInt(2) + 1;
        if(num == 1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue capturado por otro tributo. Logró escapar, pero lo dejaron sin agua");
            if (jugador.getSed() > 0) {
                jugador.setSed(jugador.getSed() - 1);
                System.out.println(jugador.getNombre() + ". Nivel de sed: " + jugador.getSed());
                jugador.setState(new Hambriento());
            } else {
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " a muerto por falta de hidratación");
                jugador.setState(new Muerto());
            }
        }else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con otro tributo. Logró escapar, pero con muchas heridas");
                jugador.setState(new Herido());
        }
    }

    public void morir() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue asesinado con un cuchillo mientras dormía");
        jugador.setState(new Muerto());
    }

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
