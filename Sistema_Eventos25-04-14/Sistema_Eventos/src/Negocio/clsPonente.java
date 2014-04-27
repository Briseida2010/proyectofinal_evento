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

public class clsPonente {
    
    private Connection cnx = new clsConexion().getConnetion();
    
    public ArrayList<clsEntidadPonente>listarPonente(){
        ArrayList<clsEntidadPonente> Ponentes=new ArrayList<clsEntidadPonente>();
        try{
            CallableStatement st= cnx.prepareCall("{call sp_S_Ponente()}");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                clsEntidadPonente pon=new clsEntidadPonente();
                
                pon.setId_pon(rs.getString("id_pon"));
                pon.setNomb_pon(rs.getString("nomb_pon"));
                pon.setApe_pon(rs.getString("ape_pon"));
                pon.setNacionalidad_pon(rs.getString("nacionalidad_pon"));
                pon.setEspecialidad_pon(rs.getString("especialidad_pon"));
                pon.setFoto_pon(rs.getString("foto_pon"));
                Ponentes.add(pon);
                
            }
            return Ponentes;
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
            
        }
    }
    
    
    public void AgregarPonente(clsEntidadPonente ponente){
    
        try{
        CallableStatement st=cnx.prepareCall("{call sp_I_Ponente(?,?,?,?,?)}");
        st.setString("pnomb_pon", ponente.getNomb_pon());
        st.setString("pape_pon", ponente.getApe_pon());
        st.setString("pnacionalidad_pon", ponente.getNacionalidad_pon());
        st.setString("pespecialidad_pon", ponente.getEspecialidad_pon());
        st.setString("pfoto_pon", ponente.getFoto_pon());
        st.executeQuery();              
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void ModificarPonente(String codigo,clsEntidadPonente ponente){
        try{
         CallableStatement st = cnx.prepareCall("{call sp_U_Ponente(?,?,?,?,?,?)}");
        st.setString("pid_pon", codigo);
        st.setString("pnomb_pon", ponente.getNomb_pon());
        st.setString("pape_pon", ponente.getApe_pon());
        st.setString("pnacionalidad_pon", ponente.getNacionalidad_pon());
        st.setString("pespecialidad_pon", ponente.getEspecialidad_pon());
        st.setString("pfoto_pon", ponente.getFoto_pon());
        st.execute();
     
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void EliminarPonente(String codigo){
         try{
         CallableStatement st = cnx.prepareCall("{call sp_D_Ponente(?)}");
         st.setString("pid_pon", codigo);
         st.execute();
    
          
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
    
    public ResultSet consultarPonente() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_Ponente()}");
            rs = st.executeQuery();
            return rs;
           }
        catch(SQLException ex){
                    throw ex;
                    }
     }
    
       public ResultSet consultarPonenteCriterio(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call SP_S_Ponente_Criterio(?,?)}");
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
