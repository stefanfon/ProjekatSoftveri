/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controler.Controller;

import domen.Student;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class StudentModel  extends AbstractTableModel {
    
    List<Student> studenti;
    
    String [] columnName=new String[]{"Student ID","Ime","Prezime","Studenski Dom","Grad"};
    
    public StudentModel(List<Student> studenti) {
        this.studenti = studenti;
    }
    
    
    
    public int getRowCount() {
        return studenti.size();
    }

    @Override
   
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s=studenti.get(rowIndex);
        
        switch(columnIndex){
            case 0: return s.getStudentID();
            
            case 1: return s.getIme();
            case 2: return s.getPrezime();
            
            case 3: return s.getStudenskiDom().getNaziv();
            case 4: return s.getGrad().getNaziv();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column]; //To change body of generated methods, choose Tools | Templates.
    }
    public void removeStudent(int i) throws SQLException, Exception{
        Controller.ObrisiStudenta(studenti.get(i));
       
        studenti.remove(i);
    }
    public List<Student> vratiStudente(){
        return studenti;
    }
    
    
    
}
