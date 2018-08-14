/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.UlogovaniModel;
import sesion.Singleton;

/**
 *
 * @author Stefan
 */
public class Tabela {
    private static volatile Tabela instance = null;
    private JTable tabela;
    private JLabel brojUlogovanih;
    public void setTabela(JTable tabela,JLabel brojUlogovanih) {
        this.tabela = tabela;
        this.brojUlogovanih=brojUlogovanih;
    }
    
    
    private Tabela(){
        
    }
    public static Tabela getInstance(){
        
        if(instance==null){
            instance=new Tabela();
        }
        return instance;
    }
    public void osvezi(){
        UlogovaniModel um=new UlogovaniModel(Singleton.getInstance().getKlijenti());
            tabela.setModel(um);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setHorizontalAlignment( JLabel.CENTER );
       tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
       tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tabela.setVisible(true);
            brojUlogovanih.setText(tabela.getRowCount()+"");
    }
}
