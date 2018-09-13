/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitness.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class classes extends javax.swing.JFrame {
Connection con ;
Statement stmt;
int flag;
DefaultTableModel model;
    /**
     * Creates new form classes
     */
    public classes(String a,String b) {
        initComponents();
       
        show1();
        pUpdate.hide();
        pview.setVisible(false);
        disabled();
        lbl.setText(a.toUpperCase()+"'s CLASS");
        txtID1.setText(b);
        setdata(b);
        show2(b);
         pAdd.setOpaque(false);
        pUpdate.setOpaque(false);
        pview.setOpaque(false);
    }
    void enabled()
{
    txtID.setEditable(true);
     txtID1.setEditable(true);
      txtID2.setEditable(true);
       txtID3.setEditable(true);
        txtName.setEditable(true);
         
     
      
}
    void setdata(String h)
    {
        try
        {
             OpenConnection();

             String query="Select * from class where iid="+h+";";
             ResultSet rs=stmt.executeQuery(query);
             if(rs.next())
             {
                 txtID2.setText(rs.getString("sid"));
                 txtID1.setText(rs.getString("iid"));
                 txtID3.setText(rs.getString("bid"));
                 txtID.setText(rs.getString("form"));
                 txtName.setText(rs.getString("day"));
                
             }
            rs.close();
            stmt.close();
            con.close();
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error in connectivity");
        }
} 
void disabled()
{
    txtID.setEditable(false);
     txtID1.setEditable(false);
      txtID2.setEditable(false);
       txtID3.setEditable(false);
    txtName.setEditable(false);
          
}
    void OpenConnection()
 {
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness?useSSL=false","root","utkarsh");
        stmt=con.createStatement();
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
 }
void show1()
{
        delete2();
        DefaultTableModel model=(DefaultTableModel)tblstdID.getModel();

        try{
            OpenConnection();
        
           String query="Select distinct(iid) from class;";
           ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           {
             String d1=rs.getString("iid") ;
             model.addRow(new Object[] {d1});
           }
           rs.close();
           stmt.close();
           con.close();
          }
        catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null, "Error in connectivity");
             }
}
void show2(String b)
{
    
      delete3();
        DefaultTableModel model=(DefaultTableModel)tbllist.getModel();

        try{
          OpenConnection();
         String query="Select * from class where iid= "+b+"";
         ResultSet rs=stmt.executeQuery(query);
         while(rs.next())
         {
             String BookID=rs.getString("sid") ;
             String BookName=rs.getString("iid") ;
             String Author=rs.getString("bid") ;
             String booktype= rs.getString("form"); 
             String d1= rs.getString("day"); 
             String d2= rs.getString("fees"); 
             
             model.addRow(new Object[] {BookID,BookName,Author,booktype,d1,d2});
         }
        rs.close();
        stmt.close();
        con.close();
        }
        catch(Exception e){
                 JOptionPane.showMessageDialog(null, e+"  Error in connectivity");
             }
}
  void delete3()
{
    DefaultTableModel model=(DefaultTableModel)tbllist.getModel();
    int rows=model.getRowCount();
    if (rows>0)
    {
        for (int i=0;i<rows;i++)
        {
            model.removeRow(0);
        }
    }
}
     void delete2()
{
    DefaultTableModel model=(DefaultTableModel)tblstdID.getModel();
    int rows=model.getRowCount();
    if (rows>0)
    {
        for (int i=0;i<rows;i++)
        {
            model.removeRow(0);
        }
    }
}
     void clear()
{
    txtID.setText("");
    txtID1.setText("");
    txtID2.setText("");
    txtID3.setText("");
    txtName.setText("");
    
      
}
     void delete1()
{
    int rows=model.getRowCount();
    if (rows>0){
        for (int i=0;i<rows;i++){
            model.removeRow(0);
        }
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

        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstdID = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllist = new javax.swing.JTable();
        pUpdate = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pAdd = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        pview = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        txtID2 = new javax.swing.JTextField();
        txtID3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("Day");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 40, -1));

        txtID.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 177, -1));

        txtName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 177, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 100, 24));

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 370, 36));

        tblstdID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instructor ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblstdID);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 105, 190));

        tbllist.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbllist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Instructor ID", "Branch ID", "Form", "DAY", "Fees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbllist.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tbllist);
        tbllist.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 577, 94));

        pUpdate.setBackground(new java.awt.Color(0, 0, 0));

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 153, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(51, 51, 51));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 153, 255));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pUpdateLayout.setVerticalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnUpdate)
                .addComponent(btnCancel))
        );

        getContentPane().add(pUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, -1, 40));

        pAdd.setBackground(new java.awt.Color(0, 0, 0));

        add.setBackground(new java.awt.Color(51, 51, 51));
        add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(0, 153, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(51, 51, 51));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 153, 255));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(51, 51, 51));
        btnDel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(0, 153, 255));
        btnDel.setText("DELETE");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(51, 51, 51));
        btnClose.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(0, 153, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnClose1.setBackground(new java.awt.Color(51, 51, 51));
        btnClose1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose1.setForeground(new java.awt.Color(0, 153, 255));
        btnClose1.setText("VIEW");
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAddLayout = new javax.swing.GroupLayout(pAdd);
        pAdd.setLayout(pAddLayout);
        pAddLayout.setHorizontalGroup(
            pAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnEdit)
                .addGap(27, 27, 27)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addGap(18, 18, 18)
                .addComponent(btnClose1)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pAddLayout.setVerticalGroup(
            pAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(btnEdit)
                    .addComponent(btnDel)
                    .addComponent(btnClose)
                    .addComponent(btnClose1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, -1, -1));

        pview.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pviewLayout = new javax.swing.GroupLayout(pview);
        pview.setLayout(pviewLayout);
        pviewLayout.setHorizontalGroup(
            pviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );
        pviewLayout.setVerticalGroup(
            pviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(pview, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Branch ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 100, 24));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Student ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 100, 24));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Instructor ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 100, 24));

        txtID1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 177, -1));

        txtID2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 177, -1));

        txtID3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 177, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fitness/manage/yoga-hd-wallpaper_024616754_279.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, 20, 2000, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if ((txtID.getText()).compareTo("")!=0 && (txtName.getText()).compareTo("")!=0   ){
                OpenConnection();

               
                String y=null;

                if(flag==1)
                {
                    String query="insert into student_f values ("+Integer.parseInt(txtID2.getText())+",'"+txtID1.getText()+"','"+txtID3.getText()+"','"+txtID.getText()+"','"+txtName.getText()+"','500','"+"');";
                    stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Record Updated!");
                }
                else if(flag==2)
                {

                    String query="update class set sid='"+txtID2.getText()+"',bid='"+txtID3.getText()+"',form='"+txtID.getText()+"',day='"+txtName.getText()+"',fees='500' where iid="+txtID1.getText()+";";
                    stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Record Modified!");
                }

                stmt.close();
                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Fields Empty");

            }

            pUpdate.setVisible(false);
            pAdd.setVisible(true);
            pview.setVisible(false);
            clear();
            disabled();
            show1();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        pview.setVisible(false);
        clear();// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        pUpdate.setVisible(true);
        pAdd.setVisible(false);
        pview.setVisible(false);
        enabled();
        lbl.setText("FINANCE");
        flag=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        String y=JOptionPane.showInputDialog("Enter the Student ID to modify");
        setdata(y);
        pview.setVisible(false);
        pUpdate.setVisible(true);
        pAdd.setVisible(false);
        lbl.setText("FINANCE");
        enabled();
        flag=2;
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        String x=JOptionPane.showInputDialog("Enter the StudentID to Delete");
        setdata(x);
        int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete finance?");
        if (ans==JOptionPane.YES_OPTION)
        {
            try
            {
                 OpenConnection();

                String query="Delete from student_f where sid=" + x + ";";
                stmt.executeUpdate(query);

                stmt.close();
                con.close();

                JOptionPane.showMessageDialog(null, "Record Deleted!");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Record Not Deleted!");
        }
        show1();
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        String y=JOptionPane.showInputDialog("Enter the Student ID to VIEW");
        show2(y);
        lbl.setText("FINANCE");
        pUpdate.setVisible(false);
        pAdd.setVisible(false);
        pview.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pview.setVisible(false);
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        clear();
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
            java.util.logging.Logger.getLogger(classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JPanel pAdd;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JPanel pview;
    private javax.swing.JTable tbllist;
    private javax.swing.JTable tblstdID;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
