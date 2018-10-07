package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mundo.Principal;

public class VentanaLista extends JFrame implements ActionListener {

	private JPanel contentPane;
	private VentanaPrincipal miV;
	private JLabel lblInformacion;
	private JPanel panelSuperior;
	private JLabel lblLista;
	private JPanel panelInferior;
	private JButton botonVolver;

	public VentanaLista(VentanaPrincipal miV) {
		this.miV = miV;
		setBounds(100, 100, 602, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		construirPanelSuperior();
		construirPanelInferior();
		getContentPane().add(panelSuperior);
		getContentPane().add(panelInferior);
	}

	public void construirPanelSuperior() {
		String lista = miV.imprimirListaClientes();
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(1, 1));
		lblInformacion = new JLabel("La lista de todos los clientes es: ");
		lblLista = new JLabel("" + lista);
		panelSuperior.add(lblInformacion);
		panelSuperior.add(lblLista);
	}

	public void construirPanelInferior() {
		panelInferior = new JPanel();
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(this);
		panelInferior.add(botonVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPrincipal miVP = new VentanaPrincipal();
		miVP.setVisible(true);
		this.dispose();

	}

}
