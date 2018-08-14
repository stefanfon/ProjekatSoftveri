/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Stefan
 */
public class JtxtListener implements DocumentListener {

    
    
    JTextComponent comp = null;
    Border defaBorder = null;
    Border color = BorderFactory.createLineBorder(Color.red);

    public JtxtListener(JTextComponent jtc) {
        comp = jtc;
        defaBorder = comp.getBorder();
        comp.getDocument().addDocumentListener(this);
        this.osluskuj();
    }

    public void insertUpdate(DocumentEvent e) {
        osluskuj();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        osluskuj();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        osluskuj();
    }

    private void osluskuj() {
        if (comp.getText().trim().length() != 0) {
            comp.setBorder(defaBorder);

        } else {
            comp.setBorder(color);
        }
      
        
    }

}
