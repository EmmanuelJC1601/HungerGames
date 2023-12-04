package Distritos.State;
import java.util.Random;

import Distritos.Profesional;
import Distritos.Tributo;

public class Herido implements State{
    

    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " esta muy herido para ir a atacar.");
    }

    @Override
    public void comer(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " quiere comida pero esta herido");
        jugador.setState(new Hambriento());
    }

    @Override
    public void curarse(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se ha curado gracias a un patrocinador.");
        jugador.setState(new Normal());
    }

    @Override
    public void defenderse(Tributo enemigo){
        int num = random.nextInt(4) + 1;
        if (enemigo instanceof Profesional) {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" ha sido traicionado por "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        }
        else {
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" esta peleando con "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
        }
        if(num==1){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            enemigo.setState(new Muerto());
            enemigo.morir();
        }
        else if(num==2){
            jugador.escapar(enemigo);
        }
        else if(num==3){
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " y "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" se han matado mutuamente");
            jugador.setState(new Muerto());
            jugador.morir();
            enemigo.setState(new Muerto());
            enemigo.morir();
        }
        else{
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " estaba muy herido para defenderse de "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
            jugador.setState(new Muerto());
            jugador.morir();
        }
    }

    @Override
    public void escapar(Tributo enemigo){
        System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" intento escapar de "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+"pero no lo logro");
        jugador.setState(new Muerto());
        jugador.morir();
    }

    @Override
    public void morir(){
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fallecio por infeccion.");
        jugador.setState(new Muerto());
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
    Random random = new Random();
    
    public void atacar() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontro con ");
        int num = random.nextInt(2) + 1;

            if (jugador instanceof Profesional) {
                if(num==1){
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha ganado la batalla");
                }else{
                    
                }
            } else {
                
            }
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
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue picado por rastrevíspulas. Falleció");
        jugador.setState(new Muerto());
    }
    
    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }
    */
}