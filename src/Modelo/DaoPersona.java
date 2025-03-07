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
public class DaoPersona extends Conexion {

    public boolean agregar(Persona p) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO personas (persona_id, nombres, apellidos ,email, numero_telefonico, direccion) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            pst.setString(2, p.getNombres());
            pst.setString(3, p.getApellidos());
            pst.setString(4, p.getEmail());
            pst.setString(5, p.getNumeroTelefonico());
            pst.setString(6, p.getDireccion());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public boolean actualizar(Persona p) {
        Connection cnx = getConexion();
        String stc = "UPDATE personas SET nombres=?,apellidos=?,email=?,numero_telefonico=?,direccion=? WHERE persona_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, p.getNombres());
            pst.setString(2, p.getApellidos());
            pst.setString(3, p.getEmail());
            pst.setString(4, p.getNumeroTelefonico());
            pst.setString(5, p.getDireccion());
            pst.setString(6, Integer.toString(p.getId()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Persona p) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM personas WHERE persona_id=?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            rst = pst.executeQuery();
            if (rst.next()) {
                p.setNombres(rst.getString("nombres"));
                p.setApellidos(rst.getString("apellidos"));
                p.setEmail(rst.getString("email"));
                p.setNumeroTelefonico(rst.getString("numero_telefonico"));
                p.setDireccion(rst.getString("direccion"));

            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Persona p) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM persona WHERE persona_id=?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public boolean existenciaCliente(Persona p) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM personas WHERE persona_id=?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(p.getId()));
            rst = pst.executeQuery();
            if (rst.next()) {

                p.setNombres(rst.getString("nombres"));
                p.setApellidos(rst.getString("apellidos"));
                p.setEmail(rst.getString("email"));
                p.setNumeroTelefonico(rst.getString("numero_telefonico"));
                p.setDireccion(rst.getString("direccion"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public Persona buscarPorId(int id) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM personas WHERE persona_id=?";
        PreparedStatement pst;
        ResultSet rst;
        Persona persona = null; 

        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, id);
            rst = pst.executeQuery();

            if (rst.next()) {
                
                persona = new Persona();
                persona.setId(rst.getInt("persona_id"));
                persona.setNombres(rst.getString("nombres"));
                persona.setApellidos(rst.getString("apellidos"));
                persona.setEmail(rst.getString("email"));
                persona.setNumeroTelefonico(rst.getString("numero_telefonico"));
                persona.setDireccion(rst.getString("direccion"));
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "buscarPorId");
        }

        return persona;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
