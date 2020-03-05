package Clases;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.*;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import Conexion.Conexion;

public class Usuario {
		protected int id_user;
		protected String first_name;
		protected String last_name;
		protected String genre;
		protected String password;
		protected int cellphone;
		
		
		public int getId_user() {
			return id_user;
		}
		public void setId_user(int id_user) {
			this.id_user = id_user;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getCellphone() {
			return cellphone;
		}
		public void setCellphone(int cellphone) {
			this.cellphone = cellphone;
		}
		public void agregar() {
			try {
			Conexion con = new Conexion();
			String sql="INSERT INTO user VALUES('"+getId_user()+"','"+getFirst_name()+"','"+getLast_name()+"',"+getGenre()+")"+"','"+getPassword()+"',"+getCellphone()+")";
			Connection c=(Connection) con.getConexion();
			Statement st = (Statement) c.createStatement();
			st.executeUpdate(sql);
			c.close();
			JOptionPane.showMessageDialog(null, "Se ha registrado con éxito");
			}
			catch(MySQLIntegrityConstraintViolationException ex) {
		    	JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe");
		    }
			catch(SQLException ex) {
				ex.printStackTrace();
			}	
		}
		public boolean validar() {
			try {
				boolean t=true;
			Conexion con = new Conexion();
			String sql="SELECT id_user FROM user";
			Connection c=(Connection) con.getConexion();
			PreparedStatement mst=(PreparedStatement) c.prepareStatement(sql);
	    	ResultSet rs=mst.executeQuery();
	    	ArrayList<String>usuario=new ArrayList<String>();
	    	while(rs.next()) {
	    		usuario.add(rs.getString("id_user"));
	    	}
			c.close();
			for(int i=0;i<usuario.size();i++) {
				if(usuario.get(i).equals(getId_user())) {
					t=false;
					break;
				}
			}
			return t;
			}
			catch(SQLException ex) {
				return false;
			}
		}
		public void cambioclave(){
			try {
				Conexion con= new Conexion();
				Connection c= con.getConexion();
				Statement st=(Statement) c.createStatement();
				String sql="UPDATE medico SET Clave= '"+getPassword()+"' WHERE id_User='"+getId_user()+"'";
				st.executeUpdate(sql);
				c.close();
				JOptionPane.showMessageDialog(null, "Clave Cambiada");
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al cambiar de clave");
			}
			
		}
		//adasMas de lo mismo 
}