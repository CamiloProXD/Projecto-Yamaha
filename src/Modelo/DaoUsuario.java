/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DaoUsuario extends Conexion {
    public boolean agregar(Persona p){
        Connection cnx= getConexion();
        String stc = "INSERT INTO usuarios (usuario_id,persona_id,username,password) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try{
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            pst.setString(2, p.getNombres());
            pst.setString(3, p.getApellidos());
            pst.setString(4, p.getNumeroTelefonico());
            pst.setString(3, p.getEmail());
            pst.setString(4, p.getDireccion());
            pst.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("Error al ejecutar el INSERT-> "+ex);
            mensaje("Error al ejecutar el INSERT","Agregar!!!");
        }
        
        return false;
    }
    
    public boolean actualizar(Persona p){
        Connection cnx= getConexion();
        String stc = "UPDATE personas SET nombres=?,apellidos=?,numero_telefonico=?,email=?,direccion=? WHERE persona_id=?";
        PreparedStatement pst;
        try{
            pst = cnx.prepareStatement(stc);  
            pst.setString(1, p.getNombres());
            pst.setString(2, p.getApellidos());
            pst.setString(3, p.getNumeroTelefonico());
            pst.setString(4, p.getEmail());
            pst.setString(5, p.getDireccion());
            pst.setString(6, Integer.toString(p.getId()));
            pst.execute();
            return true;
        }catch(SQLException ex){
            System.err.println("Error al ejecutar el UPODATE -> "+ex);
            mensaje("Error al ejecutar el UPDATE","actualizar!!!");
        }
        return false;
    } 
    
    public boolean consultar(Persona p){
        Connection cnx= getConexion();
        String stc = "SELECT * FROM personas WHERE persona_id=?";
        PreparedStatement pst;
        ResultSet rst;
        try{
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            rst = pst.executeQuery();
            if(rst.next()){
                p.setNombres(rst.getString("nombres"));
                p.setApellidos(rst.getString("apellidos"));
                p.setNumeroTelefonico(rst.getString("numero_telefonico"));
                p.setEmail(rst.getString("email"));
                p.setEmail(rst.getString("direccion"));
              
            }
            return true;
        }catch(SQLException ex){
            System.err.println("Error al ejecutar el SELECT -> "+ex);
            mensaje("Error al ejecutar el SELECT","consultar!!!");
        }
        return false;
    } 
    
     public boolean eliminar(Persona p){
        Connection cnx = getConexion();
        String stc = "DELETE DROM persona WHERE persona_id=?)";
        PreparedStatement pst;
        try{
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            pst.execute();
            return true;
        }
        catch(SQLException ex){
            System.err.println("Error al ejecutar el DELETE -> "+ex);
            mensaje("Error al ejecutar el DELETE","eliminar!!!");
        }
        return false;
   }
    
    public void mensaje(String msg, String title){
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
