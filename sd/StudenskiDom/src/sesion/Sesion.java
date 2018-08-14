/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stefan
 */
public class Sesion {
    private static Sesion instance;
    private Map<String, Object> map;
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
    private Sesion() {
        map = new HashMap<>();
    }
    
    public static Sesion getInstance(){
        if (instance == null) instance = new Sesion();
        return instance;
    }

    public Map<String, Object> getMap() {
        return map;
    }
                   
}