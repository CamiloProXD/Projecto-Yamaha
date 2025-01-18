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
public class DaoSede extends Conexion {

    public boolean agregar(Sede s) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO sucursales (sucursal_id, inventario_id, nombre_sucursal, municipio, administrador_id) VALUES (?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(s.getIdSede()));
            pst.setString(2, Integer.toString(s.getInventario_id()));
            pst.setString(3, s.getNombreSede());
            pst.setString(4, s.getMunicipio());
            pst.setString(5, Integer.toString(s.getIdAdministrador()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }
    
    public boolean actualizar(Sede s) {
        Connection cnx = getConexion();
        String stc = "UPDATE sucursales SET inventario_id=?, nombre_sucursal=?, municipio=?, administrador_id=? WHERE sucursal_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);           
            pst.setString(1, Integer.toString(s.getInventario_id()));
            pst.setString(2, s.getNombreSede());
            pst.setString(3, s.getMunicipio());
            pst.setString(4, Integer.toString(s.getIdAdministrador()));
            pst.setString(5, Integer.toString(s.getIdSede()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }
    
    public boolean consultar(Sede s) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM sucursales WHERE sucursal_id=?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(s.getIdSede()));
            rst = pst.executeQuery();
            if (rst.next()) {
                s.setInventario_id(Integer.parseInt(rst.getString("inventario_id")));
                s.setNombreSede(rst.getString("nombre_sucursal"));
                s.setMunicipio(rst.getString("municipio"));
                s.setIdAdministrador(Integer.parseInt(rst.getString("administrador_id")));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Sede s) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM sucursales WHERE sucursal_id=?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(s.getIdSede()));
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
