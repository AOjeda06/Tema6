package boletin2.ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {
	public static void main(String[] args) {
		String fileName = "src/boletin2/ej1/Carta.txt";
		int charCount = 0;
		int wordCount = 0;
		int lineCount = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				lineCount++;
				charCount += line.length();
				wordCount += line.split(" ").length;
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		System.out.println("Número de caracteres: " + charCount);
		System.out.println("Número de palabras: " + wordCount);
		System.out.println("Número de líneas: " + lineCount);
	}
}
