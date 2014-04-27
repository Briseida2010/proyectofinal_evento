

package Negocio;
import Conexion.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clsUsuario {
    private Connection cnx = new clsConexion().getConnetion();
    public ResultSet LoginUsuario(String usu,String pass) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement cst = cnx.prepareCall("{Call sp_S_usuarioLogin(?,?)}");
            cst.setString("pnomb_usu", usu);
            cst.setString("ppass_usu", pass);
            rs= cst.executeQuery();
            return rs;
        }catch(SQLException ex){
         javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
         throw ex;
        }
    }
            
      public void agregarUsuario (clsEntidadUsuario Usuario){

try{
CallableStatement st = cnx.prepareCall("{call sp_I_Usuario(?,?,?,?,?)}");
st.setString("pid_usu", Usuario.getId_usu());
st.setString("pnomb_usu", Usuario.getNomb_usu());
st.setString("ppass_usu", Usuario.getPass_usu());
st.setString("pnivel_usu", Usuario.getNivel_usu());
st.setString("pestado_usu", Usuario.getEstado_usu());

st.execute();

} catch(SQLException ex){
ex.printStackTrace();
}

}


public void modificarUsuario (String codigo, clsEntidadUsuario Usuario){
try{
CallableStatement st = cnx.prepareCall("{call sp_U_Usuario(?,?,?,?,?)}");
st.setString("pid_usu", codigo);
st.setString("pnomb_usu", Usuario.getNomb_usu());
st.setString("ppass_usu", Usuario.getPass_usu());
st.setString("pnivel_usu", Usuario.getNivel_usu());
st.setString("pestado_usu", Usuario.getEstado_usu());

st.executeUpdate();
} catch (SQLException ex){
ex.printStackTrace();
} 
}


public void eliminarUsuario (String codigo){
try{
CallableStatement st = cnx.prepareCall("{call sp_D_Usuario(?)}");
st.setString("pid_usu", codigo); 
st.execute();
} catch (SQLException ex){
ex.printStackTrace();
} 
}

 public ResultSet consultarUsuario() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_Usuario()}");
            rs = st.executeQuery();
            return rs;
            }
        catch(SQLException ex){
                    throw ex;
                    }
        }
 
 
   public ResultSet consultarUsuarioCriterio(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call SP_S_Usuarios_Criterio(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            rs = st.executeQuery();
            return rs;
            }
        catch(SQLException ex){
                    throw ex;
                    }
        }


public ArrayList listarUsuarios(){

ArrayList Usuarios = new ArrayList();
try{
CallableStatement st = cnx.prepareCall("{call SP_S_Usuario()}");
ResultSet resultSet = st.executeQuery();

while (resultSet.next()){
clsEntidadUsuario usuario = new clsEntidadUsuario();
usuario.setId_usu(resultSet.getString("id_usu"));
usuario.setNomb_usu(resultSet.getString("nomb_usu"));
usuario.setPass_usu(resultSet.getString("pass_usu"));
usuario.setNivel_usu(resultSet.getString("nivel_usu"));
usuario.setEstado_usu(resultSet.getString("estado_usu")); 

Usuarios.add(usuario);
}
return Usuarios;

} catch(SQLException ex){
ex.printStackTrace();
return null;
}

}     
            
}
