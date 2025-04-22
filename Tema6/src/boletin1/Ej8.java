package boletin1;

import java.io.*;
import java.util.*;

public class Ej8 {

	private static final String FILE_NAME = "src/boletin1/Registro.txt";

	public static void main(String[] args) {
		List<String> registros = cargarRegistros();

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\nMenú de Registro de Temperaturas:");
			System.out.println("1. Registrar nueva temperatura");
			System.out.println("2. Mostrar historial de registros");
			System.out.println("3. Salir");
			System.out.print("Elige una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1:
				registrarNuevaTemperatura(scanner, registros);
				break;
			case 2:
				mostrarHistorial(registros);
				break;
			case 3:
				guardarRegistros(registros);
				System.out.println("Registro guardado correctamente. ¡Hasta pronto!");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}
		} while (opcion != 3);
	}

	private static List<String> cargarRegistros() {
		List<String> registros = new ArrayList<>();
		File archivo = new File(FILE_NAME);
		if (archivo.exists()) {
			try (Scanner scanner = new Scanner(archivo)) {
				while (scanner.hasNextLine()) {
					registros.add(scanner.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error al cargar el registro: " + e.getMessage());
			}
		}
		return registros;
	}

	private static void registrarNuevaTemperatura(Scanner scanner, List<String> registros) {
		System.out.print("Introduce la fecha (YYYY-MM-DD): ");
		String fecha = scanner.nextLine().trim();

		System.out.print("Introduce la temperatura máxima: ");
		int tempMaxima = scanner.nextInt();

		System.out.print("Introduce la temperatura mínima: ");
		int tempMinima = scanner.nextInt();
		scanner.nextLine(); // Limpiar buffer

		String nuevoRegistro = fecha + "," + tempMaxima + "," + tempMinima;
		registros.add(nuevoRegistro);
		System.out.println("Temperatura registrada correctamente.");
	}

	private static void mostrarHistorial(List<String> registros) {
		if (registros.isEmpty()) {
			System.out.println("No hay registros almacenados.");
			return;
		}

		int maxTemp = Integer.MIN_VALUE;
		int minTemp = Integer.MAX_VALUE;

		System.out.println("\nHistorial de temperaturas:");
		for (String registro : registros) {
			System.out.println(registro);
			String[] datos = registro.split(",");
			int tempMaxima = Integer.parseInt(datos[1]);
			int tempMinima = Integer.parseInt(datos[2]);

			if (tempMaxima > maxTemp)
				maxTemp = tempMaxima;
			if (tempMinima < minTemp)
				minTemp = tempMinima;
		}

		System.out.println("\nMayor temperatura registrada: " + maxTemp);
		System.out.println("Menor temperatura registrada: " + minTemp);
	}

	private static void guardarRegistros(List<String> registros) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
			for (String registro : registros) {
				writer.println(registro);
			}
		} catch (IOException e) {
			System.out.println("Error al guardar el registro: " + e.getMessage());
		}
	}
}
