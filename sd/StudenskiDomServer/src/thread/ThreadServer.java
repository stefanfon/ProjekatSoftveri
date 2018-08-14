/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import model.UlogovaniModel;
import tabela.Tabela;
import transfer.interfejsi.Ulogovani;

/**
 *
 * @author Stefan
 */
public class ThreadServer extends Thread{

   private ServerSocket serverSocket;
    
   private JTable jtblulogovani;
   
   private JLabel brojUlogovanih;

    public ThreadServer(int port, JTable ulogovani,JLabel brojulogovanih) throws IOException {
        serverSocket = new ServerSocket(port);
        
        this.brojUlogovanih=brojulogovanih;

        this.jtblulogovani = ulogovani;
        

    }

    

    public void run() {
        while (!isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                ThreadClient client;

                try {
                    client = new ThreadClient(socket);
                    client.start();
                    
                    Tabela.getInstance().setTabela(jtblulogovani,brojUlogovanih);

                  

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
