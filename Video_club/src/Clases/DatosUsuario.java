package Clases;

public class DatosUsuario {
	public boolean validar(){
		String usuario=LogiIn.Us.getText();
		String clave= new String(LogIn.pass.getPasccwod());
		String sql= "SELECT * FROM medico WHERE inUsuario= '"+usuario+"' AND Clave= '"+clave+"'";
	}

}
