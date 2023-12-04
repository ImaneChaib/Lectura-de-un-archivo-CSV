

package com.mycompany.ejercicionotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoNotasMedias {
    public static void main(String[] args) {
        try {
            
            BufferedReader entrada = new BufferedReader(new FileReader("alumnosNotas.txt"));
            
            
            BufferedWriter salida = new BufferedWriter(new FileWriter("alumnosMedias.txt"));
            
            String linea;
            while ((linea = entrada.readLine()) != null) {
                
                String[] partes = linea.split(":");
                String nombre = partes[0];
                int[] notas = new int[partes.length - 1];
                
                
                for (int i = 1; i < partes.length; i++) {
                    notas[i - 1] = Integer.parseInt(partes[i]);
                }
                
                
                double notaMedia = calcularNotaMedia(notas);
                
                
                salida.write(nombre + ": " + notaMedia + "\n");
            }
            
            
            entrada.close();
            salida.close();
            
            System.out.println("Notas medias guardadas en 'alumnosMedias.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    private static double calcularNotaMedia(int[] notas) {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }
}
