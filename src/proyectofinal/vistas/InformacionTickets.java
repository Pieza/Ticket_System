/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import javax.swing.JOptionPane;
import proyectofinal.enums.EstadoTickete;
import proyectofinal.objetos.Administrador;
import proyectofinal.objetos.Cliente;
import proyectofinal.objetos.Ticket;
import proyectofinal.utilidades.Data;
import proyectofinal.utilidades.InformacionUsuario;

/**
 *
 * @author ulacit
 */
public class InformacionTickets extends javax.swing.JFrame {

    /**
     * Creates new form InformacionTickets
     */
    private int id;
    private Ticket ticket;

    public InformacionTickets(int id, String estadoTicket) {
        // inicializar componentes de la vista
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if (InformacionUsuario.usuario instanceof Cliente) {
            CmbxUsuarios.show(false);
            LblAsignarCasoA.show(false);
        }
        if ((estadoTicket.equalsIgnoreCase("SIN_ASIGNAR"))) {
            //CmbxUsuarios.show(true);
            //LblAsignarCasoA.show(true);
            //cargarUsuarioCombobox();
        } else {
            //CmbxUsuarios.show(false);
            LblAsignarCasoA.setText("Reasignar a:");
        }
        if(estadoTicket.equalsIgnoreCase("COMPLETADO")){
            LblAsignarCasoA.setText("Ticket completado por:");
            lblNuevaActualizacion.show(false);
            TxtNuevaActualizacion.show(false);
            CmbxUsuarios.setEnabled(false);
            CmbxEstadoCaso.setEnabled(false);
            BtnActualizarCaso.show(false);
        }
        this.id = id;

        actualizarVista();
    }

    private void cargarUsuarioCombobox() {
        CmbxUsuarios.removeAllItems();
        String[] listaUsuarios = Data.LISTA_USUARIOS.obtieneAdministradores();

        //Vector fileVector = new Vector();
        for (String usuario : listaUsuarios) {
            CmbxUsuarios.addItem(usuario);
        }
        // se verifica si hay un asignado para el ticket
        Administrador asignado = ticket.getAsignadolvl1() != null ? ticket.getAsignadolvl1()
                : ticket.getAsignadolvl2() != null ? ticket.getAsignadolvl2()
                : ticket.getAsignadolvl3() != null ? ticket.getAsignadolvl3()
                : null;

        // si hay asignado se selecciona en el combo box
        if (asignado != null) {
            for (int i = 0; i < listaUsuarios.length; i++) {
                if (listaUsuarios[i].contains("[" + asignado.getId() + "]")) {
                    CmbxUsuarios.setSelectedIndex(i);
                }

            }

        }
    }

    private void actualizarTickete() {
        try {
            // se obtiene el usuario seleccionado
            String strUser = CmbxUsuarios.getSelectedItem().toString();
            int id = Integer.parseInt(strUser.substring(1, strUser.indexOf("]")));

            // se obtiene el estado seleccionado
            EstadoTickete estado = EstadoTickete.valueOf(CmbxEstadoCaso.getSelectedItem().toString());
            Administrador asignado = (Administrador) Data.LISTA_USUARIOS.extrae(id);

            // se actualiza el ticket
            if (Data.TICKETES.actualizarTicket(ticket.getId(), TxtNuevaActualizacion.getText(), estado, asignado)) {
                JOptionPane.showMessageDialog(null, "Tickete actualizado correctamente!");
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el tickete");
            }
            
            if(estado == EstadoTickete.COMPLETADO){
                Data.HISTORIAL_TICKETES.inserta(ticket);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el tickete");
        }
    }

    private void actualizarVista() {
        // extrae el tickete por id
        TxtNuevaActualizacion.setText("");
        ticket = Data.TICKETES.busquedaTicketPorID(id);
        TxtIdTicket.setText(Integer.toString(ticket.getId()));
        TxtDescripcion.setText(ticket.getDescripcion());
        TxtEmailCliente.setText(ticket.getCreadoPor().getCorreo());
        TxtNombreCliente.setText(ticket.getCreadoPor().getNombre() + " " + ticket.getCreadoPor().getApellidos());
        TxttelefonoCliente.setText(Integer.toString(ticket.getCreadoPor().getTelefono()));
        TxtHistorialCaso.setText(ticket.getHistorial());
        cargarUsuarioCombobox();
        // se elige el estado del tickete en el combobox
        switch (ticket.getEstado()) {
            case EN_PROGRESO:
                CmbxEstadoCaso.setSelectedIndex(1);
                break;
            case ESPERANDO_RESPUESTA:
                CmbxEstadoCaso.setSelectedIndex(2);
                break;
            case COMPLETADO:
                CmbxEstadoCaso.setSelectedIndex(3);
                break;
            default:
                CmbxEstadoCaso.setSelectedIndex(0);
                break;
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
        TxtIdTicket = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNombreCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtEmailCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxttelefonoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CmbxEstadoCaso = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtNuevaActualizacion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtHistorialCaso = new javax.swing.JTextArea();
        BtnActualizarCaso = new javax.swing.JButton();
        lblNuevaActualizacion = new javax.swing.JLabel();
        LblAsignarCasoA = new javax.swing.JLabel();
        CmbxUsuarios = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID Ticket:");

        TxtIdTicket.setEditable(false);

        jLabel2.setText("Descripción:");

        TxtDescripcion.setEditable(false);

        jLabel3.setText("Nombre:");

        TxtNombreCliente.setEditable(false);

        jLabel4.setText("Email:");

        TxtEmailCliente.setEditable(false);

        jLabel5.setText("Teléfono:");

        TxttelefonoCliente.setEditable(false);

        jLabel6.setText("Estado del caso:");

        CmbxEstadoCaso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDIENTE", "EN_PROGRESO", "ESPERANDO_RESPUESTA", "COMPLETADO", "SIN_ASIGNAR" }));

        TxtNuevaActualizacion.setColumns(20);
        TxtNuevaActualizacion.setRows(5);
        jScrollPane1.setViewportView(TxtNuevaActualizacion);

        TxtHistorialCaso.setEditable(false);
        TxtHistorialCaso.setColumns(20);
        TxtHistorialCaso.setRows(5);
        jScrollPane2.setViewportView(TxtHistorialCaso);

        BtnActualizarCaso.setText("Actualizar Caso");
        BtnActualizarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarCasoActionPerformed(evt);
            }
        });

        lblNuevaActualizacion.setText("Nueva Actualización:");

        LblAsignarCasoA.setText("Asignar caso a:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(TxtDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblAsignarCasoA)
                        .addGap(18, 18, 18)
                        .addComponent(CmbxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnActualizarCaso))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(TxtIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(CmbxEstadoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(TxttelefonoCliente))
                        .addGap(25, 25, 25)
                        .addComponent(lblNuevaActualizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtIdTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CmbxEstadoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblAsignarCasoA)
                        .addComponent(CmbxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNuevaActualizacion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxttelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(BtnActualizarCaso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActualizarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarCasoActionPerformed
        if (!TxtNuevaActualizacion.getText().isEmpty()) {
            actualizarTickete();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una actualización válida");
        }
    }//GEN-LAST:event_BtnActualizarCasoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizarCaso;
    private javax.swing.JComboBox<String> CmbxEstadoCaso;
    private javax.swing.JComboBox<String> CmbxUsuarios;
    private javax.swing.JLabel LblAsignarCasoA;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtEmailCliente;
    private javax.swing.JTextArea TxtHistorialCaso;
    private javax.swing.JTextField TxtIdTicket;
    private javax.swing.JTextField TxtNombreCliente;
    private javax.swing.JTextArea TxtNuevaActualizacion;
    private javax.swing.JTextField TxttelefonoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNuevaActualizacion;
    // End of variables declaration//GEN-END:variables
}
