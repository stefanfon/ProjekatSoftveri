/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import constants.Constants;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Stefan
 */
public class DataBaseConnection {
    private static DataBaseConnection instance;
    private final Connection connection;
    
    private DataBaseConnection() throws SQLException, IOException{
        
        connection=DriverManager.getConnection(DataBaseResources.getInstance().getValue(Constants.URL), DataBaseResources.getInstance().getValue(Constants.USER), DataBaseResources.getInstance().getValue(Constants.PASSWORD));
        connection.setAutoCommit(true);
    }
    public Connection getConnection(){
        return connection;
    }
    public static DataBaseConnection getDataBaseConnection() throws SQLException, IOException{
        if(instance==null){
            instance=new DataBaseConnection();
        }
        return instance;
    }
    
}
