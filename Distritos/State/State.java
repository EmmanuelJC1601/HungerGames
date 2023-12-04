package Distritos.State;
import Distritos.Tributo;

public interface State {
    void atacar(Tributo enemigo);
    void sobrevivir();
    void comer();
    void curarse();
    void defenderse(Tributo enemigo);
    void escapar(Tributo enemigo);
    void morir();
    void sufrirEvento();

    void setTributo(Tributo jugador);
}
