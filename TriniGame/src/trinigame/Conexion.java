package trinigame;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Conexion {
   private URL url;
   private String urlConectar = "http://localhost/TriniGame/public/conectar/";
   private BufferedReader in;
   private String in_json;

    public Conexion() throws  IOException, ParseException {
      
       
    }
    
    public Object showUser(int id) throws MalformedURLException, IOException, ParseException{
        
        urlConectar = "http://localhost/TriniGame/public/conectar/";
        
         urlConectar += id;
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         //Objeto para recibir respuesta
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         //Leemos
         in_json = in.readLine();
         
         JSONParser parser = new JSONParser();
         
         Object obj = parser.parse(in_json);
         
         
         in.close();
         
         return obj;
    }
    
}


