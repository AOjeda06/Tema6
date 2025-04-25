package boletin2.ej6;

import java.io.*;

public class Ej6 {

	public static void main(String[] args) {
		String archivo = "src/boletin2/ej6/deportistas.txt"; // Ruta del archivo

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			br.readLine(); // Leer y descartar la primera línea (encabezado)

			String deportistaMayorEdad = "";
			int mayorEdad = Integer.MIN_VALUE;

			String deportistaMayorPeso = "";
			int mayorPeso = Integer.MIN_VALUE;

			String deportistaMayorEstatura = "";
			double mayorEstatura = Double.MIN_VALUE;

			// Leer los datos de los deportistas
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(" "); // Separar por espacios

				// Manejo del nombre completo
				String nombre = datos[0] + " " + datos[1];
				int edad = Integer.parseInt(datos[2]);
				int peso = Integer.parseInt(datos[3]);
				double estatura = Double.parseDouble(datos[4]);

				// Comparaciones
				if (edad > mayorEdad) {
					mayorEdad = edad;
					deportistaMayorEdad = nombre;
				}

				if (peso > mayorPeso) {
					mayorPeso = peso;
					deportistaMayorPeso = nombre;
				}

				if (estatura > mayorEstatura) {
					mayorEstatura = estatura;
					deportistaMayorEstatura = nombre;
				}
			}

			// Imprimir resultados
			System.out.println("Deportista de mayor edad: " + deportistaMayorEdad + " (" + mayorEdad + " años)");
			System.out.println("Deportista con mayor peso: " + deportistaMayorPeso + " (" + mayorPeso + " kg)");
			System.out.println(
					"Deportista con mayor estatura: " + deportistaMayorEstatura + " (" + mayorEstatura + " m)");

		} catch (IOException | NumberFormatException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
