import java.util.Random;

public class Herido implements State{
    

    private Tributo jugador;
    Random random = new Random();

    @Override
    public void atacar(Tributo enemigo){
    }

    @Override
    public void comer(){
    }

    @Override
    public void curarse(){
    }

    @Override
    public void defenderse(Tributo enemigo){
    }

    @Override
    public void escapar(Tributo enemigo){
    }

    @Override
    public void morir(){
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
