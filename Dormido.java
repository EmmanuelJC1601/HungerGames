import java.util.Timer;
import java.util.TimerTask;

public class Dormido implements State{

    public Tributo jugador;
    
    public void atacar() {
        System.out.println(jugador.getNombre() + " del Distrito: " + jugador.getDistrito() + " fue asesinado por los profesionales mientras dormía");
        jugador.setState(new Hambriento());
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

    public void setTributo(Tributo jugador) {
        this.jugador = jugador;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                jugador.setState(new Normal());
            }
        }, 10000);
    }
}
