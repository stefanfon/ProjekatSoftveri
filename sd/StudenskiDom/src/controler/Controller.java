package controler;

import domen.Grad;
import domen.Prenociste;
import domen.Referent;
import domen.StudenskiDom;
import domen.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import sesion.Sesion;
import transfer.interfejsi.IOperation;
import transfer.interfejsi.IStatus;
import transfer.interfejsi.Ulogovani;
import transfer.odgovor.ResponseObject;
import transfer.zahtev.RequestObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stefan
 */
public class Controller {

    public static List<Referent> vratiSveReferente() throws Exception {

        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.VRATI_SVE_ZAPOSLENE);
        Socket socket = Sesion.getInstance().getSocket();

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        if (code == IStatus.OK) {

            return (List<Referent>) responseObject.getData();

        } else {
            throw new Exception("Greska u komunikaciji");

        }

    }

    public static List<Grad> vratiSveGradove() throws Exception {
        try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_SVE_GRADOVE);

            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (List<Grad>) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return null;

    }

    public static void dodajKljentanaServer(Ulogovani clijent) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.REGISTRUJ_KLIJENTA);
        requestObject.setData(clijent);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        if (code == IStatus.OK) {
            return;
        } else {
            throw new Exception("Greska u komunikaciji");
        }

    }

    public static void ugasiKlijenta(Ulogovani ulogovani) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.UGASI_KLIJENTA);
        requestObject.setData(ulogovani);
        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();

        if (responseObject.getMessage() != null) {
            if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                System.exit(0);

            }
        }

        if (code == IStatus.OK) {

            return;
        } else {

            throw new Exception("Greska u komunikaciji");
        }

    }

    public static void dodajKlijenta(Referent referent) throws IOException, Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.REGISTRUJ_KLIJENTA);
        requestObject.setData(referent);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        if (code == IStatus.OK) {
            return;
        } else {
            throw new Exception("Greska u komunikaciji");
        }
    }

    public static void sacuvajSvaPrenocista(List<Prenociste> listaPrenocista) throws IOException, Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.SACUVAJ_SVA_PRENOCISTEA);
        requestObject.setData(listaPrenocista);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        System.out.println(code);
        if (responseObject.getMessage() != null) {
            if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                System.exit(0);

            }
        }

        if (code == IStatus.OK) {
            JOptionPane.showMessageDialog(null, "Sistem je uspesno sacuvao");
            return;
        } else {

            throw new Exception("Greska u komunikaciji");
        }
    }

    public static int vratiBrojDanaZaStudenta(Student s) throws Exception {
        try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_BROJ_PRIJAVLJENIH_PRENOCISTA);
            requestObject.setData(s);
            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (int) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return 0;
    }

    public static Student VratiSstudentaPoBrojucipa(Student s) throws Exception {
        try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_STUDENTA_PO_BROju_CIP);
            requestObject.setData(s);
            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (Student) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }

        return null;
    }

    public static List<Prenociste> vratiListuPrenocistaZaOdredjenogReferenta(Referent brojRadneKnjizice) throws Exception {
        try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_PRENOCISTA_ZA_oDREDJENOG_REFERENTA);
            requestObject.setData(brojRadneKnjizice);

            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (List<Prenociste>) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return null;
    }

    

    public static List<Prenociste> vratiListuPrenocistaZaOdredjenogReferentaIStudenta(Student student) throws Exception {
     try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_PRENOCISTA_ZA_oDREDJENOG_STUDENTA);
            requestObject.setData(student);

            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (List<Prenociste>) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return null;
    }

    public static StudenskiDom vratiDomZaODrjedjenogRefernta(Referent referent) throws Exception {
        try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VARTI_DOM_ZA_ODREDJENOG_REFERNTA);
            requestObject.setData(referent);

            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (StudenskiDom) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return null;
    }

    public static List<Student> VratiStudenteIzOdredjenogDoma(Referent referent) throws Exception {
       try {
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(IOperation.VRATI_STUDENTE_IZ_ODREDJENOG_DOMA);
            requestObject.setData(referent);

            ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
            out.writeObject(requestObject);
            out.flush();

            ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
            ResponseObject responseObject = (ResponseObject) ois.readObject();
            int code = responseObject.getCode();
            if (responseObject.getMessage() != null) {
                if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                    JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                    System.exit(0);

                }
            }
            if (code == IStatus.OK) {
                return (List<Student>) responseObject.getData();

            }

        } catch (Exception e) {

            throw new Exception("Greska u komunikaciji");
        }
        return null;
    }

    public static void ObrisiStudenta(Student s) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.OBRISI_STUDENTA);
        requestObject.setData(s);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        System.out.println(code);
        if (responseObject.getMessage() != null) {
            if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                System.exit(0);

            }
        }

        if (code == IStatus.OK) {
            
            return;
        } else {

            throw new Exception("Greska u komunikaciji");
        }
    }

    public static void zapamtiStudenta(Student s) throws Exception {
          RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.ZAPAMTI_STUDENTA);
        requestObject.setData(s);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        System.out.println(code);
        if (responseObject.getMessage() != null) {
            if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                System.exit(0);

            }
        }

        if (code == IStatus.OK) {
            
            return;
        } else {

            throw new Exception("Greska u komunikaciji");
        }
    }

    public static void promeniStudenta(Student s) throws Exception {
          RequestObject requestObject = new RequestObject();
        requestObject.setOperation(IOperation.PROMENI_STUDENTA);
        requestObject.setData(s);

        ObjectOutputStream out = new ObjectOutputStream(Sesion.getInstance().getSocket().getOutputStream());
        out.writeObject(requestObject);
        out.flush();

        ObjectInputStream ois = new ObjectInputStream(Sesion.getInstance().getSocket().getInputStream());
        ResponseObject responseObject = (ResponseObject) ois.readObject();
        int code = responseObject.getCode();
        System.out.println(code);
        if (responseObject.getMessage() != null) {
            if (responseObject.getMessage().equalsIgnoreCase("Otkacen")) {
                JOptionPane.showMessageDialog(null, "Sistem vas je otkacio!!!");
                System.exit(0);

            }
        }

        if (code == IStatus.OK) {
            
            return;
        } else {

            throw new Exception("Greska u komunikaciji");
        }
    }

    
}
