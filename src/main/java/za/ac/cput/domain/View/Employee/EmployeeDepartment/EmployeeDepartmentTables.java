/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package za.ac.cput.domain.View.Employee.EmployeeDepartment;

import java.io.IOException;
//import za.ac.cput.domain.View.Employee.EmployeeContact.*;
//import za.ac.cput.domain.View.Employee.EmployeeGender.*;
//import za.ac.cput.domain.View.Employee.EmployeeLeaves.*;
//import za.ac.cput.domain.View.Employee.Leave.*;
//import za.ac.cput.domain.View.Employee.EmployeeSalary.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.domain.ContactType;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Leaves;
import za.ac.cput.domain.OkHttp.OkHttpClient;
import za.ac.cput.domain.Salary;
//import za.ac.cput.domain.View.Employee.EmployeeGender.*;

/*
Farai Malone Chawora 
student # 220145547

*/
public class EmployeeDepartmentTables extends javax.swing.JFrame {

    DefaultTableModel tableModel,tableModel1;
    public EmployeeDepartmentTables() {
        initComponents();
      createColumEmployee();
        createColumDepartment();
        pupolateDepartment();
      pupolateEmployee();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leavesTable = new javax.swing.JTable();
        idEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leavesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        leavesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leavesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(leavesTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 470, 360));
        jPanel1.add(idEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 180, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EmployeeId");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DepartId");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 100, 40));
        jLabel1.getAccessibleContext().setAccessibleName("EmployeeId");

        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 180, 40));

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 110, 30));

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setText("Back");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 110, 30));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMPLOYEE DEPARTMENT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 350, 40));

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        EmployeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmployeeTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 240, 450, 360));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EMPLOYEE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DEPARTMENT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeTableMouseClicked
         String id=tableModel.getValueAt(EmployeeTable.getSelectedRow(), 0).toString();
        idEmp.setText(id);

    }//GEN-LAST:event_EmployeeTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
             if(idEmp.getText().isEmpty() && jTextField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Select both ID");
            }else{
            OkHttpClient.saveEmployeeDepartment(idEmp.getText(), jTextField1.getText());
            pupolateDepartment();
            pupolateEmployee();}
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDepartmentTables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void leavesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leavesTableMouseClicked
    String id=tableModel1.getValueAt(leavesTable.getSelectedRow(), 0).toString();
        jTextField1.setText(id);
    }//GEN-LAST:event_leavesTableMouseClicked
   public void pupolateEmployee(){
    
          List EmployeeList =OkHttpClient.getAllEmployeeRequest();
           List<Employee> Employe_List =  EmployeeList;
           try{ 
               
            EmployeeTable.setModel(tableModel);
            tableModel = (DefaultTableModel) EmployeeTable.getModel();
            tableModel.setRowCount(0);
            for (int i = 0; i < Employe_List .size(); i++) {
                
             Object[] objs = {
              
               Employe_List .get(i).getEmployeeId(),
               Employe_List .get(i).getFirstName(),
               Employe_List .get(i).getMiddleName(),
               Employe_List .get(i).getLastName()
             
                };
                tableModel.addRow(objs);
            }
           }  catch(Exception es){
           
           
           }
    }
    public void pupolateDepartment(){
    
        
          List DepartmentList =OkHttpClient.getAllDepartment();
           List<Department> Department_List =  DepartmentList;
           try{ 
               
            leavesTable.setModel(tableModel1);
            tableModel1 = (DefaultTableModel) leavesTable.getModel();
            tableModel1.setRowCount(0);
            for (int i = 0; i < Department_List .size(); i++) {
                
             Object[] objs = {
              
               Department_List .get(i).getDeptId(),
               Department_List .get(i).getDeptName(),
               Department_List .get(i).getDeptDesc()
             
                };
                tableModel1.addRow(objs);
            }
           }  catch(Exception es){
           
           
           }
    }
    public  void createColumEmployee(){
    
       tableModel=  (DefaultTableModel) EmployeeTable.getModel();
       tableModel.addColumn("Employee Id");
       tableModel.addColumn("First Name");
       tableModel.addColumn("Middle Name");
       tableModel.addColumn("Last Name");
     
    }
     public  void createColumDepartment(){
       
     
       tableModel1=  (DefaultTableModel) leavesTable.getModel();
        tableModel1.addColumn("Depart Id");
       tableModel1.addColumn("Name");
       tableModel1.addColumn("Descr");
    }
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
            java.util.logging.Logger.getLogger(EmployeeDepartmentTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDepartmentTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDepartmentTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDepartmentTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDepartmentTables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JTextField idEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable leavesTable;
    // End of variables declaration//GEN-END:variables
}
