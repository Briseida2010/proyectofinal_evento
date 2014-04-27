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

public class clsOrganizador {
    
    private Connection cnx = new clsConexion().getConnetion();
    
    public ArrayList<clsEntidadOrganizador>listarOrganizador(){
        ArrayList<clsEntidadOrganizador> Organizadores=new ArrayList<clsEntidadOrganizador>();
        try{
            CallableStatement st= cnx.prepareCall("{call sp_S_Organizador()}");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                clsEntidadOrganizador org=new clsEntidadOrganizador();
                org.setId_org(rs.getString("id_org"));
                org.setNomb_org(rs.getString("nomb_org"));
                org.setApel_org(rs.getString("apel_org"));
                org.setDni_org(rs.getString("dni_org"));
                org.setCel_org(rs.getString("cel_org"));
                Organizadores.add(org);
            }
            return Organizadores;      
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;     
        }
    }
    
    
    public void AgregarOrganizador(clsEntidadOrganizador organizador){
    
        try{
        CallableStatement st=cnx.prepareCall("{call sp_I_Organizador(?,?,?,?)}");
        st.setString("pnomb_org", organizador.getNomb_org());
        st.setString("papel_org", organizador.getApel_org());
        st.setString("pdni_org", organizador.getDni_org());
        st.setString("pcel_org", organizador.getCel_org());
        st.executeQuery();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void ModificarOrganizador(String codigo,clsEntidadOrganizador organizador){
        try{
         CallableStatement st = cnx.prepareCall("{call sp_U_Organizador(?,?,?,?,?)}");
        st.setString("pid_org", codigo);
        st.setString("pnomb_org", organizador.getNomb_org());
        st.setString("papel_org", organizador.getApel_org());
        st.setString("pdni_org", organizador.getDni_org());
        st.setString("pcel_org", organizador.getCel_org());
        st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void EliminarOrganizador(String codigo){
            try{
            CallableStatement st = cnx.prepareCall("{call sp_D_Organizador(?)}");
            st.setString("pid_org", codigo);
            st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
    
    public ResultSet consultarOrganizador() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_Organizador()}");
            rs = st.executeQuery();
            return rs;
           }
        catch(SQLException ex){
                    throw ex;
                    }
        }
    
    

    
      public ResultSet consultarOrganizadorCriterio(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call SP_S_Organizador_Criterio(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            rs = st.executeQuery();
            return rs;
            }
        catch(SQLException ex){
                    throw ex;
                    }
        }
    
}
