package Mundo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.VentanaPrincipal;

public class Principal {
    
	private static ArrayList<Cliente> misClientes = new ArrayList<>();
	private static Persistencia serializarClientes = new Persistencia();
	
	public static void main(String[] args) {
		
		VentanaPrincipal miV = new VentanaPrincipal();
		miV.setVisible(true);
		
		serializarClientes.serializar(misClientes);
		 
	}
	

	public void añadirCliente(Cliente pCliente) {
		misClientes.add(pCliente);

	}

	public boolean yaExiste(Cliente pCliente) {
		boolean centinela = false;
		for (int i = 0; i < misClientes.size(); i++) {
			Cliente miC = misClientes.get(i);
			if (miC.getIdentificacion().equals(pCliente.getIdentificacion())) {
				centinela = true;
			}
		}
		return centinela;

	}

	public void quitarCliente(String identificacion) {
		for (int i = 0; i < misClientes.size(); i++) {
			Cliente miC = misClientes.get(i);
			if (miC.getIdentificacion().equals(identificacion)) {
				misClientes.remove(miC);
			}
		}

	}

	public boolean estaVacio() {
		boolean centinela = false;
		if (misClientes.isEmpty()) {
			centinela = true;
		}
		return centinela;
	}
	private ArrayList<Cliente> nuevoArray = serializarClientes.deserializar();
	public String imprimirListaClientes() {
		String lista = "";
		int contador = 1;

		for (int i = 0; i < nuevoArray.size(); i++) {
			Cliente miCA = nuevoArray.get(i);
			lista += " " + contador + ". " + miCA.getNombre() + " - " + miCA.getIdentificacion() + "\n";
			contador++;
		}

		return lista;
	}

}
