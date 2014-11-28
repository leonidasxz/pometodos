// MODIFICADO ULTIMA VEZ: FCA, 7/OCT, 3:40
// REVISAR ATRIBUTOS SEGUN DIAGRAMA DE CLASES

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author fcuevas
 */
public class Entrenador {
    
    Pokemon inicial;
    private String nombre;
    private String region;
    private ArrayList<Pokemon> listaPokemons = new ArrayList<Pokemon>(); // TENTATIVO, LARGO 6
    private String[] medallas = new String[8];
    protected int ranking;
    Pokemon activo;
    public boolean esGanador;
    private boolean tieneEquipo;
    private int mejorRachaTorreDeBatalla; //Para torre de batalla - rafael
    private int[] logrosTorreDeBatalla; //Para torre de batalla - rafael
            
    public Entrenador(String nombre){
        this.nombre = nombre;
        this.region = region;
        this.medallas = medallas;
        System.out.println(this.nombre+" Quiere ser maestro de los pokimons");
        }

    public void seleccionarListaPokemon(){
    }
    public void batallar(){
        System.out.println("Es tu turno mr"+nombre);
        
    }
    public void seleccionarMovimiento(Pokemon pokemon, int i){
        
       
    }
    
    public void setInicial(Pokemon pokemon){
        inicial = pokemon;
        System.out.println("el incial es"+inicial.getNombre());
       
    }
    public Pokemon getInicial(){
        return inicial;
    }

    public Pokemon getActivo() {
        return activo;
    }

    public void setActivo(Pokemon activo) {
        this.activo = activo;
    }
    
            
    public void elegirPokemonBatalla(){
        
    }
    public void jugarCampeonato(){
        
    }
    public void jugarTorreBatalla(){
        
    }
    
   

    //GETTERS AND SETTERS
    public void setTieneEquipo(boolean tieneEquipo) {    
        this.tieneEquipo = tieneEquipo;
    }
    
    public boolean getTieneEquipo() {
           return tieneEquipo;
       }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public void setListaPokemons(ArrayList<Pokemon> listaPokemons) {
        this.listaPokemons = listaPokemons;
        
    }

    public String[] getMedallas() {
        return medallas;
    }

    public void setMedallas(String[] medallas) {
        this.medallas = medallas;
    }
    
    public int getRanking(){
        return this.ranking;
    }
    
    public void setRanking (int ranking){
        this.ranking = ranking;
    }
    
    
}
