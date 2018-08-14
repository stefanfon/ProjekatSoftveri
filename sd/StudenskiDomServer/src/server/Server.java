/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import domen.Grad;
import domen.Referent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.ApstraktnaGenerickaOperacija;
import so.VratiSveGradove;
import so.VratiSveReferente;
import transfer.interfejsi.IOperation;
import transfer.interfejsi.IStatus;
import transfer.odgovor.ResponseObject;

import transfer.zahtev.RequestObject;

/**
 *
 * @author Stefan
 */
public class Server {

    public void start() throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Server je startovan");
            Socket socket = serverSocket.accept();
            System.out.println("Server ceka klijenta");

            startComunication(socket);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startComunication(Socket socket) throws Exception {
        while (true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            RequestObject requestObject = (RequestObject) ois.readObject();

            ResponseObject responseObject = new ResponseObject();

            switch (requestObject.getOperation()) {
                case IOperation.VRATI_SVE_ZAPOSLENE:
                    try {
                        Referent referent=new Referent();
                            ApstraktnaGenerickaOperacija vrati=new VratiSveReferente();
                           
                           List<Referent> lsita=(List<Referent>) vrati.opsteIzvrsenje(referent);
                        responseObject.setCode(IStatus.OK);

                        responseObject.setData(lsita);
                    } catch (Exception e) {
                        responseObject.setCode(IStatus.Greska);
                        responseObject.setMessage(e.getMessage());

                    }
                    break;
                case IOperation.VRATI_SVE_GRADOVE:
                    try {
                        Grad g=new Grad();
                            ApstraktnaGenerickaOperacija aps=new VratiSveGradove();
                            
                            List<Grad> lista=(List<Grad>) aps.opsteIzvrsenje(g);
                        responseObject.setCode(IStatus.OK);
                        responseObject.setData(lista);
                    } catch (Exception e) {
                        responseObject.setCode(IStatus.Greska);
                        responseObject.setMessage(e.getMessage());
                    }
                    break;

            }
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(responseObject);
            out.flush();
        }
    }
}
