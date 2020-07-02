/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HomelessShelterRoles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FoodDistributionOrganization;
import Business.Organization.HomelessShelterManagerOrganization;
import Business.Organization.HomelessShelterDonationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeliveryStatus;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import userinterface.NGORole.NGOFoodDistributionWorkAreaJPanel;
import userinterface.HomelessShelterRoles.HomelessShelterDonationsWorkAreaJPanel;

/**
 *
 * @author sumedhtelang
 */
public class HomelessShelterManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HomelessShelterManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private HomelessShelterManagerOrganization homelessShelterManagerOrganization;
    private HomelessShelterDonationOrganization homelessShelterDonationOrganization;
    private FoodDistributionOrganization foodDistributionOrganization;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Organization outorganization;
    private Network network;
    EcoSystem ecosystem;
    private TableRowSorter<DefaultTableModel> sorter;
    private ArrayList<WorkRequest> workRequestList;
    int quantity = 0;
    int requirement =0;
    
    public HomelessShelterManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization,
            EcoSystem ecosystem, Enterprise enterprise) {
        initComponents();
        this.ecosystem = ecosystem;
        this.userProcessContainer = userProcessContainer;
        homelessShelterManagerOrganization = (HomelessShelterManagerOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        DefaultTableModel model2 = (DefaultTableModel) workRequestJTable.getModel();

        quantity = populateSupervisorWorkTable1(model2);
       
        //jLabelTotalQuantity.setText(String.valueOf(quantity));
        this.organization = organization;
        //populateSearchByTypeComboBox();
        populateSearchByQuantityComboBox();
        workRequestList = organization.getWorkQueue().getWorkRequestList();
        DefaultTableModel model = (DefaultTableModel) jTableFoodRequest.getModel();
        valueLabel.setText(enterprise.getEnterpriseName());

         DefaultTableModel model3 = (DefaultTableModel) reqTable.getModel();
        requirement = populateRequirementsTable(model3); 
        populateRequestWorkTable(model);
    
        
    }
    
    private void populateSearchByTypeComboBox() {
     
        Set<String> hset = new HashSet<String>();
        for (Network network : ecosystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        
                        String ar = request.getFoodType().toLowerCase();
                        hset.add(ar);

            }
        }

        }
        }
      
        
    }
    
    public int populateSupervisorWorkTable1(DefaultTableModel model2) {
        int x = 0;
        model2.setRowCount(0);
        for (Network network : ecosystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                       if(request.getFoodQuantityInKg()==0){break;}
                        if(request.getReceiver()==null){
                                Object[] row = new Object[4];
                        row[0] = request;
                        row[1] = request.getFoodQuantityInKg();
                        row[2] = request.getCurrentStatus();
                        String result = ((DeliveryStatus) request).getStatus();
                        row[3] = request.getFoodType();
                        model2.addRow(row);
                    }
                    }
                }
            }
        }
        return x;
    }
    
     public int populateRequirementsTable(DefaultTableModel model3) {
        int x = 0;
        model3.setRowCount(0);
        for (Network network : ecosystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        if(request.getRequirement()==0){break;}
                        if(request.getReceiver()==null){
                        Object[] row = new Object[3];
                        row[0] = request;
                        row[1] = request.getRequirement();
                        row[2] = request.getCurrentStatus();

                        model3.addRow(row);
                    }
                    }
                }
            }
        }
        return x;
    }
    
    private void populateSearchByQuantityComboBox() {
        
        ArrayList<String> array = new ArrayList<>();
        for (Network network : ecosystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        
                    }
                }
            }
        }
    }
    
    public void populateRequestWorkTable(DefaultTableModel model) {

        model.setRowCount(0);
///        for (Network  network: ecosystem.getNetworkList()){
///        for (Enterprise enterprise :network.getEnterpriseDirectory().getEnterpriseList()){
///       for (SupervisorOrganization organization:(SupervisorOrganization) enterprise.getOrganizationDirectory().getOrganizationList())
        for (WorkRequest request : homelessShelterManagerOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[2];
            row[0] = request;
            row[1] = request.getRequirement();       
            model.addRow(row);
          return;      
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFoodRequest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestFoodJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        reqTable = new javax.swing.JTable();
        refreshRequirementsBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTableFoodRequest.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        jTableFoodRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Provider", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableFoodRequest);

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Homeless Shelter Manager Area");

        jLabel2.setText("Enterprise Name :");

        valueLabel.setText("<value>");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        workRequestJTable.setBackground(new java.awt.Color(255, 255, 153));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Provider", "Quantity", "Status", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        requestFoodJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-submit-document-32.png"))); // NOI18N
        requestFoodJButton.setText("Request Food");
        requestFoodJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestFoodJButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Request Food Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(requestFoodJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestFoodJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Food Request", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        reqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Donations Organization", "Requirement", "Status"
            }
        ));
        jScrollPane4.setViewportView(reqTable);

        refreshRequirementsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-approval-50.png"))); // NOI18N
        refreshRequirementsBtn.setText("Approve Request");
        refreshRequirementsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshRequirementsBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Review Requirements");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshRequirementsBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel3)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshRequirementsBtn))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Review Requirements", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(463, 463, 463))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(valueLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(valueLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(549, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestFoodJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestFoodJButtonActionPerformed
        // TODO add your handling code here:
        try{
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0) {
             JOptionPane.showMessageDialog(null, "Please select a row");

        } 
          WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            try {
                ((DefaultTableModel) workRequestJTable.getModel()).removeRow(selectedRow);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Can't Proceed");
            
            }
            workRequestJTable.setCellSelectionEnabled(false);
           
            
            //Sending request block
            request.setReceiver(userAccount);
            request.setDeliveryOption("pickup");
        //End of send block...
        
           
            request.setCurrentStatus("Pending");
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof HomelessShelterManagerOrganization) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            DefaultTableModel model = (DefaultTableModel) jTableFoodRequest.getModel();

            populateRequestWorkTable(model);
            JOptionPane.showMessageDialog(null, "Request Send");
            //jProgressBar1.setValue(0);
            
            request.setRecieverAddress(enterprise.getEnterpriseAddress());
            
        }
        catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Invalid Opration");

        }
    }//GEN-LAST:event_requestFoodJButtonActionPerformed

    private void refreshRequirementsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshRequirementsBtnActionPerformed
        // TODO add your handling code here:
                  int selectedRow = reqTable.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row");
            
        }
        WorkRequest request = (WorkRequest) reqTable.getValueAt(selectedRow,0);
        request.setCurrentStatus("Approved");
         DefaultTableModel model3 = (DefaultTableModel) reqTable.getModel();
    populateRequirementsTable(model3);
    }//GEN-LAST:event_refreshRequirementsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableFoodRequest;
    private javax.swing.JButton refreshRequirementsBtn;
    private javax.swing.JTable reqTable;
    private javax.swing.JButton requestFoodJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
