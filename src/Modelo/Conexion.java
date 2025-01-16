/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Conexion {
    public Connection getConexion(){
        Connection cnx = null;
        String URL = "jdbc:mysql://localhost:3306/produccion";
        String usuario = "root";
        String contrasena = "12345678";  
                
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx =  DriverManager.getConnection(URL,"root","");
        }catch(SQLException|ClassNotFoundException ex){
            System.err.println("Error al conectar la BD ->"+ex);
            JOptionPane.showMessageDialog(null, "Error al conectar la BD!!!","conexion",1);
        }   
        return cnx;
    }
}
