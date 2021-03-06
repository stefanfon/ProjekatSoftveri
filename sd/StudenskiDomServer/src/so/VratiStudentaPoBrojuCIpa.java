/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Student;

/**
 *
 * @author Stefan
 */
public class VratiStudentaPoBrojuCIpa extends ApstraktnaGenerickaOperacija{
    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Student) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        Student sdd = (Student) odo;
        try {
            
            sdd.setUslovPretrage(sdd.getBrojCipKartice());
            
            return dbbr.vrati(sdd);
        } catch (Exception e) {
            rollbackTransakcije();
            throw new Exception("Dogodila se greska prilikom ucitavanja  studenta sa idjem:" + sdd.getStudentID() + ". Greska:" + e.getMessage());
        }
    }
}
