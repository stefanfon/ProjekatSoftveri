/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.interfejsi;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Ulogovani implements Serializable{
    String ime;
    String prezime;
    String vreme;

    public Ulogovani(String ime, String prezime, String vreme) {
        this.ime = ime;
        this.prezime = prezime;
        this.vreme = vreme;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ime);
        hash = 37 * hash + Objects.hashCode(this.prezime);
        hash = 37 * hash + Objects.hashCode(this.vreme);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ulogovani other = (Ulogovani) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return true;
    }
    
    
    
}
