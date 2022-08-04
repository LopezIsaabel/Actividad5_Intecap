/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tarea5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author izabe
 */
public class Tarea5 {

    public void leerarchivo() {
        File archivo; // variable de tipo file
        FileReader leer; //variable de tipo FileReader
        BufferedReader almacenamiento; // funciona pra leer el documento
        
        String cadena = "";
        Scanner cr= new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del archivo que desea ver, ingresado con .txt");
        String nombre= cr.nextLine();
        archivo = new File(nombre);

        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            String linea = "";
            while ((linea = almacenamiento.readLine()) != null) {
                System.out.println(linea);
                //se ejecuta cada linea

            }

        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void crearchivo() {
        
        Scanner cr= new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo que desea crear, ingresado con .txt");
        String nombre= cr.nextLine();
        File archivo = new File(nombre);
        FileWriter escribir;
        PrintWriter lineas;
     

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                lineas = new PrintWriter(escribir);
                System.out.println("Ingrese el contenido del para el archivo");
                String dato= cr.nextLine();
                lineas.println(dato);
                lineas.close();
                escribir.close();
                System.out.println("Archivo creado");
            } catch (Exception e) {
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                lineas = new PrintWriter(escribir);
                System.out.println("Esta documento ya existe, escribe el contenido del archivo");
                String dato= cr.nextLine();
                lineas.println(dato);
                lineas.close();
                escribir.close();
            } catch (Exception e) {
            }
        }

    }

    private void menu() {
        Tarea5 t5 = new Tarea5();
        while (true) {
            Scanner sp = new Scanner(System.in);
            System.out.println("**********MENU**********");
            System.out.println("1. Crear un archivo");
            System.out.println("2. Leer un archivo");
            System.out.println("3. Cerrar");
            System.out.println("************************");
            int resp = sp.nextInt();

            switch (resp) {
                case 1:

                    t5.crearchivo();
                    break;
                case 2:

                    t5.leerarchivo();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Tarea5 t5 = new Tarea5();
        t5.menu();
    }
}
