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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class StudenskiDom extends OpstiDomenskiObjekat implements Serializable{
    private Long StudenskiDomId;
   private String Naziv,Adresa;
   private Referent referent;

    public StudenskiDom() {
    }
   
   

    public StudenskiDom(Long StudenskiDomId, String Naziv, String Adresa, Referent referenti) {
        this.StudenskiDomId = StudenskiDomId;
        this.Naziv = Naziv;
        this.Adresa = Adresa;
        this.referent = referenti;
    }

    public Referent getReferenti() {
        return referent;
    }

    public void setReferenti(Referent referenti) {
        this.referent = referenti;
    }

    

    public Long getStudenskiDomId() {
        return StudenskiDomId;
    }

    public void setStudenskiDomId(Long StudenskiDomId) {
        this.StudenskiDomId = StudenskiDomId;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    @Override
    public String toString() {
        return Naziv ;
    }

    
    public String vratiImeKlase() {
        return "studenskidom";
    }

    
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public String postaviVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String vratiUslovZaNadjiSlog() {
        return "StudenskiDomID="+StudenskiDomId;
    }

    
    public String vratiUslovZaNadjiSlogove() {
       return "BrojRadneKnjizice="+referent.getBrojRadneKnjizice();
    }

    public String vratiNaziveAtributaZaKreiraj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public OpstiDomenskiObjekat    napraviDomenskiObjekat(ResultSet rs) throws Exception {


        Referent referent=new Referent();
        referent.setBrojRadneKnjizice(rs.getString("BrojRadneKnjizice"));
        
        return new StudenskiDom(rs.getLong("StudenskiDomID"),rs.getString("Naziv"),rs.getString("Adresa"), referent);
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
