package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mundo.Cliente;
import Mundo.Principal;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JLabel lblPresentacion;
	private JPanel panelInferior;
	private JButton botonAñadir;
	private JButton botonBorrar;
	private JButton botonCerrar;
	private JPanel panelMedio;

	private JButton botonLista;
	private Principal miCP;

	
	public VentanaPrincipal() {
		miCP = new Principal();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		construyePanelSuperior();
		construyePanelMedio();
		construyePanelInferior();
		getContentPane().add(panelSuperior);
		getContentPane().add(panelMedio);
		getContentPane().add(panelInferior);
	}

	public void construyePanelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.WHITE);

		lblPresentacion = new JLabel("Panel para el control de los usuarios");
		lblPresentacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentacion.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		panelSuperior.add(lblPresentacion);
	}

	public void construyePanelMedio() {
		panelMedio = new JPanel();
		panelMedio.setBackground(Color.WHITE);
		panelMedio.setLayout(new GridLayout(1, 1));
	}

	public void construyePanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		botonAñadir = new JButton("Añadir cliente");
		botonAñadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonAñadir.setBackground(Color.WHITE);
		botonBorrar = new JButton("Borrar cliente");
		botonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonBorrar.setBackground(Color.RED);
		botonCerrar = new JButton("Cerrar");
		botonLista = new JButton("Lista de clientes");
		botonLista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonCerrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonCerrar.setBackground(Color.RED);

		botonAñadir.addActionListener(this);
		botonBorrar.addActionListener(this);
		botonCerrar.addActionListener(this);
		botonLista.addActionListener(this);
		panelInferior.add(botonAñadir);
		panelInferior.add(botonBorrar);
		panelInferior.add(botonCerrar);
		panelInferior.add(botonLista);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaAñadir miVA = new VentanaAñadir(this);
		VentanaBorrar miVB = new VentanaBorrar(this);
		VentanaLista miVL = new VentanaLista(this);
		if (arg0.getSource() == botonAñadir) {
			miVA.setVisible(true);
			this.dispose();
		}
		if (arg0.getSource() == botonBorrar) {
			miVB.setVisible(true);
			this.dispose();
		}
		if (arg0.getSource() == botonCerrar) {
			System.exit(0);
		}
		if (arg0.getSource() == botonLista) {
			miVL.setVisible(true);
			this.dispose();
		}

	}

	public boolean estaVacio() {
		return miCP.estaVacio();
	}

	public boolean yaExiste(Cliente pCliente) {
		return miCP.yaExiste(pCliente);
	}

	public void añadirCliente(Cliente pCliente) {

		miCP.añadirCliente(pCliente);

	}

	public void quitarCliente(String identificacion) {
		miCP.quitarCliente(identificacion);

	}

	public String imprimirListaClientes() {
		return miCP.imprimirListaClientes();
	}

}
