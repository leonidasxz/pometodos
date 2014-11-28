/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.util.ArrayList;

/**
 *
 * @author fcuevas
 */
public class ControladorPokemon {
    private ArrayList<ArrayList<String>> pokemones;
    
    public ControladorPokemon(ArrayList<ArrayList<String>> pokemones){
        this.pokemones = pokemones;
        
        
    }
    
    public ArrayList<ArrayList<String>> getPokemones(){
        System.out.println(this.pokemones);
        return this.pokemones;
        
    }
    
    
    
}
