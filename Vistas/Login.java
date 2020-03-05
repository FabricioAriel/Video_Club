package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.DatosUsuario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Login extends JFrame {
	private PanelFondo panel;
	private JPanel contentPane;
	public static JTextField dUs;
	public static JPasswordField pass;
	private int c=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\fabri_000\\Downloads\\1.png"));
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 322);
		panel=new PanelFondo("/Imagenes/Fondo1.jpg");
		panel.setLayout(null);
		getContentPane().add(panel);
		
		
		
		JLabel lblIngresoALa = new JLabel("Bienvenido");
		lblIngresoALa.setForeground(new Color(255, 255, 255));
		lblIngresoALa.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 24));
		lblIngresoALa.setBounds(175, 22, 110, 25);
		panel.add(lblIngresoALa);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblUsuario.setBounds(37, 73, 100, 22);
		panel.add(lblUsuario);
	
		
		dUs = new JTextField();
		dUs.setBounds(147, 75, 220, 20);
		panel.add(dUs);
		dUs.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		lblContrasea.setBounds(37, 130, 108, 22);
		panel.add(lblContrasea);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(37, 206, 89, 23);
	panel.add(btnSalir);
	
		JButton btnIngresar = new JButton("Ingresar\r\n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clave = new String (pass.getPassword());
				if(dUs.getText().equals("") || clave.equals("")) {
					JOptionPane.showMessageDialog(null, "Por Favor Ingrese Todos Los campos");
				}
				else {
					DatosUsuario du = new DatosUsuario();
					if(du.validar()==true) {	
						MenuPrincipal mc= new MenuPrincipal();
						mc.setVisible(true);
						mc.setLocationRelativeTo(null);
					}
					else {
						JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrectos");
						c++;
					}
				}
				if(c==3) {
					JOptionPane.showMessageDialog(null,"Ha excedido el máximo de intentos");
					dispose();
				}
				
			}
			});
		btnIngresar.setBounds(329, 206, 89, 23);
		panel.add(btnIngresar);
		
		pass = new JPasswordField();
		pass.setBounds(147, 133, 220, 20);
		panel.add(pass);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoUsuario usuario= new NuevoUsuario();
				usuario.setVisible(true);
				usuario.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNuevoUsuario.setBounds(154, 206, 147, 23);
		panel.add(btnNuevoUsuario);
	}
	private void insertar_imagen(String dir,int x,int y,int w,int h ) {
		ImageIcon Logo=new ImageIcon(getClass().getResource(dir));
	}
}