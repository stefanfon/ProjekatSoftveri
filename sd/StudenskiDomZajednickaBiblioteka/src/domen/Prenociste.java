/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class Prenociste extends OpstiDomenskiObjekat implements Serializable{

    private Long RedniBroj;
    private Date DatumOd;
    private Date DatumDo;
    private Student student;
    private Referent referent;
    private Gost gost;
    private int brojDana;

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }
    
    

    public Prenociste() {
    }

    public Prenociste(Long RedniBroj, Date DatumOd, Date DatumDo, Student student, Referent referent, Gost gost) {
        this.RedniBroj = RedniBroj;
        this.DatumOd = DatumOd;
        this.DatumDo = DatumDo;
        this.student = student;
        this.referent = referent;
        this.gost = gost;
    }

    public Long getRedniBroj() {
        return RedniBroj;
    }

    public void setRedniBroj(Long RedniBroj) {
        this.RedniBroj = RedniBroj;
    }

    public Date getDatumOd() {
        return DatumOd;
    }

    public void setDatumOd(Date DatumOd) {
        this.DatumOd = DatumOd;
    }

    public Date getDatumDo() {
        return DatumDo;
    }

    public void setDatumDo(Date DatumDo) {
        this.DatumDo = DatumDo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Referent getReferent() {
        return referent;
    }

    public void setReferent(Referent referent) {
        this.referent = referent;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    @Override
    public String vratiImeKlase() {
        return "prenociste";
    }

    @Override
    public String vratiVrednostiAtributa() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datum = sdf.format(getDatumOd());
          
            String datumDo = sdf.format(getDatumDo());
            
            
        return "'"+java.sql.Date.valueOf(datum)+"','"+java.sql.Date.valueOf(datumDo)+"',"+getStudent().getStudentID()+",'"+getReferent().getBrojRadneKnjizice()+"',"+getGost().getId();
    }

    @Override
    public String postaviVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "RedniBroj="+getRedniBroj();
    }


    @Override
    public String vratiNaziveAtributaZaKreiraj() {
        return "DatumOd,DatumDo,StudentID,BrojRadneKnjizice,GostID";
    }

    @Override
    public OpstiDomenskiObjekat napraviDomenskiObjekat(ResultSet rs) throws Exception {
        Student s=new Student();
        s.setStudentID(rs.getLong("StudentID"));
        Gost g=new Gost();
        g.setId(rs.getLong("GostID"));
        Referent ref=new Referent();
        ref.setBrojRadneKnjizice(rs.getString("BrojRadneKnjizice"));
        
        return new Prenociste(rs.getLong("RedniBroj"), rs.getDate("DatumOd"), rs.getDate("DatumDo"), s, ref, g);
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
