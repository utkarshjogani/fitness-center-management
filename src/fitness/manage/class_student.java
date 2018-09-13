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
public class class_student extends javax.swing.JFrame {
Connection con ;
Statement stmt;
int flag;
DefaultTableModel model;
    /**
     * Creates new form class_student
     */
    public class_student(String a,String b) {
        initComponents();
       
        show1();
        pUpdate.hide();
        pview1.setVisible(false);
        disabled();
        lbl.setText(a.toUpperCase()+"'s Class");
        txtID2.setText(b);
        setdata(b);
        setdata_amount(b);
        show2(b);
        forclassonly();
        pAdd.setOpaque(false);
        pview1.setOpaque(false);
        pUpdate.setOpaque(false);
        
    }
    void forclassonly()
    { 
         try
        {
            OpenConnection();
        String del="delete from amount where sid="+txtID2.getText()+";";
                     stmt.executeUpdate(del);
                    String proc="call calculate("+txtID2.getText()+");";
                    stmt.executeUpdate(proc);
                    setdata_amount(txtID2.getText());
        }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error in connectivity");
        }
         
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

             String query="Select * from class where sid="+h+";";
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
    void setdata_amount(String h)
    {
        try
        {
            OpenConnection();

             String query="Select total from amount where sid="+h+";";
             ResultSet rs=stmt.executeQuery(query);
             if(rs.next())
             {
                 lbl1.setText("Total Amount="+rs.getString("total"));
               
                
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
        
           String query="Select distinct(sid) from class order by sid;";
           ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           {
             String BookID=rs.getString("sid") ;
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
         String query="Select * from class where sid= "+b+"";
         ResultSet rs=stmt.executeQuery(query);
         while(rs.next())
         {
             String d1=rs.getString("sid") ;
             String d2=rs.getString("iid") ;
             String d3=rs.getString("bid") ;
             String d4= rs.getString("form"); 
             String d5= rs.getString("day"); 
             String d6= rs.getString("fees"); 
             
             model.addRow(new Object[] {d1,d2,d3,d4,d5.toUpperCase(),d6});
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
    lbl1.setText("");
    
      
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        txtID2 = new javax.swing.JTextField();
        txtID3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstdID = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllist = new javax.swing.JTable();
        pAdd = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        pUpdate = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pview = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pview1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 102, 0));
        jLabel4.setText("Branch ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 89, 24));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 102, 0));
        jLabel5.setText("Student ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 89, 24));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 102, 0));
        jLabel6.setText("Instructor ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 120, 24));

        txtID1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 177, -1));

        txtID2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 177, -1));

        txtID3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 177, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 89, 24));

        txtName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 177, -1));

        txtID.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 177, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("Day");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 340, 50));

        tblstdID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 105, 198));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 420, 730, 78));

        pAdd.setBackground(new java.awt.Color(0, 0, 0));

        add.setBackground(new java.awt.Color(255, 153, 51));
        add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(102, 51, 0));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 153, 51));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(102, 51, 0));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(255, 153, 51));
        btnDel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(102, 51, 0));
        btnDel.setText("DELETE");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 153, 51));
        btnClose.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(102, 51, 0));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnClose1.setBackground(new java.awt.Color(255, 153, 51));
        btnClose1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose1.setForeground(new java.awt.Color(102, 51, 0));
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

        getContentPane().add(pAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, -1, -1));

        pUpdate.setBackground(new java.awt.Color(0, 0, 0));

        btnUpdate.setBackground(new java.awt.Color(255, 153, 51));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 51, 0));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 153, 51));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(102, 51, 0));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pview.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
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

        javax.swing.GroupLayout pUpdateLayout = new javax.swing.GroupLayout(pUpdate);
        pUpdate.setLayout(pUpdateLayout);
        pUpdateLayout.setHorizontalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pUpdateLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(pUpdateLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(pview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pUpdateLayout.setVerticalGroup(
            pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUpdateLayout.createSequentialGroup()
                .addGroup(pUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 40));

        pview1.setBackground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 51, 0));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pview1Layout = new javax.swing.GroupLayout(pview1);
        pview1.setLayout(pview1Layout);
        pview1Layout.setHorizontalGroup(
            pview1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pview1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        pview1Layout.setVerticalGroup(
            pview1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pview1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, -1, -1));

        lbl1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(204, 102, 0));
        lbl1.setText("jLabel3");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 200, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fitness/manage/class at beach.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 1660, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       clear();
        pUpdate.setVisible(true);
        pAdd.setVisible(false);
        pview1.setVisible(false);
        enabled();
        lbl.setText("CLASS");
        flag=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        String y=JOptionPane.showInputDialog("Enter the Student ID to modify");
        setdata(y);
        pview1.setVisible(false);
        pUpdate.setVisible(true);
        pAdd.setVisible(false);
        lbl.setText("CLASS");
        enabled();
        flag=2;
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        String x=JOptionPane.showInputDialog("Enter the StudentID to Delete");
        setdata(x);
         String y=JOptionPane.showInputDialog("Enter the Form to Delete");
         y=y.toUpperCase();
      
         setdata_amount(x);
        int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete?");
        if (ans==JOptionPane.YES_OPTION)
        {
            try
            {
               OpenConnection();

                String query="Delete from class where sid=" + x + " and form='"+y+"';";
                stmt.executeUpdate(query);
                String del="delete from amount where sid="+x+";";
                     stmt.executeUpdate(del);
                    String proc="call calculate("+x+");";
                    stmt.executeUpdate(proc);
                    setdata_amount(txtID2.getText());
                    show2(x);

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
        setdata_amount(y);
        lbl.setText("CLASS");
        pUpdate.setVisible(false);
        pAdd.setVisible(false);
        pview1.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pview1.setVisible(false);
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        pview1.setVisible(false);
        clear();
// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if ((txtID.getText()).compareTo("")!=0 && (txtName.getText()).compareTo("")!=0  ){
                OpenConnection();

                String y=null;

                if(flag==1)
                {
                    String query="insert into class values ("+Integer.parseInt(txtID2.getText())+","+txtID1.getText()+","+txtID3.getText()+",'"+txtID.getText().toUpperCase()+"','"+txtName.getText().toUpperCase()+"',500);";
                    stmt.executeUpdate(query);
                    String del="delete from amount where sid="+txtID2.getText()+";";
                     stmt.executeUpdate(del);
                    String proc="call calculate("+txtID2.getText()+");";
                    stmt.executeUpdate(proc);
                    setdata_amount(txtID2.getText());

                    JOptionPane.showMessageDialog(null, "Record Updated!");
                    show2(txtID2.getText());
                }
                else if(flag==2)
                {

                    String query="update class set iid="+txtID1.getText()+",bid="+txtID3.getText()+",form='"+txtID.getText()+"',day='"+txtName.getText()+"',fees=500 where sid="+txtID2.getText()+";";
                    stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Record Modified!");
                    show2(txtID2.getText());
                }

                stmt.close();
                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Fields Empty");

            }

            pUpdate.setVisible(false);
            pAdd.setVisible(true);
            pview1.setVisible(false);
            clear();
            disabled();
            show1();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pview1.setVisible(false);
        pAdd.setVisible(true);
        pUpdate.setVisible(false);
        clear();
        lbl.setText("CLASS");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(class_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(class_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(class_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(class_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JPanel pAdd;
    private javax.swing.JPanel pUpdate;
    private javax.swing.JPanel pview;
    private javax.swing.JPanel pview1;
    private javax.swing.JTable tbllist;
    private javax.swing.JTable tblstdID;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
