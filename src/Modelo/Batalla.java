package Modelo;
import static java.lang.Math.random;
/**
 *
 * @author fcuevas
 */
public class Batalla {
    protected boolean funcionando;
    protected int tipoDeBatalla;
    protected Entrenador[] entrenadores = new Entrenador[2];
    private int turno;
    protected int tiempo;
    
    public Batalla(){
        funcionando = true;
        turno = 0;
    }
    public void iniciarBatalla(Pokemon pkmn1, Pokemon pkmn2){
        /*System.out.println("Se incia la batalla entre: "+pkmn1.getNombre()+" y "
        +pkmn2.getNombre());
        
        pkmn1.PV[0] = pkmn1.PV[1];
        pkmn2.PV[0] = pkmn2.PV[1];
        */
        
    }
    public String quienParte(Entrenador trainer1, Entrenador trainer2){
        double random1=1;
        double random2=1;
        while(random1==random2){
            random1=random();
            random2=random();
            if(random1>random2){
                return trainer1.getNombre();
            }
            else{
                return trainer2.getNombre();
            }
        }
        System.out.println(random1);
        System.out.println(random2); // REVISAR
        return "algo saliomal";
        
        
    }
    
    public boolean getFuncionando(){
        return this.funcionando;
    }
    public void setFuncionando(boolean funcionando) {
        System.out.println("Batalla online");
        this.funcionando = funcionando;
    }

    public int getTipoDeBatalla() {
        return tipoDeBatalla;
    }

    public void setTipoDeBatalla(int tipoDeBatalla) {
        this.tipoDeBatalla = tipoDeBatalla;
    }

    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenador[] entrenadores) {
        this.entrenadores = entrenadores;
    }

    public int getTurno() {
        return this.turno;
    }

    public void avanzarTurno(){
        if(this.turno>=1)
            turno=0;
        else
            turno++;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
            
   
