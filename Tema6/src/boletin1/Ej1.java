package boletin1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		String fileName = "src/boletin1/NumerosReales.txt";

		try (Scanner scanner = new Scanner(new File(fileName))) {
			double suma = 0;
			int contador = 0;

			while (scanner.hasNextDouble()) {
				suma += scanner.nextDouble();
				contador++;
			}

			double media = (contador > 0) ? (suma / contador) : 0;

			// Mostrar resultados
			System.out.println("Suma de los números: " + suma);
			System.out.println("Media aritmética: " + media);
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
