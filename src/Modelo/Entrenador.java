// MODIFICADO ULTIMA VEZ: FCA, 7/OCT, 3:40
// REVISAR ATRIBUTOS SEGUN DIAGRAMA DE CLASES

package Modelo;

/**
 *
 * @author fcuevas
 */
public class Entrenador {
    
    private String nombre;
    private String region;
    private Pokemon[] listaPokemons = new Pokemon[6]; // TENTATIVO, LARGO 6
    private String[] medallas = new String[8];
    public int ranking;
            
    public Entrenador(String nombre){
    this.nombre = nombre;
    this.region = region;
    this.medallas = medallas;
    }

    public void seleccionarListaPokemon(){
    }
    public void batallar(){
    }
    public void seleccionarMovimiento(Pokemon pokemon, int i){
        
        
    }
    public void elegirPokemonBatalla(){
        
    }
    public void jugarCampeonato(){
        
    }
    public void jugarTorreBatalla(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //GETTERS AND SETTERS
    
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

    public Pokemon[] getListaPokemons() {
        return listaPokemons;
    }

    public void setListaPokemons(Pokemon[] listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    public String[] getMedallas() {
        return medallas;
    }

    public void setMedallas(String[] medallas) {
        this.medallas = medallas;
    }
    
    
}
