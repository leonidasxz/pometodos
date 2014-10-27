// MODIFICADO ULTIMA VEZ: FCA, 7/Oct, 3:19
// IMPORT MODELO POKEMON VA EN CONTROLADOR PKMN

package Controlador;

import Modelo.Batalla; // PRUEBA 
import Modelo.Entrenador;
import Modelo.Habilidad;
import Modelo.Pokemon;

public class ControladorPrincipal {


    public static void main(String[] args) {
        System.out.println("Comienza a funcionar");
        
        Entrenador ash = new Entrenador("ash");
        Entrenador blu = new Entrenador("blu");
        Habilidad ninguna = new Habilidad();
        Habilidad todas = new Habilidad();
        Pokemon imbecil = new Pokemon("imbecil", "pikachu","feo","tonto",ninguna,1,1);
        Pokemon tontito = new Pokemon("tontito", "charminder","feo","estupido",todas,2,3);
        Batalla primeraBatalla= new Batalla();
        
        primeraBatalla.iniciarBatalla(tontito, imbecil);
        System.out.println(blu.getNombre());
        String nombrequeparte = primeraBatalla.quienParte(ash,blu);
        
        System.out.println("Parte: "+nombrequeparte);
        
        
        
        System.out.println("Tu pokemon se llama:"+" "+imbecil.getNombre());
        System.out.println("Es de la especie: "+imbecil.getEspecie());
        System.out.println("Tiene naturaleza primaria: "+imbecil.getNaturalezaPrimaria());
        
    }
    
}
