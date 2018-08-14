/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.util.ArrayList;
import java.util.List;
import thread.ThreadClient;

/**
 *
 * @author Stefan
 */
public final class Singleton {
    private static volatile Singleton instance = null;
    private List<ThreadClient> klijenti;
    private Singleton() {
    klijenti=new ArrayList<>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public List<ThreadClient> getKlijenti() {
        return klijenti;
    }
    public void dodaj(ThreadClient client){
        klijenti.add(client);
    }
    public void obrisi(ThreadClient client){
        klijenti.remove(client);
    }
    public void obrisiSve(){
        klijenti.clear();
        instance=null;
    }

    
   
}