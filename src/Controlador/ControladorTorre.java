/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaTorre;
import Modelo.Entrenador;
import Modelo.Pokemon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Rafael
 */
public class ControladorTorre {
    
    private int rachaGanadora;
    private javax.swing.JFrame nombreVista;
    ControladorDba controladorSQL = new ControladorDba();
    
    public ControladorTorre(Entrenador entrenador, javax.swing.JFrame nombreVista){
        System.out.println("iniciando objetos");
        
        
//        VistaTorre vistaTorre = new VistaTorre(new javax.swing.JFrame(), true);
//        vistaTorre.setVisible(true);
    }
    
    public static void main (String[] args) throws SQLException{
        ControladorTorre ct = new ControladorTorre(new Entrenador("trainer"), new javax.swing.JFrame());
        ct.crearEquipoAlAzar();
    }
    
    
    //Crea el equipo
    public ArrayList<Pokemon> crearEquipoAlAzar() throws SQLException{
        ArrayList<Pokemon> pokemonTorre = new ArrayList<>();
        
        for (int i = 0; i < 6; i++){
            pokemonTorre.add(crearPokemonAlAzar());
        }
        
        return pokemonTorre;
    }
    
    public Entrenador crearEntrenadorOponente(ArrayList<Pokemon> pokemon){
        Entrenador entrenadorOponente = new Entrenador("Oponente");
        entrenadorOponente.setListaPokemons(pokemon);
        return entrenadorOponente;
    }
    
    public void iniciarNuevaTorre(Entrenador entrenador) throws SQLException{
        ControladorBatalla cb = new ControladorBatalla(nombreVista);
        Entrenador entrenadorOponente;
        
        System.out.println("Iniciando torre");
        entrenador.esGanador = true;
        ArrayList<Pokemon> pokemonEntrenador = crearEquipoAlAzar();
        entrenador.setListaPokemons(pokemonEntrenador);
        
        while(entrenador.esGanador){
            
            entrenadorOponente = crearEntrenadorOponente(crearEquipoAlAzar());
            
        }
        
    }
    
    public Pokemon crearPokemonAlAzar() throws SQLException{
        Pokemon pokemonRandom;
        Random RNG = new Random();
        //Consulto la cantidad de pokemon en la base de datos para utilizarla en el metodo random
        String consultaCantidadPokemon = "SELECT Count(*) AS cantidad FROM POKE.FAMILIA_POKEMON";        
        int cantidadPokemon = Integer.parseInt(controladorSQL.obtenerResultSetDB(consultaCantidadPokemon, true).getString("cantidad"));
        //Aun no utilizado ya que la base de datos por ahora no tiene equivalence entre ID pokemon y su numero de columna
        int pokemonSeleccionado =  RNG.nextInt(cantidadPokemon);

        // por ahora 111 es un numero fijo, el cual es el pokemon Rhyhorn de nivel 100, todos los pokemon
        // en la torre de batalla son de nivel 100
        String consultaObtenerPokemon = "select ID_FAMILIAPOKEMON, NOMBRE_FAMILIAPOKEMON, "
                + "ATAQUEMAX_FAMILIAPOKEMON, ATAQUEESPECIALMAX_FAMILIAPOKEMON, "
                + "DEFENSAMAX_FAMILIAPOKEMON, DEFENSAESPECIALMAX_FAMILIAPOKEMON, VELOCIDADMAX_FAMILIAPOKEMON, "
                + "HPMAX_FAMILIAPOKEMON, TIPO_PRIMARIO, TIPO_SECUNDARIO "
                + "from POKE.FAMILIA_POKEMON WHERE ID_FAMILIAPOKEMON ="+111;
        
        ResultSet datosPokemon = controladorSQL.obtenerResultSetDB(consultaObtenerPokemon, true);
        //ORDEN = ID, NOMBRE, ESPECIE, ATK, SPATK, DEF, SPDEF, VEL, HP, TIPO1, TIPO2
        int idPokemon = Integer.parseInt(datosPokemon.getString("ID_FAMILIAPOKEMON"));
        String familia = datosPokemon.getString("NOMBRE_FAMILIAPOKEMON");
        int atk = Integer.parseInt(datosPokemon.getString("ATAQUEMAX_FAMILIAPOKEMON"));
        int spAtk = Integer.parseInt(datosPokemon.getString("ATAQUEESPECIALMAX_FAMILIAPOKEMON"));
        int def = Integer.parseInt(datosPokemon.getString("DEFENSAMAX_FAMILIAPOKEMON"));
        int spDef = Integer.parseInt(datosPokemon.getString("DEFENSAESPECIALMAX_FAMILIAPOKEMON"));
        int vel = Integer.parseInt(datosPokemon.getString("VELOCIDADMAX_FAMILIAPOKEMON")); //Aun no implementado en el modelo Pokemon
        int hp = Integer.parseInt(datosPokemon.getString("HPMAX_FAMILIAPOKEMON"));
        
        
        //Tipos estan como datos int que corresponden a la id del tipo en la base de dato, obtengo el int y lo consulto
        //en la base de datos de tipos
        int idTipoPrimario = Integer.parseInt(datosPokemon.getString("TIPO_PRIMARIO"));
        int idTipoSecundario;
        
       
        if (datosPokemon.getString("TIPO_SECUNDARIO") == null){
            idTipoSecundario = 0;
        }
        else{
            idTipoSecundario = Integer.parseInt(datosPokemon.getString("TIPO_SECUNDARIO"));
        }
        
        String consultaObtenerTipo = "select * from POKE.ELEMENTO where ID_ELEMENTO =";
        
        ResultSet datosTipo = controladorSQL.obtenerResultSetDB(consultaObtenerTipo + idTipoPrimario, true);
        String tipoPrimario = datosTipo.getString("NOMBRE_ELEMENTO").trim();
        
        String tipoSecundario;
        if (idTipoSecundario != 0){
            datosTipo = controladorSQL.obtenerResultSetDB(consultaObtenerTipo + idTipoSecundario , true);
            tipoSecundario = datosTipo.getString("NOMBRE_ELEMENTO").trim();
        }
        else{
            tipoSecundario = null;
        }
        
        //Genero un nuevo Pokemon con sus datos
        pokemonRandom = new Pokemon(idPokemon, familia, atk, spAtk, def, spDef, hp, tipoPrimario, tipoSecundario);

        return pokemonRandom;
    }
}
