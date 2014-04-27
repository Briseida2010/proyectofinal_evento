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

public class clsRecurso {
    
    
    private Connection cnx = new clsConexion().getConnetion();
    
    public ArrayList<clsEntidadRecurso>listarRecurso(){
        ArrayList<clsEntidadRecurso> Recursos=new ArrayList<clsEntidadRecurso>();
        try{
            CallableStatement st= cnx.prepareCall("{call sp_S_Recurso()}");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                clsEntidadRecurso recurso=new clsEntidadRecurso();
                recurso.setId_recurso(rs.getString("id_recurso"));
                recurso.setNomb_recurso(rs.getString("nomb_recurso"));
                recurso.setCosto_recurso(rs.getDouble("costo_recurso"));
                Recursos.add(recurso);
            }
            return Recursos;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
            
        }
    }
    
    
    public void AgregarRecurso(clsEntidadRecurso recurso){
    
        try{
        CallableStatement st=cnx.prepareCall("{call sp_I_Recurso(?,?)}");
        st.setString("pnomb_recurso", recurso.getNomb_recurso());
        st.setDouble("pcosto_recurso", recurso.getCosto_recurso());
        st.executeQuery();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void ModificarRecurso(String codigo,clsEntidadRecurso recurso){
        try{
        CallableStatement st = cnx.prepareCall("{call sp_U_Recurso(?,?,?)}");
        st.setString("pid_recurso", codigo);
        st.setString("pnomb_recurso", recurso.getNomb_recurso());
        st.setDouble("pcosto_recurso", recurso.getCosto_recurso());

        st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void EliminarRecurso(String codigo){
            try{
            CallableStatement st = cnx.prepareCall("{call sp_D_Recurso(?)}");
            st.setString("pid_recurso", codigo);
            st.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
    
    public ResultSet consultarRecurso() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_Recurso()}");
            rs = st.executeQuery();
            return rs;
           }
        catch(SQLException ex){
                    throw ex;
                    }
        }
    
   public ResultSet consultarRecursoCriterio(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call SP_S_Recurso_Criterio(?,?)}");
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
