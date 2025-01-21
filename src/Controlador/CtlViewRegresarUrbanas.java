package Controlador;

import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoUrbanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanc
 */
public class CtlViewRegresarUrbanas implements ActionListener {

    private ViewCatalogoPrincipal vcp;
    private ViewCatalogoUrbanas cus;

    public CtlViewRegresarUrbanas(ViewCatalogoPrincipal vcp, ViewCatalogoUrbanas cus) {
        this.vcp = vcp;
        this.cus = cus;

        this.cus.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(cus.btnVolver)) {
            vcp.setVisible(true);
            cus.dispose();
        }
    }

}
