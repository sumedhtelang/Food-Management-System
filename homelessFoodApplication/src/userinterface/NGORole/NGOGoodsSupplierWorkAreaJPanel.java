/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NGORole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FoodDistributionOrganization;
import Business.Organization.GoodsSupplierOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SupervisorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sumedhtelang
 */
public class NGOGoodsSupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NGOGoodsSupplierWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private GoodsSupplierOrganization goodsSupplierOrganization;
    private Organization organization;
    private Enterprise enterprise;

    public NGOGoodsSupplierWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = account;
        this.goodsSupplierOrganization = (GoodsSupplierOrganization) organization;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblProcess.getModel();
        model.setRowCount(0);
        for(WorkRequest request : goodsSupplierOrganization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getRequestDate();
            if(request.getCurrentStatus().isEmpty()){
                System.out.println("Null");
            }
            else{
                row[1] = request.getMessage();
                row[2] = request.getReceiver()== null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getCurrentStatus();
                //row[4] = request.getMessage();
                model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcess = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        tblProcess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer Name", "Delivery", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProcess);
        if (tblProcess.getColumnModel().getColumnCount() > 0) {
            tblProcess.getColumnModel().getColumn(0).setResizable(false);
            tblProcess.getColumnModel().getColumn(1).setResizable(false);
            tblProcess.getColumnModel().getColumn(2).setResizable(false);
            tblProcess.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("NGO Goods Supplier");

        jButton1.setText("Approve And Proceed to Delivery");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        refreshBtn.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(706, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(refreshBtn))
                .addContainerGap(358, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            int selectedRow = tblProcess.getSelectedRow();
            if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row to process");
        }
            
            WorkRequest request = (WorkRequest)tblProcess.getValueAt(selectedRow, 0);
            ProcessRequestJPanel processJPanel=new ProcessRequestJPanel(userProcessContainer, request, organization, enterprise);
            userProcessContainer.add("processJPanel",processJPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        catch(Exception e){
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTable tblProcess;
    // End of variables declaration//GEN-END:variables

//    private void populateTable() {
//        
//        //SupervisorWorkRequest supervisorWorkRequest2 =    (SupervisorWorkRequest) ((GoodsSupplierOrganization)organization).getWorkQueue().getWorkRequestList().get(0);
//        //System.out.println("DATA"+supervisorWorkRequest2.getCustomerName());
//         DefaultTableModel model = (DefaultTableModel) tblProcess.getModel();
//        
//        model.setRowCount(0);
//        
//        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
//            if(userAccount.getUsername().equalsIgnoreCase(request.getProvider().getUsername())){
//                       if(request.getReceiver()!=null){
//        //SupervisorWorkRequest supervisorWorkRequest2 =    (SupervisorWorkRequest) ((GoodsSupplierOrganization)organization).getWorkQueue().getWorkRequestList().get(1);
//
//            Object[] row = new Object[4];
//            //row[0] = supervisorWorkRequest2.getApprovalStatus();
//            //row[1] = supervisorWorkRequest2.getCustomerName();
//            row[2]= request.getFoodQuantityInKg();
//            row[3]= request.getPublishDate();
//            row[0] = "Sumedh";
//            row[1] = "Sumedh";
//
//            model.addRow(row);
//            }
//                       
//        }
//        }
//        
//    }

}