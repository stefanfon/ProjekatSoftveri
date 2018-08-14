/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domen.Prenociste;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class PrenocisteModelPrikaz extends AbstractTableModel{

    private List<Prenociste> prenocista;
    
    String [] columnName=new String[]{"Student ","DatumOD","DatumDO","Gost"};

    public PrenocisteModelPrikaz(List<Prenociste> prenocista) {
        this.prenocista = prenocista;
    }
    
    
    public int getRowCount() {
        return prenocista.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prenociste prenociste=prenocista.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
        switch(columnIndex){
            case 0: return prenociste.getStudent().getIme()+" "+prenociste.getStudent().getPrezime() ;
            
            case 1: return sdf.format(prenociste.getDatumOd());
            case 2: return sdf.format(prenociste.getDatumDo());
            
            case 3: return prenociste.getGost().getIme()+" "+prenociste.getGost().getPrezime() ;
           
            default: return "N/A";
        }
    }
    @Override
    public String getColumnName(int column) {
        return columnName[column]; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Prenociste> vratiSvaPrenocista(){
        return prenocista;
    }
    
}
