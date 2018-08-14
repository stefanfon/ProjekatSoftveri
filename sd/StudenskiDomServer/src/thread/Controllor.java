/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domen.Gost;
import domen.Grad;
import domen.Prenociste;
import domen.Referent;
import domen.StudenskiDom;
import domen.Student;
import java.util.List;
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

/**
 *
 * @author Stefan
 */
class Controllor {

    public static List<Referent> vratiSveZaposlene() throws Exception {
        Referent referent = new Referent();
        ApstraktnaGenerickaOperacija vrati = new VratiSveReferente();

        List<Referent> lsita = (List<Referent>) vrati.opsteIzvrsenje(referent);
        for (Referent referent1 : lsita) {
            System.out.println(referent1.getIme());
        }
        return lsita;
    }

    static StudenskiDom vratiDomZaOdredjenogReferenta(Referent referent) throws Exception {
        ApstraktnaGenerickaOperacija vratiDom = new VratiDomPoBrojuRadneKnjizice();
        StudenskiDom sdud = new StudenskiDom();
        sdud.setReferenti(referent);

        List<StudenskiDom> listadomm = (List<StudenskiDom>) vratiDom.opsteIzvrsenje(sdud);
        StudenskiDom sd = listadomm.get(0);
        return sd;
    }

    static List<Student> vratiStudenteIzOdredjenogDOma(Referent ref) throws Exception {
        StudenskiDom sd = new StudenskiDom();
        sd.setReferenti(ref);
        ApstraktnaGenerickaOperacija vratiDom = new VratiDomPoBrojuRadneKnjizice();
        List<StudenskiDom> listadomm = (List<StudenskiDom>) vratiDom.opsteIzvrsenje(sd);
        StudenskiDom sd1 = listadomm.get(0);

        Student student = new Student();
        student.setStudenskiDom(sd1);
        ApstraktnaGenerickaOperacija vratiStudente = new VratiStudenteIZOdrjedjenogDOma();
        List<Student> listaStudent = (List<Student>) vratiStudente.opsteIzvrsenje(student);
        for (Student student1 : listaStudent) {
            student1.setStudenskiDom(sd1);
            Grad g = student1.getGrad();
            ApstraktnaGenerickaOperacija vratiGradpoId = new VratiGradPoIDu();
            Grad zaDodavanje = ((List<Grad>) vratiGradpoId.opsteIzvrsenje(g)).get(0);
            student1.setGrad(zaDodavanje);
        }
        return listaStudent;
    }

    static void obrisi(Student s) throws Exception {
        ApstraktnaGenerickaOperacija ap = new ObrisiStudenta();
        if (s.getPrenocista().size() != 0) {
            List<Prenociste> lista = s.getPrenocista();
            for (Prenociste prenociste : lista) {
                ApstraktnaGenerickaOperacija appreno = new ObrisiPrenociste();
                appreno.opsteIzvrsenje(prenociste);

            }
        }

        ap.opsteIzvrsenje(s);
    }

    static void zapamtiStudenta(Student student) throws Exception {
        ApstraktnaGenerickaOperacija zapamtiStudenta = new SacuvajStudenta();
        int s = (int) zapamtiStudenta.opsteIzvrsenje(student);
    }

    static void promeniStudenta(Student s) throws Exception {
        ApstraktnaGenerickaOperacija azuriraj = new AzurirajStudenta();
        azuriraj.opsteIzvrsenje(s);
    }

    static void sacuvajSvaPrenocista(List<Prenociste> listaPrenocista) throws Exception {
        ApstraktnaGenerickaOperacija aps = new SacuvajPrenociste();
        for (Prenociste prenociste : listaPrenocista) {
            Gost g = prenociste.getGost();
            ApstraktnaGenerickaOperacija apsgost = new VratiGostaPoJMBgu();
            List<Gost> lista = (List<Gost>) apsgost.opsteIzvrsenje(g);
            //provera da li ima u bazi
            //a svakako ga vracam zbog id
            if (lista.size() == 0) {

                ApstraktnaGenerickaOperacija apsg = new SacuvajGosta();
                int i = (int) apsg.opsteIzvrsenje(g);
                List<Gost> lista1 = (List<Gost>) apsgost.opsteIzvrsenje(g);
                g = lista1.get(0);

            } else {
                g = lista.get(0);
            }
            prenociste.setGost(g);

            int i = (int) aps.opsteIzvrsenje(prenociste);
        }
    }

    static List<Prenociste> vratPrenocistaZaReferenta(Referent referent) throws Exception {
        ApstraktnaGenerickaOperacija aps = new VratiPrenocisteZaODrjedjenogReferenta();
        Prenociste prenociste = new Prenociste();
        prenociste.setReferent(referent);

        List<Prenociste> listaPrenocista = (List<Prenociste>) aps.opsteIzvrsenje(prenociste);

        for (Prenociste prenociste1 : listaPrenocista) {
            prenociste1.setReferent(referent);

            Student s = prenociste1.getStudent();
            aps = new VratiStudentaPoIDu();
            List<Student> li = (List<Student>) aps.opsteIzvrsenje(s);
            prenociste1.setStudent(li.get(0));

            Gost g = prenociste1.getGost();
            aps = new VratiGostaPoID();
            List<Gost> lii = (List<Gost>) aps.opsteIzvrsenje(g);
            lii.get(0).getIme();
            prenociste1.setGost(lii.get(0));

        }
        return listaPrenocista;
    }

    static List<Prenociste> vratiPrenocistsaZaOdredjenogStudenta(Student student) throws Exception {
        ApstraktnaGenerickaOperacija aps = new VratiPrenocisteZaOdredjenogStudenta();
        Prenociste prenociste = new Prenociste();
        prenociste.setStudent(student);

        List<Prenociste> listaPrenocista = (List<Prenociste>) aps.opsteIzvrsenje(prenociste);
        System.out.println("Prosao");
        for (Prenociste prenociste1 : listaPrenocista) {
            prenociste1.setStudent(student);

            Referent referent = prenociste1.getReferent();
            aps = new VratiReferentaPoBrojuRk();
            List<Referent> li = (List<Referent>) aps.opsteIzvrsenje(referent);
            prenociste1.setReferent(li.get(0));

            Gost g = prenociste1.getGost();
            aps = new VratiGostaPoID();
            List<Gost> lii = (List<Gost>) aps.opsteIzvrsenje(g);
            lii.get(0).getIme();
            prenociste1.setGost(lii.get(0));

        }
        return listaPrenocista;
    }

    static int vratibrojPrijavljenih(Student s) throws Exception {
        Prenociste prenociste1 = new Prenociste();
        prenociste1.setStudent(s);
        ApstraktnaGenerickaOperacija apstraktna = new VratiBrojPrijavljenihPrenocistaStudentaUTekucemMesecu();
        List<Prenociste> listaPrenocista = (List<Prenociste>) apstraktna.opsteIzvrsenje(prenociste1);
        System.out.println("Prosao");
        float brojac = 0;
        for (Prenociste prenociste : listaPrenocista) {
            long diff = prenociste.getDatumDo().getTime() - prenociste.getDatumOd().getTime();
            float days = (diff / (1000 * 60 * 60 * 24));
            brojac += days;
        }
        return (int) brojac;

    }

    static Student vratiStudentaPoCIpu(Student s) throws Exception {
        ApstraktnaGenerickaOperacija aps = new VratiStudentaPoBrojuCIpa();

        Student student = ((List<Student>) aps.opsteIzvrsenje(s)).get(0);
        return student;
    }

    static List<Grad> vratisvegradove() throws Exception {
        Grad g = new Grad();
        ApstraktnaGenerickaOperacija aps = new VratiSveGradove();

        List<Grad> lista = (List<Grad>) aps.opsteIzvrsenje(g);

        return lista;
    }
}
