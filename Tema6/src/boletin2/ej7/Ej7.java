package boletin2.ej7;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Ej7 {
	private static final String ARCHIVO_CLIENTES = "src/boletin2/ej7/clientes.txt";
	private static TreeSet<Cliente> clientes = new TreeSet<>();

	public static void main(String[] args) {
		cargarClientes();
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n Menú Banco");
			System.out.println("1. Alta cliente");
			System.out.println("2. Baja cliente");
			System.out.println("3. Listar clientes");
			System.out.println("4. Salir");
			System.out.print("Elige una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1 -> altaCliente(scanner);
			case 2 -> bajaCliente(scanner);
			case 3 -> listarClientes();
			case 4 -> System.out.println(" Saliendo y guardando datos...");
			default -> System.out.println(" Opción no válida.");
			}
		} while (opcion != 4);

		guardarClientes();
		scanner.close();
	}

	// Cargar clientes desde el archivo
	private static void cargarClientes() {
		try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
			br.readLine(); // Saltar la primera línea (encabezado)
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				clientes.add(new Cliente(datos[0], datos[1], LocalDate.parse(datos[2]), Double.parseDouble(datos[3])));
			}
		} catch (IOException e) {
			System.out.println(" Error al leer el archivo: " + e.getMessage());
		}
	}

	// Guardar clientes en el archivo al salir
	private static void guardarClientes() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
			bw.write("DNI;Nombre Completo;Fecha de Nacimiento;Saldo\n");
			for (Cliente cliente : clientes) {
				bw.write(cliente.toString() + "\n");
			}
		} catch (IOException e) {
			System.out.println(" Error al guardar los datos: " + e.getMessage());
		}
	}

	// Alta de cliente
	private static void altaCliente(Scanner scanner) {
		System.out.print("DNI: ");
		String dni = scanner.nextLine();
		System.out.print("Nombre completo: ");
		String nombre = scanner.nextLine();
		System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
		LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
		System.out.print("Saldo inicial: ");
		double saldo = scanner.nextDouble();
		scanner.nextLine(); // Limpiar buffer

		clientes.add(new Cliente(dni, nombre, fechaNacimiento, saldo));
		System.out.println("✅ Cliente agregado correctamente.");
	}

	// Baja de cliente
	private static void bajaCliente(Scanner scanner) {
		System.out.print("Introduce DNI a eliminar: ");
		String dni = scanner.nextLine();
		if (clientes.removeIf(cliente -> cliente.getDni().equals(dni))) {
			System.out.println("Cliente eliminado correctamente.");
		} else {
			System.out.println("Cliente no encontrado.");
		}
	}

	// Listar clientes y estadísticas
	private static void listarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("No hay clientes registrados.");
			return;
		}

		System.out.println("\nLista de clientes:");
		double saldoTotal = 0, saldoMax = Double.MIN_VALUE, saldoMin = Double.MAX_VALUE;

		for (Cliente cliente : clientes) {
			System.out.println(cliente.getDni() + " - " + cliente.getNombre() + " - Saldo: " + cliente.getSaldo()
					+ "€ - Edad: " + cliente.getEdad() + " años");
			saldoTotal += cliente.getSaldo();
			saldoMax = Math.max(saldoMax, cliente.getSaldo());
			saldoMin = Math.min(saldoMin, cliente.getSaldo());
		}

		System.out.println("\nEstadísticas:");
		System.out.println("Saldo máximo: " + saldoMax + "€");
		System.out.println("Saldo mínimo: " + saldoMin + "€");
		System.out.println("Saldo promedio: " + (saldoTotal / clientes.size()) + "€");
	}
}
