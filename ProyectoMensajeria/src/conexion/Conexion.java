package conexion;

import java.math.BigInteger;
import java.security.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	
	public static Connection cn;
	
	public static void ConectarBDD(){
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            
            // Database connect
            // Conectamos con la base de datos
            cn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/mensageria",
                    "postgres", "admin");
 
            boolean valid = cn.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }
    
    public static boolean ExisteUsuarios(String nom_usuario, String contrasenya) {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        boolean existe = false;
        
        try {
            String con = encriptarContrasenya(contrasenya);
            st = cn.prepareStatement("SELECT * from usuario WHERE nom_usuario = ? AND contrasenya = ?;");
            st.setObject(1, nom_usuario);
            st.setObject(2, con);
            
            rs = st.executeQuery();
            while (rs.next()) {
                existe = true;
            }
            
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        finally {
            if (st != null) {
                try {
                    st.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return existe;
    }
    
    public static void RegistrarUsuario(String nom_usuario, String contrasenya) {
        PreparedStatement st = null;
        
        try {
            String con = encriptarContrasenya(contrasenya);
            st = cn.prepareStatement("INSERT INTO usuario VALUES (?, ?);");
            st.setObject(1, nom_usuario);
            st.setObject(2, con);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ese usuario ya existe.");
        } catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private static String encriptarContrasenya (String contraseña) throws NoSuchAlgorithmException{
        
        String cod;
 
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(contraseña.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        cod = bigInt.toString(16);
        while(cod.length() < 32 ){
            cod = "0"+cod;
        }
        return cod;
    }
    
    /*private static ArrayList listaGrupales (String nom_usuario) {
        ArrayList<Integer> id_grupo = new ArrayList<Integer>();
        ArrayList<String> id_grupo_str = new ArrayList<String>();
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            st = cn.prepareStatement("SELECT id FROM participa_grupo WHERE nom_usuario = ?");
            st.setObject(1, nom_usuario);  
            rs = st.executeQuery();
            while(rs.next()) {
                id_grupo_str.add(rs.);
            }
            
            
        } catch (Exception e) {
            
        }
        
    }*/
}
