package boletin1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		String input;
		String fileName = "src/boletin1/TextoUsuario.txt"; // Nombre del archivo
		try (FileWriter writer = new FileWriter(fileName, true); // true -> añade contenido sin sobrescribir
				Scanner scanner = new Scanner(System.in)) {

			System.out.println("Introduce cadenas de texto. Escribe 'fin' para terminar:");

			do {
				input = scanner.nextLine();

				if (!input.equalsIgnoreCase("fin")) {
					writer.write(input + "\n"); // Guarda la línea en el archivo
				}

			} while (!input.equalsIgnoreCase("fin"));

			System.out.println("Texto guardado en " + fileName);

		} catch (

		IOException e) {
			System.out.println("Error al escribir el archivo: " + e.getMessage());
		}
	}
}
