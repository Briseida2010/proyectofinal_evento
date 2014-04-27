/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;
import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clsTipoComision {
    
    
    private Connection cnx = new clsConexion().getConnetion();
    
    public ArrayList<clsEntidadTipoComision>listarTipoComision(){
        ArrayList<clsEntidadTipoComision> Comisiones=new ArrayList<clsEntidadTipoComision>();
        try{
            CallableStatement st= cnx.prepareCall("{call sp_S_TipoComision()}");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                clsEntidadTipoComision tipocomi=new clsEntidadTipoComision();
                tipocomi.setId_Tipocomi(rs.getString("id_Tipocomi"));
                tipocomi.setNomb_Tipocomi(rs.getString("nomb_Tipocomi"));
               
                Comisiones.add(tipocomi);
            }
            return Comisiones;      
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;     
        }
    }
    
    
    public void AgregarTipoComision(clsEntidadTipoComision tipocomision){
    
        try{
        CallableStatement st=cnx.prepareCall("{call sp_I_TipoComision(?)}");
        st.setString("pnomb_Tipocomi", tipocomision.getNomb_Tipocomi());
        
        st.executeQuery();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void ModificarTipoComision(String codigo,clsEntidadTipoComision tipocomision){
        try{
        CallableStatement st = cnx.prepareCall("{call sp_U_TipoComision(?,?)}");
        st.setString("pid_Tipocomi", codigo);
        st.setString("pnomb_Tipocomi", tipocomision.getNomb_Tipocomi());
        
        st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void EliminarTipoComision(String codigo){
            try{
            CallableStatement st = cnx.prepareCall("{call sp_D_TipoComision(?)}");
            st.setString("pid_Tipocomi", codigo);
            st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
    
    public ResultSet consultarTipoComision() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_TipoComision()}");
            rs = st.executeQuery();
            return rs;
           }
        catch(SQLException ex){
                    throw ex;
                    }
        }
    
    

    
      
    
    
}
