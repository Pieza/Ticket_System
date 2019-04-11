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
import proyectofinal.utilidades.Data;
import proyectofinal.utilidades.InformacionUsuario;

/**
 *
 * @author ulacit
 */
public class ListaTickets extends javax.swing.JFrame {

    /**
     * Creates new form ListaTickets
     */
    public ListaTickets() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTicketes();

        //obtenemos la informacion del logueo del usuario
        LblUsuarioLogueado.setText(InformacionUsuario.usuario.getNombre() + " " + InformacionUsuario.usuario.getApellidos());
    }

    private void cargarTicketes() {
        // se extrae la lista de ticketes del usuario usando el id
        String[] listaTicketes = Data.TICKETES.extraePendientes(InformacionUsuario.usuario.getId());

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

    private void cargarTicketsSinAsignar() {
        // se extrae la lista de ticketes del usuario usando el id
        String[] listaTicketes = Data.TICKETES.extraeSinAsignar();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableTickets = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LblUsuarioLogueado = new javax.swing.JLabel();
        CmbxAsignacionTickets = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        BtnHistorial = new javax.swing.JButton();
        BtnLogOut = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        LblUsuarioLogueado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LblUsuarioLogueado.setText("\"\"");

        CmbxAsignacionTickets.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asignados a mi", "Sin asignar" }));
        CmbxAsignacionTickets.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbxAsignacionTicketsItemStateChanged(evt);
            }
        });
        CmbxAsignacionTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbxAsignacionTicketsActionPerformed(evt);
            }
        });

        jLabel2.setText("Ver tickets:");

        BtnHistorial.setText("Ver Historial");
        BtnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHistorialActionPerformed(evt);
            }
        });

        BtnLogOut.setText("Salir");
        BtnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogOutActionPerformed(evt);
            }
        });

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblUsuarioLogueado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CmbxAsignacionTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnLogOut)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(672, Short.MAX_VALUE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LblUsuarioLogueado)
                    .addComponent(CmbxAsignacionTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BtnHistorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(BtnActualizar)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTicketsMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) TableTickets.getModel();
            int filaSeleccionada = TableTickets.getSelectedRow();//obtenemos la fila que seleccionamos
            int id = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());//obtenemos la columna 0 de la fila que seleccionamos para tener el id
            InformacionTickets info = new InformacionTickets(id, model.getValueAt(filaSeleccionada, 2).toString());//nos vamos a la informacion del ticket con el id para la busqueda
            info.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Acción no válida");
        }
    }//GEN-LAST:event_TableTicketsMouseClicked

    private void CmbxAsignacionTicketsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbxAsignacionTicketsItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_CmbxAsignacionTicketsItemStateChanged

    private void CmbxAsignacionTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbxAsignacionTicketsActionPerformed
        // TODO add your handling code here:
        actualizarVentana();
    }//GEN-LAST:event_CmbxAsignacionTicketsActionPerformed

    private void BtnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHistorialActionPerformed
        // TODO add your handling code here:
        //creamos una nueva instancia de formulario y ocultamos el actual
        HistorialTickets historial = new HistorialTickets();
        this.dispose();
        historial.show();
    }//GEN-LAST:event_BtnHistorialActionPerformed

    private void actualizarVentana() {
        //revisamos el estado del ticket para asi cargar diferentes, los asinados y los que no
        if (CmbxAsignacionTickets.getSelectedItem().equals("Sin asignar")) {
            cargarTicketsSinAsignar();
        } else {
            cargarTicketes();
        }
    }

    private void BtnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogOutActionPerformed
        //borramos datos y salimos del sistema
        Login login = new Login();
        InformacionUsuario.usuario = null;
        this.dispose();
        login.show();
    }//GEN-LAST:event_BtnLogOutActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        actualizarVentana();
    }//GEN-LAST:event_BtnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnHistorial;
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JComboBox CmbxAsignacionTickets;
    private javax.swing.JLabel LblUsuarioLogueado;
    private javax.swing.JTable TableTickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
