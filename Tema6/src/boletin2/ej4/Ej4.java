package boletin2.ej4;

import java.io.*;
import java.util.*;

public class Ej4 {

	public static void main(String[] args) {
		String archivoEntrada = "src/boletin2/ej4/FicheroSinEncriptar.txt"; // Archivo con el mensaje original
		String archivoSalida = "src/boletin2/ej4/FicheroEncriptado.txt"; // Archivo con el mensaje cifrado
		String codec = "src/boletin2/ej4/codec.txt"; // Archivo con el alfabeto y la codificación

		Map<Character, Character> mapaCodificacion = leerCodificacion(codec);

		if (mapaCodificacion != null) {
			codificarArchivo(archivoEntrada, archivoSalida, mapaCodificacion);
			System.out.println("¡El archivo ha sido cifrado correctamente!");
		} else {
			System.out.println("Error al leer el archivo de codificación.");
		}
	}

	// Método para leer la codificación desde el fichero codec.txt
	public static Map<Character, Character> leerCodificacion(String codecFile) {
		Map<Character, Character> mapa = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(codecFile))) {
			String lineaAlfabeto = br.readLine();
			String lineaCifrado = br.readLine();

			// Verifica si alguna línea es nula o vacía
			if (lineaAlfabeto == null || lineaCifrado == null || lineaAlfabeto.isEmpty() || lineaCifrado.isEmpty()) {
				System.out.println("Error: El archivo de codificación no tiene el formato correcto.");
				return null;
			}

			String[] alfabeto = lineaAlfabeto.split(" ");
			String[] cifrado = lineaCifrado.split(" ");

			if (alfabeto.length != cifrado.length) {
				System.out.println("Error: La codificación no coincide con el alfabeto.");
				return null;
			}

			for (int i = 0; i < alfabeto.length; i++) {
				mapa.put(alfabeto[i].charAt(0), cifrado[i].charAt(0));
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de codificación: " + e.getMessage());
			return null;
		}
		return mapa;
	}

	// Método para codificar el contenido del archivo
	public static void codificarArchivo(String entrada, String salida, Map<Character, Character> mapaCodificacion) {
		try (BufferedReader br = new BufferedReader(new FileReader(entrada));
				BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				StringBuilder codificado = new StringBuilder();
				for (char c : linea.toCharArray()) {
					codificado.append(mapaCodificacion.getOrDefault(c, c)); // Si no está en el mapa, deja el mismo
																			// caracter
				}
				bw.write(codificado.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al procesar los archivos: " + e.getMessage());
		}
	}
}
