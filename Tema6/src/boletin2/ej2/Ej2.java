package boletin2.ej2;

import java.io.*;
import java.util.HashSet;

public class Ej2 {
	private static final String FILE_NAME = "src/boletin2/ej2/firmas.txt";

	public static void main(String[] args) {
		mostrarFirmas();
		insertarFirma("Juan");
		insertarFirma("María");
		insertarFirma("Juan"); // No debe añadirse de nuevo
		mostrarFirmas();
	}

	public static void mostrarFirmas() {
		System.out.println("Lista de Firmas:");
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String firma;
			while ((firma = br.readLine()) != null) {
				System.out.println(firma);
			}
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo: " + e.getMessage());
		}
	}

	public static void insertarFirma(String nombre) {
		HashSet<String> firmas = new HashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String firma;
			while ((firma = br.readLine()) != null) {
				firmas.add(firma);
			}
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo: " + e.getMessage());
		}

		if (firmas.contains(nombre)) {
			System.out.println("El nombre '" + nombre + "' ya está en el libro de firmas.");
			return;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			bw.write(nombre);
			bw.newLine();
			System.out.println("Firma añadida: " + nombre);
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el archivo: " + e.getMessage());
		}
	}
}
