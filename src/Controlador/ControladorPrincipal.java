// MODIFICADO ULTIMA VEZ: FCA, 7/Oct, 3:19
// IMPORT MODELO POKEMON VA EN CONTROLADOR PKMN

package Controlador;

import Modelo.Batalla; // PRUEBA 
import Modelo.Entrenador;
import Modelo.Habilidad;
import Modelo.Pokemon;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {


    public static void main(String[] args) {
        System.out.println("Comienza a funcionar");
        ControladorPrincipal cPrincipal = new ControladorPrincipal();
        
        VistaPrincipal vPrincipal = new VistaPrincipal();
        
         
        
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
    public void simularBatalla()
    {}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
