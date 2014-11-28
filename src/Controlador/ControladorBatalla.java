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
    int danho;
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
        System.out.println("Se comienza a iniciar los activos");
        System.out.println(batalla.getTurno());
        cEquipo.trainers[batalla.getTurno()].setActivo(cEquipo.trainers[batalla.getTurno()].getInicial());
        cEquipo.trainers[this.controlTurnos()].setActivo(cEquipo.trainers[controlTurnos()].getInicial());
        System.out.println("Asignados los activos");
        
        
        
            
            
        cEquipo.trainers[batalla.getTurno()].batallar();
            
            
        this.asignarMovABotones(cEquipo.trainers[batalla.getTurno()].getActivo());
                  
            
        
    }
    public void siguienteTurno(){
        
        this.asignarMovABotones(cEquipo.trainers[batalla.getTurno()].getActivo());
        
        
    }
    public void asignarMovABotones(Pokemon pokemon){
        vBatalla.setBotones(pokemon.getMovimientos(),pokemon.getNombre(),cEquipo.trainers[batalla.getTurno()].getNombre());
        
    }
    public void asignarDanho(int dmg,Pokemon pokemon){
        System.out.println("dmg :"+dmg);
        pokemon.setPV(pokemon.getPV()[0]-dmg);
        System.out.println("vidaPKMN: "+pokemon.getPV()[0]);
        if (dmg>0){
            System.out.println("le han hecho "+dmg+" de daño a"+pokemon.getNombre()+"!!! OMG!");
            if (pokemon.getPV()[0]<=0){
                
                this.finalizarBatalla();
            }
        }
        else{
            System.out.println("Miss!, daño 0");
            
        }
        
    
    }
    public int controlTurnos(){
        if(batalla.getTurno()+1>1)
            return 0;
        else{
            return 1;
        }
    }
    public void usarMovimiento(String nombre){
        for(MovimientoAprendido movimiento:cEquipo.trainers[batalla.getTurno()].getActivo().getMovimientos()){
            System.out.println("el movimiento es: "+movimiento.getNombre());
            System.out.println("el nombre que entra en el metodo es: "+nombre);
            if(movimiento.getNombre().equals(nombre)&&movimiento.getPP()[0]!=0){
                
                danho= movimiento.getPotencia();
                System.out.println(movimiento.getPotencia());
                System.out.println(danho);
                //cPokemon.asignarDanho(danho);
            
        }
        }
        
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
                System.out.println("capa 2 escondida");
                vBatalla.mostrarCapa3();
                turno=0;
                System.out.println("A NEW CHALLENGER HAS APROACHED");
                this.iniciarBatalla();
                
                break;
            case 6:
                System.out.println("Deberia atacar");
                
                    
                this.usarMovimiento(vBatalla.getAtaque1().getText());
                this.asignarDanho(danho, cEquipo.trainers[this.controlTurnos()].getActivo());
                System.out.println("El golpeado fue: "+cEquipo.trainers[this.controlTurnos()].getNombre());
                
                batalla.avanzarTurno();
                this.siguienteTurno();
                break;
            case 7:
                System.out.println("Deberia atacar");
                
                    
                this.usarMovimiento(vBatalla.getAtaque1().getText());
                this.asignarDanho(danho, cEquipo.trainers[this.controlTurnos()].getActivo());
                System.out.println("El golpeado fue: "+cEquipo.trainers[this.controlTurnos()].getNombre());
                
                batalla.avanzarTurno();
                this.siguienteTurno();
                break;
            case 8:
                System.out.println("Deberia atacar");
                
                    
                this.usarMovimiento(vBatalla.getAtaque1().getText());
                this.asignarDanho(danho, cEquipo.trainers[this.controlTurnos()].getActivo());
                System.out.println("El golpeado fue: "+cEquipo.trainers[this.controlTurnos()].getNombre());
                
                batalla.avanzarTurno();
                this.siguienteTurno();
                break;
            case 9:
                System.out.println("Deberia atacar");
                
                    
                this.usarMovimiento(vBatalla.getAtaque1().getText());
                this.asignarDanho(danho, cEquipo.trainers[this.controlTurnos()].getActivo());
                System.out.println("El golpeado fue: "+cEquipo.trainers[this.controlTurnos()].getNombre());
                
                batalla.avanzarTurno();
                this.siguienteTurno();
                break;
            
                
                
        }
        
    }

    private void finalizarBatalla() {
        System.out.println("Ha ganado: "+cEquipo.trainers[turno].getNombre());
        vBatalla.dispose();
        
    }
    

}
            
            
            
            
