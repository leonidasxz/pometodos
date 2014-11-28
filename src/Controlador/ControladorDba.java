/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;        
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ControladorDba {
    Connection cn;
    Statement stm;
    ResultSet resultado;
    
    public ControladorDba(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/pokemdb;user=poke;password=poke");
            System.out.println("Conexion correcta");// [poke on POKE]
            stm = cn.createStatement();
            System.out.println("Ejecutando QUERY");
            
            
        }
        catch(SQLException e){
            System.out.println(e);}
    }
    
    public ArrayList<ArrayList<String>> consultaPokemonPrueba(){
        ArrayList<ArrayList<String>> salida = new ArrayList<>();
        try {
            
            String consulta = "select ID_FAMILIAPOKEMON,NOMBRE_FAMILIAPOKEMON,ATAQUEBASE_FAMILIAPOKEMON,ATAQUEMAX_FAMILIAPOKEMON,DEFENSABASE_FAMILIAPOKEMON,DEFENSAMAX_FAMILIAPOKEMON,ATAQUEESPECIALBASE_FAMILIAPOKEMON,ATAQUEESPECIALMAX_FAMILIAPOKEMON,DEFENSAESPECIALBASE_FAMILIAPOKEMON,DEFENSAESPECIALMAX_FAMILIAPOKEMON,HPBASE_FAMILIAPOKEMON,HPMAX_FAMILIAPOKEMON from POKE.FAMILIA_POKEMON";
            ResultSet resultado = this.stm.executeQuery(consulta);
            
            
            
            // ORDEN DEL STRING: POKEDEX, NOMBREFAMILIA,AtBase,AtMax,DfBase,DfMax,AeBase,AeMax,DeBase,DeMax,HpBase,HpMax
            while(resultado.next()){
                ArrayList<String> info = new ArrayList<>();
                String idPokedex = Integer.toString(resultado.getInt(1));
                String nombre= resultado.getString(2);
                String nombreFamilia = nombre.replace(" ","");
                String AtBase = Integer.toString(resultado.getInt(3));
                String AtMax = Integer.toString(resultado.getInt(4));
                String DfBase = Integer.toString(resultado.getInt(5));
                String DfMax = Integer.toString(resultado.getInt(6));
                String AeBase = Integer.toString(resultado.getInt(7));
                String AeMax = Integer.toString(resultado.getInt(8));
                String DeBase = Integer.toString(resultado.getInt(9));
                String DeMax = Integer.toString(resultado.getInt(10));
                String HpBase = Integer.toString(resultado.getInt(11));
                String HpMax = Integer.toString(resultado.getInt(12));
                info.add(idPokedex);
                info.add(nombreFamilia);
                info.add(AtBase);
                info.add(AtMax);
                info.add(DfBase);
                info.add(DfMax);
                info.add(AeBase);
                info.add(AeMax);
                info.add(DeBase);
                info.add(DeMax);
                info.add(HpBase);
                info.add(HpMax);
                
                salida.add(info);
                
                
            }
            
            System.out.println("QUERY EJECUTADA");
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    // Metodos auxiliares para obtener e ingresar datos a la base de datos
    public ResultSet obtenerResultSetDB(String query, boolean bool) throws SQLException{
        ResultSet rset;
        rset = this.stm.executeQuery(query);
        if(bool){
            rset.next(); //con bool puedes elegir si quieres hacer el .next() manualmente o no
        }
        return rset;
    }
    
    public boolean actualizarDatosDB(String query){
        try{
            this.stm.executeUpdate(query);
            return true;
        }
        catch(SQLException e){return false;}
        
    }
    
}
