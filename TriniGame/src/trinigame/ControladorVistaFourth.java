/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jorge
 */
public class ControladorVistaFourth implements ItemListener {
    
    VistaFourth vistaFourth;
    private Vista vista;
    private Logica log;
    
    public ControladorVistaFourth(VistaFourth vistaFourth,Logica log, Vista vista) {
        this.vista = vista;
        log = vista.getLog();
        this.vistaFourth = vistaFourth;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch ((((Checkbox)(e.getSource())).getName())) {
            case "respuesta1":
               
                log = vista.getLog();
                {
                    try {
                        log.mandarRespuestaUsuario(1);
                    } catch (IOException ex) {}
                }
                mostrarSiguientePregunta();
            break;
            case "respuesta2":
                 log = vista.getLog();
                 {
                    try {
                        log.mandarRespuestaUsuario(2);
                    } catch (IOException ex) {}
                 }
                mostrarSiguientePregunta();
            break;
            case "respuesta3":
                 log = vista.getLog();
                 {
                    try {
                        log.mandarRespuestaUsuario(3);
                    } catch (IOException ex) {}
                 }
                mostrarSiguientePregunta();
            break;
            case "respuesta4":
                log = vista.getLog();
                 {
                    try {
                        log.mandarRespuestaUsuario(4);
                    } catch (IOException ex) {}
                 }
                mostrarSiguientePregunta();
                
            break;
        }
    }
    
    public void mostrarSiguientePregunta(){
         
         log.siguienteTurno();
         int contPregunta = log.darContadorPregunta();
        
         try {
            vista.setVistaFourth(contPregunta);
         }catch (ParseException ex) {} catch (IOException ex) {}
        
    }
    

}
