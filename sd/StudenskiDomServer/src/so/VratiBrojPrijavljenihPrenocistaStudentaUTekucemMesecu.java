/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Prenociste;

/**
 *
 * @author Stefan
 */
public class VratiBrojPrijavljenihPrenocistaStudentaUTekucemMesecu extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
            if (odo instanceof Prenociste) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        Prenociste prenociste=(Prenociste)odo;
        
        prenociste.setUslovPretrage("EXTRACT(MONTH FROM DatumOd)=MONTH(CURRENT_TIMESTAMP) AND \n"
                + " EXTRACT(YEAR FROM DatumOd)=YEAR(CURRENT_TIMESTAMP)\n"
                + " AND StudentID="+prenociste.getStudent().getStudentID());
        
        return dbbr.vrati(prenociste);
    }
    
}
