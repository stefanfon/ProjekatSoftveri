/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.toedter.calendar.JDateChooser;
import domen.Gost;
import domen.Grad;
import domen.Prenociste;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class PrenocistaModel extends AbstractTableModel {

    private int brojVecPrijavljenihDana;
    private int fixni;
    private JLabel labelaDani;
    private List<Prenociste> prenocista;
    private String[] columnNames = {"RBR", "Ime", "Prezime", "JMBG", "DatumOd", "DatumDO", "Grad gosta"};

    public PrenocistaModel(List<Prenociste> prenocista, JLabel dani) {
        this.prenocista = prenocista;
        this.brojVecPrijavljenihDana = Integer.parseInt(dani.getText());
        this.labelaDani = dani;
        this.fixni=this.brojVecPrijavljenihDana;
    }

    @Override

    public int getRowCount() {

        return prenocista.size();
    }

    public List<Prenociste> getPrenocista() {
        if (prenocista != null) {
            return prenocista;
        } else {

            JOptionPane.showMessageDialog(null, "Niste uneli ni jedno prenociste");
            return null;
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prenociste prenociste = prenocista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return prenociste.getRedniBroj();
            case 1:

                return prenociste.getGost() != null ? prenociste.getGost().getIme() : "";
            case 2:
                return prenociste.getGost() != null ? prenociste.getGost().getPrezime() : "";
            case 3:
                return prenociste.getGost() != null ? prenociste.getGost().getJmbg() : "";
            case 4:
                
               
               
                  return prenociste.getDatumOd();
                       
                
               
            case 5:
                return prenociste.getDatumDo();
            case 6:
                // return prenociste.getGost() != null ? prenociste.getGost().getGrad().getNaziv() : "";
                if (prenociste.getGost() == null) {
                    return null;
                } else {
                    if (prenociste.getGost().getGrad() == null) {
                        return null;
                    } else {
                        return prenociste.getGost().getGrad().getNaziv();
                    }
                }

            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void dodajNovoPrenociseteUlistu() {
        if (prenocista.isEmpty() || (prenocista.get(prenocista.size() - 1).getGost() != null && prenocista.get(prenocista.size() - 1).getGost().getIme().equals("")==false
                && prenocista.get(prenocista.size() - 1).getGost().getJmbg().equals("")==false && prenocista.get(prenocista.size() - 1).getGost().getPrezime().equals("")==false
                && prenocista.get(prenocista.size() - 1).getGost().getGrad() != null && prenocista.get(prenocista.size() - 1).getDatumDo() != null
                && prenocista.get(prenocista.size() - 1).getDatumOd() != null)) {
            //treba jos za datume da dodam uslove
            Prenociste prenociste = new Prenociste();
            String s = prenocista.size() + 1 + "";
            Long id = Long.parseLong(s);

            prenociste.setRedniBroj(id);

            prenocista.add(prenociste);

            fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena \n da biste presli na novo");
            return;
        }

    }

    public void obrisatired(int red) {
        if (red >= 0 && red < prenocista.size()) {
            brojVecPrijavljenihDana = brojVecPrijavljenihDana - prenocista.get(red).getBrojDana();
            labelaDani.setText(brojVecPrijavljenihDana + "");
            prenocista.remove(red);
        }
        updateList();
        fireTableDataChanged();
    }

    private void updateList() {
        int size = prenocista.size();
        for (int i = 0; i < size; i++) {
            String redni = (i + 1) + "";
            Long novi = Long.parseLong(redni);
            prenocista.get(i).setRedniBroj(novi);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==4 || columnIndex == 5 || columnIndex == 2 || columnIndex == 1 || columnIndex == 3 || columnIndex == 6) {
            return true;
        }
        if (rowIndex == 2 || rowIndex == 1 || rowIndex == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Prenociste prenociste = prenocista.get(rowIndex);
        Date trenutni = new Date();
        switch (columnIndex) {
            case 1:
                String ime = (String) aValue;
                if (prenociste.getGost() != null) {
                    prenociste.getGost().setIme(ime);
                } else {
                    Gost g = new Gost();
                    g.setIme(ime);
                    prenociste.setGost(g);
                }
                break;
            case 2:
                String prezime = (String) aValue;
                if (prenociste.getGost() != null) {
                    prenociste.getGost().setPrezime(prezime);
                } else {
                    Gost g = new Gost();
                    g.setPrezime(prezime);
                    prenociste.setGost(g);
                }

                break;
            case 3:
                String jmbg = (String) aValue;
                if (prenociste.getGost() != null) {
                    prenociste.getGost().setJmbg(jmbg);
                } else {
                    Gost g = new Gost();
                    g.setJmbg(jmbg);
                    prenociste.setGost(g);
                }
                break;
            case 4:

                Date datumOD = (Date) aValue;
                if (prenociste.getDatumDo() != null) {
                    if (prenociste.getDatumDo().before(datumOD)) {
                        JOptionPane.showMessageDialog(null, "Datum OD mora biti posle datuma DO");

                    } else {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
                        if (Integer.parseInt(dateFormat.format(trenutni)) != Integer.parseInt(dateFormat.format(datumOD))) {
                            JOptionPane.showMessageDialog(null, "Prenociste moze biti prijavljeno \n samo za tekuci mesec");
                        } else {
                            long diff =prenociste.getDatumDo().getTime() - datumOD.getTime();
                            float days = (diff / (1000 * 60 * 60 * 24));
                            int DaniZajednoPrenociste = (int) days;

                            updateBrojPrijvljeniihDanaISetujDatum(prenociste,rowIndex, DaniZajednoPrenociste, datumOD,1);
                            
                        }
                    }

                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
                    System.out.println("Prosao");
                    if (Integer.parseInt(dateFormat.format(trenutni)) != Integer.parseInt(dateFormat.format(datumOD))) {
                        JOptionPane.showMessageDialog(null, "Prenociste moze biti prijavljeno \n samo za tekuci mesec");
                    } else {

                        prenociste.setDatumOd(datumOD);
                    }
                }
                break;
            case 5:
                if (prenociste.getDatumOd() == null) {
                    JOptionPane.showMessageDialog(null, "Morate prvo uneti datum OD");

                } else {
                    Date datumDo = (Date) aValue;
                    if (prenociste.getDatumOd().after(datumDo)) {
                        JOptionPane.showMessageDialog(null, "Datum DO mora biti posle datuma DO");
                    } else {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");

                        if (Integer.parseInt(dateFormat.format(trenutni)) != Integer.parseInt(dateFormat.format(datumDo))) {
                            JOptionPane.showMessageDialog(null, "Prenociste moze biti prijavljeno \n samo za tekuci mesec");
                        } else {
                            long diff = datumDo.getTime() - prenociste.getDatumOd().getTime();
                            float days = (diff / (1000 * 60 * 60 * 24));
                            int DaniZajednoPrenociste = (int) days;

                            updateBrojPrijvljeniihDanaISetujDatum(prenociste,rowIndex, DaniZajednoPrenociste, datumDo,2);

                        }
                    }
                }
                break;
            case 6:
                Grad gr = (Grad) aValue;
                if (prenociste.getGost() != null) {
                    prenociste.getGost().setGrad(gr);
                } else {
                    Gost g = new Gost();
                    g.setGrad(gr);
                    prenociste.setGost(g);
                }

                break;

        }

    }
/// ovu metodu zovem oba puta
    private void updateBrojPrijvljeniihDanaISetujDatum(Prenociste prenociste,int izuzetak, int DaniZajednoPrenociste, Date datumDo,int i) {
        if (prenociste.getBrojDana() != 0) {
            
            if ((DaniZajednoPrenociste + brojVecPrijavljenihDana-prenociste.getBrojDana() > 10)) {
                int brojKojiSeMoguPrijaviti=racunaj(izuzetak);
                JOptionPane.showMessageDialog(null, "Mozete prijaviti jos \n najvise " + ( brojKojiSeMoguPrijaviti) + " dana za tekuci mesec");
            } else {
                brojVecPrijavljenihDana = brojVecPrijavljenihDana - prenociste.getBrojDana();
                brojVecPrijavljenihDana += DaniZajednoPrenociste;
                labelaDani.setText(brojVecPrijavljenihDana + "");
                if(i==1){
                    prenociste.setDatumOd(datumDo);
                }else{
                    prenociste.setDatumDo(datumDo); 
                }
                
                prenociste.setBrojDana(DaniZajednoPrenociste);
            }
        } else {
            
            if ((DaniZajednoPrenociste + brojVecPrijavljenihDana > 10)) {
                int brojKojiSeMoguPrijaviti=racunaj(izuzetak);
                JOptionPane.showMessageDialog(null, "Mozete prijaviti jos \n najvise " + ( brojKojiSeMoguPrijaviti) + " dana za tekuci mesec");
            } else {
                brojVecPrijavljenihDana += DaniZajednoPrenociste;
                labelaDani.setText(brojVecPrijavljenihDana + "");
                 if(i==1){
                    prenociste.setDatumOd(datumDo);
                }else{
                    prenociste.setDatumDo(datumDo); 
                }
                prenociste.setBrojDana(DaniZajednoPrenociste);
            }
        }

    }

    private int racunaj(int izuzetak) {
        int suma=0;
       for(int i=0;i<prenocista.size();i++){
           if(i==izuzetak){
               continue;
           }else{
               suma+=prenocista.get(i).getBrojDana();
           }
       }
        return 10-fixni-suma;
    }

}
