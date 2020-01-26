/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.json.simple.parser.ParseException;
public class ControladorVistaMain {
    
    Vista vista;
    
    Timer timer;
    
    int numeroActual=0;;
    
    
    public ControladorVistaMain(Vista vista) {
        this.vista = vista;
    }
    
    public void iniciarContadorVistaMain() {
        timer = new Timer(30,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (numeroActual <= 100) {
                        numeroActual++;
                        vista.getVistaMain().cambiarPosicionBarra(numeroActual); 
                     }
                    else{
                        detenerContadorVistaMain();
                    }
               } 
            }); 
        //timer.setRepeats(true);
        timer.start();
    }
    
    public void detenerContadorVistaMain() {
        timer.stop();
        CambiarVista();
    }

    public void CambiarVista() {
            try {
                vista.setVistaSecond();
            } catch (IOException ex) {
                Logger.getLogger(ControladorVistaMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVistaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
    