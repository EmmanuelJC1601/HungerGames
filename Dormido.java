import java.util.Timer;
import java.util.TimerTask;

public class Dormido implements State{

    private Tributo jugador;
    
    public void atacar() {
        
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
