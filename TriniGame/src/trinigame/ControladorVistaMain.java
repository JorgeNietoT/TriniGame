/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Jorge
 */
public class ControladorVistaMain implements ActionListener {
    
    Vista vista;
    
    Timer timer;
    
    int contador = 1;
    
    public ControladorVistaMain(Vista vista) {
        this.vista = vista;
    }
    
    public void iniciarContadorVistaMain() {
        timer = new Timer(650, this);
        timer.setRepeats(true);
        timer.start();
    }
    
    public void detenerContadorVistaMain() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (contador == 0){
           vista.setVistaSecond();
           detenerContadorVistaMain();
        } else {
            contador--;
        }
    }
    
}
