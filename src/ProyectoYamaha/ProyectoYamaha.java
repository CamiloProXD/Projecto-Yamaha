/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProyectoYamaha;

import Controlador.CtlViewCatalogoPrincipal;
import Controlador.CtlViewCerrarSesion;
import Controlador.CtlViewPrincipal;
import Modelo.DaoUsuario;
import Modelo.Inventario;
import Modelo.Moto;
import Modelo.Persona;
import Modelo.Sede;
import Modelo.Usuario;
import Modelo.Venta;
import Vista.ViewCerrarSesion;
import Vista.ViewAdministrador;
import Vista.ViewCatalogoAutomaticas;
import Vista.ViewCatalogoCross;
import Vista.ViewCatalogoDeportivas;
import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoSuperDep;
import Vista.ViewCatalogoTodoTer;
import Vista.ViewCatalogoUrbanas;
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
        ViewCerrarSesion cs = new ViewCerrarSesion();
        ViewCatalogoDeportivas vcd = new ViewCatalogoDeportivas();
        ViewCatalogoSuperDep vsd = new ViewCatalogoSuperDep();
        ViewCatalogoAutomaticas vca = new ViewCatalogoAutomaticas();
        ViewCatalogoCross vcc = new ViewCatalogoCross();
        ViewCatalogoUrbanas vcu = new ViewCatalogoUrbanas();
        ViewCatalogoTodoTer vctt = new ViewCatalogoTodoTer();
        
        
        //Controladores
        CtlViewPrincipal ctlvp = new CtlViewPrincipal(vp, vpa, vpv, vcp, daousuario, usuario);
        CtlViewCerrarSesion ctlcs = new CtlViewCerrarSesion(vp, vpv, vpa, cs);
        CtlViewCatalogoPrincipal ctlvcp = new CtlViewCatalogoPrincipal(vcp, vcd, vsd, vca, vcc, vcu, vctt, vp);
        
        vp.setVisible(true);
    }
    
}
