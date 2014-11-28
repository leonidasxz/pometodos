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
    
    private int[] PV = new int[2];//EN PV[0] Vida actual, PV[1] Vida maxima
   
    

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
        movimientos[0] = new MovimientoAprendido("Placaje","normal");
        movimientos[1] = new MovimientoAprendido("Latigazo","normal");
        movimientos[2] = new MovimientoAprendido("Salto","electrico");
        movimientos[3] = new MovimientoAprendido("Llorar","agua");
    }
    
    //  Constructor usado en Torre de Batalla para generar pokemon al azar - rafael
    public Pokemon(int numPokedex, String especie, int ataque, int ataqueEspecial, 
            int defensa, int defensaEspecial, int PV, String naturalezaPrimaria,
            String naturalezaSecundaria){
        
        this.numPokedex = numPokedex;
        this.nombre = especie;
        this.especie = especie;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.PV[0] = PV;
        this.PV[1] = PV;
        this.naturalezaPrimaria = naturalezaPrimaria;
        this.naturalezaSecundaria = naturalezaSecundaria;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getExperienciaActual() {
        return experienciaActual;
    }

    public void setExperienciaActual(int experienciaActual) {
        this.experienciaActual = experienciaActual;
    }

    public int[] getPV() {
        return PV;
    }

    public void setPV(int[] PV) {
        this.PV = PV;
    }
    public void setPV(int PV){
        this.PV[0] = PV;
    }
            
}
