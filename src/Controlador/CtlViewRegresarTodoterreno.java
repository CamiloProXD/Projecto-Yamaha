
package Controlador;

import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoTodoterreno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanc
 */
public class CtlViewRegresarTodoterreno implements ActionListener{

    private ViewCatalogoPrincipal vcp;
    private ViewCatalogoTodoterreno ctt;

    public CtlViewRegresarTodoterreno(ViewCatalogoPrincipal vcp, ViewCatalogoTodoterreno ctt) {
        this.vcp = vcp;
        this.ctt = ctt;
        this.ctt.btnVolver.addActionListener(this);
    }
       
    @Override
    public void actionPerformed(ActionEvent ev) {
         if (ev.getSource().equals(ctt.btnVolver)) {
            vcp.setVisible(true);
            ctt.dispose();
        }
    }
    
}
