/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.interfejsi;

/**
 *
 * @author Stefan
 */
public interface IOperation {
    public static final int VRATI_SVE_ZAPOSLENE=1;
    public static final int VRATI_SVE_GRADOVE=2;
    public static final int REGISTRUJ_KLIJENTA=3;
    public static final int UGASI_KLIJENTA=4;
    public static final int SACUVAJ_SVA_PRENOCISTEA=5;
    public static final int VRATI_BROJ_PRIJAVLJENIH_PRENOCISTA=6;
    public static final int VRATI_STUDENTA_PO_BROju_CIP=7;
    public static final int VRATI_PRENOCISTA_ZA_oDREDJENOG_REFERENTA=8;
    public static int VratiPrenocistaZaRefernta=9;
    public static int VRATI_PRENOCISTA_ZA_oDREDJENOG_STUDENTA=10;
    public static int VARTI_DOM_ZA_ODREDJENOG_REFERNTA=11;
    public static int VRATI_STUDENTE_IZ_ODREDJENOG_DOMA=12;
    public static int OBRISI_STUDENTA=13;
    public static int ZAPAMTI_STUDENTA=14;
    public static int PROMENI_STUDENTA=15;
}
