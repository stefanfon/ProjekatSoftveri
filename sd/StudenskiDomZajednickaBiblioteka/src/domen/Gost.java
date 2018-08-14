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
public class Gost extends OpstiDomenskiObjekat implements Serializable{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   private String jmbg;
   private String ime;
   private String prezime;
  
   private Grad grad;

    public Gost() {
    }

    public Gost(String jmbg, String ime, String prezime, Grad grad) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
       
        this.grad = grad;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Gost(Long id, String jmbg, String ime, String prezime, Grad grad) {
        this.id = id;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
    }
    

   

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String vratiImeKlase() {
        return "gost2";
    }

    @Override
    public String vratiVrednostiAtributa() {
               return "'"+getJmbg()+"','"+getIme()+"','"+prezime+"',"+grad.getPttBroj();
    }

    @Override
    public String postaviVrednostAtributa() {
        return "JMBGGosta='"+getJmbg()+"',Ime='"+getIme()+"',Prezime='"+getPrezime()+"',PttBroj="+getGrad().getPttBroj();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "id="+getId();
    }

    

    @Override
    public String vratiNaziveAtributaZaKreiraj() {
      return  "JMBGGosta,Ime,Prezime,PttBroj";
    }

    @Override
    public OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception {
        Grad gr=new Grad();
       gr.setPttBroj(rs.getLong("PttBroj"));
       
       return new Gost(rs.getLong("id"),rs.getString("JMBGGosta"), rs.getString("Ime"), rs.getString("Prezime"),gr);
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuZaResultSet(ResultSet rs) throws Exception {
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
