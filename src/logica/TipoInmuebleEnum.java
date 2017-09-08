/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.stream.Stream;

/**
 *
 * @author Jorge Galindo
 */
public enum TipoInmuebleEnum {
  CASA, APTO, LOTE; 
  public static String[] names() {
    return Stream.of(TipoInmuebleEnum.values()).map(TipoInmuebleEnum::name).toArray(String[]::new);
  }
}

