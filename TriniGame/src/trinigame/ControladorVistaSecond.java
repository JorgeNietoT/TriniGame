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
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jorge
 */
public class ControladorVistaSecond implements ActionListener {
    private boolean response;
    private Logica log;
    private Vista vista;
    private VistaSecond vistaSecond;
    
    
    public ControladorVistaSecond(Vista vista, VistaSecond vistaSecond) throws IOException, ParseException {
        this.vista = vista;
        this.vistaSecond = vistaSecond;
        log = new Logica();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
             response = log.comprobarExisteUsuario( Integer.parseInt(vistaSecond.getUserId()));
        } catch (IOException ex) {
          
        } catch (ParseException ex) {
 
        }
        
        if(response){
            System.out.println(vistaSecond.getUserId());
            System.out.println("Hola");
            //vista.setVistaThird();
        }else{
            System.out.println(vistaSecond.getUserId());
            System.out.println("No te conozco");
        }
    }
    
}
