/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.IndustriesOrganization;
import Business.Organization.Organization;
import Business.Role.AssetAgentRole;
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
 * @author prathameshnemade
 */
public class AssetIndustriesEditJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;
    Integer selectedDelIndex;
    IndustriesOrganization selectedRealEstate;
    ArrayList<IndustriesOrganization> allEstates = new ArrayList<>();
    ArrayList<UserAccount> assetsAdminUser = new ArrayList<>();

    public AssetIndustriesEditJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        initComponents();

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoinNetwork = ongoing1;
            }
        }
        setAssetAdminUsers();

        _getData();
    }

    public void _getData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof AssetMarketEnterprise) {
                for (int j = 0; j < ongoing.getOrganizationDirectory().getOrganizationList().size(); j++) {

                    selectedOrganization = ongoing.getOrganizationDirectory().getOrganizationList().get(j);
                    if (selectedOrganization instanceof IndustriesOrganization) {
                        IndustriesOrganization ongoing2 = (IndustriesOrganization) selectedOrganization;
                        allEstates.add(ongoing2);
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ongoing2.getIndustries().entrySet()) {

                            Object[] row = {
                                ongoing2.getCompanyName(),
                                set.getKey(),
                                set.getValue().get("maxPrice"),
                                set.getValue().get("quantity"),
                                set.getValue().get("doc"),
                                ongoing2.getAdmin().getUsername().toString(),
                                set.getValue().get("location"),};
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void setAssetAdminUsers() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing.getRole() instanceof AssetAgentRole) {
                this.assetsAdminUser.add(ongoing);
                asset.add(ongoing.getUsername());
            }
        }
        String[] assetSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(assetSDropdown);
        this.industryComboBox.setModel(brandSDropdownModel);
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
        jTable1 = new javax.swing.JTable();
        deletejLabel = new javax.swing.JLabel();
        serialNoJLabel = new javax.swing.JLabel();
        industryNameJField = new javax.swing.JTextField();
        brandJLabel1 = new javax.swing.JLabel();
        industryComboBox = new javax.swing.JComboBox<>();
        serialNoJLabel2 = new javax.swing.JLabel();
        nameJField = new javax.swing.JTextField();
        serialNoJLabel1 = new javax.swing.JLabel();
        industryUnitJField = new javax.swing.JTextField();
        serialNoJLabel3 = new javax.swing.JLabel();
        industryJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        serialNoJLabel4 = new javax.swing.JLabel();
        industryLocationJField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Company Name", "Industry Name", "Price", "Units", "Date of creation", "Admin", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        serialNoJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel.setText("Company Name(*):");

        industryNameJField.setBackground(new java.awt.Color(238, 238, 238));
        industryNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        industryNameJField.setText("Enter here");
        industryNameJField.setToolTipText("Click to enter your name.");
        industryNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        industryNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                industryNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                industryNameJFieldnameChangeHandler(evt);
            }
        });
        industryNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryNameJFieldActionPerformed(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

        industryComboBox.setEnabled(false);
        industryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                industryComboBoxItemStateChanged(evt);
            }
        });
        industryComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                industryComboBoxFocusGained(evt);
            }
        });
        industryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryComboBoxActionPerformed(evt);
            }
        });
        industryComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                industryComboBoxPropertyChange(evt);
            }
        });

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText(" Name(*):");

        nameJField.setBackground(new java.awt.Color(238, 238, 238));
        nameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameJField.setText("Enter here");
        nameJField.setToolTipText("Click to enter your name.");
        nameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        nameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameJFieldnameChangeHandler(evt);
            }
        });
        nameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Max Unit(*):");

        industryUnitJField.setBackground(new java.awt.Color(238, 238, 238));
        industryUnitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        industryUnitJField.setText("Enter here");
        industryUnitJField.setToolTipText("Click to enter your name.");
        industryUnitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        industryUnitJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                industryUnitJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                industryUnitJFieldnameChangeHandler(evt);
            }
        });
        industryUnitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryUnitJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel3.setText("Price(*):");

        industryJField.setBackground(new java.awt.Color(238, 238, 238));
        industryJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        industryJField.setText("Enter here");
        industryJField.setToolTipText("Click to enter your name.");
        industryJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        industryJField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                industryJFieldHierarchyChanged(evt);
            }
        });
        industryJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                industryJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                industryJFieldnameChangeHandler(evt);
            }
        });
        industryJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryJFieldActionPerformed(evt);
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

        serialNoJLabel4.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel4.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel4.setText("Location (*):");

        industryLocationJField.setBackground(new java.awt.Color(238, 238, 238));
        industryLocationJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        industryLocationJField.setText("Enter here");
        industryLocationJField.setToolTipText("Click to enter your name.");
        industryLocationJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        industryLocationJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                industryLocationJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                industryLocationJFieldnameChangeHandler(evt);
            }
        });
        industryLocationJField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                industryLocationJFieldMouseClicked(evt);
            }
        });
        industryLocationJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryLocationJFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serialNoJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(industryNameJField)
                            .addComponent(industryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameJField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(industryLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(industryUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(serialNoJLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(industryJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(176, 176, 176)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel)
                    .addComponent(industryNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(industryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(industryLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(industryUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel3)
                    .addComponent(industryJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void industryNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryNameJFieldFocusGained
        if (industryNameJField.getText().equals("Enter here")) {
            industryNameJField.setText("");
        }
    }//GEN-LAST:event_industryNameJFieldFocusGained

    private void industryNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_industryNameJFieldnameChangeHandler

    private void industryNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industryNameJFieldActionPerformed

    private void industryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_industryComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_industryComboBoxItemStateChanged

    public void _adminChnageHandler() {
        selectedDelIndex = this.industryComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.assetsAdminUser.get(selectedDelIndex);
        }
    }
    private void industryComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_industryComboBoxFocusGained

    private void industryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industryComboBoxActionPerformed

    private void industryComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_industryComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_industryComboBoxPropertyChange

    private void nameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJFieldFocusGained
        if (this.nameJField.getText().equals("Enter here")) {
            nameJField.setText("");
        }
    }//GEN-LAST:event_nameJFieldFocusGained

    private void nameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJFieldnameChangeHandler

    private void nameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJFieldActionPerformed

    private void industryUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryUnitJFieldFocusGained
        if (industryUnitJField.getText().equals("Enter here")) {
            industryUnitJField.setText("");
        }
    }//GEN-LAST:event_industryUnitJFieldFocusGained

    private void industryUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_industryUnitJFieldnameChangeHandler

    private void industryUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industryUnitJFieldActionPerformed

    private void industryJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryJFieldFocusGained
        if (this.industryJField.getText().equals("Enter here")) {
            industryJField.setText("");
        }
    }//GEN-LAST:event_industryJFieldFocusGained

    private void industryJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_industryJFieldnameChangeHandler

    private void industryJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industryJFieldActionPerformed

    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.industryComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.industryNameJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Real Estate Company Name! \n";
        }
        if (!this.industryLocationJField.getText().matches("[a-zA-Z0-9 ]+")) {
            errorMEssage += "Invalid Location Name! \n";
        }

        if (!this.nameJField.getText().matches("[a-zA-Z]+")) {
            errorMEssage += "Invalid Real Estate Name! \n";
        }
        if (!this.industryUnitJField.getText().matches("[0-9]+")) {
            errorMEssage += "Real Estate Unit should be a number! \n";
        }
        if (!this.industryJField.getText().matches("[0-9]+")) {
            errorMEssage += "Real Estate Price should be a number! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, errorMEssage, "Real Estate Edit", ERROR_MESSAGE);
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedOrganization != null) {
            Boolean valid = validateItem();
            if (valid) {
                HashMap<String, HashMap<String, Object>> estates = new HashMap<>();
                HashMap<String, Object> estate = new HashMap<>();
                estate.put("maxPrice", this.industryJField.getText().toString());
                estate.put("quantity", this.industryUnitJField.getText().toString());
                estate.put("doc", new Date());
                estate.put("location", this.industryLocationJField.getText().toString());
                estates.put(this.nameJField.getText(), estate);
                selectedRealEstate.setAdmin(this.selectedUser);
                selectedRealEstate.setIndustries(estates);
                selectedRealEstate.setCompanyName(this.industryNameJField.getText());
                _getData();
                JOptionPane.showMessageDialog(this, "Industry udpated successfully!", "Industry", INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select Industry to update !", "Industry", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedRealEstate = this.allEstates.get(selectedIndex);
            this.industryNameJField.setText(selectedRealEstate.getCompanyName());
            for (HashMap.Entry<String, HashMap<String, Object>> set
                    : selectedRealEstate.getIndustries().entrySet()) {

                this.industryComboBox.setSelectedItem(selectedRealEstate.getAdmin().getUsername().toString());
                nameJField.setText(set.getKey());
                industryUnitJField.setText(set.getValue().get("quantity").toString());
                industryJField.setText(set.getValue().get("maxPrice").toString());
                industryLocationJField.setText(set.getValue().get("location").toString());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletejLabelMouseClicked
        if (selectedRealEstate != null) {
            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof AssetMarketEnterprise) {
                    ongoing.getOrganizationDirectory().getOrganizationList().remove(selectedOrganization);
                }
            }
            _getData();
            JOptionPane.showMessageDialog(this, "Industry deleted successfully!", "Industry", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Industry to delete !", "Industry", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletejLabelMouseClicked

    private void industryJFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_industryJFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_industryJFieldHierarchyChanged

    private void industryLocationJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryLocationJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_industryLocationJFieldFocusGained

    private void industryLocationJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_industryLocationJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_industryLocationJFieldnameChangeHandler

    private void industryLocationJFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_industryLocationJFieldMouseClicked
        if (this.industryLocationJField.getText().equals("Enter here")) {
            industryLocationJField.setText("");
        }
    }//GEN-LAST:event_industryLocationJFieldMouseClicked

    private void industryLocationJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryLocationJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industryLocationJFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel deletejLabel;
    private javax.swing.JComboBox<String> industryComboBox;
    private javax.swing.JTextField industryJField;
    private javax.swing.JTextField industryLocationJField;
    private javax.swing.JTextField industryNameJField;
    private javax.swing.JTextField industryUnitJField;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameJField;
    private javax.swing.JLabel serialNoJLabel;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JLabel serialNoJLabel3;
    private javax.swing.JLabel serialNoJLabel4;
    // End of variables declaration//GEN-END:variables

}
