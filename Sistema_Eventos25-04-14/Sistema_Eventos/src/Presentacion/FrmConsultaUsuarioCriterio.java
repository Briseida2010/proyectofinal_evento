/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Entidad.*;
import Negocio.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


/**
 *
 * @author BEPIS
 */
public class FrmConsultaUsuarioCriterio extends javax.swing.JInternalFrame {

    static ResultSet rs = null;
    DefaultTableModel dtm = new DefaultTableModel();
    

    public FrmConsultaUsuarioCriterio() {
        initComponents(); 
        agruparBotones();
        cargarTabla();
    }

    
    public void agruparBotones(){
        buttonGroup1.add(rbtnCodigo);
        buttonGroup1.add(rbtnNombre);
        buttonGroup1.add(rbtnNivel);
        buttonGroup1.add(rbtnTodos);
    }
    
    public void cargarTabla(){
        String titulos[] = {"codigo", "Nombre", "Password", "Nivel", "Estado"};
        dtm.setColumnIdentifiers(titulos);
        tablaCriterio.setModel(dtm);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        btngenerar = new javax.swing.JButton();
        btncerrar = new javax.swing.JButton();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnNivel = new javax.swing.JRadioButton();
        rbtnTodos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCriterio = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Consulta de Usuario por Criterio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setText("Criterio de Busqueda :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        getContentPane().add(txtbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, -1));

        btngenerar.setText("Generar");
        btngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btngenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        btncerrar.setText("Cerrar");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 70, -1));

        rbtnCodigo.setText("Codigo");
        getContentPane().add(rbtnCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        rbtnNombre.setText("Nombre");
        rbtnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNombreActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        rbtnNivel.setText("Nivel");
        getContentPane().add(rbtnNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        rbtnTodos.setText("Todos");
        getContentPane().add(rbtnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        tablaCriterio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCriterio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 530, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarActionPerformed
       String Criterio, Busqueda;
       Busqueda = txtbusqueda.getText();
       if(rbtnCodigo.isSelected()){
           Criterio = "codigo";
       }
       else if(rbtnNombre.isSelected()){
         Criterio ="nombre";
       }              
       else if (rbtnNivel.isSelected()){
           Criterio = "nivel";
       } 
       else{
           Criterio = "";
       }
       
        clsUsuario usuario = new clsUsuario();
    try{
        rs = usuario.consultarUsuarioCriterio(Criterio, Busqueda);
        boolean encuentra = false;
        String Datos[] = new String[5];
        int f,i;
        f = dtm.getRowCount();
        if(f>0){
            for(i=0; i<f; i++){
                dtm.removeRow(0);
            }
        }
        
        while(rs.next()){
            Datos[0] = (String) rs.getString(1);
            Datos[1] = (String) rs.getString(2);
            Datos[2] = (String) rs.getString(3);
            Datos[3] = (String) rs.getString(4);
            Datos[4] = (String) rs.getString(5);
            dtm.addRow(Datos);
            encuentra = true;
        }
        if(encuentra = false){
            JOptionPane.showMessageDialog(null, "Registro no encontrado");
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btngenerarActionPerformed

    private void rbtnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btngenerar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnNivel;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JRadioButton rbtnTodos;
    private javax.swing.JTable tablaCriterio;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}