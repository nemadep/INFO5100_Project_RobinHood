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
import Business.Organization.BanksOrganization;
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
public class ForexBankEditJPanel extends javax.swing.JPanel {
    
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;
    Integer selectedDelIndex;
    BanksOrganization selectedBank;
    ArrayList<BanksOrganization> allBank = new ArrayList<>();
    ArrayList<UserAccount> forexAdminUser = new ArrayList<>();

    /**
     * Creates new form ForexBankEditJPanel
     */
    public ForexBankEditJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
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
        
        _getData();
        setForexAdminUsers();
        
    }
    
    public void _getData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof ForexMarketEnterprise) {
                for (int j = 0; j < ongoing.getOrganizationDirectory().getOrganizationList().size(); j++) {

                    selectedOrganization = ongoing.getOrganizationDirectory().getOrganizationList().get(j);
                    if (selectedOrganization instanceof BanksOrganization) {
                        BanksOrganization ongoing2 = (BanksOrganization) selectedOrganization;
                        allBank.add(ongoing2);
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ongoing2.getBank().entrySet()) {

                            Object[] row = {
                                ongoing2.getBankName(),
                                set.getKey(),
                                set.getValue().get("maxPrice"),
                                set.getValue().get("quantity"),
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
        bankNameJLabel = new javax.swing.JLabel();
        bankNameJField = new javax.swing.JTextField();
        bankAdminJLabel1 = new javax.swing.JLabel();
        adminComboBox = new javax.swing.JComboBox<>();
        forexNameJLabel2 = new javax.swing.JLabel();
        forexNameJField = new javax.swing.JTextField();
        bankContactJlabel1 = new javax.swing.JLabel();
        maxUnitJField = new javax.swing.JTextField();
        bankEmailJLabel3 = new javax.swing.JLabel();
        priceJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Bank Name", "Forex Name", "Price", "Units", "Date of creation", "Admin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        bankNameJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        bankNameJLabel.setForeground(new java.awt.Color(67, 100, 100));
        bankNameJLabel.setText("Bank Name(*):");

        bankNameJField.setBackground(new java.awt.Color(238, 238, 238));
        bankNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bankNameJField.setText("Enter here");
        bankNameJField.setToolTipText("Click to enter your name.");
        bankNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        bankNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bankNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bankNameJFieldnameChangeHandler(evt);
            }
        });
        bankNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankNameJFieldActionPerformed(evt);
            }
        });

        bankAdminJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        bankAdminJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        bankAdminJLabel1.setText("Admin (*):");

        adminComboBox.setEnabled(false);
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

        bankContactJlabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        bankContactJlabel1.setForeground(new java.awt.Color(67, 100, 100));
        bankContactJlabel1.setText("Max Unit(*)");

        maxUnitJField.setBackground(new java.awt.Color(238, 238, 238));
        maxUnitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        maxUnitJField.setText("Enter here");
        maxUnitJField.setToolTipText("Click to enter your name.");
        maxUnitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        maxUnitJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maxUnitJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                maxUnitJFieldnameChangeHandler(evt);
            }
        });
        maxUnitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxUnitJFieldActionPerformed(evt);
            }
        });

        bankEmailJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        bankEmailJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        bankEmailJLabel3.setText("Price(*):");

        priceJField.setBackground(new java.awt.Color(238, 238, 238));
        priceJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        priceJField.setText("Enter here");
        priceJField.setToolTipText("Click to enter your name.");
        priceJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        priceJField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                priceJFieldHierarchyChanged(evt);
            }
        });
        priceJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                priceJFieldnameChangeHandler(evt);
            }
        });
        priceJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceJFieldActionPerformed(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bankNameJLabel)
                    .addComponent(bankAdminJLabel1)
                    .addComponent(forexNameJLabel2)
                    .addComponent(bankContactJlabel1)
                    .addComponent(bankEmailJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(forexNameJField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(bankNameJField))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankNameJLabel)
                    .addComponent(bankNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(bankContactJlabel1)
                    .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankEmailJLabel3)
                    .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedBank = this.allBank.get(selectedIndex);
            this.bankNameJField.setText(selectedBank.getBankName());
            for (HashMap.Entry<String, HashMap<String, Object>> set
                : selectedBank.getBank().entrySet()) {

                this.adminComboBox.setSelectedItem(selectedBank.getAdmin().getUsername().toString());
                forexNameJField.setText(set.getKey());
                maxUnitJField.setText(set.getValue().get("quantity").toString());
                priceJField.setText(set.getValue().get("maxPrice").toString());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletejLabelMouseClicked
        if (selectedBank != null) {
            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof ForexMarketEnterprise) {
                    ongoing.getOrganizationDirectory().getOrganizationList().remove(selectedOrganization);
                }
            }
            _getData();
            JOptionPane.showMessageDialog(this, "Bank deleted successfully!", "Bank", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Bank to delete !", "Bank", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletejLabelMouseClicked

    private void bankNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bankNameJFieldFocusGained
        if (bankNameJField.getText().equals("Enter here")) {
            bankNameJField.setText("");
        }
    }//GEN-LAST:event_bankNameJFieldFocusGained

    private void bankNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bankNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_bankNameJFieldnameChangeHandler

    private void bankNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankNameJFieldActionPerformed

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

    private void maxUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldFocusGained
        if (maxUnitJField.getText().equals("Enter here")) {
            maxUnitJField.setText("");
        }
    }//GEN-LAST:event_maxUnitJFieldFocusGained

    private void maxUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldnameChangeHandler

    private void maxUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldActionPerformed

    private void priceJFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_priceJFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldHierarchyChanged

    private void priceJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldFocusGained
        if (this.priceJField.getText().equals("Enter here")) {
            priceJField.setText("");
        }
    }//GEN-LAST:event_priceJFieldFocusGained

    private void priceJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldnameChangeHandler

    private void priceJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedOrganization != null) {
            Boolean valid = validateItem();
            if (valid) {
                HashMap<String, HashMap<String, Object>> bank = new HashMap<>();
                HashMap<String, Object> bankName = new HashMap<>();
                bankName.put("maxPrice", this.priceJField.getText().toString());
                bankName.put("quantity", this.maxUnitJField.getText().toString());
                bankName.put("doc", new Date());
                bank.put(this.forexNameJField.getText(), bankName);
                selectedBank.setAdmin(this.selectedUser);
                selectedBank.setBank(bank);
                selectedBank.setBankName(this.bankNameJField.getText());
                _getData();
                JOptionPane.showMessageDialog(this, "Bank udpated successfully!", "Bank", INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select Bank to update !", "Bank", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

     public Boolean validateItem() {
        String errorMEssage = "";
        if (this.adminComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.bankNameJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Bank Name! \n";
        }
        if (!this.forexNameJField.getText().matches("[a-zA-Z]+")) {
            errorMEssage += "Invalid Forex Name! \n";
        }
        if (!this.maxUnitJField.getText().matches("[0-9]+")) {
            errorMEssage += "Max unit should be a number! \n";
        }
        if (!this.priceJField.getText().matches("[0-9]+")) {
            errorMEssage += "Price should be a number! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, errorMEssage, "Bank Edit", ERROR_MESSAGE);
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> adminComboBox;
    private javax.swing.JLabel bankAdminJLabel1;
    private javax.swing.JLabel bankContactJlabel1;
    private javax.swing.JLabel bankEmailJLabel3;
    private javax.swing.JTextField bankNameJField;
    private javax.swing.JLabel bankNameJLabel;
    private javax.swing.JLabel deletejLabel;
    private javax.swing.JTextField forexNameJField;
    private javax.swing.JLabel forexNameJLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField maxUnitJField;
    private javax.swing.JTextField priceJField;
    // End of variables declaration//GEN-END:variables
}
