/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Jorge Galindo
 */
public abstract class Inmueble {
  private final String codigoNacional;
  private final String id_ciudadano;
  private final String direccion;
  private final String tipo;
  private final Double area;
  private final BigDecimal valorComercial;
  private final int estrato;

  /**
   *
   * @param pCcodigoNacional
   * @param pDireccion
   * @param pArea
   * @param pValorComercial
   * @param pEstrato
   */
  public Inmueble(String pCcodigoNacional, String pId_ciudadano, String pDireccion, String pTipo, Double pArea, BigDecimal pValorComercial, int pEstrato) {
    this.codigoNacional = pCcodigoNacional;
    this.id_ciudadano   = pId_ciudadano;
    this.direccion      = pDireccion;
    this.tipo           = pTipo;
    this.area           = pArea;
    this.valorComercial = pValorComercial;
    this.estrato        = pEstrato;
  }
  
  abstract BigDecimal CalcularImpuesto();
  
  public String getCodigoNacional() {
    return codigoNacional;
  }

  public String getId_ciudadano() {
    return id_ciudadano;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTipo() {
    return tipo;
  }

  public Double getArea() {
    return area;
  }

  public BigDecimal getValorComercial() {
    return valorComercial;
  }

  public int getEstrato() {
    return estrato;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.codigoNacional);
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
    final Inmueble other = (Inmueble) obj;
    return Objects.equals(this.codigoNacional, other.codigoNacional);
  }

  @Override
  public String toString() {
    return "Inmueble{" + "codigoNacional=" + codigoNacional + ", direccion=" + direccion + ", area=" + area + ", valorComercial=" + valorComercial + ", estrato=" + estrato + '}';
  }
  
  
  
  
  
}
