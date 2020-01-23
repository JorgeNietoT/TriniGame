/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import org.json.simple.parser.ParseException;
import static trinigame.Logica.ID_USUARIO;


/**
 *
 * @author Jorge
 */
public class ControladorVistaThird implements ActionListener {
    
    private Vista vista;
    VistaThird vistaThird;
    private Conexion con;
    
    public ControladorVistaThird(VistaThird vistaThird, Vista vista) throws IOException, ParseException {
        this.vistaThird = vistaThird;
        this.vista = vista;
        con = new Conexion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        int id = ID_USUARIO;
        if ((((JRadioButton)(e.getSource())).isSelected())) {
            try {
                con.cambiarEstadoPreparadoTrue(id);
                System.out.println(con.showUser(id));
            } catch (IOException ex) {} catch (ParseException ex) {}
        } else {
            try {
                try {
                    con.cambiarEstadoAPreparadoFalse(id);
                } catch (MalformedURLException ex) { } catch (ParseException ex) {}
            } catch (IOException ex) {}
            try {
                System.out.println(con.showUser(id));
            } catch (IOException ex) {} catch (ParseException ex) {}
        }
    }
    
}
