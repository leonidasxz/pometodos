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

public abstract class EspeciePokemon {
    private String nombre;
    protected String naturalezaPrimaria;
    protected String naturalezaSecundaria;
    protected ArrayList<PosibleMovimiento> posiblesMovimientos = new 
        ArrayList<PosibleMovimiento>();
    
    public PosibleMovimiento restriccionMovimientos(String nombre){
        PosibleMovimiento hola = new PosibleMovimiento();
        return hola;
    }
    
    

    
}
