/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.math.BigDecimal;

/**
 *
 * @author Jorge Galindo
 */
public class Casa extends Inmueble{

  public Casa(String pCcodigoNacional, String pId_ciudadano, String pDireccion, String pTipo, Double pArea, BigDecimal pValorComercial, int pEstrato) {
    super(pCcodigoNacional, pId_ciudadano, pDireccion, pTipo, pArea, pValorComercial, pEstrato);
  }
  
  /**
   *
   * @param pCcodigoNacional
   * @param pId_ciudadano
   * @param pDireccion
   * @param pTipo
   * @param pArea
   * @param pValorComercial
   * @param pEstrato
   * @return 
   */
  public Casa of (String pCcodigoNacional, String pId_ciudadano, String pDireccion, String pTipo, Double pArea, BigDecimal pValorComercial, int pEstrato) {
    Casa miCasa = new Casa(pCcodigoNacional, pId_ciudadano, pDireccion, pTipo, pArea, pValorComercial, pEstrato);
    return miCasa;
  }

  @Override
  BigDecimal CalcularImpuesto() {
    double area               = super.getArea();
    BigDecimal valorComercial = super.getValorComercial();
    BigDecimal impuesto       = valorComercial.multiply(new BigDecimal(area));
    impuesto                  = impuesto.multiply(new BigDecimal(0.9));
    
    return impuesto;
  }

   
}
