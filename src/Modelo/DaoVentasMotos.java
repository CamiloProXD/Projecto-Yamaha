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
public class DaoVentasMotos extends Conexion {

    public boolean agregar(VentasMotos vm) {
        Connection cnx = getConexion();
        String stc = "INSERT INTO ventas_motos (venta_id, moto_id) VALUES (?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, vm.getVentaId());
            pst.setString(2, vm.getMotoId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }

        return false;
    }

    public List<VentasMotos> consultar(VentasMotos vm) {
        Connection cnx = getConexion();
        String stc = "SELECT * FROM ventas_motos WHERE venta_id=?";
        List<VentasMotos> lista = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, vm.getVentaId());
            rst = pst.executeQuery();
            while (rst.next()) {
                VentasMotos vmotos = new VentasMotos();
                vm.setVentaId(rst.getInt("venta_id"));
                vm.setMotoId(rst.getString("moto_id"));
                lista.add(vmotos);
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return lista;
    }

    public boolean eliminar(VentasMotos vm) {
        Connection cnx = getConexion();
        String stc = "DELETE FROM ventas_motos WHERE venta_id=? AND moto_id=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setInt(1, vm.getVentaId());
            pst.setString(2, vm.getMotoId());
            pst.executeUpdate();
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public ResultSet consultarVentasXVendedor(String idVendedor) {
        Connection cnx = getConexion();
        String query = "SELECT v.fecha AS 'fecha de venta', SUM(p.monto_pago) AS 'total de esta venta' "
                + "FROM ventas v "
                + "JOIN pagos p ON v.numero_factura = p.numero_factura "
                + "WHERE v.vendedor_id = ? "
                + "GROUP BY v.fecha";
        PreparedStatement pst;
        ResultSet rst = null;
        try {
            pst = cnx.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(idVendedor));
            rst = pst.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al consultar ventas: " + e.getMessage());
        }
        return rst;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
