/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.manage;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class password_show extends javax.swing.JFrame {

    /**
     * Creates new form password_show
     */
    public password_show(String a) {
       
        initComponents();
         lbl.setText(a);
        pcancel.hide();
        pas.setText("");
        
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
        pas = new javax.swing.JPasswordField();
        lbl = new javax.swing.JLabel();
        plog = new javax.swing.JPanel();
        pcancel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Enter password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 74, -1, 23));

        pas.setText("jPasswordField1");
        getContentPane().add(pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 74, 100, 23));

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 22, 107, 25));

        javax.swing.GroupLayout plogLayout = new javax.swing.GroupLayout(plog);
        plog.setLayout(plogLayout);
        plogLayout.setHorizontalGroup(
            plogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        plogLayout.setVerticalGroup(
            plogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(plog, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 115, -1, -1));

        javax.swing.GroupLayout pcancelLayout = new javax.swing.GroupLayout(pcancel);
        pcancel.setLayout(pcancelLayout);
        pcancelLayout.setHorizontalGroup(
            pcancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pcancelLayout.setVerticalGroup(
            pcancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 171, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String x=pas.getText();
        if(x.equals("utkarsh"))
        {
            if (lbl.getText().equals("STUDENT"))
           {
           STUDENT s1=new STUDENT();
               s1.setVisible(true);
               setVisible(false);
           }
            else if(lbl.getText().equals("INSTRUCTOR"))
            {
                instructor i1=new instructor();
               i1.setVisible(true);
               setVisible(false);
            }
            
            
       }
        else{
            plog.hide();
            pcancel.show();
        
           JOptionPane.showMessageDialog(null, "Wrong password!");
           setVisible(false);
           
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(password_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(password_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(password_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(password_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JPasswordField pas;
    private javax.swing.JPanel pcancel;
    private javax.swing.JPanel plog;
    // End of variables declaration//GEN-END:variables
}