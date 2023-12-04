package Distritos.State;
import java.util.*;

import Distritos.Profesional;
import Distritos.Tributo;

public class Normal implements State{

    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ataca a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        enemigo.defenderse(jugador);
    }

    @Override
    public void sobrevivir(){
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" se esta moviendo");
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
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " va a dormir");
        jugador.setState(new Dormido());
    }

    @Override
    public void defenderse(Tributo enemigo){
        int num = random.nextInt(4) + 1;
        if (enemigo instanceof Profesional && jugador instanceof Profesional) {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sido traicionado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        }
        else {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" esta peleando con "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        }
        if(num==1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+", pero salió herido");
            jugador.setState(new Herido());
            enemigo.setState(new Muerto());
            enemigo.morir();
        }
        else if(num==2){
            jugador.escapar(enemigo);
        }
        else if(num==3){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" ileso");
            enemigo.setState(new Muerto());
            enemigo.morir();
        }
        else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue asesinado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            jugador.setState(new Muerto());
            jugador.morir();
        }
    }

    @Override
    public void escapar(Tributo enemigo){
        int num = random.nextInt(3) + 1;
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" escapa de "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        if(num==1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo ileso");
        }
        else if(num==2){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo herido");
            jugador.setState(new Herido());
        }
        else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " escapo herido pero lastimo a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            jugador.setState(new Herido());
            enemigo.setState(new Herido());
        }
    }

    @Override
    public void morir(){
        //System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha muerto");
    }

    @Override
    public void sufrirEvento(){
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sufrido el evento: ");
    }

    @Override
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
}
