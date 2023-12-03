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
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " decidió ir a buscar comida");
        jugador.setState(new Hambriento());
    }

    public void curarse() {
        int num = random.nextInt(2) + 1;

        if (jugador instanceof Profesional) {
            System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se fue a la cornocopia a conseguir armas");     

        } else {
            if(num==1){
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encuentra en el bosque mientras busca un lugar para dormir");
                jugador.setState(new Dormido());
            }else{
                System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " tuvo un accidente mientras trepaba un árbol");
                if (jugador.getVida() > 0) {
                        jugador.setVida(jugador.getVida() - 1);
                        System.out.println(jugador.getNombre() +". Vidas restantes: " + jugador.getVida());
                    } else {
                        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto por falta de vidas");
                        jugador.setState(new Muerto());
                    }
            }
        }
    }

    public void defenderse() {
        int num = random.nextInt(2) + 1;

            if (jugador instanceof Profesional) {
                if(num==1){
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con otro tributo, sin embargo, logró defenderse");
                }else{
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue traicionado por los aliados.");
                    if (jugador.getVida() > 0) {
                        jugador.setVida(jugador.getVida() - 1);
                        System.out.println(jugador.getNombre() + ". Vidas restantes: " + jugador.getVida());
                    } else {
                        System.out.println(jugador.getNombre() + " ha muerto");
                        jugador.setState(new Muerto());
                    }
                }
            } else {
                if(num==1){
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con otro tributo, pero logró defenderse");
                    jugador.setState(new Herido());
                }else{
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con un profesional y fue asesinado");
                    jugador.setState(new Muerto());
                }
            }
    }

    public void escapar() {
        int num = random.nextInt(2) + 1;

            if (jugador instanceof Profesional) {
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue traicionado por los aliados.");
                    if (jugador.getVida() > 0) {
                        jugador.setVida(jugador.getVida() - 1);
                        System.out.println(jugador.getNombre() + " logró escapar. Vidas restantes: " + jugador.getVida());
                    } else {
                        System.out.println(jugador.getNombre() + " ha muerto en batalla");
                        jugador.setState(new Muerto());
                    }
            }else {
                if(num==1){
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con otro tributo, sin embargo, logró escapar");
                    jugador.setState(new Herido());
                }else{
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontró con otro tributo y tuvo que dejar su comida para escapar");
                    if (jugador.getHambre() > 0) {
                        jugador.setHambre(jugador.getHambre() - 1);
                        System.out.println(jugador.getNombre() + ". Nivel de hambre: " + jugador.getHambre());
                    } else {
                        System.out.println(jugador.getNombre() + " por falta de comida");
                        jugador.setState(new Muerto());
                    }
                }
            }
    }

    public void morir() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " falleció por infección.");
        jugador.setState(new Muerto());
    }

    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }

}
