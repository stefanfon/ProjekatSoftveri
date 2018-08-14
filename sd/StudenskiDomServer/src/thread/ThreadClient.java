/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import db.DataBaseConnection;

import domen.Gost;
import domen.Grad;
import domen.OpstiDomenskiObjekat;
import domen.Prenociste;
import domen.Referent;
import domen.StudenskiDom;
import domen.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import model.UlogovaniModel;
import sesion.Singleton;
import so.ApstraktnaGenerickaOperacija;
import so.AzurirajStudenta;
import so.ObrisiPrenociste;
import so.ObrisiStudenta;
import so.SacuvajGosta;
import so.SacuvajPrenociste;
import so.SacuvajStudenta;
import so.VratiBrojPrijavljenihPrenocistaStudentaUTekucemMesecu;
import so.VratiDomPoBrojuRadneKnjizice;
import so.VratiGostaPoID;
import so.VratiGostaPoJMBgu;
import so.VratiGradPoIDu;
import so.VratiPrenocisteZaODrjedjenogReferenta;
import so.VratiPrenocisteZaOdredjenogStudenta;
import so.VratiReferentaPoBrojuRk;
import so.VratiStudentaPoBrojuCIpa;
import so.VratiStudentaPoIDu;
import so.VratiStudenteIZOdrjedjenogDOma;
import so.VratiSveGradove;
import so.VratiSveReferente;
import tabela.Tabela;
import transfer.interfejsi.IOperation;
import transfer.interfejsi.IStatus;
import transfer.interfejsi.Ulogovani;
import transfer.odgovor.ResponseObject;
import transfer.zahtev.RequestObject;

/**
 *
 * @author Stefan
 */
public class ThreadClient extends Thread {

    private Socket socket;

    private String ime;
    private String prezime;
    private String vreme;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ThreadClient(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;

    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                RequestObject requestObject = (RequestObject) ois.readObject();

                ResponseObject responseObject = new ResponseObject();

                switch (requestObject.getOperation()) {
                    case IOperation.VRATI_SVE_ZAPOSLENE:

                        try {
                            
                            
                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratiSveZaposlene());
                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;

                    case IOperation.VARTI_DOM_ZA_ODREDJENOG_REFERNTA:
                        try {
                            
                            Referent referent = (Referent) requestObject.getData();
                            
                           

                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratiDomZaOdredjenogReferenta(referent));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }

                        break;
                    case IOperation.REGISTRUJ_KLIJENTA:
                        try {

                            Referent referent = (Referent) requestObject.getData();
                            responseObject.setCode(IStatus.OK);

                            ime = referent.getIme();
                            prezime = referent.getPrezime();

                            Date date = new Date();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                            vreme = sdf.format(date);

                            Singleton.getInstance().dodaj(this);
                            Tabela.getInstance().osvezi();
                            System.out.println("Registrovao");
                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.VRATI_STUDENTE_IZ_ODREDJENOG_DOMA:
                        try {

                            Referent ref = (Referent) requestObject.getData();

                            

                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratiStudenteIzOdredjenogDOma(ref));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }

                        break;
                    case IOperation.OBRISI_STUDENTA:
                        try {

                            Student s = (Student) requestObject.getData();

                            
                            Controllor.obrisi(s);

                            responseObject.setCode(IStatus.OK);

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.ZAPAMTI_STUDENTA:
                        try {

                           
                          

                            Controllor.zapamtiStudenta((Student) requestObject.getData());

                            responseObject.setCode(IStatus.OK);

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.PROMENI_STUDENTA:
                        try {

                            Student s = (Student) requestObject.getData();

                           
                            Controllor.promeniStudenta(s);
                            responseObject.setCode(IStatus.OK);

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }

                        break;
                    case IOperation.SACUVAJ_SVA_PRENOCISTEA:

                        try {

                            List<Prenociste> listaPrenocista = (List<Prenociste>) requestObject.getData();

                            
                            Controllor.sacuvajSvaPrenocista(listaPrenocista);
                            responseObject.setCode(IStatus.OK);

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }

                        break;

                    case IOperation.VRATI_PRENOCISTA_ZA_oDREDJENOG_REFERENTA:
                        try {

                            Referent referent = (Referent) requestObject.getData();
                            
                            // List<Prenociste> listaPrenocista = Repository.vratiPrenocistaZaOdredjenogReferentaa(brojRadneKnjizice);
                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratPrenocistaZaReferenta(referent));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.VRATI_PRENOCISTA_ZA_oDREDJENOG_STUDENTA:
                        try {
                            Student student = (Student) requestObject.getData();

                            

                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratiPrenocistsaZaOdredjenogStudenta(student));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;

                    case IOperation.VRATI_BROJ_PRIJAVLJENIH_PRENOCISTA:
                        try {

                            Student s = (Student) requestObject.getData();
                            

                            //int)brojac

                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratibrojPrijavljenih(s));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;

                    case IOperation.VRATI_STUDENTA_PO_BROju_CIP:
                        try {

                            Student s = (Student) requestObject.getData();
                           

                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratiStudentaPoCIpu(s));

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.UGASI_KLIJENTA:
                        try {
                            interrupt();
                            responseObject.setCode(IStatus.OK);

                            Singleton.getInstance().obrisi(this);
                            Tabela.getInstance().osvezi();

                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                    case IOperation.VRATI_SVE_GRADOVE:
                        try {

                           
                            responseObject.setCode(IStatus.OK);
                            responseObject.setData(Controllor.vratisvegradove());
                        } catch (Exception e) {
                            responseObject.setCode(IStatus.Greska);
                            responseObject.setMessage(e.getMessage());

                        }
                        break;
                }

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(responseObject);
                out.flush();

            } catch (IOException ex) {
                Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

}
