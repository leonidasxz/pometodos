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
    public Movimiento usarMovimiento(Movimiento apretado){
        return apretado;            
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int[] getPP() {
        return PP;
    }

    public void setPP(int[] PP) {
        this.PP = PP;
    }

    public int getBlanco() {
        return blanco;
    }

    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    public String getEfectoSecundario() {
        return efectoSecundario;
    }

    public void setEfectoSecundario(String efectoSecundario) {
        this.efectoSecundario = efectoSecundario;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
