import java.util.*;

public class Normal implements State{
    public Tributo jugador;
    Random random = new Random();

    public void atacar() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontro con otro tributo");
        int num = random.nextInt(2) + 1;

            if (jugador instanceof Profesional) {
                if(num==1){
                    System.out.println(jugador.getNombre() + " ha ganado la batalla");
                }else{
                    if (jugador.getVida() > 0) {
                        jugador.setVida(jugador.getVida() - 1);
                        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha perdido la batalla. Vidas restantes: " + jugador.getVida());
                    } else {
                        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto en batalla");
                        jugador.setState(new Muerto());
                    }
                }
            } else {
                if(num==1){
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha ganado la batalla");
                }else{
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto en batalla");
                    jugador.setState(new Muerto());
                }
            }
    }

    public void comer() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " está buscando comida");
        jugador.setState(new Hambriento());
    }

    public void curarse() {
        int num = random.nextInt(2) + 1;

        if (jugador instanceof Profesional) {
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " tuvo un accidente");     

        } else {
            if(num==1){
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha ganado la batalla");
            }else{
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto en batalla");
                jugador.setState(new Muerto());
            }
        }
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

}
