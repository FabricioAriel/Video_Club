package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NuevoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUs;
	private JPasswordField pass;
	private JTextField txtTel;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setForeground(new Color(255, 255, 255));
		lblNuevoUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblNuevoUsuario.setBounds(138, 20, 115, 14);
		contentPane.add(lblNuevoUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 381, 57);
		contentPane.add(panel);
		
		txtNomUs = new JTextField();
		txtNomUs.setBounds(167, 97, 188, 20);
		contentPane.add(txtNomUs);
		txtNomUs.setColumns(10);
		
		JLabel lblNombres = new JLabel("Contrase\u00F1a\r\n");
		lblNombres.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblNombres.setBounds(26, 178, 93, 14);
		contentPane.add(lblNombres);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a");
		lblRepetirContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblRepetirContrasea.setBounds(26, 214, 115, 14);
		contentPane.add(lblRepetirContrasea);
		
		pass = new JPasswordField();
		pass.setBounds(167, 175, 188, 20);
		contentPane.add(pass);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(167, 242, 188, 20);
		contentPane.add(txtTel);
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino"}));
		comboBox.setBounds(167, 136, 103, 20);
		contentPane.add(comboBox);
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clave=new String (pass.getPassword());
				String clave2=new String (confirmpass.getPassword());
				if(txtNomUs.getText().equals("") || clave.equals("") || clave2.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
				}
				else {
					if(!clave.equals(clave2)) {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					}
					else {
						Usuario us = new Usuario();
						us.setId_user();
						us.setGenre(comboBox.getSelectedItem()+"");
						us.setPassword(clave);
						int tel=(int)Integer.parseInt(txtTel.getText());
						us.setCellphone(tel);
						if(us.validar()==true) {
						us.agregar();
						}
						else {
							JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe");
						}
					}
				}
			}
		});
		btnRegistrarse.setBounds(218, 297, 108, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login v1=new Login();
				v1.setVisible(true);
				v1.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSalir.setBounds(52, 297, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblNombreDeUsuario.setBounds(26, 100, 115, 14);
		contentPane.add(lblNombreDeUsuario);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(167, 211, 188, 20);
		contentPane.add(confirmpass);
		
		JLabel lblTelfonocelular = new JLabel("Tel\u00E9fono o Celular");
		lblTelfonocelular.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblTelfonocelular.setBounds(26, 250, 115, 14);
		contentPane.add(lblTelfonocelular);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		lblGnero.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblGnero.setBounds(26, 139, 115, 14);
		contentPane.add(lblGnero);
		
		
	}
}
