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

/**
 *
 * @author Jorge
 */
public class ControladorTimerVistaThird implements ActionListener {
    
    Timer timer;
    Conexion con;
    Vista vista;
    
    
    public ControladorTimerVistaThird(Vista vista) throws IOException, ParseException {
        this.vista = vista;
        iniciarTimerVistaThird();
        con = new Conexion();
    }
    
    public void iniciarTimerVistaThird() {
        timer = new Timer(1500, this);
        timer.setRepeats(true);
        timer.start();
    }
    
    public void detenerTimerVistaThird() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean check = false;
        try {
            check = con.comprobarTodosListos();
        } catch (IOException ex) {System.out.println("Error el de conexion Timer");}
        if(check){
           vista.setVistaFourth();
           detenerTimerVistaThird();
        }
        
        
    }
    
}
