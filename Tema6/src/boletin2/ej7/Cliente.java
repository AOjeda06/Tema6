package boletin2.ej7;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa a un cliente de un banco con datos como DNI, nombre,
 * fecha de nacimiento y saldo. Implementa la interfaz Comparable para ordenar
 * los clientes por su DNI.
 */
public class Cliente implements Comparable<Cliente> {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private double saldo;

	/**
	 * Constructor de la clase Cliente.
	 * 
	 * @param dni             DNI del cliente.
	 * @param nombre          Nombre completo del cliente.
	 * @param fechaNacimiento Fecha de nacimiento del cliente.
	 * @param saldo           Saldo disponible en la cuenta del cliente.
	 */
	public Cliente(String dni, String nombre, LocalDate fechaNacimiento, double saldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.saldo = saldo;
	}

	/**
	 * Obtiene el DNI del cliente.
	 * 
	 * @return El DNI del cliente.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Obtiene el nombre completo del cliente.
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la fecha de nacimiento del cliente.
	 * 
	 * @return La fecha de nacimiento del cliente.
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Obtiene el saldo actual del cliente.
	 * 
	 * @return El saldo del cliente.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Calcula la edad del cliente con base en su fecha de nacimiento.
	 * 
	 * @return La edad del cliente en años.
	 */
	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	/**
	 * Compara dos clientes por su DNI para mantener un orden natural.
	 * 
	 * @param otro Cliente con el que se compara.
	 * @return Valor negativo si el DNI es menor, positivo si es mayor, y 0 si son
	 *         iguales.
	 */
	@Override
	public int compareTo(Cliente otro) {
		return this.dni.compareTo(otro.getDni());
	}

	/**
	 * Devuelve una representación en formato texto del cliente, separando los
	 * valores con punto y coma.
	 * 
	 * @return Cadena con los datos del cliente en formato
	 *         "DNI;Nombre;FechaNacimiento;Saldo".
	 */
	@Override
	public String toString() {
		return dni + ";" + nombre + ";" + fechaNacimiento + ";" + saldo;
	}
}
