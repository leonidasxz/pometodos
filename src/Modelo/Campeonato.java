    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author fcuevas
 */
public class Campeonato {
    
    protected ArrayList<Batalla> batallas = new ArrayList<Batalla>();
    
    public boolean comprobarMedalla(Entrenador trainer){
        if (8==trainer.getMedallas().length){
            return true;
        }
        else
            return false;
    }
    
}
