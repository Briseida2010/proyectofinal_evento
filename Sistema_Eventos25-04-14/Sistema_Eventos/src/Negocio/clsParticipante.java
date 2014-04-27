/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Conexion.clsConexion;
import Entidad.clsEntidadParticipante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author azteca
 */
public class clsParticipante {
    
    private Connection cnx = new clsConexion().getConnetion();
    
   public ArrayList<clsEntidadParticipante>listarParticipante(){
        ArrayList<clsEntidadParticipante> Participante=new ArrayList<clsEntidadParticipante>();
        try{
            CallableStatement st= cnx.prepareCall("{call sp_S_Participante()}");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                clsEntidadParticipante par=new clsEntidadParticipante();
                
                par.setId_par(rs.getString("id_par"));
                par.setNomb_par(rs.getString("nomb_par"));
                par.setApe_par(rs.getString("ape_par"));
                par.setEmail_par(rs.getString("email_par"));
                par.setCelular_par(rs.getString("celular_par"));
                Participante.add(par);
            }
            return Participante;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
            
        }
    }
  
    
    public void AgregarParticipante(clsEntidadParticipante participante){
    
        try{
        CallableStatement st=cnx.prepareCall("{call sp_I_Participante(?,?,?,?)}");
        st.setString("pnomb_par", participante.getNomb_par());
        st.setString("pape_par", participante.getApe_par());
        st.setString("pemail_par", participante.getEmail_par());
        st.setString("pcelular_par", participante.getCelular_par());
        st.execute();
                      
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void ModificarParticipante(String codigo,clsEntidadParticipante participante){
        try{
         CallableStatement st = cnx.prepareCall("{call sp_U_Participante(?,?,?,?,?)}");
        st.setString("pid_par", codigo);
        st.setString("pnomb_par", participante.getNomb_par());
        st.setString("pape_par", participante.getApe_par());
        st.setString("pemail_par", participante.getEmail_par());
        st.setString("pcelular_par", participante.getCelular_par());
        st.execute();
          
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void EliminarParticipante(String codigo){
         try{
         CallableStatement st = cnx.prepareCall("{call sp_D_Participante(?)}");
         st.setString("pid_par", codigo);
         st.execute();
          
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
    
     public ResultSet consultarParticipante() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call sp_S_Participante()}");
            rs = st.executeQuery();
            return rs;
           }
        catch(SQLException ex){
                    throw ex;
                    }
        }
    
       public ResultSet consultarParticipanteCriterio(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement st = cnx.prepareCall("{call SP_S_Participante_Criterio(?,?)}");
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
