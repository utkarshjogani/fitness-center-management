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
public class instructor_f extends javax.swing.JFrame {
Connection con ;
Statement stmt;
int flag;
DefaultTableModel model;
    /**
     * Creates new form instructor_f
     */
    public instructor_f(String a,String b) {
        initComponents();
       
        show1();
        pUpdate.hide();
        pview.setVisible(false);
        disabled();
        lbl.setText(a.toUpperCase()+"'s Finance");
        txtID.setText(b);
        
        show2(b);
         pAdd.setOpaque(false);
        pUpdate.setOpaque(false);
        pview.setOpaque(false);
    }
void disabled()
{
    txtID.setEditable(false);
    txtName.setEditable(false);
    txtGender.setEditable(false);      
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
        
           String query="Select distinct(iid) from instructor_f order by iid;";
           ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           {
             String BookID=rs.getString("iid") ;
             model.addRow(new Object[] {BookID});
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
         String query="Select * from instructor_f where iid= "+b+"";
         ResultSet rs=stmt.executeQuery(query);
         while(rs.next())
         {
             String BookID=rs.getString("iid") ;
             String BookName=rs.getString("amount") ;
             String Author=rs.getString("month") ;
             String booktype= rs.getString("date_of_transfer"); 
             model.addRow(new Object[] {BookID,BookName,Author,booktype});
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
    txtName.setText("");
    txtGender.setText("");
    lbldate.setText("");   
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

        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        cbDate = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        cbmonth = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox();
        lbl = new javax.swing.JLabel();
        pUpdate = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pview = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstdID = new javax.swing.JTable();
        pAdd = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllist = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 177, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Amount paid");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 170, -1));

        txtGender.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 177, -1));

        cbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });
        getContentPane().add(cbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        txtName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 177, -1));

        cbmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mm", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmonthActionPerformed(evt);
            }
        });
        getContentPane().add(cbmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Instructor ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 140, 24));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Month");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 110, -1));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 140, 23));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Date of payment");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 170, -1));

        cbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2013", "2014", "2015", "2017", "2018" }));
        getContentPane().add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        lbl.setFont(new java.awt.Font("Engravers MT", 0, 24)); // NOI18N
        lbl.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 360, 36));

        pUpdate.setBackground(new java.awt.Color(0, 0, 0));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(102, 102, 102));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        getContentPane().add(pUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, -1, 50));

        pview.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
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

        getContentPane().add(pview, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        tblstdID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "instructorID"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 105, 130));

        pAdd.setBackground(new java.awt.Color(0, 0, 0));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(204, 204, 204));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(102, 102, 102));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(204, 204, 204));
        btnDel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(102, 102, 102));
        btnDel.setText("DELETE");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(204, 204, 204));
        btnClose.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(102, 102, 102));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnClose1.setBackground(new java.awt.Color(204, 204, 204));
        btnClose1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose1.setForeground(new java.awt.Color(102, 102, 102));
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
                .addGap(18, 18, 18)
                .addComponent(btnDel)
                .addGap(19, 19, 19)
                .addComponent(btnClose)
                .addGap(18, 18, 18)
                .addComponent(btnClose1)
                .addContainerGap(32, Short.MAX_VALUE))
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

        getContentPane().add(pAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 550, 50));

        tbllist.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbllist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "instructor ID", "Amount paid", "month", "date of transfer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbllist.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tbllist);
        tbllist.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 450, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fitness/manage/banknote_currency_money_numbers_50323_1920x1080.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 0, 1710, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDateActionPerformed

    private void cbmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmonthActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if ((txtID.getText()).compareTo("")!=0 && (txtName.getText()).compareTo("")!=0 && (txtGender.getText()).compareTo("")!=0 &&  (cbDate.getSelectedItem())!="" && (cbmonth.getSelectedItem())!="" && (cbYear.getSelectedItem())!=""  ){
                OpenConnection();

                String d=cbYear.getSelectedItem()+"/"+cbmonth.getSelectedItem()+"/"+cbDate.getSelectedItem();
                String y=null;

                if(flag==1)
                {
                    String query="insert into instructor_f values ("+Integer.parseInt(txtID.getText())+",'"+txtName.getText()+"','"+txtGender.getText()+"','"+d+"');";
                    stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Record Updated!");
                }
                else if(flag==2)
                {

                    String query="update instructor_f set amount='"+txtName.getText()+"',month='"+txtGender.getText()+"',date_of_transfer='"+d+"' where iid="+txtID.getText()+" and date_of_transfer='"+lbldate.getText()+"';";
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
            show2(txtID.getText());
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pview.setVisible(false);
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
        String g=JOptionPane.showInputDialog("Enter the Date of transaction in yyyy/mm/dd format");
        
        setdata(y,g);
        pview.setVisible(false);
        pUpdate.setVisible(true);
        pAdd.setVisible(false);
        lbl.setText("FINANCE");
        enabled();
        flag=2;
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        String x=JOptionPane.showInputDialog("Enter the instructor ID to Delete");
        String g=JOptionPane.showInputDialog("Enter the Date of transaction in yyyy/mm/dd format.");
        setdata(x,g);
        int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete finance?");
        if (ans==JOptionPane.YES_OPTION)
        {
            try
            {
                OpenConnection();
                String query="Delete from instructor_f where iid=" + x + " and date_of_transfer='"+g+"';";
                stmt.executeUpdate(query);

                stmt.close();
                con.close();

                JOptionPane.showMessageDialog(null, "Record Deleted!");
                show2(x);
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
void setdata(String h,String g)
    {
        try
        {
             OpenConnection();

             String query="Select * from instructor_f where iid="+h+" and date_of_transfer='"+g+"';";
             ResultSet rs=stmt.executeQuery(query);
             if(rs.next())
             {
                 txtID.setText(rs.getString("iid"));
                 txtName.setText(rs.getString("amount"));
                 txtGender.setText(rs.getString("month"));
                 lbldate.setText(rs.getString("date_of_transfer"));
             }
            rs.close();
            stmt.close();
            con.close();
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error in connectivity"+e);
        }
} 
   void enabled()
{
    txtID.setEditable(true);
    txtName.setEditable(true);
    txtGender.setEditable(true);
    
}
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
       clear();
        String y=JOptionPane.showInputDialog("Enter the Student ID to VIEW");
        
        show2(y);
        lbl.setText("FINANCE");
        pUpdate.setVisible(false);
        pAdd.setVisible(false);
        pview.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClose1ActionPerformed

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
            java.util.logging.Logger.getLogger(instructor_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(instructor_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(instructor_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(instructor_f.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox cbDate;
    private javax.swing.JComboBox cbYear;
    private javax.swing.JComboBox cbmonth;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbldate;
    private javax.swing.JPanel pAdd;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JPanel pview;
    private javax.swing.JTable tbllist;
    private javax.swing.JTable tblstdID;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}