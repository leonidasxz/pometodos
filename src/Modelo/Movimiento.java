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
    protected String nombre;
    protected String tipo;
    protected int potencia;
    protected int precision;
    protected int[] PP = new int[2]; //EN PP[0] PP's actuales, PP[1] PP's Máximos
    protected int blanco;
    protected String efectoSecundario;
    protected String contacto;
    
    public Movimiento(){}
    public Movimiento(String nombre,String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    
}
