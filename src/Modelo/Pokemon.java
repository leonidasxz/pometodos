// MODIFICADO ULTIMA VEZ: FCA, 13/Oct, 10:03
// REVISAR DIAGRAMA PARA VER ACCESO DE LOS ATRIBUTOS
// PUNTOS DE VIDA AGREGADO

package Modelo;

import java.util.ArrayList;


/**
 *
 * @author fcuevas
 */
public class Pokemon extends EspeciePokemon {
    
    private String nombre;
    private String especie;
    private int numPokedex;
    private int nivel;
    private Habilidad habilidad;
    private MovimientoAprendido[] movimientos = new MovimientoAprendido[4];
    protected String estado;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int experienciaActual;
    
    public int[] PV = new int[2];//EN PV[0] Vida actual, PV[1] Vida maxima
   
    

    public Pokemon() {
    }

    public Pokemon(String nombre, String especie, String naturalezaPrimaria, String naturalezaSecundaria, Habilidad habilidad, int numPokedex, int nivel) {
        this.nombre = nombre;
        this.especie = especie;
        this.naturalezaPrimaria = naturalezaPrimaria;
        this.naturalezaSecundaria = naturalezaSecundaria;
        this.habilidad = habilidad;
        this.numPokedex = numPokedex;
        this.nivel = nivel;
        this.PV[0] = 100;
        this.PV[1] = 100;
        
        System.out.println("A new :"+this.nombre+" has appeared");
    }
    
    
    public void usarMovimiento(){
        
    }
    
    public void usarHabilidad(){
   
    }
    public String mostrarEstado(){
        return this.estado;
    }
    
   
    
// GETTER Y SETTER, NO MODIFICAR
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNaturalezaPrimaria() {
        return naturalezaPrimaria;
    }

    public void setNaturalezaPrimaria(String naturalezaPrimaria) {
        this.naturalezaPrimaria = naturalezaPrimaria;
    }

    public String getNaturalezaSecundaria() {
        return naturalezaSecundaria;
    }

    public void setNaturalezaSecundaria(String naturalezaSecundaria) {
        this.naturalezaSecundaria = naturalezaSecundaria;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public MovimientoAprendido[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(MovimientoAprendido[] movimientos) {
        this.movimientos = movimientos;
    }

    public ArrayList<PosibleMovimiento> getPosiblesMovimientos() {
        return posiblesMovimientos;
    }

    public void setPosiblesMovimientos(ArrayList<PosibleMovimiento> posiblesMovimientos) {
        this.posiblesMovimientos = posiblesMovimientos;
    }
    
    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
            
}
