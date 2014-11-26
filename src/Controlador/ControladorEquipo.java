/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrenador;
import Modelo.Pokemon;
import Vista.VistaEquipo;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorEquipo {
    VistaEquipo vEquipo;
    Scanner sc;
    int opcion;
    int player = 1;
    Entrenador[] trainers = new Entrenador[2];
    Pokemon[] pokemons = new Pokemon[3];
    ControladorPokemon cPokemon;
    
    public ControladorEquipo(){
        sc = new Scanner(System.in);
        
        while(this.player <=2){
            
            trainers[this.player-1] = new Entrenador("Entrenador"+this.player);
            int contador=0;
            
            System.out.println("Turno del"+trainers[this.player-1].getNombre());
            
            while(contador<3){
              
                System.out.println("Elija sus 3 pokemon, uno por uno , ej;1  : ");
                System.out.println("0.- Salir");
                System.out.println("1.- Pikachu");
                System.out.println("2.- Charmander");
                System.out.println("3.- Squirtle");
                System.out.print("4.- Bulbasaur: ");
                opcion = sc.nextInt();
                switch(opcion){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        pokemons[contador]= new Pokemon("RataElectrica", "pikachu", "electrico", null, null, 1, 1);
                        break;
                    case 2:
                        pokemons[contador]= new Pokemon("RatadeFuego", "charmander", "fuego", null, null, 2, 1);
                        break;
                    case 3:
                        pokemons[contador]= new Pokemon("TortugaHermosa", "squirtle", "agua", null, null, 3, 1);
                        break;
                    case 4:
                        pokemons[contador]= new Pokemon("Plantito", "bulbasaur", "planta", null, null, 4, 1);
                        break;
                }
                contador++;
                
            }
            ArrayList<Pokemon> listaNueva= trainers[this.player-1].getListaPokemons();
            for(Pokemon cadaPokemon: pokemons){
                listaNueva.add(cadaPokemon);
            
            }
            trainers[this.player-1].setListaPokemons(listaNueva);
            
            this.player++;
        }
        sc.close();
        
    
    }
    public ControladorEquipo(javax.swing.JFrame vista,int i){
        System.out.println("Controlador EQUIPO ACTIVATED");
        switch(i){
            case 3:
                this.crearEquipo(vista);
                System.out.println("oli");
        }
        
               
    }
    public void crearEquipo(javax.swing.JFrame vistaPapi){
        VistaEquipo vEquipo = new VistaEquipo(vistaPapi, true);
        vEquipo.setVisible(true);
        
        
    }
}
