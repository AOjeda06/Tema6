package boletin1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) {
        String fileName = "src/boletin1/datos.txt"; // Nombre del archivo

        try (FileWriter writer = new FileWriter(fileName, true); // true -> modo "append" para no sobrescribir
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Introduce tu nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Introduce tu edad:");
            int edad = scanner.nextInt();

            // Escribir en el archivo
            writer.write(nombre + " " + edad + "\n");

            System.out.println("Datos guardados correctamente en " + fileName);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
