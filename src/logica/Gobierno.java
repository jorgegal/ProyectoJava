/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import backend.dao_Ciudadanos;
import backend.dao_Inmuebles;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Jorge Galindo
 */
public class Gobierno {

  public static void main(String[] args){
    int Opcion = 0;
    // Invocar menu
    do {            
      switch (Opcion) {
        case 1:
          leerinfo();
        break;
        case 2:
          crearCiudadano();
        break;
        case 3:
          crearInmueble();
        break;
        case 4:
          //
        case 5:
          listarDatos();
        break;
      }
      menu();
      Scanner scan = new Scanner(System.in);
      Opcion = scan.nextInt();
    } while (Opcion != 9);
  }
  
  /**
   *
   */
  public static void leerinfo(){
    dao_Ciudadanos.CargarCiudadanos();
    dao_Inmuebles.CargarInmuebles();
  }
  
  public static void listarDatos(){
    if (dao_Ciudadanos.CiudadanosCargados()){
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- CIUDADANOS ORDENADOS POR ID                                        -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Ciudadanos.ListarCiudadanosPorId().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println();
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- CIUDADANOS ORDENADOS POR NOMBRE                                    -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Ciudadanos.ListarCiudadanosPorNombre().forEach((c) -> {System.out.println(c.toString()); });
    } else {
      System.out.println("**********************************************************************");
      System.out.println("* NO SE HAN CARGADO LOS CIUDADANOS                                    *" );
      System.out.println("**********************************************************************");
    }
    
    if (dao_Inmuebles.InmueblesCargados()){
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- CASAS ORDENADAS POR CODIGO                                         -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarCasasPorCodigo().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println();
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- CASAS ORDENADAS POR DIRECCION                                      -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarCasasPorDireccion().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- APARTAMENTOS ORDENADOS POR CODIGO                                  -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarApartamentosPorCodigo().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println();
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- APARTAMENTOS ORDENADOS POR DIRECCION                               -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarApartamentosPorDireccion().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- LOTES ORDENADOS POR CODIGO                                         -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarLotesPorCodigo().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println();
      System.out.println("----------------------------------------------------------------------");
      System.out.println("- LOTES ORDENADOS POR DIRECCION                                      -" );
      System.out.println("----------------------------------------------------------------------");
      dao_Inmuebles.ListarLotesPorDireccion().forEach((c) -> {System.out.println(c.toString()); });
    } else {
      System.out.println("**********************************************************************");
      System.out.println("* NO SE HAN CARGADO LOS INMUEBLES                                    *" );
      System.out.println("**********************************************************************");
    }
  }
  
  public static void crearCiudadano(){
    Scanner scan = new Scanner(System.in);
    System.out.println("-- Creación de Ciudadanos --");
    System.out.print  ("Ingrese el Id: ");
    String id = scan.nextLine();
    if ( id.length() > 0) {
      System.out.print("Ingrese el nombre: ");
      String nombre = scan.nextLine();
      if ( nombre.length() > 0) {
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scan.nextLine();
        if ( apellidos.length() > 0) {
          Ciudadano c = new Ciudadano(id, nombre, apellidos);
          if (dao_Ciudadanos.GuardarCiudadano(c)){
            System.out.println("El ciudadano fue almacenado en la base de datos!");
          } else {
            System.out.println("El ciudadano no fue almacenado en la base de datos!");
          }
        } else {
          System.out.println("Los apellidos no son validos!");
        }
      } else {
        System.out.println("El nombre no es valido!");
      }
    } else {
      System.out.println("El id no es valido!");
    }
  }
  
  public static void crearInmueble(){
    String pId_ciudadano;
    String pCcodigoNacional;
    String pDireccion;
    int intTipo;
    String pTipo;
    Double pArea;
    int pEstrato;        
    Scanner scan = new Scanner(System.in);
    System.out.println("-- Creación de Inmuebles --");
    // Desplegar la lista de Ciudadanos, esto normalmente no se hace por consola
    // pero debido a la naturaleza del ejercicio, se implementa para repasar 
    // lampdas y api stream ;)
    dao_Ciudadanos.ListarCiudadanosPorId().forEach((c) -> {System.out.println(c.getId() + " - " + c.getNombres() + " " + c.getApellidos()); });
    System.out.print("Ingrese el Id del Ciudadano: ");
    pId_ciudadano = scan.nextLine();
    if (pId_ciudadano.length() > 0) {
      // Validar si el id ingresado el valido en la BD
      if (dao_Ciudadanos.ValidarCiudadano(pId_ciudadano)) {
        // Solicitar la informacion de atributos del inmueble
        /**
        * @param pCcodigoNacional
        * @param pId_ciudadano
        * @param pDireccion
        * @param pTipo
        * @param pArea
        * @param pValorComercial
        * @param pEstrato
        */
        System.out.print("Ingrese el Codigo Nacional: ");
        pCcodigoNacional = scan.nextLine();
        if (pCcodigoNacional.length() > 0) {
          System.out.print("Ingrese la direccion: ");
          pDireccion = scan.nextLine();
          if (pDireccion.length() > 0) {
            int conteo = 1;
            for(TipoInmuebleEnum te: TipoInmuebleEnum.values()){
                System.out.println(conteo + " - " + te.toString());
                conteo++;
            }
            System.out.print("Ingrese el tipo: ");
            intTipo = scan.nextInt();
            pTipo = "";
            if (0< intTipo && intTipo < conteo){
              String[] alista = TipoInmuebleEnum.names();
              pTipo = alista[intTipo - 1];
            }
            if (pTipo.length() > 0) {
              System.out.print("Ingrese el area: ");
              pArea = scan.nextDouble();
              if (pArea > 0) {
                System.out.print("Ingrese el valor comercial: ");
                BigDecimal pValorComercial = scan.nextBigDecimal();
                BigDecimal foo = BigDecimal.valueOf(0);
                if (pValorComercial.compareTo(foo) > 0) {
                  System.out.print("Ingrese el estrato: ");
                  pEstrato = scan.nextInt();
                  if (pEstrato > 0) {
                    Ciudadano c = new Ciudadano(pId_ciudadano, "", "");
                    // Segun el tipo se ejecuta el dao correspondiente para grabar
                    if (pTipo == TipoInmuebleEnum.APTO.name()) {
                      Apartamento i = new Apartamento(pCcodigoNacional, pDireccion, pId_ciudadano, pTipo, pArea, pValorComercial, pEstrato);
                      if (dao_Inmuebles.GuardarApartamento(c, i)){
                        System.out.println("El inmueble " + pTipo + " fue almacenado en la base de datos!");
                      } else {
                        System.out.println("El inmueble " + pTipo + " no fue almacenado en la base de datos!");
                      }
                    } else if (pTipo == TipoInmuebleEnum.APTO.name()) {
                      Casa i = new Casa(pCcodigoNacional, pDireccion, pId_ciudadano, pTipo, pArea, pValorComercial, pEstrato);
                      if (dao_Inmuebles.GuardarCasa(c, i)){
                        System.out.println("El inmueble " + pTipo + " fue almacenado en la base de datos!");
                      } else {
                        System.out.println("El inmueble " + pTipo + " no fue almacenado en la base de datos!");
                      }
                    } else if (pTipo == TipoInmuebleEnum.LOTE.name()) {
                      Lote i = new Lote(pCcodigoNacional, pDireccion, pId_ciudadano, pTipo, pArea, pValorComercial, pEstrato);
                      if (dao_Inmuebles.GuardarLote(c, i)){
                        System.out.println("El inmueble " + pTipo + " fue almacenado en la base de datos!");
                      } else {
                        System.out.println("El inmueble " + pTipo + " no fue almacenado en la base de datos!");
                      }
                    }
                  } else {
                    System.out.println("El estrato no es valido!");
                  }
                } else {
                  System.out.println("El valor comercial no es valido!");
                }
              } else {
                System.out.println("El area no es valida!");
              }
            } else {
              System.out.println("El tipo no es valido!");
            }  
          } else {
            System.out.println("La direccion no es valida!");
          }
        } else {
          System.out.println("El Codigno nacional no es valido!");
        }
      } else {
        System.out.println("El id de ciudadano no se encuentra en la lista!");
      }
    } else {
      System.out.println("El id de ciudadano no es valido!");
    }
  }
  
  public static void reporteInmuebles(){
    
  }
  
  private static void menu(){
    System.out.println("----------------------------");
    System.out.println("- 1. Cargar datos          -");
    System.out.println("- 2. Crear Ciudadano       -");
    System.out.println("- 3. Crear Inmueble        -");
    System.out.println("- 4. Reporte de Inmuebles  -");
    System.out.println("- 5. Listar datos          -");
    System.out.println("- 9. Salir                 -");
    System.out.println("----------------------------");
    System.out.print  ("Selecciones una opción: ");
  }
  
}
