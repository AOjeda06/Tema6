package boletin1;

import java.io.*;
import java.util.*;

public class Ej6 {

	public static void main(String[] args) {
		String inputFile = "src/boletin1/NumerosDesordenados.txt";
		String outputFile = "src/boletin1/NumerosOrdenados.txt";

		List<Integer> numeros = new ArrayList<>();

		// Leer números del archivo y almacenarlos en una lista
		try (Scanner scanner = new Scanner(new File(inputFile))) {
			while (scanner.hasNextInt()) {
				numeros.add(scanner.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se pudo encontrar el archivo " + inputFile);
			return;
		}

		// Ordenar la lista en orden ascendente
		Collections.sort(numeros);

		// Escribir los números ordenados en otro archivo
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
			for (int numero : numeros) {
				writer.println(numero);
			}
			System.out.println("Números ordenados guardados en " + outputFile);
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo " + outputFile + ": " + e.getMessage());
		}
	}
}
