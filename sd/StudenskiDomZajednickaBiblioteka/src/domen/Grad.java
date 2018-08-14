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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class Grad extends OpstiDomenskiObjekat implements Serializable{
  private  Long PttBroj;
  private String naziv;

    public Grad(Long PttBroj, String naziv) {
        this.PttBroj = PttBroj;
        this.naziv = naziv;
    }
    public Grad(){
        
    }

    public Long getPttBroj() {
        return PttBroj;
    }

    public void setPttBroj(Long PttBroj) {
        this.PttBroj = PttBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public String toString(){
        return naziv;
  
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.PttBroj);
        hash = 23 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grad other = (Grad) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.PttBroj, other.PttBroj)) {
            return false;
        }
        return true;
    }

   
    public String vratiImeKlase() {
        return "grad";
    }

    
    public String vratiVrednostiAtributa() {
        return "'"+getNaziv()+"'";
    }

    
    public String postaviVrednostAtributa() {
        return "Naziv='"+getNaziv()+"'";
    }

    
    public String vratiUslovZaNadjiSlog() {
        return "PttBroj="+getPttBroj();
    }

    
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String vratiNaziveAtributaZaKreiraj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception {
            return new Grad(rs.getLong("PttBroj"),rs.getString("Naziv"));
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
