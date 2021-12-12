/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CryptoAgentRole;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CryptoBuyWorkRequest;
import Business.WorkQueue.CryptoSellWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author urvang
 */
public class CryptoAllocationRequest extends javax.swing.JPanel {

    /**
     * Creates new form CryptoAllocationRequest
     */
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    Organization selectedOrganization;
    WorkRequest selectedRequest;
    ArrayList<WorkRequest> allRequests = new ArrayList<>();

    public CryptoAllocationRequest(EcoSystem ecosystem, UserAccount account) {
        this.ecosystem = ecosystem;
        this.account = account;
        initComponents();

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoinNetwork = ongoing1;
            }
        }
        getStatus();

    }

    public void getStatus() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof CryptoBuyWorkRequest) {
                CryptoBuyWorkRequest temp = (CryptoBuyWorkRequest) ongoing;
                if (temp.getRaisedTo() == this.account && temp.getStatusType() == CryptoBuyWorkRequest.StatusType.Initiated) {
                    allRequests.add(temp);
                    Object[] row = {
                        "BUY",
                        temp.getCompanyName(),
                        temp.getOraganization(),
                        temp.getQuantity(),
                        temp.getPrice(),
                        temp.getModifiedAt(),
                        temp.getStatusType()
                    };
                    model.addRow(row);
                }
            } else if (ongoing instanceof CryptoSellWorkRequest) {
                CryptoSellWorkRequest temp = (CryptoSellWorkRequest) ongoing;
                if (temp.getRaisedTo() == this.account && temp.getStatusType() == CryptoSellWorkRequest.StatusType.Initiated) {
                    allRequests.add(temp);
                    Object[] row = {
                        "SELL",
                        temp.getCompanyName(),
                        temp.getOraganization(),
                        temp.getQuantity(),
                        temp.getPrice(),
                        temp.getModifiedAt(),
                        temp.getStatusType()
                    };
                    model.addRow(row);
                }
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

        jPanel1 = new javax.swing.JPanel();
        brandJLabel1 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Change Status to :");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approve", "Deny" }));
        statusComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusComboBoxItemStateChanged(evt);
            }
        });
        statusComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                statusComboBoxFocusGained(evt);
            }
        });
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });
        statusComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statusComboBoxPropertyChange(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(200, 203, 178));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(67, 100, 100));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "BUY/SELL", "Company Name", "Product Name", "Quantity", "Price", "Date of creation", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(brandJLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 321, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(brandJLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statusComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusComboBoxItemStateChanged
        //todo
    }//GEN-LAST:event_statusComboBoxItemStateChanged

    private void statusComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_statusComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxFocusGained

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void statusComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusComboBoxPropertyChange
        //tpdp
    }//GEN-LAST:event_statusComboBoxPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (selectedRequest != null) {
            String statusSelected = this.statusComboBox.getSelectedItem().toString();

            if (this.selectedRequest instanceof CryptoBuyWorkRequest) {
                CryptoBuyWorkRequest request = (CryptoBuyWorkRequest) this.selectedRequest;
                request.setStatusType(statusSelected == "Approve" ? CryptoBuyWorkRequest.StatusType.Completed : CryptoBuyWorkRequest.StatusType.Rejected);
            } else {
                CryptoSellWorkRequest request = (CryptoSellWorkRequest) this.selectedRequest;
                request.setStatusType(statusSelected == "Approve" ? CryptoSellWorkRequest.StatusType.Sold : CryptoSellWorkRequest.StatusType.SellRejected);
                for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
                    WorkRequest ongoing = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
                    if (ongoing instanceof CryptoBuyWorkRequest) {
                        CryptoBuyWorkRequest temp1 = (CryptoBuyWorkRequest) ongoing;
                        if (temp1.getRaisedTo() == this.account && temp1.getRaisedBy() == request.getRaisedBy() && temp1.getOraganization() == request.getOraganization() && temp1.getAssetName().equals(request.getAssetName()) && temp1.getStatusType() == CryptoBuyWorkRequest.StatusType.Awaiting) {
                            temp1.setStatusType(statusSelected == "Approve" ? CryptoBuyWorkRequest.StatusType.Sold : CryptoBuyWorkRequest.StatusType.Completed);
                        }
                    }
                }
            }
        }
        getStatus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedRequest = this.allRequests.get(selectedIndex);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> statusComboBox;
    // End of variables declaration//GEN-END:variables
}
