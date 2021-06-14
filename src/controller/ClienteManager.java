package controller;

import java.util.Scanner;

import dao.ClienteDao;
import model.Cliente;

public class ClienteManager {
	
	public static ClienteDao cliente = new ClienteDao();
	
	public static void main (String [] args) {
		
		Scanner entrada = new Scanner (System.in);
		imprimirMenu();
		int opcion;
		opcion = entrada.nextInt();
		while (opcion >= 1 && opcion <= 3) {
			imprimirMenu();
			switch (opcion){
			case 1: insertarCliente ();
				break;
			case 2 : consultarCliente ();
				break;
			case 3: System.out.println ("Digito la opcion de salir");
				break;
			default:
				break;
			}
			
			opcion = entrada.nextInt();
		}
	}
	
	public static void imprimirMenu () {
		System.out.println ("------------MENU------------");
		System.out.println ("1. INSERTAR CLIENTE ");
		System.out.println ("2. CONSULTAR CLIENTE POR ID ");
		System.out.println ("3. CONSULTAR TODOS LOS CLIENTES ");
		System.out.println (" DIGITE LA OPCION DESEADA ");
		System.out.println ("----------------------------");
	}
	public static void  insertarCliente () {
		Scanner entrada = new Scanner (System.in);
		String nombre ="",apellido = "", email = "";
		int cedula, telefono, ciudad, pais;
		
		System.out.println (" DIGITE EL NOMBRE DEL CLIENTE");
		nombre = entrada.nextLine();
		System.out.println (" DIGITE EL APELLIDO DEL CLIENTE");
		apellido = entrada.nextLine();
		System.out.println (" DIGITE LA CEDULA DEL CLIENTE");
		cedula = entrada.nextInt();
		System.out.println (" DIGITE EL TELEFONO DEL CLIENTE");
		telefono = entrada.nextInt();
		System.out.println (" DIGITE EL E-MAIL DEL CLIENTE");
		email  = entrada.nextLine();
		System.out.println (" DIGITE LA CIUDAD DEL CLIENTE");
		ciudad = entrada.nextInt();
		System.out.println (" DIGITE EL PAIS DEL CLIENTE");
		pais = entrada.nextInt();
		
		Cliente nuevocliente = new Cliente (nombre, apellido, cedula, telefono, email, ciudad, pais);
		System.out.println(nuevocliente.toString());
		cliente.insert(nuevocliente);
		System.out.println ("**** REGISTRO EXITOSO ****");
		
	}
	
	public static void consultarCliente () {
		Scanner entrada = new Scanner (System.in);
		int idCliente;
		System.out.println ("Digite el ID del Cliente que busca");
		idCliente = entrada.nextInt ();
		Cliente clienteconsultado = cliente.read(idCliente);
		System.out.println (clienteconsultado.toString());
	}

}
