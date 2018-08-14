/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import form.FBaza;
import form.FServer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;

/**
 *
 * @author Petar
 */
public class DataBaseResources {

    private static DataBaseResources instance;
    private Properties propeties;

    private DataBaseResources() throws FileNotFoundException, IOException {
        loadProperties();
    }

    private void loadProperties() throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("./db.properties");
            propeties = new Properties();
            propeties.load(fis);
            fis.close();
              
        } catch (FileNotFoundException fnfe) {
            SetInstance();
            FBaza fbaz=new FBaza();
            fbaz.setVisible(true);
            
            
        }
    }
    
    public String getValue(String key){
        return propeties.getProperty(key);
    }
    public static void SetInstance(){
        instance=null;
    }
    
    public void setValue(String key,String value){
        propeties.setProperty(key, value);
    }

    public static DataBaseResources getInstance() throws IOException {
        if (instance == null) {
            instance = new DataBaseResources();
        }
        return instance;
    }
}
