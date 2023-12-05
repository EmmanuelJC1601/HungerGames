package Distritos.State;
import java.util.Random;

import Distritos.Profesional;
import Distritos.Tributo;

public class Hambriento implements State{
    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " no tiene energia para ir a atacar.");
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void sobrevivir(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " debe comer pronto o morira.");
            comer();
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
                jugador.setState(new Normal());
                jugador.setHambre(3);
            }
            else{
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " no encontro nada");
                if(jugador.getHambre()==0){
                    jugador.morir();
                    jugador.setState(new Muerto());
                }
                else{
                    jugador.setHambre(jugador.getHambre()-1);
                }
            }
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void curarse(){
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
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " logro asesinar a "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
                enemigo.setState(new Muerto());
                enemigo.morir();
            }
            else if(num==2){
                jugador.escapar(enemigo);
            }
            else if(num==3){
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " y "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+" se han matado mutuamente");
                jugador.setState(new Muerto());
                jugador.morir();
                enemigo.setState(new Muerto());
                enemigo.morir();
            }
            else{
                Thread.sleep(2000);
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " estaba muy cansado para defenderse de "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito());
                jugador.setState(new Muerto());
                jugador.morir();
            }
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void escapar(Tributo enemigo){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre()+" del Distrito: " + jugador.getDistrito()+" intento escapar de "+enemigo.getNombre()+" del Distrito: " + enemigo.getDistrito()+", pero no lo logro");
            jugador.setState(new Muerto());
            jugador.morir();
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void morir(){
        try {
            Thread.sleep(2000);
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " murio de inanicion");
        } catch (InterruptedException e) {
            // NADA
        }
    }

    @Override
    public void sufrirEvento(){
        try {
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
