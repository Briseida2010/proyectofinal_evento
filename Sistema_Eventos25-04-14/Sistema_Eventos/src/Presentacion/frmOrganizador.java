/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Entidad.*;
import Negocio.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import java.util.Date;
import java.text.*;
import javax.swing.table.DefaultTableModel;

public class frmOrganizador extends javax.swing.JInternalFrame {

    
    String Codigo;
    double resultado;
    int registros;
    
    public frmOrganizador() {
        initComponents();
        activarBotones(true,false,false,true);
        actualizarTabla();
        desactivarCampos();
    }
    
    void limpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtCelular.setText("");
        
    }
    
    void activarCampos(){
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtDni.setEnabled(true);
        txtCelular.setEnabled(true);
    }
    
    void desactivarCampos(){
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtDni.setEnabled(false);
        txtCelular.setEnabled(false);
    }
    
    void activarBotones(boolean n,boolean g,boolean m,boolean e){
        btnNuevo.setEnabled(n);
        btnGrabar.setEnabled(g);
        btnModificar.setEnabled(m);
        btnEliminar.setEnabled(e);
    }
    
     void actualizarTabla(){
     String titulos[] = {"Id","Nombres","Apellidos","DNI","Celular"};  
     clsOrganizador organizador = new clsOrganizador();
     ArrayList<clsEntidadOrganizador>organizadores = organizador.listarOrganizador();
     Iterator iterator = organizadores.iterator();
     DefaultTableModel dtm = new DefaultTableModel(null,titulos);
     String fila[]=new String [5];
     while (iterator.hasNext()){
         clsEntidadOrganizador org = new clsEntidadOrganizador();
         org = (clsEntidadOrganizador) iterator.next();
         fila[0] = org.getId_org();
         fila[1] = org.getNomb_org();
         fila[2] = org.getApel_org();
         fila[3] = org.getDni_org();
         fila[4] = org.getCel_org();
          
         dtm.addRow(fila);                   
     }
        tblOrganizador.setModel(dtm);
     } 
     
    void seleccionarTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
         registros = tblOrganizador.getSelectedRow();
         if(registros==-1){
             JOptionPane.showMessageDialog(this, "se debe seleccionar un registro");
         }else{
             dtm = (DefaultTableModel)tblOrganizador.getModel();
             Codigo=((String)dtm.getValueAt(registros, 0));
             txtNombres.setText((String)dtm.getValueAt(registros, 1));
             txtApellidos.setText((String)dtm.getValueAt(registros, 2));
             txtDni.setText((String)dtm.getValueAt(registros, 3));
             txtCelular.setText((String)dtm.getValueAt(registros, 4));
             activarBotones(true,false,true,true);
             activarCampos();
         }
     }
    
    void recorrerTabla(){
         DefaultTableModel dtm = new DefaultTableModel(); 
         if(registros==-1){
             JOptionPane.showMessageDialog(this, "se debe seleccionar un registro");
         }else{
             dtm = (DefaultTableModel)tblOrganizador.getModel();
             Codigo=((String)dtm.getValueAt(registros, 0));
             txtNombres.setText((String)dtm.getValueAt(registros, 1));
             txtApellidos.setText((String)dtm.getValueAt(registros, 2));
             txtDni.setText((String)dtm.getValueAt(registros, 3));
             txtCelular.setText((String)dtm.getValueAt(registros, 4));
             activarBotones(true,false,true,true);
             activarCampos();
         }   
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganizador = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mantenimiento de Organizador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombres:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));

        tblOrganizador.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrganizador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrganizadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrganizador);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 540, 130));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/record.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/page_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/page_remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/computer_remove.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rewind.png"))); // NOI18N
        btnPrimero.setText("Primero");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrimero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/skip_backward.png"))); // NOI18N
        btnAnterior.setText("<<Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/skip_forward.png"))); // NOI18N
        btnSiguiente.setText("siguiente>>");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fast_forward.png"))); // NOI18N
        btnUltimo.setText("Ultimo");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Celular:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellidos:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("DNI:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        getContentPane().add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 190, 30));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, 30));
        getContentPane().add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 190, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrganizadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrganizadorMouseClicked
        seleccionarTabla();
    }//GEN-LAST:event_tblOrganizadorMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        activarCampos();
        txtNombres.requestFocus();
        activarBotones(false,true,false,false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        clsOrganizador organizador = new clsOrganizador();
        clsEntidadOrganizador org = new clsEntidadOrganizador();

        org.setNomb_org(txtNombres.getText());
        org.setApel_org(txtApellidos.getText());
        org.setDni_org(txtDni.getText());
        org.setCel_org(txtCelular.getText());

        organizador.AgregarOrganizador(org);
        actualizarTabla();
        activarBotones(true,false,false,false);
        desactivarCampos();
        limpiarCampos();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        clsOrganizador organizador = new clsOrganizador();
        
        clsEntidadOrganizador org = new clsEntidadOrganizador();
        org.setNomb_org(txtNombres.getText());
        org.setApel_org(txtApellidos.getText());
        org.setDni_org(txtDni.getText());
        org.setCel_org(txtCelular.getText());

        organizador.ModificarOrganizador(Codigo, org);
        actualizarTabla();
        desactivarCampos();
        limpiarCampos();
        activarBotones(true,false,false,false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int r;
        r = JOptionPane.showConfirmDialog(null, "¿Estas seguro de Eliminar el registro?",
            "Pregunta",0);
        if(r==0){
            clsOrganizador org = new clsOrganizador();
            org.EliminarOrganizador(Codigo);
            actualizarTabla();
            limpiarCampos();

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int r;
        r = JOptionPane.showConfirmDialog(null, "¿Deseas Cancelar la Operacion?",
            "Pregunta",0);
        if(r==0){
            limpiarCampos();
            txtNombres.setEnabled(true);
            txtNombres.requestFocus();
            activarBotones(true,false,false,false);
            desactivarCampos();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        registros = 0;
        recorrerTabla();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        registros =registros-1;
        if(registros<0){
            registros = 0;
            JOptionPane.showMessageDialog(null, "Primer Registro");

        }
        recorrerTabla();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        registros =registros+1;
        if(registros>tblOrganizador.getRowCount()-1){
            registros = tblOrganizador.getRowCount()-1;
            JOptionPane.showMessageDialog(null, "Ultimo Registro");

        }
        recorrerTabla();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        registros = tblOrganizador.getRowCount()-1;
        recorrerTabla();
    }//GEN-LAST:event_btnUltimoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrganizador;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
