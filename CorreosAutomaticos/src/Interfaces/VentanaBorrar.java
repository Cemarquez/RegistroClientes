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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Mundo.Principal;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaBorrar extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JLabel lblInformacion;
	private JTextField textFieldIdentificacion;
	private JPanel panelInferior;
	private JButton botonBorrar;
	private JButton botonVolver;
	private VentanaPrincipal miV;

	public VentanaBorrar(VentanaPrincipal miV) {
		this.miV = miV;
		setBounds(100, 100, 608, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		construyePanelSuperior();
		construyePanelInferior();
		getContentPane().add(panelSuperior);
		getContentPane().add(panelInferior);
	}

	public void construyePanelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(1, 2));

		lblInformacion = new JLabel("Identificación del usuario que desea borrar: ");
		textFieldIdentificacion = new JTextField();

		panelSuperior.add(lblInformacion);
		panelSuperior.add(textFieldIdentificacion);

	}

	public void construyePanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		botonBorrar = new JButton("Borrar cliente.");
		botonBorrar.setBackground(Color.RED);
		botonBorrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonVolver = new JButton("Volver.");
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonBorrar.addActionListener(this);
		botonVolver.addActionListener(this);
		panelInferior.add(botonBorrar);
		panelInferior.add(botonVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPrincipal miVP = new VentanaPrincipal();
		String identificacion = textFieldIdentificacion.getText();
		if (e.getSource() == botonBorrar) {
			if (miV.estaVacio() == true) {
				JOptionPane.showMessageDialog(null, "No hay clientes");
			} else {
				miV.quitarCliente(identificacion);
				JOptionPane.showMessageDialog(null, "Cliente removido correctamente");
				miVP.setVisible(true);
				this.dispose();
			}

		}
		if (e.getSource() == botonVolver) {
			miVP.setVisible(true);
			this.dispose();
		}

	}

}
