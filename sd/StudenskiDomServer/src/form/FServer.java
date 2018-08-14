/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sesion.Singleton;
import tabela.Tabela;
import thread.ThreadClient;
import thread.ThreadSat;
import thread.ThreadServer;
import transfer.odgovor.ResponseObject;

/**
 *
 * @author Stefan
 */
public class FServer extends javax.swing.JFrame {

    /**
     * Creates new form FServer
     */
    public FServer() {
        initComponents();
        postaviSat();
        jbtnOtkaci.setVisible(false);
        jbtnStopiraj.setEnabled(false);
        jlblBrojPrijavljenih.setText(jtblUlogovani.getRowCount()+"");
        osluskujZaSelekciju();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblSat = new javax.swing.JLabel();
        jbtnPokreniServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblUlogovani = new javax.swing.JTable();
        jbtnOtkaci = new javax.swing.JButton();
        jbtnStopiraj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlblBrojPrijavljenih = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnPokreniServer.setText("PokreniServer");
        jbtnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPokreniServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Trenutno ulogovani referetni:");

        jtblUlogovani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtblUlogovani);

        jbtnOtkaci.setText("Otkaci za servera");
        jbtnOtkaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOtkaciActionPerformed(evt);
            }
        });

        jbtnStopiraj.setText("StopirajServer");
        jbtnStopiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStopirajActionPerformed(evt);
            }
        });

        jLabel2.setText("Broj prijavljenih:");

        jMenu1.setText("Konfiguracija");

        jMenuItem1.setText("Parametri za bazu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtnStopiraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnPokreniServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                                        .addComponent(jlblSat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlblBrojPrijavljenih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addComponent(jbtnOtkaci, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jbtnStopiraj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jlblSat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnPokreniServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jbtnOtkaci))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jlblBrojPrijavljenih, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPokreniServerActionPerformed
        int port = 9090;
        try {
            if (server == null) {
                server = new ThreadServer(port, jtblUlogovani,jlblBrojPrijavljenih);
                server.start();
                System.out.println("server je pokrenut");

            } else {
                server.isInterrupted();
                System.out.println("Server je pnovo pokrenut");
            }
            
            jbtnPokreniServer.setEnabled(false);
            jbtnStopiraj.setEnabled(true);

        } catch (IOException ex) {
            Logger.getLogger(FServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtnPokreniServerActionPerformed

    private void jbtnOtkaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOtkaciActionPerformed
        int i = jtblUlogovani.getSelectedRow();

        Singleton.getInstance().getKlijenti().get(i).interrupt();
       
        try {
            ObjectOutputStream out=new ObjectOutputStream(Singleton.getInstance().getKlijenti().get(i).getSocket().getOutputStream());
            ResponseObject responseObject=new ResponseObject();
            responseObject.setMessage("Otkacen");
            out.writeObject(responseObject);
            out.flush();
            System.out.println("otkacen");
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        Singleton.getInstance().getKlijenti().remove(i);
        System.out.println("odradio ga je");
           
        Tabela.getInstance().osvezi();
        
    }//GEN-LAST:event_jbtnOtkaciActionPerformed

    private void jbtnStopirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStopirajActionPerformed
        // TODO add your handling code here:

        if (server != null) {
            server.interrupt();
            System.out.println("Server je stopiran");
            jbtnPokreniServer.setEnabled(true);
            jbtnStopiraj.setEnabled(false);
        }

        List<ThreadClient> klijenti = Singleton.getInstance().getKlijenti();
        for (ThreadClient threadClient : klijenti) {
            threadClient.interrupt();

        }
       
       
        try {
            for (ThreadClient threadClient : klijenti) {
                
            ObjectOutputStream out=new ObjectOutputStream(threadClient.getSocket().getOutputStream());
            ResponseObject responseObject=new ResponseObject();
            responseObject.setMessage("Otkacen");
            out.writeObject(responseObject);
            out.flush();
            System.out.println("otkacen");
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FServer.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for(int i=0;i<klijenti.size();i++){
//            
//        Singleton.getInstance().getKlijenti().remove(i);
//        System.out.println("odradio ga je");
//        Tabela.getInstance().osvezi();
//        
//        
//        }
         Singleton.getInstance().obrisiSve();
         Tabela.getInstance().osvezi();
         
        
    }//GEN-LAST:event_jbtnStopirajActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FBaza f=new FBaza();
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnOtkaci;
    private javax.swing.JButton jbtnPokreniServer;
    private javax.swing.JButton jbtnStopiraj;
    private javax.swing.JLabel jlblBrojPrijavljenih;
    private javax.swing.JLabel jlblSat;
    private javax.swing.JTable jtblUlogovani;
    // End of variables declaration//GEN-END:variables
    private Thread nitSat;
    private Thread server;

    private void postaviSat() {
        nitSat = new ThreadSat(jlblSat);
        nitSat.start();
    }

    private void osluskujZaSelekciju() {
        jtblUlogovani.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jbtnOtkaci.setVisible(true);
            }
        });

    }

}