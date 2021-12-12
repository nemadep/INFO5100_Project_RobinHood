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

/**
 *
 * @author ronak
 */
public class ForexBrokerCreateJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;

    ArrayList<UserAccount> forexAdminUser = new ArrayList<>();

    /**
     * Creates new form ForexBrokerCreateJPanel
     */
    public ForexBrokerCreateJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        initComponents();
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoinNetwork = ongoing1;
            }
        }
        this.brokerDateOfCreationJLabel.setText(new Date().toString());
        setForexAdminUsers();
    }

    private void setForexAdminUsers() {
        ArrayList<String> forex = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing.getRole() instanceof ForexAgentRole) {
                Boolean found = false;
                for (int k = 0; k < this.ecosystem.getNetwork().getNetworkList().size(); k++) {
                    for (int j = 0; j < this.ecosystem.getNetwork().getNetworkList().get(k).getEnterpriseDirectory().getEnterpriseDir().size(); j++) {
                        Enterprise temp = this.ecosystem.getNetwork().getNetworkList().get(k).getEnterpriseDirectory().getEnterpriseDir().get(j);
                        if (temp instanceof ForexMarketEnterprise) {
                            for (int p = 0; p < temp.getOrganizationDirectory().getOrganizationList().size(); p++) {
                                Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(p);
                                if (temp1 instanceof BanksOrganization) {
                                    BanksOrganization temp3 = ((BanksOrganization) temp1);
                                    if (temp3.getAdmin() == ongoing) {
                                        found = true;
                                    }
                                } else if (temp1 instanceof BrokersOrganization) {
                                    BrokersOrganization temp4 = ((BrokersOrganization) temp1);
                                    if (temp4.getAdmin() == ongoing) {
                                        found = true;
                                    }

                                }
                            }
                        }
                    }
                }
                if (!found) {
                    this.forexAdminUser.add(ongoing);
                    forex.add(ongoing.getUsername());
                }
            }
        }
        String[] forexDropdown = forex.toArray(new String[forex.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(forexDropdown);
        this.brokerComboBox.setModel(brandSDropdownModel);
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
        serialNoJLabel = new javax.swing.JLabel();
        brokerNameJField = new javax.swing.JTextField();
        cardentifierJLabel1 = new javax.swing.JLabel();
        brokerDateOfCreationJLabel = new javax.swing.JTextField();
        serialNoJLabel1 = new javax.swing.JLabel();
        brokerContactJField = new javax.swing.JTextField();
        serialNoJLabel2 = new javax.swing.JLabel();
        forexnameJField = new javax.swing.JTextField();
        serialNoJLabel3 = new javax.swing.JLabel();
        brokerEmailJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        brandJLabel1 = new javax.swing.JLabel();
        brokerComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        serialNoJLabel4 = new javax.swing.JLabel();
        maxUnitJField = new javax.swing.JTextField();
        serialNoJLabel5 = new javax.swing.JLabel();
        priceJField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        serialNoJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel.setText("Broker Name(*):");

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

        cardentifierJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel1.setText("Date of Creation:");

        brokerDateOfCreationJLabel.setEditable(false);
        brokerDateOfCreationJLabel.setBackground(new java.awt.Color(216, 220, 228));
        brokerDateOfCreationJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        brokerDateOfCreationJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brokerDateOfCreationJLabel.setToolTipText("This is your identifier.");
        brokerDateOfCreationJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        brokerDateOfCreationJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerDateOfCreationJLabelActionPerformed(evt);
            }
        });

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Contact(*):");

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

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText("Forex Name (*):");

        forexnameJField.setBackground(new java.awt.Color(238, 238, 238));
        forexnameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        forexnameJField.setText("Enter here");
        forexnameJField.setToolTipText("Click to enter your name.");
        forexnameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        forexnameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                forexnameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                forexnameJFieldnameChangeHandler(evt);
            }
        });
        forexnameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forexnameJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel3.setText("Email(*):");

        brokerEmailJField.setBackground(new java.awt.Color(238, 238, 238));
        brokerEmailJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        brokerEmailJField.setText("Enter here");
        brokerEmailJField.setToolTipText("Click to enter your name.");
        brokerEmailJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
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
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

        brokerComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                brokerComboBoxItemStateChanged(evt);
            }
        });
        brokerComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brokerComboBoxFocusGained(evt);
            }
        });
        brokerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerComboBoxActionPerformed(evt);
            }
        });
        brokerComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                brokerComboBoxPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a Broker");

        serialNoJLabel4.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel4.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel4.setText("Max unit  (*):");

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
        maxUnitJField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxUnitJFieldMouseClicked(evt);
            }
        });
        maxUnitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxUnitJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel5.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel5.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel5.setText("Price (*):");

        priceJField.setBackground(new java.awt.Color(238, 238, 238));
        priceJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        priceJField.setText("Enter here");
        priceJField.setToolTipText("Click to enter your name.");
        priceJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        priceJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                priceJFieldnameChangeHandler(evt);
            }
        });
        priceJField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priceJFieldMouseClicked(evt);
            }
        });
        priceJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceJFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialNoJLabel)
                            .addComponent(brandJLabel1)
                            .addComponent(serialNoJLabel2)
                            .addComponent(serialNoJLabel1)
                            .addComponent(serialNoJLabel3)
                            .addComponent(cardentifierJLabel1)
                            .addComponent(serialNoJLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerDateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forexnameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerContactJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brokerEmailJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(serialNoJLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokerNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forexnameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel5)
                    .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(brokerContactJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel3)
                    .addComponent(brokerEmailJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardentifierJLabel1)
                    .addComponent(brokerDateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void brokerDateOfCreationJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerDateOfCreationJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerDateOfCreationJLabelActionPerformed

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

    private void forexnameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forexnameJFieldFocusGained
        if (this.forexnameJField.getText().equals("Enter here")) {
            forexnameJField.setText("");
        }
    }//GEN-LAST:event_forexnameJFieldFocusGained

    private void forexnameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forexnameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_forexnameJFieldnameChangeHandler

    private void forexnameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forexnameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forexnameJFieldActionPerformed

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
        Boolean valid = validateItem();
        if (valid) {
            HashMap<String, HashMap<String, Object>> brokers = new HashMap<>();
            HashMap<String, Object> broker = new HashMap<>();
            broker.put("maxPrice", this.priceJField.getText().toString());
            broker.put("quantity", this.maxUnitJField.getText().toString());
            broker.put("brokeremail", this.brokerEmailJField.getText().toString());
            broker.put("brokercontact", this.brokerContactJField.getText().toString());
            broker.put("doc", new Date());
            brokers.put(this.forexnameJField.getText(), broker);

            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof ForexMarketEnterprise) {
                    ongoing.getOrganizationDirectory().createBrokerOrganization(this.brokerNameJField.getText(), Organization.Type.Brokers, this.forexnameJField.getText().toString(), this.selectedUser, brokers, new Date());
                }
            }
            JOptionPane.showMessageDialog(this, "Broker created successfully!", "Broker", INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.brokerComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.brokerNameJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Broker Name! \n";
        }
        if (!this.maxUnitJField.getText().matches("[0-9]+")) {
            errorMEssage += "Forex Unit should be a number! \n";
        }
        if (!this.priceJField.getText().matches("[0-9]+")) {
            errorMEssage += "Forex Price should be a number! \n";
        }

        if (!this.forexnameJField.getText().matches("[a-zA-Z]+")) {
            errorMEssage += "Invalid Name! \n";
        }
        if (!this.brokerContactJField.getText().matches("[0-9]+")) {
            errorMEssage += "Contact should be a number! \n";
        }
        if (!this.brokerEmailJField.getText().matches("[a-zA-Z0-9@.]+")) {
            errorMEssage += "Invali Email! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        setForexAdminUsers();
        JOptionPane.showMessageDialog(this, errorMEssage, "Broker Edit", ERROR_MESSAGE);
        return false;
    }
    private void brokerComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_brokerComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_brokerComboBoxItemStateChanged

    private void brokerComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brokerComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerComboBoxFocusGained

    private void brokerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerComboBoxActionPerformed

    private void brokerComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_brokerComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_brokerComboBoxPropertyChange

    private void maxUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldFocusGained

    private void maxUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldnameChangeHandler

    private void maxUnitJFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxUnitJFieldMouseClicked
        if (this.maxUnitJField.getText().equals("Enter here")) {
            maxUnitJField.setText("");
        }
    }//GEN-LAST:event_maxUnitJFieldMouseClicked

    private void maxUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldActionPerformed

    private void priceJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldFocusGained

    private void priceJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldnameChangeHandler

    private void priceJFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceJFieldMouseClicked
        if (this.priceJField.getText().equals("Enter here")) {
            priceJField.setText("");
        }
    }//GEN-LAST:event_priceJFieldMouseClicked

    private void priceJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldActionPerformed

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.brokerComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.forexAdminUser.get(selectedDelIndex);
            System.out.println("!!!" + selectedUser.getUsername().toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JComboBox<String> brokerComboBox;
    private javax.swing.JTextField brokerContactJField;
    private javax.swing.JTextField brokerDateOfCreationJLabel;
    private javax.swing.JTextField brokerEmailJField;
    private javax.swing.JTextField brokerNameJField;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JTextField forexnameJField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maxUnitJField;
    private javax.swing.JTextField priceJField;
    private javax.swing.JLabel serialNoJLabel;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JLabel serialNoJLabel3;
    private javax.swing.JLabel serialNoJLabel4;
    private javax.swing.JLabel serialNoJLabel5;
    // End of variables declaration//GEN-END:variables
}
