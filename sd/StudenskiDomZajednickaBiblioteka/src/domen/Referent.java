/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class Referent extends OpstiDomenskiObjekat implements Serializable{
    private String JMBG,Ime,Prezime;
private String BrojRadneKnjizice;
    public Referent(){
        
    }
    public Referent(String BrojRadneKnjizice, String JMBG, String Ime, String Prezime) {
        this.BrojRadneKnjizice = BrojRadneKnjizice;
        this.JMBG = JMBG;
        this.Ime = Ime;
        this.Prezime = Prezime;
    }

    public String getBrojRadneKnjizice() {
        return BrojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String BrojRadneKnjizice) {
        this.BrojRadneKnjizice = BrojRadneKnjizice;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    
    public String vratiImeKlase() {
        return "referent";
    }

    
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String postaviVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String vratiUslovZaNadjiSlog() {
        return "BrojRadneKnjizice="+getBrojRadneKnjizice();
    }

    
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String vratiNaziveAtributaZaKreiraj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception {
        return new Referent(rs.getString("BrojRadneKnjizice"),rs.getString("JMBG"), rs.getString("Ime"),rs.getString("Prezime"));
    }

  
    public List<OpstiDomenskiObjekat> vratiListuZaResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        try {
            while(rs.next()){
                lista.add(napraviDomenskiObjekat(rs));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Referent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Referent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

   
    

    
    
    
    
            
}
