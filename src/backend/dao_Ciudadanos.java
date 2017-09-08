/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Ciudadano;

/**
 *
 * @author Jorge Galindo
 */
public class dao_Ciudadanos extends dao_Conexion{
   
  private static ArrayList<Ciudadano> aCiudadanos = new ArrayList<>();
  private static boolean cargados = false;
  
  /**
   *
   * @return Boolean
   */
  public static void CargarCiudadanos() {
    boolean flag = true;
    ResultSet rs = null;
    Statement st = null;
    String query = "";
    try {
      aCiudadanos.clear();
      query = "select id, nombres, apellidos from ciudadanos";
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()){
        aCiudadanos.add(new Ciudadano(rs.getString("id").trim(), rs.getString("nombres").trim(), rs.getString("apellidos").trim()));
        flag = true;
      }          
    } catch (SQLException ex) {
      Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        rs.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    cargados = flag;
  }  
  
  public static boolean CiudadanosCargados() {
    return cargados;
  }
  
  public static ArrayList<Ciudadano> ListarCiudadanosPorId() {
    Collections.sort(aCiudadanos, (Ciudadano c1, Ciudadano c2) -> (c1.getId().compareTo(c2.getId())));
    return aCiudadanos;
  }
  
  public static ArrayList<Ciudadano> ListarCiudadanosPorNombre() {
          
    Collections.sort(aCiudadanos, (Ciudadano c1, Ciudadano c2) -> (c1.getNombres().compareTo(c2.getNombres())));
    return aCiudadanos;
  }
  
  public static boolean GuardarCiudadano(Ciudadano c){
    boolean flag = true;
    PreparedStatement st = null;
    try {
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.prepareStatement("insert into ciudadanos(id, nombres, apellidos) values(?, ?, ?)");
      st.setString(1, c.getId());
      st.setString(2, c.getNombres());
      st.setString(3, c.getApellidos());
      st.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    return flag;
  }
  
  public static boolean ValidarCiudadano(String id) {
    boolean flag = true;
    /*
    ResultSet rs = null;
    PreparedStatement st = null;
    try {
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.prepareStatement("select id from ciudadanos where = ?");
      st.setString(1, id);
      rs = st.executeQuery();
      if (rs.next()){
        if (id.equals(rs.getString("id").trim())){
          flag = true;
        }
      }          
    } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println(ex.getMessage());
        flag = false;
    } finally {
      try {
        rs.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    */
    return flag;
  }  
  
}
