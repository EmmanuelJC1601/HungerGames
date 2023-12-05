package Distritos.State;
import java.util.*;

import Distritos.Profesional;
import Distritos.Tributo;

public class Normal implements State{

    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ataca a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            enemigo.defenderse(jugador);
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void sobrevivir(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" se esta moviendo");
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
            if(num == 1){
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
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " va a dormir");
            jugador.setState(new Dormido());
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void defenderse(Tributo enemigo){
        int num = random.nextInt(4) + 1;
        try {
            if (enemigo instanceof Profesional && jugador instanceof Profesional) {
                Thread.sleep(2000);
                System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sido traicionado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            }
            else {
                Thread.sleep(2000);
                System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" esta peleando con "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            }
            if(num==1){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+", pero salió herido");
                jugador.setState(new Herido());
                enemigo.setState(new Muerto());
                enemigo.morir();
            }
            else if(num==2){
                jugador.escapar(enemigo);
            }
            else if(num==3){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" ileso");
                enemigo.setState(new Muerto());
                enemigo.morir();
            }
            else{
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue asesinado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
                jugador.setState(new Muerto());
                jugador.morir();
            }
        } catch (InterruptedException e) {
            // NADA
        }
        
    }

    @Override
    public void escapar(Tributo enemigo){
        int num = random.nextInt(3) + 1;
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito()+" escapa de " + enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            if(num==1){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo ileso");
            }
            else if(num==2){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo herido");
                jugador.setState(new Herido());
            }
            else{
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo herido pero lastimo a " + enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
                jugador.setState(new Herido());
                enemigo.setState(new Herido());
            }
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void morir(){
        try {
            Thread.sleep(2000);
            //System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto");
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void sufrirEvento(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha sufrido el evento: ");
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
}
