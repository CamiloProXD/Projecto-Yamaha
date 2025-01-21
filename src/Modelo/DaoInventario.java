package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoInventario extends Conexion {

    public boolean agregar(Inventario i) {
        String stc = "INSERT INTO inventarios (inventario_id, cantidad) VALUES (?, ?)";
        try (Connection cnx = getConexion(); PreparedStatement pst = cnx.prepareStatement(stc)) {
            pst.setInt(1, i.getInventarioId());
            pst.setInt(2, i.getCantidad());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT -> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }
        return false;
    }

    public boolean actualizar(Inventario i) {
        String stc = "UPDATE inventarios SET cantidad=? WHERE inventario_id=?";
        try (Connection cnx = getConexion(); PreparedStatement pst = cnx.prepareStatement(stc)) {
            pst.setInt(1, i.getCantidad());
            pst.setInt(2, i.getInventarioId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el UPDATE -> " + ex);
            mensaje("Error al ejecutar el UPDATE", "Actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Inventario i) {
        String stc = "SELECT * FROM inventarios WHERE inventario_id=?";
        try (Connection cnx = getConexion(); PreparedStatement pst = cnx.prepareStatement(stc)) {
            pst.setInt(1, i.getInventarioId());
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                i.setCantidad(rst.getInt("cantidad"));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "Consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Inventario i) {
        String stc = "DELETE FROM inventarios WHERE inventario_id=?";
        try (Connection cnx = getConexion(); PreparedStatement pst = cnx.prepareStatement(stc)) {
            pst.setInt(1, i.getInventarioId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "Eliminar!!!");
        }
        return false;
    }

    public List<Object[]> obtenerInventarioPorSucursal(int idSucursal) {
        List<Object[]> inventario = new ArrayList<>();
        String query = "SELECT m.nombre, m.modelo, m.color_moto, SUM(i.cantidad_motos) as totalCantidad "
                + "FROM inventarios i "
                + "JOIN motos m ON i.sucursal_id = m.sucursal_id "
                + "WHERE i.sucursal_id = ? "
                + "GROUP BY m.nombre, m.modelo, m.color_moto";

        try (Connection cnx = getConexion(); PreparedStatement stmt = cnx.prepareStatement(query)) {
            stmt.setInt(1, idSucursal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                inventario.add(new Object[]{
                    rs.getString("nombre"),
                    rs.getInt("modelo"), 
                    rs.getString("color_moto"),
                    rs.getInt("totalCantidad")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta -> " + e);
            mensaje("Error al ejecutar la consulta", "Consultar Inventario!!!");
        }

        return inventario;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }
}