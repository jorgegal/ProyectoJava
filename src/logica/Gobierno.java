/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import backend.dao_Ciudadanos;
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
          //
        break;
        case 4:
          //
        break;
      }
      menu();
      Scanner scan = new Scanner(System.in);
      Opcion = scan.nextInt();
    } while (Opcion != 5);
  }
  
  /**
   *
   */
  public static void leerinfo(){
    if (dao_Ciudadanos.CargarCiudadanos()){
      dao_Ciudadanos.ListarCiudadanosPorId().forEach((c) -> {System.out.println(c.toString()); });
      System.out.println();
      dao_Ciudadanos.ListarCiudadanosPorNombre().forEach((c) -> {System.out.println(c.toString()); });
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
    Scanner scan = new Scanner(System.in);
    System.out.println("-- Creación de Inmuebles --");
    System.out.print  ("Ingrese el Id: ");
    String id = scan.nextLine();
    if ( id.length() > 0) {
      System.out.print("Ingrese el nombre: ");
      String nombre = scan.nextLine();
      if ( nombre.length() > 0) {
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scan.nextLine();
        if ( apellidos.length() > 0) {
          /*
          Ciudadano c = new Ciudadano(id, nombre, apellidos);
          if (dao_Ciudadanos.GuardarCiudadano(c)){
            System.out.println("El ciudadano fue almacenado en la base de datos!");
          } else {
            System.out.println("El ciudadano no fue almacenado en la base de datos!");
          }
          */
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
  
  public static void reporteInmuebles(){
    
  }
  
  private static void menu(){
    System.out.println("----------------------------");
    System.out.println("- 1. Cargar datos          -");
    System.out.println("- 2. Crear Ciudadano       -");
    System.out.println("- 3. Crear Inmueble        -");
    System.out.println("- 4. Reporte de Inmuebles  -");
    System.out.println("- 5. Salir                 -");
    System.out.println("----------------------------");
    System.out.print  ("Selecciones una opción: ");
  }
  
}
