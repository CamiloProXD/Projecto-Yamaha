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
public class DaoInventario extends Conexion {

    public boolean agregar(Inventario i) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO inventarios (inventario_id, cantidad) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(i.getInventarioId()));
            pst.setString(2, Integer.toString(i.getCantidad()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public boolean actualizar(Inventario i) {
        Connection cnx = getConexion();
        String stc = "UPDATE inventarios SET cantidad=? WHERE inventario_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(i.getCantidad()));
            pst.setString(2, Integer.toString(i.getInventarioId()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Inventario i) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM inventarios WHERE inventario_id=?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(i.getInventarioId()));
            rst = pst.executeQuery();
            if (rst.next()) {
                i.setCantidad(Integer.parseInt(rst.getString("cantidad")));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Inventario i) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM inventarios WHERE inventario_id=?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(i.getInventarioId()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public List<Object[]> obtenerInventarioPorSucursal(int idSucursal) {
        Connection cnx = getConexion();
        String stc = "SELECT m.nombre, m.modelo, m.color, SUM(i.cantidad) as total_cantidad " +
                     "FROM inventario i " +
                     "JOIN motos m ON i.id_moto = m.id_moto " +
                     "WHERE i.id_sucursal = ? " +
                     "GROUP BY m.nombre, m.modelo, m.color";
        PreparedStatement pst;
        ResultSet rst;
        List<Object[]> inventario = new ArrayList<>();

        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, idSucursal);
            rst = pst.executeQuery();

            while (rst.next()) {
                Object[] fila = new Object[4];
                fila[0] = rst.getString("nombre");
                fila[1] = rst.getString("modelo");
                fila[2] = rst.getString("color");
                fila[3] = rst.getInt("total_cantidad");

                inventario.add(fila); // Agregar fila al resultado
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener inventario -> " + ex.getMessage());
        }

        return inventario;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
