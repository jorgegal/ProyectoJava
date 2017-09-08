/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Galindo
 */
public class dao_Conexion {
  public static final String USERNAME = "sysdba";
  public static final String PASSWORD = "masterkey";
  public static final String HOST = "localhost";
  public static final String PORT = "1433";
  public static final String DATABASE = "TrabajoJava";
  public static final String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  public static final String URL = "jdbc:sqlserver://" + HOST + ":" + PORT + ";databaseName=" + DATABASE+";";
    
  /**
   *
   */
  public static java.sql.Connection dbcon;
    
  public dao_Conexion() {
      try {
          Class.forName(CLASSNAME);
          dbcon = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      } catch (ClassNotFoundException | SQLException e) {
          System.out.println("Error: "+ e.getMessage());
          Logger.getLogger(dao_Conexion.class.getName()).log(Level.SEVERE, null, e);
      }
  }
    
  public void Desconectar(){
    try {
      dbcon.close();
    } catch (SQLException ex) {
      Logger.getLogger(dao_Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    //public static void main(String[] args){
    //  Conexion mycon = new Conexion();
    //}
  
}
