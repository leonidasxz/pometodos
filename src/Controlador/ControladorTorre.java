/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaTorre;
import Modelo.Entrenador;
import Modelo.Pokemon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Rafael
 */
public class ControladorTorre implements ActionListener{
    
    private int rachaGanadora;
    private javax.swing.JFrame nombreVista;
    ControladorDba controladorSQL = new ControladorDba();
    VistaTorre vistaTorre;
    private Entrenador entrenador;
    
    public ControladorTorre(Entrenador entrenador, javax.swing.JFrame nombreVista) {
        this.entrenador = entrenador;
        vistaTorre = new VistaTorre(new javax.swing.JFrame(), true);
        vistaTorre.agregarListeners(this);
        vistaTorre.setVisible(true);
        
        
    }
    
    public static void main (String[] args) throws SQLException{
        ControladorTorre ct = new ControladorTorre(new Entrenador("trainer"), new javax.swing.JFrame());
    }
    
    
    //Crea el equipo
    public ArrayList<Pokemon> crearEquipoAlAzar() throws SQLException{
        ArrayList<Pokemon> pokemonTorre = new ArrayList<>();
        
        while(pokemonTorre.size() < 6){
            Pokemon pokemonNuevo = crearPokemonAlAzar();
            if (pokemonTorre.contains(pokemonNuevo) == false){
                pokemonTorre.add(pokemonNuevo);
            }
        }

        return pokemonTorre;
    }
    
    public Entrenador crearEntrenadorOponente() throws SQLException{
        Entrenador entrenadorOponente = new Entrenador("Oponente");
        ArrayList<Pokemon> pokemon = crearEquipoAlAzar();
        entrenadorOponente.setListaPokemons(pokemon);
        return entrenadorOponente;
    }
    
    public void iniciarNuevaTorre() throws SQLException{
        //ControladorBatalla cb = new ControladorBatalla(nombreVista);
        vistaTorre.setVisible(false);

        rachaGanadora = 0;
        System.out.println("Iniciando torre");
        
        
        batallaTorreBatalla();
        

        
    }
    
    public void batallaTorreBatalla() throws SQLException{
        //Entrenador entrenadorOponente = crearEntrenadorOponente();
        ArrayList<Pokemon> pokemonEntrenador = crearEquipoAlAzar();

        this.entrenador.setListaPokemons(pokemonEntrenador);
        
        //hacer batalla con el entrenador
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas ganar? Ingresa booleano");
        this.entrenador.esGanador = sc.nextBoolean();                              
        
        
        
        if (this.entrenador.esGanador){
            rachaGanadora++;
            vistaTorre.setRacha(rachaGanadora);
            vistaTorre.mostrarVistaCambios(this.entrenador);
        }
        
        else{
            vistaTorre.mostrarVentanaDespuesDeBatalla(1, rachaGanadora);
        }
    }
    
    public Pokemon crearPokemonAlAzar() throws SQLException{
        Pokemon pokemonRandom;
        Random RNG = new Random();
        //Consulto la cantidad de pokemon en la base de datos para utilizarla en el metodo random
        String consultaCantidadPokemon = "SELECT Count(*) AS cantidad FROM POKE.FAMILIA_POKEMON";        
        //int cantidadPokemon = Integer.parseInt(controladorSQL.obtenerResultSetDB(consultaCantidadPokemon, true).getString("cantidad"));
        //Aun no utilizado ya que la base de datos por ahora no tiene equivalence entre ID pokemon y su numero de columna
        //int pokemonSeleccionado =  RNG.nextInt(cantidadPokemon);

        // por ahora 111 es un numero fijo, el cual es el pokemon Rhyhorn de nivel 100, todos los pokemon
        // en la torre de batalla son de nivel 100
        int [] pokemonActuales = {74, 75, 76, 95, 111, 112, 138, 139, 140, 141, 142, 246, 247, 248, 369, 408, 409, 464};
        int cantidadPokemon = pokemonActuales.length;
        int pokemonSeleccionado = RNG.nextInt(cantidadPokemon);
        
        String consultaObtenerPokemon = "select ID_FAMILIAPOKEMON, NOMBRE_FAMILIAPOKEMON, "
                + "ATAQUEMAX_FAMILIAPOKEMON, ATAQUEESPECIALMAX_FAMILIAPOKEMON, "
                + "DEFENSAMAX_FAMILIAPOKEMON, DEFENSAESPECIALMAX_FAMILIAPOKEMON, VELOCIDADMAX_FAMILIAPOKEMON, "
                + "HPMAX_FAMILIAPOKEMON, TIPO_PRIMARIO, TIPO_SECUNDARIO "
                + "from POKE.FAMILIA_POKEMON WHERE ID_FAMILIAPOKEMON ="+pokemonActuales[pokemonSeleccionado];
        
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
    
    public void cambiarPokemon() throws SQLException{
        Object pokemonSeleccionado = vistaTorre.getValorSeleccionado();
        ArrayList<Pokemon> nuevosPokemon = this.entrenador.getListaPokemons();
        System.out.println("---------Pokemon antiguos----------");
        for (Pokemon pokemon: nuevosPokemon){
            System.out.println(pokemon.getNombre());
        }
        boolean pokemonCambiado = false;
        
        while(!pokemonCambiado){
            for (int i = 0; i < nuevosPokemon.size(); i++){
                if (nuevosPokemon.get(i).getNombre().equals(pokemonSeleccionado)){
                    Pokemon nuevoPokemon = crearPokemonAlAzar();

                    if (nuevoPokemon.equals(nuevosPokemon.get(i)) == false){
                        nuevosPokemon.set(i, nuevoPokemon);
                        System.out.println("cambiado: "+nuevoPokemon.getNombre());
                        vistaTorre.actualizarContadorCambios();
                        pokemonCambiado = true;
                    }
                }           
            }
        }
        System.out.println("----------Pokemon nuevos-----------");
        
        for (Pokemon pokemon : nuevosPokemon){
            System.out.println(pokemon.getNombre());
        }
        
        System.out.println("-----------------------------------");
        
        this.entrenador.setListaPokemons(nuevosPokemon);
        vistaTorre.mostrarPokemonEnLista(this.entrenador);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        int accion = Integer.parseInt(ae.getActionCommand());
        switch(accion){
            case 1:
                break;
                
            case 2:
                try{
                    iniciarNuevaTorre();
                } catch (SQLException e){}
                break;
                
            case 3:
                break;
                
            case 4:
                try{
                    vistaTorre.esconderVentanaCambios();
                    batallaTorreBatalla();
                } catch (SQLException e){}
                break;
                
            case 6:
                try{
                    cambiarPokemon();
                } catch (SQLException e){}
                break;
                
            default:
                System.out.println("alguna wea paso");
                break;
                   
        }
    }
}
