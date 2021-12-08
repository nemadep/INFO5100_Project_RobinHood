/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CompanyAgentRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.Organization.CompaniesOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.StockMarketAdminRole.companyEditPanel;

/**
 *
 * @author prathameshnemade
 */
public class CompanyAgentJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JPanel browsingJPanel;
    CompaniesOrganization company;
    
    public CompanyAgentJPanel(JPanel rootJPanel, UserAccount account, EcoSystem system, JPanel browsingJPanel) {
        this.ecosystem = system;
        this.account = account;
        this.browsingJPanel = browsingJPanel;
        
        initComponents();
        
        this.company = getOrganization();
        
        CompanyAgentHome home = new CompanyAgentHome(ecosystem, account, company);
        jSplitPane.setRightComponent(home);
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
        jLabel2 = new javax.swing.JLabel();
        userNameJLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        AccountCreationJButton = new javax.swing.JButton();
        AccountCreationJButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane.setDividerLocation(-350);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Noto Sans Oriya", 0, 36)); // NOI18N
        jLabel2.setText("Hello,");

        userNameJLabel.setFont(new java.awt.Font("Noto Sans Oriya", 1, 36)); // NOI18N
        userNameJLabel.setText("Company Agent!");

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

        AccountCreationJButton.setBackground(new java.awt.Color(200, 203, 178));
        AccountCreationJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        AccountCreationJButton.setForeground(new java.awt.Color(67, 100, 100));
        AccountCreationJButton.setText("Manage Company Stock");
        AccountCreationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountCreationJButtonActionPerformed(evt);
            }
        });

        AccountCreationJButton1.setBackground(new java.awt.Color(200, 203, 178));
        AccountCreationJButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        AccountCreationJButton1.setForeground(new java.awt.Color(67, 100, 100));
        AccountCreationJButton1.setText("Allocate Stock");
        AccountCreationJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountCreationJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AccountCreationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(userNameJLabel))
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(AccountCreationJButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameJLabel)
                .addGap(18, 18, 18)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountCreationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountCreationJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSplitPane)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        CompanyAgentHome home = new CompanyAgentHome(ecosystem, account, company);
        jSplitPane.setRightComponent(home);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void AccountCreationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountCreationJButtonActionPerformed
        CompanyAgentEdit createAdmin = new CompanyAgentEdit(ecosystem, account, company);
        this.jSplitPane.setRightComponent(createAdmin);
    }//GEN-LAST:event_AccountCreationJButtonActionPerformed

    private void AccountCreationJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountCreationJButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountCreationJButton1ActionPerformed

    public CompaniesOrganization getOrganization(){
        Network ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }
        
        OrganizationDirectory orgs = null;
        
        for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ep = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ep instanceof StockMarketEnterprise) {
                orgs = ep.getOrganizationDirectory();
                break;
            }
        }
        
        for(Organization o: orgs.getOrganizationList()){
            if(o.getType().equals(Organization.Type.Companies.getValue())){
                CompaniesOrganization temp = (CompaniesOrganization) o;
                if(temp.getAdmin().getUsername().equals(account.getUsername())){
                    return temp;
                }
            }
        }
        
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccountCreationJButton;
    private javax.swing.JButton AccountCreationJButton1;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JLabel userNameJLabel;
    // End of variables declaration//GEN-END:variables
}
