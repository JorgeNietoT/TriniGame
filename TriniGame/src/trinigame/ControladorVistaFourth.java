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

/**
 *
 * @author Jorge
 */
public class ControladorVistaFourth implements ItemListener {
    
    VistaFourth vistaFourth;
    
    public ControladorVistaFourth(VistaFourth vistaFourth) {
        this.vistaFourth = vistaFourth;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch ((((Checkbox)(e.getSource())).getName())) {
            case "respuesta1":
                System.out.println("respuesta1");
            break;
            case "respuesta2":
                System.out.println("respuesta2");
            break;
            case "respuesta3":
                System.out.println("respuesta3");
            break;
            case "respuesta4":
                System.out.println("respuesta4");
            break;
        }
    }
    
}
