/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author grabieloX19X
 */
public class DaoPago extends Conexion {

    public boolean agregar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "insert into pagos(numero_factura, monto_pago, pagado) values(?, ?, ?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura() + "");
            pst.setString(2, pago.getMontoPago() + "");
            pst.setString(3, pago.isPagado() + "");
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el INSERT-> " + ex);
            mensaje("Error al ejecutar el INSERT", "Agregar!!!");
        }
        return false;
    }

    public boolean actualizar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "update pagos set numero_factura=?, monto_pago=?, pagado=?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura() + "");
            pst.setString(2, pago.getMontoPago() + "");
            pst.setString(3, pago.isPagado() + "");
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el update-> " + ex);
            mensaje("Error al ejecutar el update", "actualizar!!!");
        }
        return false;
    }

    public boolean consultar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "select * from pagos where numero_factura = ?";
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, pago.getNumeroFactura() + "");
            rst = pst.executeQuery();
            if (rst.next()) {
                pago.setNumeroFactura(Integer.parseInt(rst.getString("numero_factura")));
                pago.setMontoPago(Double.parseDouble(rst.getString("monto_pago")));
                pago.setPagado(Integer.parseInt(rst.getString(stc)));
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el SELECT -> " + ex);
            mensaje("Error al ejecutar el SELECT", "consultar!!!");
        }
        return false;
    }

    public boolean eliminar(Pago pago) {
        Connection cnx = getConexion();
        String stc = "delete from pagos where numero_factura = ?";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(stc);
            pst.setString(1, Integer.toString(pago.getNumeroFactura()));
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar el DELETE -> " + ex);
            mensaje("Error al ejecutar el DELETE", "eliminar!!!");
        }
        return false;
    }

    public boolean existePago(int numeroFactura) {
        Connection cnx = getConexion();
        String query = "SELECT COUNT(*) AS total FROM pagos WHERE numero_factura = ?";
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = cnx.prepareStatement(query);
            pst.setInt(1, numeroFactura);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta para verificar existencia de pago -> " + ex);
            mensaje("Error al verificar existencia de pago", "Consulta!!!");
        }

        return false;
    }

    public double obtenerTotalRestantePorVenta(int numeroFactura) {
        double totalMotos = 0;
        double totalPagado = 0;
        String queryTotalMotos = "SELECT SUM(m.precio_unitario) AS total FROM ventas_motos vm "
                + "JOIN motos m ON vm.moto_id = m.serial_moto "
                + "WHERE vm.venta_id = ?";
        String queryTotalPagado = "SELECT SUM(monto_pago) AS total_pagado FROM pagos WHERE numero_factura = ?";

        try (Connection cnx = getConexion()) {
            try (PreparedStatement pstTotalMotos = cnx.prepareStatement(queryTotalMotos)) {
                pstTotalMotos.setInt(1, numeroFactura);
                ResultSet rsMotos = pstTotalMotos.executeQuery();
                if (rsMotos.next()) {
                    totalMotos = rsMotos.getDouble("total");
                }
            }
            try (PreparedStatement pstTotalPagado = cnx.prepareStatement(queryTotalPagado)) {
                pstTotalPagado.setInt(1, numeroFactura);
                ResultSet rsPagado = pstTotalPagado.executeQuery();
                if (rsPagado.next()) {
                    totalPagado = rsPagado.getDouble("total_pagado");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el total restante por venta -> " + ex);
            mensaje("Error al obtener el total restante", "Consulta!!!");
        }
        return totalMotos - totalPagado;
    }

    public boolean procesarPago(int numeroFactura, double montoPago) {
        Connection cnx = getConexion();
        String queryTotalMotos = "SELECT SUM(m.precio_unitario) AS total FROM ventas_motos vm "
                + "JOIN motos m ON vm.moto_id = m.serial_moto "
                + "WHERE vm.venta_id = ?";
        String queryTotalPagado = "SELECT SUM(monto_pago) AS total_pagado FROM pagos WHERE numero_factura = ?";
        String queryActualizarPago = "UPDATE pagos SET monto_pago = ?, pagado = ? WHERE numero_factura = ?";
        PreparedStatement pstTotalMotos, pstTotalPagado, pstActualizarPago;
        ResultSet rs;

        try {
            pstTotalMotos = cnx.prepareStatement(queryTotalMotos);
            pstTotalMotos.setInt(1, numeroFactura);
            rs = pstTotalMotos.executeQuery();
            double totalMotos = 0;
            if (rs.next()) {
                totalMotos = rs.getDouble("total");
            }
            pstTotalPagado = cnx.prepareStatement(queryTotalPagado);
            pstTotalPagado.setInt(1, numeroFactura);
            rs = pstTotalPagado.executeQuery();
            double totalPagado = 0;
            if (rs.next()) {
                totalPagado = rs.getDouble("total_pagado");
            }
            double nuevoTotalPagado = totalPagado + montoPago;
            pstActualizarPago = cnx.prepareStatement(queryActualizarPago);
            pstActualizarPago.setDouble(1, nuevoTotalPagado);
            pstActualizarPago.setInt(2, nuevoTotalPagado >= totalMotos ? 1 : 0);
            pstActualizarPago.setInt(3, numeroFactura);
            pstActualizarPago.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al procesar el pago -> " + ex);
            mensaje("Error al procesar el pago", "Proceso de Pago!!!");
        }

        return false;
    }

    public boolean crearPagoSiNoExiste(int numeroFactura, double montoPago) {
        Connection cnx = getConexion();
        String queryVerificarPago = "SELECT COUNT(*) AS total FROM pagos WHERE numero_factura = ?";
        String queryTotalMotos = "SELECT SUM(m.precio_unitario) AS total FROM ventas_motos vm "
                + "JOIN motos m ON vm.moto_id = m.serial_moto "
                + "WHERE vm.venta_id = ?";
        String queryAgregarPago = "INSERT INTO pagos (numero_factura, monto_pago, pagado) VALUES (?, ?, ?)";
        String queryTotalPagado = "SELECT SUM(monto_pago) AS total_pagado FROM pagos WHERE numero_factura = ?";
        PreparedStatement pstVerificarPago, pstTotalMotos, pstAgregarPago, pstTotalPagado;
        ResultSet rs;
        try {
            pstVerificarPago = cnx.prepareStatement(queryVerificarPago);
            pstVerificarPago.setInt(1, numeroFactura);
            rs = pstVerificarPago.executeQuery();
            pstTotalMotos = cnx.prepareStatement(queryTotalMotos);
            pstTotalMotos.setInt(1, numeroFactura);
            ResultSet rsMotos = pstTotalMotos.executeQuery();
            double totalMotos = 0;
            if (rsMotos.next()) {
                totalMotos = rsMotos.getDouble("total");
            }
            if (rs.next() && rs.getInt("total") > 0) {
                pstTotalPagado = cnx.prepareStatement(queryTotalPagado);
                pstTotalPagado.setInt(1, numeroFactura);
                rs = pstTotalPagado.executeQuery();
                double totalPagado = 0;
                if (rs.next()) {
                    totalPagado = rs.getDouble("total_pagado");
                }
                double nuevoTotalPagado = totalPagado + montoPago;
                String queryActualizarPago = "UPDATE pagos SET monto_pago = ?, pagado = ? WHERE numero_factura = ?";
                PreparedStatement pstActualizarPago = cnx.prepareStatement(queryActualizarPago);
                pstActualizarPago.setDouble(1, nuevoTotalPagado);
                pstActualizarPago.setInt(2, nuevoTotalPagado >= totalMotos ? 1 : 0);
                pstActualizarPago.setInt(3, numeroFactura);
                pstActualizarPago.executeUpdate();

                return true;
            }
            if (totalMotos > 0) {
                pstAgregarPago = cnx.prepareStatement(queryAgregarPago);
                pstAgregarPago.setInt(1, numeroFactura);
                if (montoPago >= totalMotos) {
                    pstAgregarPago.setDouble(2, totalMotos);
                    pstAgregarPago.setInt(3, 1);
                } else {
                    pstAgregarPago.setDouble(2, montoPago);
                    pstAgregarPago.setInt(3, 0);
                }
                pstAgregarPago.executeUpdate();
                return true;
            } else {
                System.out.println("No hay motos asociadas a la venta con la factura: " + numeroFactura);
            }
        } catch (SQLException ex) {
            System.err.println("Error al crear el pago -> " + ex);
            mensaje("Error al crear el pago", "Crear Pago!!!");
        }

        return false;
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}
