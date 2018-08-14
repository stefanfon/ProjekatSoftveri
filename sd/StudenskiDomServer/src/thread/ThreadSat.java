/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Stefan
 */
public class ThreadSat  extends Thread{
    
    JLabel sat;

    public ThreadSat(JLabel sat) {
        this.sat = sat;
    }
    
    
    
    
    @Override
    
    public void run() {
        while(!isInterrupted()){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String s = sdf.format(date);
            sat.setText(s);
        }

    }
    
}
