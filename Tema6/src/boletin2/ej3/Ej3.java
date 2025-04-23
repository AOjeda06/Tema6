package boletin2.ej3;

import java.io.*;
import java.util.Scanner;

public class Ej3 {
	private static final int LINEAS_POR_PAGINA = 24;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nombreArchivo = "src/boletin2/ej3/ficheroPrueba.txt";

		try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea;
			int contador = 0;

			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
				contador++;

				if (contador % LINEAS_POR_PAGINA == 0) {
					System.out.println("\nPresiona Enter para continuar...");
					scanner.nextLine();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el archivo '" + nombreArchivo + "'.");
		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
		}
		scanner.close();
	}
}
