/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;        
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Rafael
 */
public class ControladorLogin implements ActionListener {
    

    ControladorPrincipal cp;
    VistaLogin vistaLogin;
    private boolean existeUsuario;
    public boolean usuarioLogueado;
    public String nombreUsuario;
    private String DBHost;
    private String DBUsuario;
    private String DBContrasena;
    private Connection con;
    private Statement stmt;
    private String comandoSQL;
    private ResultSet resultSet;
    
    public static void main(String[] args) throws SQLException{
        //ControladorLogin cLogin = new ControladorLogin();
    }
        
    public ControladorLogin(){
        vistaLogin = new VistaLogin();
        vistaLogin.agregarListeners(this);
        vistaLogin.setVisible(true);
        
        
        //Base de datos
        this.DBHost = "jdbc:derby://localhost:1527/PokemonUsuarios";
        this.DBContrasena = "pometodos";
        this.DBUsuario = "pometodos";
        try {
            Connection con = DriverManager.getConnection(DBHost, DBUsuario, DBContrasena);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean loginUsuario(String usuario, String contrasena) throws SQLException{
        usuarioLogueado = false;
        nombreUsuario = null;
        boolean contrasenaCorrecta = false;
        boolean usuarioCorrecto = false;

        
        comandoSQL = "SELECT USUARIO, CONTRASEÑA FROM POMETODOS.USUARIOS";
        
        try{
            resultSet = stmt.executeQuery(comandoSQL);
        } catch (SQLException ex){}
        
        while (resultSet.next() && usuarioCorrecto == false && contrasenaCorrecta == false){
            if (usuario.equals(resultSet.getString("USUARIO")) && contrasena.equals(resultSet.getString("CONTRASEÑA"))){
                usuarioCorrecto = true;
                contrasenaCorrecta = true;
                nombreUsuario = usuario;
            }            
        }
        if (usuarioCorrecto && contrasenaCorrecta){
            usuarioLogueado = true;
            vistaLogin.setVisible(false);
            synchronized(this){
                notify();
            }
        }
        System.out.println(usuarioLogueado);        
        return usuarioLogueado;
    }
    
    public boolean crearNuevoUsuario(String usuario, String contrasena, String confirmacionContrasena) throws SQLException{
        existeUsuario = false;
        comandoSQL = "SELECT USUARIO FROM POMETODOS.USUARIOS";
        try {
            resultSet = stmt.executeQuery(comandoSQL);
        } catch (SQLException ex) {
            return false;
        }
        
        while (resultSet.next() && existeUsuario == false){
            if (usuario.equals(resultSet.getString("USUARIO"))){
                existeUsuario = true;              
            }            
        }

        if (existeUsuario == false && contrasena.equals(confirmacionContrasena)
                && !usuario.equals("") && !contrasena.equals("") 
                && !confirmacionContrasena.equals("")){
            
            comandoSQL = "INSERT INTO POMETODOS.USUARIOS (USUARIO, \"CONTRASEÑA\") "+"VALUES ('"+usuario+"', '" +contrasena+"')";
            
            try{
                stmt.executeUpdate(comandoSQL);
            } catch (SQLException ex){}
        }
        
        else if (existeUsuario){
            System.out.println("Usuario ya existe");
        }
        
        else if(!usuario.equals("") && (contrasena.equals("") || confirmacionContrasena.equals(""))){
            System.out.println("ingrese una contraseña");
        }
        
        else if (usuario.equals("")){
            System.out.println("Escriba un nombre de usuario");
        }
        
        else if (!contrasena.equals(confirmacionContrasena) && !contrasena.equals("")
                && !confirmacionContrasena.equals("")){
            System.out.println("Las contraseñas son diferentes");
        }
               
        else{
            System.out.println("Ocurrio un error");
        }               
        return false;
    }
    
    public void notificar(ControladorPrincipal controlador){
        synchronized(controlador){
            controlador.notify();
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String accion = ae.getActionCommand();
        switch (accion) {
            case "crearUsuario":
                vistaLogin.guardarUsuarioContrasenaEnObjeto();
        {
            try {
                crearNuevoUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena(), vistaLogin.getContrasenaConfirmada());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                vistaLogin.limpiar();
                break;
            case "loguearUsuario":
                vistaLogin.guardarUsuarioContrasenaEnObjeto();
        {
            try {
                usuarioLogueado = loginUsuario(vistaLogin.getUsuario(), vistaLogin.getContrasena());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                vistaLogin.limpiar();
                break;
            default:
                System.out.println("que chucha paso");
                break;
        }
    }
    
    
}
