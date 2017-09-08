/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import static backend.dao_Conexion.dbcon;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Casa;
import logica.Apartamento;
import logica.Ciudadano;
import logica.Lote;
import logica.TipoInmuebleEnum;

/**
 *
 * @author Jorge Galindo
 */
public class dao_Inmuebles extends dao_Conexion{
  
  private static ArrayList<Casa> aCasas = new ArrayList<>();
  private static ArrayList<Apartamento> aApartamentos = new ArrayList<>();
  private static ArrayList<Lote> aLotes = new ArrayList<>();
  private static boolean cargados = false;
  
  public static void CargarInmuebles() {
    boolean flag = true;
    ResultSet rs = null;
    Statement st = null;
    String query;
    String codigo_nacional;
    String id_ciudadano;
    String tipo;
    String direccion;
    Double area;
    BigDecimal valor_comercial;
    int estrato;
    try {
      aCasas.clear();
      aApartamentos.clear();
      aLotes.clear();
      query = "select codigo_nacional, id_ciudadano, tipo, direccion, area, valor_comercial, estrato from Inmuebles";
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()){
        codigo_nacional = rs.getString("codigo_nacional").trim();
        id_ciudadano = rs.getString("id_ciudadano").trim();
        tipo = rs.getString("tipo").trim();
        direccion = rs.getString("direccion").trim();
        area = rs.getDouble("area");
        valor_comercial = rs.getBigDecimal("valor_comercial");
        estrato = rs.getInt("estrato");
        if (tipo.equals(TipoInmuebleEnum.APTO.name())){
          aApartamentos.add(new Apartamento(codigo_nacional, id_ciudadano, direccion, tipo, area, valor_comercial, estrato));
        }
        if (tipo.equals(TipoInmuebleEnum.CASA.name())){
          aCasas.add(new Casa(codigo_nacional, id_ciudadano, direccion, tipo, area, valor_comercial, estrato));
        }
        if (tipo.equals(TipoInmuebleEnum.LOTE.name())){
          aLotes.add(new Lote(codigo_nacional, id_ciudadano, direccion, tipo, area, valor_comercial, estrato));
        }
        flag = true;
      }          
    } catch (SQLException ex) {
      Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        rs.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    cargados = flag;
  }  
  
  public static boolean InmueblesCargados() {
    return cargados;
  }
  
  public static ArrayList<Casa> ListarCasasPorCodigo() {
    Collections.sort(aCasas, (Casa c1, Casa c2) -> (c1.getCodigoNacional().compareTo(c2.getCodigoNacional())));
    return aCasas;
  }
  
  public static ArrayList<Casa> ListarCasasPorDireccion() {
    Collections.sort(aCasas, (Casa c1, Casa c2) -> (c1.getDireccion().compareTo(c2.getDireccion())));
    return aCasas;
  }
  
  public static ArrayList<Apartamento> ListarApartamentosPorCodigo() {
    Collections.sort(aApartamentos, (Apartamento a1, Apartamento a2) -> (a1.getCodigoNacional().compareTo(a2.getCodigoNacional())));
    return aApartamentos;
  }
  
  public static ArrayList<Apartamento> ListarApartamentosPorDireccion() {
    Collections.sort(aApartamentos, (Apartamento a1, Apartamento a2) -> (a1.getDireccion().compareTo(a2.getDireccion())));
    return aApartamentos;
  }
  
  public static ArrayList<Lote> ListarLotesPorCodigo() {
    Collections.sort(aLotes, (Lote lt1, Lote lt2) -> (lt1.getCodigoNacional().compareTo(lt2.getCodigoNacional())));
    return aLotes;
  }
  
  public static ArrayList<Lote> ListarLotesPorDireccion() {
    Collections.sort(aLotes, (Lote lt1, Lote lt2) -> (lt1.getDireccion().compareTo(lt2.getDireccion())));
    return aLotes;
  }
  
  public static boolean GuardarCasa(Ciudadano c, Casa ic){
    boolean flag = true;
    PreparedStatement st = null;
    try {
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.prepareStatement("insert into inmuebles(codigo_nacional, id_ciudadano, tipo, direccion, area, valor_comercial, estrato) values(?, ?, ?, ?, ?, ?, ?)");
      st.setString(1, ic.getCodigoNacional());
      st.setString(2, c.getId());
      st.setString(3, ic.getTipo());
      st.setString(4, ic.getDireccion());
      st.setDouble(5, ic.getArea());
      st.setBigDecimal(6, ic.getValorComercial());
      st.setInt(7, ic.getEstrato());
      st.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    return flag;
  }
  
  public static boolean GuardarApartamento(Ciudadano c, Apartamento ia){
    boolean flag = true;
    PreparedStatement st = null;
    try {
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.prepareStatement("insert into inmuebles(codigo_nacional, id_ciudadano, tipo, direccion, area, valor_comercial, estrato) values(?, ?, ?, ?, ?, ?, ?)");
      st.setString(1, ia.getCodigoNacional());
      st.setString(2, c.getId());
      st.setString(3, ia.getTipo());
      st.setString(4, ia.getDireccion());
      st.setDouble(5, ia.getArea());
      st.setBigDecimal(6, ia.getValorComercial());
      st.setInt(7, ia.getEstrato());
      st.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    return flag;
  }
  
  public static boolean GuardarLote(Ciudadano c, Lote il){
    boolean flag = true;
    PreparedStatement st = null;
    try {
      dao_Conexion mycon = new dao_Conexion();
      st = dbcon.prepareStatement("insert into inmuebles(codigo_nacional, id_ciudadano, tipo, direccion, area, valor_comercial, estrato) values(?, ?, ?, ?, ?, ?, ?)");
      st.setString(1, il.getCodigoNacional());
      st.setString(2, c.getId());
      st.setString(3, il.getTipo());
      st.setString(4, il.getDireccion());
      st.setDouble(5, il.getArea());
      st.setBigDecimal(6, il.getValorComercial());
      st.setInt(7, il.getEstrato());
      st.executeUpdate();
      flag = true;
    } catch (SQLException ex) {
      Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
      flag = false;
    } finally {
      try {
        st.close();
      } catch (SQLException ex) {
        Logger.getLogger(dao_Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
      }
    }  
    return flag;
  }
  
}
