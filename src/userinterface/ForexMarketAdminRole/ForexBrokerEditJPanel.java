/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ForexMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ForexMarketEnterprise;
import Business.Network.Network;
import Business.Organization.BrokersOrganization;
import Business.Organization.Organization;
import Business.Role.ForexAgentRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronak
 */
public class ForexBrokerEditJPanel extends javax.swing.JPanel {
    
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;
    Integer selectedDelIndex;
    BrokersOrganization selectedBroker;
    ArrayList<BrokersOrganization> allBrokers = new ArrayList<>();
    ArrayList<UserAccount> forexAdminUser = new ArrayList<>();

    /**
     * Creates new form ForexBrokerEditJPanel
     */
    public ForexBrokerEditJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        initComponents();
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        
        Network ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoinNetwork = ongoing1;
            }
        }
        setForexAdminUsers();
        _getData();
        
        
    }
    
    public void _getData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof ForexMarketEnterprise) {
                for (int j = 0; j < ongoing.getOrganizationDirectory().getOrganizationList().size(); j++) {

                    selectedOrganization = ongoing.getOrganizationDirectory().getOrganizationList().get(j);
                    if (selectedOrganization instanceof BrokersOrganization) {
                        BrokersOrganization ongoing2 = (BrokersOrganization) selectedOrganization;
                        allBrokers.add(ongoing2);
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ongoing2.getBroker().entrySet()) {

                            Object[] row = {
                                ongoing2.getBrokerName(),
                                set.getKey(),
                                set.getValue().get("brokeremail"),
                                set.getValue().get("brokercontact"),
                                set.getValue().get("doc"),
                                ongoing2.getAdmin().getUsername().toString()
                            };
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void setForexAdminUsers() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing.getRole() instanceof ForexAgentRole) {
                this.forexAdminUser.add(ongoing);
                asset.add(ongoing.getUsername());
            }
        }
        String[] assetSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(assetSDropdown);
        this.adminComboBox.setModel(brandSDropdownModel);
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
        jTable1 = new javax.swing.JTable();
        deletejLabel = new javax.swing.JLabel();
        brokerNameJLabel = new javax.swing.JLabel();
        brokerNameJField = new javax.swing.JTextField();
        bankAdminJLabel1 = new javax.swing.JLabel();
        adminComboBox = new javax.swing.JComboBox<>();
        forexNameJLabel2 = new javax.swing.JLabel();
        forexNameJField = new javax.swing.JTextField();
        brokerContactJlabel1 = new javax.swing.JLabel();
        brokerContactJField = new javax.swing.JTextField();
        brokerEmailJLabel3 = new javax.swing.JLabel();
        brokerEmailJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Broker Name", "Forex Name", "Email", "Contact", "Date of creation", "Admin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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

        deletejLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/delete.png"))); // NOI18N
        deletejLabel.setText("Delete");
        deletejLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletejLabelMouseClicked(evt);
            }
        });

        brokerNameJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brokerNameJLabel.setForeground(new java.awt.Color(67, 100, 100));
        brokerNameJLabel.setText("Broker Name(*):");

        brokerNameJField.setBackground(new java.awt.Color(238, 238, 238));
        brokerNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brokerNameJField.setText("Enter here");
        brokerNameJField.setToolTipText("Click to enter your name.");
        brokerNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        brokerNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brokerNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brokerNameJFieldnameChangeHandler(evt);
            }
        });
        brokerNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerNameJFieldActionPerformed(evt);
            }
        });

        bankAdminJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        bankAdminJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        bankAdminJLabel1.setText("Admin (*):");

        adminComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                adminComboBoxItemStateChanged(evt);
            }
        });
        adminComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminComboBoxFocusGained(evt);
            }
        });
        adminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminComboBoxActionPerformed(evt);
            }
        });
        adminComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                adminComboBoxPropertyChange(evt);
            }
        });

        forexNameJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        forexNameJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        forexNameJLabel2.setText("Forex Name(*):");

        forexNameJField.setBackground(new java.awt.Color(238, 238, 238));
        forexNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        forexNameJField.setText("Enter here");
        forexNameJField.setToolTipText("Click to enter your name.");
        forexNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        forexNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                forexNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                forexNameJFieldnameChangeHandler(evt);
            }
        });
        forexNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forexNameJFieldActionPerformed(evt);
            }
        });

        brokerContactJlabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brokerContactJlabel1.setForeground(new java.awt.Color(67, 100, 100));
        brokerContactJlabel1.setText("Contact(*)");

        brokerContactJField.setBackground(new java.awt.Color(238, 238, 238));
        brokerContactJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brokerContactJField.setText("Enter here");
        brokerContactJField.setToolTipText("Click to enter your name.");
        brokerContactJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        brokerContactJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brokerContactJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brokerContactJFieldnameChangeHandler(evt);
            }
        });
        brokerContactJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerContactJFieldActionPerformed(evt);
            }
        });

        brokerEmailJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brokerEmailJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        brokerEmailJLabel3.setText("Email(*):");

        brokerEmailJField.setBackground(new java.awt.Color(238, 238, 238));
        brokerEmailJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brokerEmailJField.setText("Enter here");
        brokerEmailJField.setToolTipText("Click to enter your name.");
        brokerEmailJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        brokerEmailJField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                brokerEmailJFieldHierarchyChanged(evt);
            }
        });
        brokerEmailJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brokerEmailJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brokerEmailJFieldnameChangeHandler(evt);
            }
        });
        brokerEmailJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerEmailJFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(200, 203, 178));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(67, 100, 100));
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brokerNameJLabel)
                    .addComponent(bankAdminJLabel1)
                    .addComponent(forexNameJLabel2)
                    .addComponent(brokerContactJlabel1)
                    .addComponent(brokerEmailJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(brokerEmailJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerContactJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(forexNameJField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(brokerNameJField))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokerNameJLabel)
                    .addComponent(brokerNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankAdminJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forexNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forexNameJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokerContactJlabel1)
                    .addComponent(brokerContactJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokerEmailJLabel3)
                    .addComponent(brokerEmailJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedBroker = this.allBrokers.get(selectedIndex);
            this.brokerNameJField.setText(selectedBroker.getBrokerName());
            for (HashMap.Entry<String, HashMap<String, Object>> set
                : selectedBroker.getBroker().entrySet()) {

                this.adminComboBox.setSelectedItem(selectedBroker.getAdmin().getUsername().toString());
                forexNameJField.setText(set.getKey());
                brokerContactJField.setText(set.getValue().get("brokercontact").toString());
                brokerEmailJField.setText(set.getValue().get("brokeremail").toString());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletejLabelMouseClicked
        if (selectedBroker != null) {
            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof ForexMarketEnterprise) {
                    ongoing.getOrganizationDirectory().getOrganizationList().remove(selectedOrganization);
                }
            }
            _getData();
            JOptionPane.showMessageDialog(this, "Broker deleted successfully!", "Broker", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Broker to delete !", "Broker", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletejLabelMouseClicked

    private void brokerNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerNameJFieldFocusGained
        if (brokerNameJField.getText().equals("Enter here")) {
            brokerNameJField.setText("");
        }
    }//GEN-LAST:event_brokerNameJFieldFocusGained

    private void brokerNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerNameJFieldnameChangeHandler

    private void brokerNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerNameJFieldActionPerformed

    private void adminComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxItemStateChanged

    public void _adminChnageHandler() {
        selectedDelIndex = this.adminComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.forexAdminUser.get(selectedDelIndex);
        }
    }
    private void adminComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxFocusGained

    private void adminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxActionPerformed

    private void adminComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adminComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxPropertyChange

    private void forexNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forexNameJFieldFocusGained
        if (this.forexNameJField.getText().equals("Enter here")) {
            forexNameJField.setText("");
        }
    }//GEN-LAST:event_forexNameJFieldFocusGained

    private void forexNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forexNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_forexNameJFieldnameChangeHandler

    private void forexNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forexNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forexNameJFieldActionPerformed

    private void brokerContactJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerContactJFieldFocusGained
        if (brokerContactJField.getText().equals("Enter here")) {
            brokerContactJField.setText("");
        }
    }//GEN-LAST:event_brokerContactJFieldFocusGained

    private void brokerContactJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerContactJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerContactJFieldnameChangeHandler

    private void brokerContactJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerContactJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerContactJFieldActionPerformed

    private void brokerEmailJFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_brokerEmailJFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerEmailJFieldHierarchyChanged

    private void brokerEmailJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerEmailJFieldFocusGained
        if (this.brokerEmailJField.getText().equals("Enter here")) {
            brokerEmailJField.setText("");
        }
    }//GEN-LAST:event_brokerEmailJFieldFocusGained

    private void brokerEmailJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerEmailJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerEmailJFieldnameChangeHandler

    private void brokerEmailJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerEmailJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerEmailJFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedOrganization != null) {
            Boolean valid = validateItem();
            if (valid) {
                HashMap<String, HashMap<String, Object>> broker = new HashMap<>();
                HashMap<String, Object> brokerName = new HashMap<>();
                brokerName.put("brokeremail", this.brokerEmailJField.getText().toString());
                brokerName.put("brokercontact", this.brokerContactJField.getText().toString());
                brokerName.put("doc", new Date());
                broker.put(this.forexNameJField.getText(), brokerName);
                selectedBroker.setAdmin(this.selectedUser);
                selectedBroker.setBroker(broker);
                selectedBroker.setBrokerName(this.brokerNameJField.getText());
                _getData();
                JOptionPane.showMessageDialog(this, "Broker udpated successfully!", "Broker", INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select Broker to update !", "Broker", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.adminComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.brokerNameJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Broker Name! \n";
        }
        if (!this.forexNameJField.getText().matches("[a-zA-Z]+")) {
            errorMEssage += "Invalid Forex Name! \n";
        }
        if (!this.brokerContactJField.getText().matches("[0-9]+")) {
            errorMEssage += "Broker contact should be a number! \n";
        }
        if (!this.brokerEmailJField.getText().matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")) {
            errorMEssage += "Forex email should be a number! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, errorMEssage, "Broker Edit", ERROR_MESSAGE);
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> adminComboBox;
    private javax.swing.JLabel bankAdminJLabel1;
    private javax.swing.JTextField brokerContactJField;
    private javax.swing.JLabel brokerContactJlabel1;
    private javax.swing.JTextField brokerEmailJField;
    private javax.swing.JLabel brokerEmailJLabel3;
    private javax.swing.JTextField brokerNameJField;
    private javax.swing.JLabel brokerNameJLabel;
    private javax.swing.JLabel deletejLabel;
    private javax.swing.JTextField forexNameJField;
    private javax.swing.JLabel forexNameJLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
