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

import Mundo.Cliente;
import Mundo.MailSender;
import Mundo.Principal;

public class VentanaA�adir extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JLabel lblInformacion;
	private JLabel labelNombre;
	private JPanel panelMedio;
	private JLabel labelIdentificacion;
	private JLabel labelDireccion;
	private JLabel labelCorreo;
	private JTextField textFieldNombre;
	private JTextField textFieldIdentificacion;
	private JTextField textFieldCorreo;
	private JTextField textFieldDireccion;
	private JPanel panelInferior;
	private JButton botonA�adir;
	private JButton botonVolver;

	private JButton botonBorrarCampos;
	private VentanaPrincipal miV;

	public VentanaA�adir(VentanaPrincipal miV) {
		this.miV = miV;
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
		lblInformacion = new JLabel("Ventana para a�adir un cliente a la lista.");
		panelSuperior.add(lblInformacion);
	}

	public void construyePanelMedio() {
		panelMedio = new JPanel();
		panelMedio.setLayout(new GridLayout(4, 2));
		labelNombre = new JLabel("Nombre: ");
		labelIdentificacion = new JLabel("Identificaci�n: ");
		labelDireccion = new JLabel("Dirreci�n: ");
		labelCorreo = new JLabel("Correo: ");
		textFieldNombre = new JTextField();
		textFieldIdentificacion = new JTextField();
		textFieldDireccion = new JTextField();
		textFieldCorreo = new JTextField();

		panelMedio.add(labelNombre);
		panelMedio.add(textFieldNombre);
		panelMedio.add(labelIdentificacion);
		panelMedio.add(textFieldIdentificacion);
		panelMedio.add(labelDireccion);
		panelMedio.add(textFieldDireccion);
		panelMedio.add(labelCorreo);
		panelMedio.add(textFieldCorreo);
	}

	public void construyePanelInferior() {
		panelInferior = new JPanel();
		botonA�adir = new JButton("A�adir");
		botonVolver = new JButton("Volver");
		botonBorrarCampos = new JButton("Vaciar campos");

		botonA�adir.addActionListener(this);
		botonVolver.addActionListener(this);
		botonBorrarCampos.addActionListener(this);

		panelInferior.add(botonA�adir);
		panelInferior.add(botonVolver);
		panelInferior.add(botonBorrarCampos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaPrincipal miVP = new VentanaPrincipal();
		String nombre = textFieldNombre.getText();
		String identificacion = textFieldIdentificacion.getText();
		String direccion = textFieldDireccion.getText();
		String correo = textFieldCorreo.getText();

		Cliente miC = new Cliente(nombre, identificacion, direccion, correo);

		if (e.getSource() == botonA�adir) {
			if (miV.yaExiste(miC) == true) {
				textFieldNombre.setText(" ");
				textFieldDireccion.setText(" ");
				textFieldIdentificacion.setText(" ");
				textFieldCorreo.setText(" ");
				JOptionPane.showMessageDialog(null, "El cliente ya existe");
			} else {
				miV.a�adirCliente(miC);
				JOptionPane.showMessageDialog(null, "Cliente a�adido correctamente");
				MailSender.remitente = miC.getCorreo();
				MailSender.mensaje = "Hola, " + miC.getNombre() + ". Se le env�a este correo para informarle que fue registrado correctamente como cliente." + "\n" + "Identificacion: " + miC.getIdentificacion();
				MailSender.SendMail();
				miVP.setVisible(true);
				this.dispose();
			}

		}
		if (e.getSource() == botonVolver) {
			miVP.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == botonBorrarCampos) {
			textFieldNombre.setText(" ");
			textFieldDireccion.setText(" ");
			textFieldIdentificacion.setText(" ");
			textFieldCorreo.setText(" ");
		}
	}

}
