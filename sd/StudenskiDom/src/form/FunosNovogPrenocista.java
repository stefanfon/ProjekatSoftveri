/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import controler.Controller;
import domen.Grad;
import domen.Prenociste;
import domen.Referent;
import domen.Student;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import models.PrenocistaModel;
import sesion.Sesion;

/**
 *
 * @author Stefan
 */
public class FunosNovogPrenocista extends javax.swing.JFrame {

    /**
     * Creates new form FunosNovogPrenocista
     */
    private List<Prenociste> prenocista;
    private Student student;
    private PrenocistaModel pm;
    

    public FunosNovogPrenocista(Student s) throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        prenocista = new ArrayList<>();

      
       
        this.student = s;
        jlblStudent.setText(student.getIme() + " " + student.getPrezime());

        /////
        /////
        popuniLabeluSaBrojemDana();
          podesitabelu();
           popunicelijusaCombo();
        setstatusbar();
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlblStudent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPrenocista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jbtnDodajNovo = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlblBrojPrijavljenihDana = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Student koji prijavljuje prenociste:");

        jlblStudent.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jtblPrenocista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblPrenocista.setRowHeight(25);
        jScrollPane1.setViewportView(jtblPrenocista);

        jButton1.setText("Sacuvaj Sva prenocista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtnDodajNovo.setText("Dodaj novo prenocisete");
        jbtnDodajNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajNovoActionPerformed(evt);
            }
        });

        jbtnObrisi.setText("Obrisi oznaceno prenociste");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jLabel2.setText("Broj prijavljenih prenocista  u tekucem mesecu:");

        jlblBrojPrijavljenihDana.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jlblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnDodajNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnObrisi)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jlblBrojPrijavljenihDana, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnObrisi)
                    .addComponent(jbtnDodajNovo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jlblBrojPrijavljenihDana, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrenocistaModel pm = (PrenocistaModel) jtblPrenocista.getModel();

        List<Prenociste> listaPrenocista = pm.getPrenocista();
        
        if (listaPrenocista != null && listaPrenocista.size()!=0) {
            
            for (Prenociste prenociste : listaPrenocista) {
                prenociste.setStudent(student);
                Referent referent=(Referent)Sesion.getInstance().getMap().get("ulogovani");
                prenociste.setReferent(referent);
                System.out.println(prenociste.getDatumDo());
                
            }
            try {
                if(proveriDaLiSuSvaPoljaPopunjena(listaPrenocista)){
                Controller.sacuvajSvaPrenocista(listaPrenocista);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena");
                }
            } catch (Exception ex) {
                Logger.getLogger(FunosNovogPrenocista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Niste ubacili ni jedno prenociste");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnDodajNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajNovoActionPerformed
        PrenocistaModel pm = (PrenocistaModel) jtblPrenocista.getModel();
        pm.dodajNovoPrenociseteUlistu();
    }//GEN-LAST:event_jbtnDodajNovoActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed

        int selectedROw = jtblPrenocista.getSelectedRow();

        if (selectedROw >= 0) {
            PrenocistaModel pm = (PrenocistaModel) jtblPrenocista.getModel();
            pm.obrisatired(selectedROw);
            
            
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDodajNovo;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JLabel jlblBrojPrijavljenihDana;
    private javax.swing.JLabel jlblStudent;
    private javax.swing.JTable jtblPrenocista;
    // End of variables declaration//GEN-END:variables

    private void podesitabelu() throws Exception {

        pm = new PrenocistaModel(prenocista,jlblBrojPrijavljenihDana);
        jtblPrenocista.setModel(pm);

        podesiSirinu();
        JComboBox comboBox = new JComboBox();

        comboBox.removeAllItems();
        List<Grad> gradovi = Controller.vratiSveGradove();
        for (Grad grad : gradovi) {
            comboBox.addItem(grad);
        }

        TableColumn columnProduct = jtblPrenocista.getColumnModel().getColumn(6);
        columnProduct.setCellEditor(new DefaultCellEditor(comboBox));

        TableColumn datumOD = jtblPrenocista.getColumnModel().getColumn(4);
        datumOD.setCellRenderer(new JDateChooserRenderer());
        datumOD.setCellEditor(new JDateChooserCellEditor());

        TableColumn datumDo = jtblPrenocista.getColumnModel().getColumn(5);
        datumDo.setCellRenderer(new JDateChooserRenderer());
        datumDo.setCellEditor(new JDateChooserCellEditor());

    }

    private void setstatusbar() {
        setLayout(new BorderLayout());

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(statusPanel, BorderLayout.SOUTH);

        statusPanel.setPreferredSize(new Dimension(getWidth(), 30));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        Referent r = (Referent) Sesion.getInstance().getMap().get("ulogovani");
        JLabel statusLabel = new JLabel("Trenutno ulogovani referent:" + r.getIme() + " " + r.getPrezime());

        statusPanel.add(statusLabel);
    }
    private JComboBox<Object> gradovi = new JComboBox<>();

    private void popunicelijusaCombo() throws Exception {
        List<Grad> listagradova = Controller.vratiSveGradove();
        gradovi.removeAllItems();
        for (Grad grad : listagradova) {
            gradovi.addItem(grad);

        }
        TableColumn tc = jtblPrenocista.getColumnModel().getColumn(6);
        tc.setCellEditor(new DefaultCellEditor(gradovi));

    }

    private void podesiSirinu() {
        jtblPrenocista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtblPrenocista.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtblPrenocista.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtblPrenocista.getColumnModel().getColumn(2).setPreferredWidth(150);
        jtblPrenocista.getColumnModel().getColumn(3).setPreferredWidth(150);
        jtblPrenocista.getColumnModel().getColumn(4).setPreferredWidth(200);
        jtblPrenocista.getColumnModel().getColumn(5).setPreferredWidth(200);
        jtblPrenocista.getColumnModel().getColumn(6).setPreferredWidth(150);
        jtblPrenocista.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        //da vrednost teksta bude u centru
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    }

    private void popuniLabeluSaBrojemDana() throws Exception {
        int brojdana=Controller.vratiBrojDanaZaStudenta(student);
        
        jlblBrojPrijavljenihDana.setText(brojdana+"");
    }

    private boolean proveriDaLiSuSvaPoljaPopunjena(List<Prenociste> listaPrenocista) {
        
        for (Prenociste prenociste : listaPrenocista) {
            if(prenociste.getDatumDo()==null || prenociste.getDatumOd()==null || prenociste.getGost().getIme().equals("") || prenociste.getGost().getPrezime().equals("")
                    || prenociste.getGost().getJmbg().equals("") && prenociste.getGost().getGrad()==null){
                return false;
            }
        }
        
        
        return true;
    }

}
