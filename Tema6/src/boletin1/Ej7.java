package boletin1;

import java.io.*;
import java.util.*;

public class Ej7 {

	private static final int MAX_CONTACTOS = 20;
	private static final String FILE_NAME = "src/boletin1/Agenda.txt";
	private static TreeMap<String, String> agenda = new TreeMap<>();

	public static void main(String[] args) {
		cargarAgenda(); // Cargar datos previos si existen

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\nMenú de Agenda:");
			System.out.println("1. Nuevo contacto");
			System.out.println("2. Buscar por nombre");
			System.out.println("3. Mostrar todos");
			System.out.println("4. Salir y guardar");
			System.out.print("Elige una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1:
				nuevoContacto(scanner);
				break;
			case 2:
				buscarContacto(scanner);
				break;
			case 3:
				mostrarContactos();
				break;
			case 4:
				guardarAgenda();
				System.out.println("Agenda guardada. ¡Hasta pronto!");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}
		} while (opcion != 4);
	}

	private static void cargarAgenda() {
		File archivo = new File(FILE_NAME);
		if (archivo.exists()) {
			try (Scanner scanner = new Scanner(archivo)) {
				while (scanner.hasNextLine()) {
					String[] datos = scanner.nextLine().split(",");
					if (datos.length == 2) {
						agenda.put(datos[0], datos[1]); // Nombre, Teléfono
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error al cargar la agenda: " + e.getMessage());
			}
		}
	}

	private static void nuevoContacto(Scanner scanner) {
		if (agenda.size() >= MAX_CONTACTOS) {
			System.out.println("La agenda está llena. No se pueden agregar más contactos.");
			return;
		}

		System.out.print("Introduce el nombre: ");
		String nombre = scanner.nextLine().trim();
		if (agenda.containsKey(nombre)) {
			System.out.println("Este nombre ya está en la agenda.");
			return;
		}

		System.out.print("Introduce el teléfono: ");
		String telefono = scanner.nextLine().trim();
		agenda.put(nombre, telefono);
		System.out.println("Contacto agregado.");
	}

	private static void buscarContacto(Scanner scanner) {
		System.out.print("Introduce el nombre a buscar: ");
		String nombre = scanner.nextLine().trim();
		String telefono = agenda.get(nombre);

		if (telefono != null) {
			System.out.println("Teléfono de " + nombre + ": " + telefono);
		} else {
			System.out.println("El contacto no está en la agenda.");
		}
	}

	private static void mostrarContactos() {
		if (agenda.isEmpty()) {
			System.out.println("La agenda está vacía.");
			return;
		}

		System.out.println("\nLista de contactos ordenada:");
		for (Map.Entry<String, String> entry : agenda.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	private static void guardarAgenda() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
			for (Map.Entry<String, String> entry : agenda.entrySet()) {
				writer.println(entry.getKey() + "," + entry.getValue());
			}
		} catch (IOException e) {
			System.out.println("Error al guardar la agenda: " + e.getMessage());
		}
	}
}
