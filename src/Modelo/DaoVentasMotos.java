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
            pst.setInt(2, vm.getMotoId());
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
                vm.setMotoId(rst.getInt("moto_id"));
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
            pst.setInt(2, vm.getMotoId());
            pst.executeUpdate();
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public ResultSet consultarVentasXVendedor(String vendedorId, String fechaIni, String fechaFin) {
        Connection cnx = getConexion();
        String stc = "select vm.fecha, p.monto_pago from ventas v "
                + "join pagos p on v.numero_factura = p.numero_factura "
                + "where v.vendedor_id = ? "
                + "and v.fecha between ? and ?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, vendedorId);
            pst.setString(2, fechaIni);
            pst.setString(3, fechaFin);
            return pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("error consultarVentasXVendedor: " + e);
        }
        return null;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
