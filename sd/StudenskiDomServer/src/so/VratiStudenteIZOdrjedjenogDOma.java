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
public class VratiStudenteIZOdrjedjenogDOma extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Student) {

        } else {
            throw new Exception("Greska u parametru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
            Student student=(Student)odo;
            
            student.setUslovPretrage("StudenskiDomID="+student.getStudenskiDom().getStudenskiDomId());
            
            return dbbr.vrati(student);
    }
    
}
