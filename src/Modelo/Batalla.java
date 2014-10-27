package Modelo;
import static java.lang.Math.random;
/**
 *
 * @author fcuevas
 */
public class Batalla {
    public int tipoDeBatalla;
    public Entrenador[] entrenadores = new Entrenador[2];
    
    public void iniciarBatalla(Pokemon pkmn1, Pokemon pkmn2){
        System.out.println("Se incia la batalla entre: "+pkmn1.getNombre()+" y "
        +pkmn2.getNombre());
        
        pkmn1.PV[0] = pkmn1.PV[1];
        pkmn2.PV[0] = pkmn2.PV[1];
        
        
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
            
    
}
