/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DaoSede extends Conexion {

    public boolean agregar(Sede s) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO sucursales (sucursal_id, inventario_id, nombre_sucursal, municipio, administrador_id, direccion_sucursal) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(s.getIdSede()));
            pst.setString(2, Integer.toString(s.getInventario_id()));
            pst.setString(3, s.getNombreSede());
            pst.setString(4, s.getMunicipio());
            pst.setString(5, Integer.toString(s.getIdAdministrador()));
            pst.setString(6, s.getDireccionSede());
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
        String stc = "UPDATE sucursales SET inventario_id=?, nombre_sucursal=?, municipio=?, administrador_id=?, direccion_sucursal=? WHERE sucursal_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(s.getInventario_id()));
            pst.setString(2, s.getNombreSede());
            pst.setString(3, s.getMunicipio());
            pst.setString(4, Integer.toString(s.getIdAdministrador()));
            pst.setString(5, s.getDireccionSede());
            pst.setString(6, Integer.toString(s.getIdSede()));
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
                s.setDireccionSede(rst.getString("direccion_sucursal"));
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

    public List<Sede> obtenerTodas() {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM sucursales";
        PreparedStatement pst;
        ResultSet rst;
        List<Sede> listaSedes = new ArrayList<>();
        try {
            pst = cnx.prepareStatement(stc);
            rst = pst.executeQuery();
            while (rst.next()) {
                Sede s = new Sede();
                s.setIdSede(rst.getInt("sucursal_id"));
                s.setInventario_id(rst.getInt("inventario_id"));
                s.setNombreSede(rst.getString("nombre_sucursal"));
                s.setMunicipio(rst.getString("municipio"));
                s.setIdAdministrador(rst.getInt("administrador_id"));
                s.setDireccionSede(rst.getString("direccion_sucursal"));
                listaSedes.add(s); 
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex.getMessage());
        }

        return listaSedes;
    }

    public Sede obtenerPorId(int idSucursal) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM sucursales WHERE sucursal_id = ?";
        PreparedStatement pst;
        ResultSet rst;
        Sede sucursal = null;

        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, idSucursal);
            rst = pst.executeQuery();

            if (rst.next()) {
                sucursal = new Sede();
                sucursal.setIdSede(rst.getInt("sucursal_id"));
                sucursal.setInventario_id(rst.getInt("inventario_id"));
                sucursal.setNombreSede(rst.getString("nombre_sucursal"));
                sucursal.setMunicipio(rst.getString("municipio"));
                sucursal.setIdAdministrador(rst.getInt("administrador_id"));
                sucursal.setDireccionSede(rst.getString("direccion_sucursal"));

                System.out.println("Sucursal encontrada: " + sucursal.getIdSede() + " - " + sucursal.getNombreSede());
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT en obtenerPorId -> " + ex.getMessage());
        }

        return sucursal; // Retorna null si no existe
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
