/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProyectoYamaha;

import Controlador.CtlCerrarSesion;
import Controlador.CtlViewPrincipal;
import Modelo.DaoUsuario;
import Modelo.Inventario;
import Modelo.Moto;
import Modelo.Persona;
import Modelo.Sede;
import Modelo.Usuario;
import Modelo.Venta;
import Vista.CerrarSesion;
import Vista.ViewAdministrador;
import Vista.ViewCatalogoPrincipal;
import Vista.ViewPrincipal;
import Vista.ViewVendedor;



/**
 *
 * @author User
 */
public class ProyectoYamaha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Datos
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Moto moto = new Moto();
        Sede sede = new Sede();
        Venta venta = new Venta();
        Inventario inventario = new Inventario();
        
        //Dao
        DaoUsuario daousuario = new DaoUsuario();
        
        
        
        //Vistas
        ViewPrincipal vp = new ViewPrincipal();
        ViewAdministrador vpa = new ViewAdministrador();
        ViewVendedor vpv = new ViewVendedor();
        ViewCatalogoPrincipal vcp = new ViewCatalogoPrincipal();
        CerrarSesion cs = new CerrarSesion();
        
        
        //Controladores
        CtlViewPrincipal ctlvp = new CtlViewPrincipal(vp, vpa, vpv, vcp, daousuario, usuario);
        CtlCerrarSesion ctlcs = new CtlCerrarSesion(vp, vpv, vpa, cs);
        
        vp.setVisible(true);
    }
    
}
