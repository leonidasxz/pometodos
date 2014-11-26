/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrenador;

/**
 *
 * @author fcuevas
 */
public class ControladorEntrenador {
    Entrenador entrenadorPrincipal;
    boolean tieneEquipo;
    
    public ControladorEntrenador(String nombre){
        entrenadorPrincipal = new Entrenador(nombre);
        
    }
}
