import java.util.*;

public class Normal implements State{
    private Tributo jugador;
    Random random = new Random();

    //obtenerListaTributosDesdeElMain
    ArrayList<Tributo> listaTributos = TributosMain();
    Tributo tributoEnemigo = TributoAleatorio(listaTributos, jugador);
    

    public void atacar() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " se encontro con ");
        int num = random.nextInt(2) + 1;

            if (jugador instanceof Profesional) {
                if(num==1){
                    System.out.println(jugador.getNombre() + " ha ganado la batalla contra ");
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
                    System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " ha muerto en batalla");
                    jugador.setState(new Muerto());
                }
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
        
    }

    public void setTributo(Tributo jugador){
        this.jugador = jugador;
    }

}
