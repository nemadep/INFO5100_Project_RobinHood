/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StockMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.Role.CompanyAgentRole;
import Business.Role.MutualFundsAgentRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author urvang
 */
public class mutualFundsOrganizationPanel extends javax.swing.JPanel {

    /**
     * Creates new form mutualFundsOrganizationPanel
     */
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoing;
    UserAccount selectedUser;
    ArrayList<UserAccount> selectedDropDown;
    stockMarketDashboard parent;
    
    public mutualFundsOrganizationPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel, stockMarketDashboard parent) {
        
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        this.parent = parent;
        
        initComponents();
        
        setStockAdminUsers();
        
        this.ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }
        
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        brandJLabel = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();
        brandJLabel1 = new javax.swing.JLabel();
        adminComboBox = new javax.swing.JComboBox<>();
        cardentifierJLabel3 = new javax.swing.JLabel();
        cardentifierJLabel1 = new javax.swing.JLabel();
        dateOfCreationJLabel = new javax.swing.JTextField();
        cardentifierJLabel2 = new javax.swing.JLabel();
        createdByJLabel = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add a Mutual Funds");

        brandJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel.setText("Country (*):");

        countryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling Islands)", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Cote D'Ivoire (Ivory Coast)", "Croatia (Hrvatska", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France", "Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and McDonald Islands", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (North)", "Korea (South)", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and The Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "S. Georgia and S. Sandwich Isls.", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom (Britain / UK)", "United States of America (USA)", "US Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City State (Holy See)", "Venezuela", "Viet Nam", "Virgin Islands (British)", "Virgin Islands (US)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zaire", "Zambia", "Zimbabwe" }));
        countryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countryComboBoxItemStateChanged(evt);
            }
        });
        countryComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryComboBoxFocusGained(evt);
            }
        });
        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });
        countryComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                countryComboBoxPropertyChange(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

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

        cardentifierJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel3.setText("Name:");

        cardentifierJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel1.setText("Date of Creation:");

        dateOfCreationJLabel.setEditable(false);
        dateOfCreationJLabel.setBackground(new java.awt.Color(216, 220, 228));
        dateOfCreationJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        dateOfCreationJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dateOfCreationJLabel.setToolTipText("This is your identifier.");
        dateOfCreationJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        dateOfCreationJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfCreationJLabelActionPerformed(evt);
            }
        });

        cardentifierJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel2.setText("Created By:");

        createdByJLabel.setEditable(false);
        createdByJLabel.setBackground(new java.awt.Color(216, 220, 228));
        createdByJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        createdByJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        createdByJLabel.setToolTipText("This is your identifier.");
        createdByJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        createdByJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createdByJLabelActionPerformed(evt);
            }
        });

        addJButton.setBackground(new java.awt.Color(200, 203, 178));
        addJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(67, 100, 100));
        addJButton.setText("ADD");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(482, 482, 482))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brandJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardentifierJLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardentifierJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardentifierJLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countryComboBox, 0, 1, Short.MAX_VALUE)
                            .addComponent(adminComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateOfCreationJLabel)
                            .addComponent(createdByJLabel)
                            .addComponent(jTextField1))
                        .addGap(400, 400, 400))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardentifierJLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdByJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel2))
                .addGap(18, 18, 18)
                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(645, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void countryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countryComboBoxItemStateChanged
        //TOdo
    }//GEN-LAST:event_countryComboBoxItemStateChanged

    private void countryComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxFocusGained

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void countryComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_countryComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxPropertyChange

    private void adminComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxItemStateChanged

    private void adminComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminComboBoxFocusGained
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxFocusGained

    private void adminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxActionPerformed

    private void adminComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adminComboBoxPropertyChange
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxPropertyChange

    private void dateOfCreationJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfCreationJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfCreationJLabelActionPerformed

    private void createdByJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdByJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createdByJLabelActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        String companyName = jTextField1.getText();
        String companyCountry = countryComboBox.getSelectedItem().toString();
        String creationDate = dateOfCreationJLabel.getText();

        UserAccount createdBy = account;
        UserAccount admin = ecosystem.getUserAccountDirectory().getAccountOnUsername(adminComboBox.getSelectedItem().toString());

        //Company comp = new Company(companyName, companyCountry, createdBy, admin);

        for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ep = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ep instanceof StockMarketEnterprise) {
                ep.getOrganizationDirectory().createMutualFundOrganization(companyName, admin, new Date());
            }
        }
        
        parent.parseList();

        this.ecosystem.generateBrowsingHistoryEnterprise(this.browsingJPanel);
        JOptionPane.showMessageDialog(this, "Enterprise edited successfully!", "Add Enterprise", INFORMATION_MESSAGE);
    }//GEN-LAST:event_addJButtonActionPerformed

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.adminComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            System.out.println(selectedDelIndex);
            this.selectedUser = this.selectedDropDown.get(selectedDelIndex);
        }
    }
    
    public void setStockAdminUsers() {
        ArrayList<String> asset = new ArrayList<>();
        this.selectedDropDown = new ArrayList<>();

        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing.getRole() instanceof MutualFundsAgentRole) {
                this.selectedDropDown.add(ongoing);
                asset.add(ongoing.getUsername());
            }
        }

        String[] assetSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(assetSDropdown);
        this.adminComboBox.setModel(brandSDropdownModel);
    }

    private void initData(){
        dateOfCreationJLabel.setText(new Date().toString());
        createdByJLabel.setText(account.getUsername());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JComboBox<String> adminComboBox;
    private javax.swing.JLabel brandJLabel;
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JLabel cardentifierJLabel2;
    private javax.swing.JLabel cardentifierJLabel3;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JTextField createdByJLabel;
    private javax.swing.JTextField dateOfCreationJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
