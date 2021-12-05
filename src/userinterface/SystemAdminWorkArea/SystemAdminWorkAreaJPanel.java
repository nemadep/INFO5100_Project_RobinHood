/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

import javax.swing.JPanel;
import userinterface.Enterprise.EnterpriseCreateJPanel;
import userinterface.Network.NetworkCreateJPanel;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount account;
    JPanel browsingJPanel;

    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem, JPanel browsingJPanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.account = account;
        this.browsingJPanel = browsingJPanel;
        userNameJLabel.setText(account.getUsername());

        SystemAdminDashboard updateProfileAdmin = new SystemAdminDashboard(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(updateProfileAdmin);

        Boolean temp1 = false;
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network temp = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (temp.getIsSelected()) {
                temp1 = true;
            }
        }
        if (temp1) {
            this.browsingJPanel.setVisible(true);
            this.ecosystem.generateBrowsingHistoryEnterprise(browsingJPanel);
        }
        //TODO- for enterprose and organization
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        networkButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userNameJLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        oraganizationButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        networkButton.setBackground(new java.awt.Color(200, 203, 178));
        networkButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        networkButton.setForeground(new java.awt.Color(67, 100, 100));
        networkButton.setText("Network");
        networkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans Oriya", 0, 36)); // NOI18N
        jLabel2.setText("Hello,");

        userNameJLabel.setFont(new java.awt.Font("Noto Sans Oriya", 1, 36)); // NOI18N
        userNameJLabel.setText("System Admin!");

        homeButton.setBackground(new java.awt.Color(200, 203, 178));
        homeButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(67, 100, 100));
        homeButton.setText("Home");
        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        oraganizationButton1.setBackground(new java.awt.Color(200, 203, 178));
        oraganizationButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        oraganizationButton1.setForeground(new java.awt.Color(67, 100, 100));
        oraganizationButton1.setText("Enterprise");
        oraganizationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oraganizationButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameJLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(networkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oraganizationButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameJLabel))
                .addGap(78, 78, 78)
                .addComponent(networkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(oraganizationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(483, Short.MAX_VALUE)))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jLabel3.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel3)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel3);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void networkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkButtonActionPerformed
        NetworkCreateJPanel networkCreateJPanel = new NetworkCreateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(networkCreateJPanel);
    }//GEN-LAST:event_networkButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        SystemAdminDashboard createAdmin = new SystemAdminDashboard(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(createAdmin);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void oraganizationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oraganizationButton1ActionPerformed
        Boolean temp1 = false;
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network temp = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (temp.getIsSelected()) {
                temp1 = true;
            }
        }
        if (temp1) {
            this.browsingJPanel.setVisible(true);
            this.ecosystem.generateBrowsingHistoryEnterprise(browsingJPanel);
            EnterpriseCreateJPanel enterpriseCreateJPanel = new EnterpriseCreateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
            this.jSplitPane.setRightComponent(enterpriseCreateJPanel);
        } else {
            JOptionPane.showMessageDialog(this, "Please select/create a network first!", "Setup", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_oraganizationButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JButton networkButton;
    private javax.swing.JButton oraganizationButton1;
    private javax.swing.JLabel userNameJLabel;
    // End of variables declaration//GEN-END:variables
}
