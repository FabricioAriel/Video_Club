package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class DatosUsuario {
	public boolean validar(){
		String usuario=LogiIn.Us.getText();
		String clave= new String(LogIn.pass.getPasccwod());
		String sql= "SELECT * FROM medico WHERE inUsuario= '"+usuario+"' AND Clave= '"+clave+"'";
		boolean t=false;
		try {
			Conexion con = new Conexion();
			Conexion c=(Conexion) con.getConexion();
			PreparedStatement mst;
			mst = (PreparedStatement) ((Connection) c).prepareStatement(sql);
			ResultSet rs = mst.executeQuery();
			if(rs.next()==true) {
				t=true;
			}
			else {
				t=false;
			}
			c.clone();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
