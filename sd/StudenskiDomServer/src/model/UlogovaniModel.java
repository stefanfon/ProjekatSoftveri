/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import thread.ThreadClient;
import transfer.interfejsi.Ulogovani;

/**
 *
 * @author Stefan
 */
public class UlogovaniModel extends AbstractTableModel{

    List<ThreadClient> ulogovani;
    String [] columntName={"Ime i Prezime","Vreme Prijave"};

    public UlogovaniModel(List<ThreadClient> ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    
    public int getRowCount() {
        return ulogovani.size();
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        ThreadClient u=ulogovani.get(rowIndex);
        switch(columnIndex){
            case 0: return u.getIme()+" "+u.getPrezime();
            
            case 1: return u.getVreme();
            
            default: return "N/A";
        }
    }

    @Override
    public int getColumnCount() {
        return columntName.length;
    }
    public String getColumnName(int column) {
        return columntName[column]; //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
