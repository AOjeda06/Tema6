package boletin1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {
        String fileName = "src/boletin1/Alumnos.txt"; // Ruta del archivo

        try (Scanner scanner = new Scanner(new File(fileName))) {
            int sumaEdad = 0;
            double sumaEstatura = 0;
            int contador = 0;

            System.out.println("Nombres de las personas:");

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split("\\s+"); // Divide por espacios y tabulaciones
                    
                    String nombre = datos[0];
                    int edad = Integer.parseInt(datos[1]);
                    double estatura = Double.parseDouble(datos[2]);

                    System.out.println("- " + nombre);

                    sumaEdad += edad;
                    sumaEstatura += estatura;
                    contador++;
                }
            }

            if (contador > 0) {
                double mediaEdad = (double) sumaEdad / contador;
                double mediaEstatura = sumaEstatura / contador;

                System.out.println("\nMedia de edad: " + mediaEdad);
                System.out.println("Media de estatura: " + mediaEstatura);
            } else {
                System.out.println("No se encontraron datos en el archivo.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos: " + e.getMessage());
        }
    }
}
