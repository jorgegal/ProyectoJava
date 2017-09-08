/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Objects;

/**
 *
 * @author Jorge Galindo
 */
public final class Ciudadano {
  private final String id;
  private final String nombres;
  private final String apellidos;
  
  /**
   * 
   * @param pId
   * @param pNombres
   * @param pApellidos 
   */
  public Ciudadano(String pId, String pNombres, String pApellidos){
    this.id = pId;
    this.nombres = pNombres;
    this.apellidos = pApellidos;         
  }
  
  /**
   *
   * @param pId
   * @param pNombres
   * @param pApellidos
   * @return 
   */
  public static Ciudadano of (String pId, String pNombres, String pApellidos){
    Ciudadano miCiudadano = new Ciudadano(pId, pNombres, pApellidos);
    return miCiudadano;
  }

  public String getId() {
    return id;
  }

  public String getNombres() {
    return nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.id);
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
    final Ciudadano other = (Ciudadano) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Ciudadano{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
  }
  
  
  
}
