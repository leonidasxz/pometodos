/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author fcuevas
 */
public class MovimientoAprendido extends Movimiento {
    
    public MovimientoAprendido(){}
    public MovimientoAprendido(String nombre,String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
        int[] valorInicial = {5,5};
        this.PP = valorInicial;
        this.potencia = 21;
    }
    
}
