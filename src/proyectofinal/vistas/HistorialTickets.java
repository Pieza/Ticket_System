/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.objetos.Cliente;
import proyectofinal.utilidades.Data;
import proyectofinal.utilidades.InformacionUsuario;

/**
 *
 * @author ulacit
 */
public class HistorialTickets extends javax.swing.JFrame {

    /**
     * Creates new form HistorialTickets
     */
    public HistorialTickets() {
        initComponents();
        this.setLocationRelativeTo(null);
        obtenerTicketes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableTickets = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descripción", "Estado", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTicketsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableTickets);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Historial de ticketes cerrados");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTicketsMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) TableTickets.getModel();
            int filaSeleccionada = TableTickets.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString().trim());
            String bb = model.getValueAt(filaSeleccionada, 2).toString();
            InformacionTickets info = new InformacionTickets(id, model.getValueAt(filaSeleccionada, 2).toString());
            info.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Acción no válida");
        }
    }//GEN-LAST:event_TableTicketsMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (InformacionUsuario.usuario instanceof Cliente) {
            ListaTicketsCliente listaTicketsCliente = new ListaTicketsCliente();
            listaTicketsCliente.show();
            this.dispose();
        } else {
            ListaTickets listaTickets = new ListaTickets();
            listaTickets.show();
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    private void obtenerTicketes(){
        String[] listaTicketes = Data.HISTORIAL_TICKETES.preOrden();

        Vector fileVector = new Vector();
        for (String ticket : listaTicketes) {
            fileVector.add(new Vector(Arrays.asList(ticket.toString().split(","))));
        }

        Vector headings = new Vector();
        headings.add("Id");
        headings.add("Descripción");
        headings.add("Estado");
        headings.add("Cliente");

        DefaultTableModel model = new DefaultTableModel(fileVector, headings);
        TableTickets.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableTickets;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
