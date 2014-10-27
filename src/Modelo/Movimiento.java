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
public abstract class Movimiento {
    public String tipo;
    public int potencia;
    public int precision;
    public int[] PP = new int[2]; //EN PP[0] PP's actuales, PP[1] PP's Máximos
    public int blanco;
    public String efectoSecundario;
    public String contacto;
    
    public Movimiento(){}
    public Movimiento(String tipo){
        this.tipo=tipo;
    }
    
}
