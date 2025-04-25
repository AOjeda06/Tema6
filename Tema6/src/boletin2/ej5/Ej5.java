package boletin2.ej5;

import java.io.*;

public class Ej5 {

	public static void main(String[] args) {
		String archivo1 = "src/boletin2/ej5/archivo1.txt"; // Primer archivo a comparar
		String archivo2 = "src/boletin2/ej5/archivo2.txt"; // Segundo archivo a comparar

		compararArchivos(archivo1, archivo2);
	}

	public static void compararArchivos(String archivo1, String archivo2) {
		try (BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
				BufferedReader br2 = new BufferedReader(new FileReader(archivo2))) {

			String linea1, linea2 = null;
			int numLinea = 1; // Contador de líneas

			while ((linea1 = br1.readLine()) != null && (linea2 = br2.readLine()) != null) {
				if (!linea1.equals(linea2)) {
					// Encontramos una diferencia en esta línea, ahora buscamos el primer carácter
					// distinto
					for (int i = 0; i < Math.min(linea1.length(), linea2.length()); i++) {
						if (linea1.charAt(i) != linea2.charAt(i)) {
							System.out.println("Diferencia en línea " + numLinea + ", carácter " + (i + 1) + ": '"
									+ linea1.charAt(i) + "' vs '" + linea2.charAt(i) + "'");
							return;
						}
					}

					// Si la diferencia es por una longitud distinta
					if (linea1.length() != linea2.length()) {
						System.out.println("Diferencia en línea " + numLinea + ": longitud distinta (" + linea1.length()
								+ " vs " + linea2.length() + ")");
						return;
					}
				}
				numLinea++;
			}

			// Si un archivo tiene más líneas que otro
			if (linea1 != null) {
				System.out.println("Diferencia en línea " + numLinea + ": el segundo archivo terminó antes.");
			} else if (linea2 != null) {
				System.out.println("Diferencia en línea " + numLinea + ": el primer archivo terminó antes.");
			} else {
				System.out.println("Los archivos son idénticos.");
			}

		} catch (IOException e) {
			System.out.println("Error al leer los archivos: " + e.getMessage());
		}
	}
}
