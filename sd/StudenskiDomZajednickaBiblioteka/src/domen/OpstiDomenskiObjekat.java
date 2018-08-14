/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Petar
 */
public abstract class OpstiDomenskiObjekat {
    
    private String uslovPretrage="";

    public String getUslovPretrage() {
        return uslovPretrage;
    }

    public void setUslovPretrage(String uslovPretrage) {
        this.uslovPretrage =" WHERE "+uslovPretrage;
    }
    
    
    
    
    public abstract String vratiImeKlase();
    public abstract String vratiVrednostiAtributa();//vrednosti za insert
    public abstract String postaviVrednostAtributa();//za update
    public abstract String vratiUslovZaNadjiSlog(); //PO PRRIMARNOM KLJUCU                    
   
   
    public abstract String vratiNaziveAtributaZaKreiraj();//nazivi kolona za insert
    public abstract OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception;
    public abstract List<OpstiDomenskiObjekat> vratiListuZaResultSet(ResultSet rs ) throws Exception;
     
   
     
    
}
