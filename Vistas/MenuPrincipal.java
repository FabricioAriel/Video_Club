package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import com.mysql.jdbc.PreparedStatement;

import com.toedter.calendar.JCalendar;

import Conexion.Conexion;

import java.awt.Color;


import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;

import java.awt.SystemColor;
import com.toedter.calendar.JMonthChooser;


public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	protected static String idUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	 * @param AncestorListener 
	 */
	public MenuPrincipal() {
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date fecha=calendar.getDate();	
				long d=fecha.getTime();
				java.sql.Date fe=new java.sql.Date(d);
				 String sql="";
					sql="SELECT a.hora,	CONCAT(b.nombre,' ',b.ApPaterno,' ',b.ApMaterno),c.Tipo,b.Telefono,b.Celular FROM paciente b,cita a, tipo_cita c ,medico d WHERE "
							+ "d.idUsuario='"+idUsuario+"' and b.idUsuario=d.idUsuario and b.idPaciente=a.idPaciente "
							+ " and a.idTipo=c.idTipo and a.fecha='"+fe+"' order by (a.hora) asc;"; 
					try {
						DefaultTableModel modelo = new DefaultTableModel();
						table.setModel(modelo);
						PreparedStatement consulta=null;
						ResultSet rs=null;
						Conexion con=new Conexion();
						Connection c=con.getConexion();
						consulta=(PreparedStatement) c.prepareStatement(sql);
						rs=consulta.executeQuery();
						java.sql.ResultSetMetaData rsmd=rs.getMetaData();
						int col=rsmd.getColumnCount();
						modelo.addColumn("Hora");
						modelo.addColumn("Paciente");
						modelo.addColumn("Tipo");
						modelo.addColumn("Teléfono");
						modelo.addColumn("Celular");
						table.getColumnModel().getColumn(0).setPreferredWidth(35);
						table.getColumnModel().getColumn(1).setPreferredWidth(200);
						table.getColumnModel().getColumn(2).setPreferredWidth(63);
						table.getColumnModel().getColumn(3).setPreferredWidth(30);
						table.getColumnModel().getColumn(4).setPreferredWidth(30);
						while(rs.next()) {
							Object[]filas=new Object[col];
							for(int i=0;i<col;i++) {
								filas[i]=rs.getObject(i+1);
							}
							modelo.addRow(filas);
							
							
						}
						
					}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, "Error "+ex);
					}
			}
		});
		calendar.setBounds(10, 259, 202, 169);
		contentPane.add(calendar);
			}});
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 108, 202, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 158, 625, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Hora", "Paciente", "Tipo", "Tel\u00E9fono", "Celular"
			}
		));

		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(222, 108, 625, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCitasDelDa = new JLabel("Citas Del D\u00EDa");
		lblCitasDelDa.setForeground(new Color(255, 255, 255));
		lblCitasDelDa.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblCitasDelDa.setBounds(275, 11, 115, 17);
		panel_1.add(lblCitasDelDa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(222, 11, 625, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
	
		JLabel lblNewLabel = new JLabel("Nuevo Paciente");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblNewLabel.setBounds(34, 61, 89, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNevaCita = new JLabel("Nueva Cita");
		lblNevaCita.setFont(new Font("Bookman Old Style", Font.PLAIN, 11));
		lblNevaCita.setBounds(182, 61, 65, 14);
		panel_2.add(lblNevaCita);
		
		
		JButton btnSalir = new JButton("");
		btnSalir.setBackground(new Color(192, 192, 192));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply=JOptionPane.showConfirmDialog(null, "¿Desea Salir de la Angenda?",null,JOptionPane.YES_NO_OPTION);
				if(reply==JOptionPane.YES_OPTION) {
					Login lg = new Login();
					lg.setVisible(true);
					lg.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		btnSalir.setBounds(499, 15, 45, 45);
		panel_2.add(btnSalir);
		
		
		}};

