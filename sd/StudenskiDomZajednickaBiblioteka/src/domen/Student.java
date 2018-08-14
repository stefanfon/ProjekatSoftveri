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
public class Student extends OpstiDomenskiObjekat implements Serializable{
    private Long StudentID;
    private String JMBG,BrojCipKartice,Ime,Prezime;
    private StudenskiDom studenskiDom;
    private Grad grad;
    private List<Prenociste> prenocista;
    
    public List<Prenociste> getPrenocista() {
        return prenocista;
    }

    public void setPrenocista(List<Prenociste> prenocista) {
        this.prenocista = prenocista;
    }
    
    
    
    public Student(){
        
    }

    public Student(String JMBG, String BrojCipKartice, String Ime, String Prezime, StudenskiDom studenskiDom, Grad grad) {
        this.JMBG = JMBG;
        this.BrojCipKartice = BrojCipKartice;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.studenskiDom = studenskiDom;
        this.grad = grad;
    }
    
    public Student(Long StudentID, String JMBG, String BrojCipKartice, String Ime, String Prezime, StudenskiDom studenskiDom, Grad grad) {
        this.StudentID = StudentID;
        this.JMBG = JMBG;
        this.BrojCipKartice = BrojCipKartice;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.studenskiDom = studenskiDom;
        this.grad = grad;
    }

    public Long getStudentID() {
        return StudentID;
    }

    public void setStudentID(Long StudentID) {
        this.StudentID = StudentID;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getBrojCipKartice() {
        return BrojCipKartice;
    }

    public void setBrojCipKartice(String BrojCipKartice) {
        this.BrojCipKartice = BrojCipKartice;
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

    public StudenskiDom getStudenskiDom() {
        return studenskiDom;
    }

    public void setStudenskiDom(StudenskiDom studenskiDom) {
        this.studenskiDom = studenskiDom;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String vratiImeKlase() {
        return "student";
    }

    public String vratiVrednostiAtributa() {
        return "'"+getJMBG()+"','"+getBrojCipKartice()+"','"+Ime+"','"+Prezime+"',"+studenskiDom.getStudenskiDomId()+","+grad.getPttBroj();
    }
    
    public String postaviVrednostAtributa() {
     
      return "JMBG='"+getJMBG()+"',BrojCipKartice='"+getBrojCipKartice()+"',Ime='"+Ime+"',Prezime='"+Prezime+"',StudenskiDomID="+studenskiDom.getStudenskiDomId()+",PttBroj="+grad.getPttBroj();
    }

    public String vratiUslovZaNadjiSlog() {
        return "StudentID="+StudentID;
    }

    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String vratiNaziveAtributaZaKreiraj() {
       return "JMBG,BrojCipKartice,Ime,Prezime,StudenskiDomID,PttBroj";
    }

    public OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception {
        StudenskiDom sd=new StudenskiDom();
        sd.setStudenskiDomId(rs.getLong("StudenskiDomID"));
        
       Grad g=new Grad();
       g.setPttBroj(rs.getLong("PttBroj"));
       return new Student(rs.getLong("StudentID"), rs.getString("JMBG"), rs.getString("BrojCipKartice"), rs.getString("Ime"), rs.getString("Prezime"),sd,g);
        
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
