/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ForexMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.CryptoMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ForexMarketEnterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author ronak
 */
public class ForexMarketAdminJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount account;
    JPanel browsingJPanel;
    ArrayList<Network> allNetworks = new ArrayList<>();
    Network selectedNetwork;
    ArrayList<Enterprise> enterpriseSelection = new ArrayList<>();

    public ForexMarketAdminJPanel(JPanel rootJPanel, UserAccount account, EcoSystem system, JPanel browsingJPanel) {
        initComponents();
        this.userProcessContainer = rootJPanel;
        this.ecosystem = system;
        this.account = account;
        this.browsingJPanel = browsingJPanel;
        initComponents();
        this.userNameJLabel.setText(account.getUsername());

        getNetwork();
        getLeftButtonStatus();
    }

    public void getNetwork() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            asset.add(ongoing1.getNName());
            this.allNetworks.add(ongoing1);
            enterpriseSelection = ongoing1.getEnterpriseDirectory().getEnterpriseDir();
        }
        String[] netwrokSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(netwrokSDropdown);
        this.networkComboBox.setModel(brandSDropdownModel);

//        this.assetJButton.setVisible(selectedNetwork.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") == null ? false : true);
//        this.forexJButton.setVisible(selectedNetwork.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket") == null ? false : true);
//        this.cryptoJButton.setVisible(selectedNetwork.getEnterpriseDirectory().getEnterpriseSelection().get("CryptoMarket") == null ? false : true);
//        this.stockJButton.setVisible(selectedNetwork.getEnterpriseDirectory().getEnterpriseSelection().get("StockMarket") == null ? false : true);
    }

    public void getLeftButtonStatus() {
        Boolean isAssetFound = false;
        Boolean isForexFound = false;
        Boolean isStockFound = false;
        Boolean isCryptoFound = false;
        for (int i = 0; i < this.enterpriseSelection.size(); i++) {
            if (enterpriseSelection.get(i) instanceof AssetMarketEnterprise && ((AssetMarketEnterprise) enterpriseSelection.get(i)).admin == this.account) {
                isAssetFound = true;
            } else if (enterpriseSelection.get(i) instanceof CryptoMarketEnterprise && ((CryptoMarketEnterprise) enterpriseSelection.get(i)).admin == this.account) {
                isCryptoFound = true;
            } else if (enterpriseSelection.get(i) instanceof ForexMarketEnterprise && ((ForexMarketEnterprise) enterpriseSelection.get(i)).admin == this.account) {
                isForexFound = true;
            } else if (enterpriseSelection.get(i) instanceof StockMarketEnterprise && ((StockMarketEnterprise) enterpriseSelection.get(i)).admin == this.account) {
                isStockFound = true;
            }
        }
        if (isForexFound) {
            this.forexJButton.setVisible(true);
        } else {
            this.forexJButton.setVisible(!true);
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
        jSplitPane = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        forexJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userNameJLabel = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox<>();
        brandJLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 581));

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

        forexJButton.setBackground(new java.awt.Color(200, 203, 178));
        forexJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        forexJButton.setForeground(new java.awt.Color(67, 100, 100));
        forexJButton.setText("Forex Market");
        forexJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forexJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans Oriya", 0, 36)); // NOI18N
        jLabel2.setText("Hello,");

        userNameJLabel.setFont(new java.awt.Font("Noto Sans Oriya", 1, 36)); // NOI18N
        userNameJLabel.setText("System Admin!");

        networkComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                networkComboBoxItemStateChanged(evt);
            }
        });
        networkComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                networkComboBoxFocusGained(evt);
            }
        });
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });
        networkComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                networkComboBoxPropertyChange(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Select Network (*):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forexJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(brandJLabel1)
                            .addComponent(userNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameJLabel)
                .addGap(18, 18, 18)
                .addComponent(brandJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forexJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel3)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel3);

        jPanel1.add(jSplitPane, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        ForexMarketDashboardJPanel forexMarketDashboardJPanel = new ForexMarketDashboardJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(forexMarketDashboardJPanel);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void forexJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forexJButtonActionPerformed
        ForexMarketViewJPanel forexAgentBankJPanel = new ForexMarketViewJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(forexAgentBankJPanel);
    }//GEN-LAST:event_forexJButtonActionPerformed

    private void networkComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_networkComboBoxItemStateChanged

    private void networkComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_networkComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_networkComboBoxFocusGained

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkComboBoxActionPerformed

    private void networkComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_networkComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_networkComboBoxPropertyChange

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.networkComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedNetwork = this.allNetworks.get(selectedDelIndex);
            for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
                Network ongoing = this.ecosystem.getNetwork().getNetworkList().get(i);
                if (ongoing == this.selectedNetwork) {
                    ongoing.setIsSelected(true);
                } else {
                    ongoing.setIsSelected(!true);
                }
            }
            enterpriseSelection = selectedNetwork.getEnterpriseDirectory().getEnterpriseDir();
            getLeftButtonStatus();
            ForexMarketDashboardJPanel forexMarketDashboardJPanel = new ForexMarketDashboardJPanel(ecosystem, account, jSplitPane, browsingJPanel);
            this.jSplitPane.setRightComponent(forexMarketDashboardJPanel);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JButton forexJButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JComboBox<String> networkComboBox;
    private javax.swing.JLabel userNameJLabel;
    // End of variables declaration//GEN-END:variables
}
