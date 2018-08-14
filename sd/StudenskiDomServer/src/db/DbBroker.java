/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import constants.Constants;
import domen.OpstiDomenskiObjekat;
import domen.Referent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Petar
 */
public class DbBroker {

    private Connection connection;
    private static DbBroker instance;

    private DbBroker() throws Exception {
        
        connection = DataBaseConnection.getDataBaseConnection().getConnection();
    }

    public static DbBroker getInstance() throws Exception {
        if (instance == null) {
            instance = new DbBroker();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    

    public void commitTransakcije() throws SQLException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new SQLException("Neuspesan commit transakcije! Greska: " + e.getMessage());
        }
    }

    public void rollackTransakcije() throws SQLException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new SQLException("Neuspesan rollback transakcije! Greska: " + e.getMessage());
        }
    }

    public void raskiniKonekciju() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new SQLException("Dogodila se greska prilikom zatvaranja konekcije!");
        }
    }

    

    
     
     public int kreiraj(OpstiDomenskiObjekat odo ) throws Exception {
        try {
            String upit = "INSERT INTO " + odo.vratiImeKlase() + "(" + odo.vratiNaziveAtributaZaKreiraj() + ") VALUES(" + odo.vratiVrednostiAtributa() + ")";
            PreparedStatement ps = connection.prepareStatement(upit, PreparedStatement.RETURN_GENERATED_KEYS);

            int brojRedova = ps.executeUpdate();

            if (brojRedova > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }

                rs.close();
                ps.close();

                return id;
            }

            throw new Exception("Neuspesno kreiranje tabeli " + odo.vratiImeKlase());
        } catch (Exception e) {
            throw new Exception("Neuspesno kreiranje tabeli " + odo.vratiImeKlase());
        }
    }

    public boolean azuriraj(OpstiDomenskiObjekat odo ) throws SQLException {
        Statement statement = null;
        try {
            String query = "UPDATE " + odo.vratiImeKlase() + " SET " + odo.postaviVrednostAtributa() + " WHERE " + odo.vratiUslovZaNadjiSlog() + "";
            statement = connection.createStatement();

            int rowNumber = statement.executeUpdate(query);

            if (rowNumber > 0) {
                return true;
            }

            return false;
        } catch (Exception e) {
            return false;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public boolean obrisi(OpstiDomenskiObjekat odo ) throws Exception {
        Statement statement = null;
        try {
            String query = "DELETE FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaNadjiSlog();
            statement = connection.createStatement();
            int rowNumber = statement.executeUpdate(query);

            if (rowNumber > 0) {
                return true;
            }

            return false;
        } catch (Exception e) {
            throw new Exception("Dogodila se greska prilikom brisanja iz tabele " +odo.vratiImeKlase());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    public List<OpstiDomenskiObjekat> vrati(OpstiDomenskiObjekat odo) throws Exception {
        Statement statement = null;
        try {

            String query = "SELECT * FROM " + odo.vratiImeKlase() + odo.getUslovPretrage();
            System.out.println(query);
            
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);
            
            return odo.vratiListuZaResultSet(rs);
        } catch (Exception e) {
            
            throw new Exception("Dogodila se greska prilikom vracanja entiteta iz tabele " + odo.vratiImeKlase()+ ". Greska" + e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    

}
