/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JOptionPane;
import proyectofinal.Enums.NivelSoporte;
import proyectofinal.Objetos.Administrador;
import proyectofinal.Objetos.Cliente;
import proyectofinal.Utilidades.Data;
import proyectofinal.Utilidades.InformacionUsuario;

/**
 *
 * @author ulacit
 */
public class Login extends javax.swing.JFrame {

    /*
    Vector fileVector = new Vector();
fileVector.add(new Vector(Arrays.asList(new String[]{"row1 col1", "row1 col2"})));
fileVector.add(new Vector(Arrays.asList(new String[]{"row2 col1", "row2 col2"})));
    
     */
    /**
     * Creates new form Login
     */
    public Login() {
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_3, "Jose", "Ulloa", "jose@mail.com", "123", 1));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_3, "Alejandro", "Salguero", "alejandro@mail.com", "123", 2));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_2, "Carlos", "Espinosa", "carlos@mail.com", "123", 3));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_1, "Martir", "Canales", "martir@mail.com", "123", 4));
        Data.LISTA_USUARIOS.inserta(new Cliente(88888888, "Mario", "Torres", "mario@mail.com", "123", 5));
        Data.LISTA_USUARIOS.inserta(new Cliente(88888888, "Luis", "Marin", "luis@mail.com", "123", 6));
        initComponents();
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
        TxtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BtnIngresar = new javax.swing.JButton();
        TxtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnIngresar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtContrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(BtnIngresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            if (Data.LISTA_USUARIOS.login(TxtUsuario.getText(), TxtContrasena.getText())) {
                ListaTickets listaTickets = new ListaTickets();
                listaTickets.show();
                this.hide();
            }
        }
    }//GEN-LAST:event_BtnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public boolean validarDatos() {

        if (TxtContrasena.getText().isEmpty() && TxtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Po favor no dejar campos sin llenar");
            TxtContrasena.requestFocus();
            return false;
        }

        if (TxtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dejaste el campo usuario sin datos");
            TxtUsuario.requestFocus();
            return false;
        }

        if (TxtContrasena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dejaste el campo contraseña sin datos");
            TxtContrasena.requestFocus();
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JPasswordField TxtContrasena;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
