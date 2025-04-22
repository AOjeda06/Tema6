package boletin1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		String fileName = "src/boletin1/Enteros.txt"; // Asegúrate de que esta ruta es correcta

		try (Scanner scanner = new Scanner(new File(fileName))) {
			double suma = 0;
			int contador = 0;

			// Permitir cualquier cantidad de espacios o tabulaciones entre números
			while (scanner.hasNext()) {
				String token = scanner.next();
				try {
					int numero = Integer.parseInt(token);
					suma += numero;
					contador++;
				} catch (NumberFormatException e) {
					System.out.println("Valor no válido encontrado: " + token);
				}
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
