/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Vista.VistaBatalla;
import Modelo.Batalla;
import Modelo.Entrenador;
import Modelo.Movimiento;
import Modelo.MovimientoAprendido;
import Modelo.Pokemon;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorBatalla implements ActionListener{
    
    VistaBatalla vBatalla;
    Batalla batalla;
    ControladorPokemon cPokemon;
    ControladorEquipo cEquipo;
    boolean esperar = false;
    Object valorSeleccionado;
    int turno = 0;
    MovimientoAprendido movEnBotones0;
    MovimientoAprendido movEnBotones1;
    
    
    public ControladorBatalla(javax.swing.JFrame nombreVista){
        System.out.println("Nuevo controlador Batalla");
        vBatalla = new VistaBatalla(nombreVista,true);
        vBatalla.agregarListener(this);
        vBatalla.setVisible(true);
        
        
    }
    
    public void seleccionarEquipo(){
        this.cEquipo = new ControladorEquipo();
        this.seleccionPokeInicial();
    }
    
    public void seleccionPokeInicial(){
        System.out.println("Comienza la batalla");
        this.vBatalla.esconderCapa1();
        this.vBatalla.mostrarCapa2();
        this.agregarALista();
        
    }
    public void agregarALista(){
        this.vBatalla.agregarEnLista(cEquipo.trainers[turno].getListaPokemons());
        
    }
    
    public void iniciarPokemon(Object vSeleccion){
        System.out.println("El poke seleccionado es: "+vSeleccion);
        for(Entrenador entrenador: this.cEquipo.trainers){
            for(Pokemon pokes:entrenador.getListaPokemons()){
                if(vSeleccion==pokes.getNombre()){
                    System.out.println("Su seleccion es correcta");
                    entrenador.setInicial(pokes);
                    
                    
                    
                }
            }
        }
                    
                    
                    
        
        
        
        
    }
    public void iniciarBatalla(){
        batalla = new Batalla();
        while(batalla.getFuncionando()==true){
            batalla.setTurno(0);
            cEquipo.trainers[batalla.getTurno()].batallar();
            this.asignarMovABotones(cEquipo.trainers[batalla.getTurno()].getInicial());
            batalla.setFuncionando(esperar);
                
            
        }
    }
    public void asignarMovABotones(Pokemon pokemon){
        vBatalla.setBotones(pokemon.getMovimientos(),pokemon.getNombre());
        
            
        
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){     
        int accion = Integer.parseInt(ae.getActionCommand());
        switch(accion){
            case 1:
                System.out.println("Simple");
                this.seleccionarEquipo();
                break;
            case 2:
                System.out.println("Doble");
                
            break;
            case 3:
                System.out.println("Triple");
                
                break;
            case 4:
               valorSeleccionado = this.vBatalla.getValorSeleccionado();
               this.iniciarPokemon(valorSeleccionado);
               turno++;
               this.agregarALista();
               this.vBatalla.bAceptarSegundoClick();
               
               
               break;
            case 5:
                valorSeleccionado = this.vBatalla.getValorSeleccionado();
                this.iniciarPokemon(valorSeleccionado);
                vBatalla.esconderCapa2();
                vBatalla.mostrarCapa3();
                turno=0;
                this.iniciarBatalla();
                System.out.println("A NEW CHALLENGER HAS APROACHED");
                break;
            case 6:
                
                break;
            
                
                
        }
        
    }
    
    
    
}
            
            
            
            
