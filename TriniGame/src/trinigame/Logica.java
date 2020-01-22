/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dmmli
 */
public class Logica {
    
    private Conexion con;
    
    public Logica() throws IOException, ParseException{
        con = new Conexion();
    }
    
    public boolean comprobarExisteUsuario(int id) throws IOException, MalformedURLException, ParseException{
        Object obj = con.showUser(id);
        
        if(obj != null) return true;
        return false;
        
    }

}
