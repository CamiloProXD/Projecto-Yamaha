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

    public boolean agregar(Usuario u) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO usuarios (username,password,rol,salario) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getRol());
            pst.setString(4, Double.toString(u.getSalario()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public boolean actualizar(Usuario u) {
        Connection cnx = getConexion();
        String stc = "UPDATE usuarios SET username=?,password=?,rol=?,salario=? WHERE usuario_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getRol());
            pst.setString(4, Double.toString(u.getSalario()));
            pst.setString(5, Integer.toString(u.getIdUsuario()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Usuario u) {
        Connection cnx = getConexion();
        String stc = "SELECT p.nombres, p.apellidos, p.numero_telefonico, p.email, p.direccion, u.username, u.password, u.rol, u.salario, u.sucursal_id"
                + " FROM usuarios u "
                + "INNER JOIN personas p ON p.persona_id = u.persona_id "
                + "WHERE u.id_usuario = ?"; 
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, u.getIdUsuario());
            rst = pst.executeQuery();
            if (rst.next()) {

                u.setNombres(rst.getString("nombres"));
                u.setApellidos(rst.getString("apellidos"));
                u.setNumeroTelefonico(rst.getString("numero_telefonico"));
                u.setEmail(rst.getString("email"));
                u.setDireccion(rst.getString("direccion"));
                u.setUsername(rst.getString("username"));
                u.setPassword(rst.getString("password"));
                u.setRol(rst.getString("rol"));
                u.setSalario(Double.parseDouble(rst.getString("salario")));
                u.setIdSede(Integer.parseInt(rst.getString("sucursal_id")));

            } else {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Usuario u) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM persona WHERE usuario_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(u.getIdUsuario()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
