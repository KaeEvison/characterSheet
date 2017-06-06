package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipmentManager extends javax.swing.JFrame
{
    CharacterSheet cSheet;
    ArrayList<Equipment> equipment;
    ArrayList<String> equipmentNames = new ArrayList();
    ArrayList<String> attributeNames = new ArrayList();
    int iHolder;
    String sHolder;
    Equipment currentEquipment;
    Attribute currentAttribute;
    
    public EquipmentManager()
    {
        initComponents();
        
        cSheet = ZombiesStuff.cSheet;
        equipment = cSheet.currentCharacter.getEquipment();
        
        updateAll();
    }
    
    //Update the UI
    private void updateAll()
    {
        getEquipmentNames();
        lstEquipment.setListData(equipmentNames.toArray(new String[0]));
    }
    
   //Method to retrieve names from the equipment list
    private void getEquipmentNames()
    {
        //clear list
        equipmentNames.clear();
        //For each piece of equipment, retrieve the name and add it to list
        for (int i = 0; i < equipment.size(); i++)
        {
            equipmentNames.add(equipment.get(i).getName());
        }
    }
    
    private void getAttributeNames()
    {
        //clear list
        attributeNames.clear();
        //For each attribute on the selected piece of equipment, retrieve the name and add it to the list
        for (int i = 0; i < currentEquipment.size(); i++)
        {
            attributeNames.add(currentEquipment.get(i).getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEquipment = new javax.swing.JList<>();
        btnAddEquipment = new javax.swing.JButton();
        btnRemoveEquipment = new javax.swing.JButton();
        btnEquipmentToTop = new javax.swing.JButton();
        btnEquipmentToBottom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAttributes = new javax.swing.JList<>();
        btnAddAttribute = new javax.swing.JButton();
        brtnRemoveAttribute = new javax.swing.JButton();
        btnAttributeToTop = new javax.swing.JButton();
        btnAttributeToBottom = new javax.swing.JButton();
        txtAttributeName = new javax.swing.JTextField();
        btnAttributeUpdate = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAttributeDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEquipment.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstEquipment.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEquipmentValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEquipment);

        btnAddEquipment.setText("Add equipment");
        btnAddEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEquipmentActionPerformed(evt);
            }
        });

        btnRemoveEquipment.setText("Remove equipment");
        btnRemoveEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEquipmentActionPerformed(evt);
            }
        });

        btnEquipmentToTop.setText("Move to top");
        btnEquipmentToTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentToTopActionPerformed(evt);
            }
        });

        btnEquipmentToBottom.setText("Move to bottom");
        btnEquipmentToBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentToBottomActionPerformed(evt);
            }
        });

        lstAttributes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstAttributes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAttributesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstAttributes);

        btnAddAttribute.setText("Add attribute");
        btnAddAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAttributeActionPerformed(evt);
            }
        });

        brtnRemoveAttribute.setText("Remove atrtibute");
        brtnRemoveAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brtnRemoveAttributeActionPerformed(evt);
            }
        });

        btnAttributeToTop.setText("Move to top");
        btnAttributeToTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttributeToTopActionPerformed(evt);
            }
        });

        btnAttributeToBottom.setText("Move to bottom");
        btnAttributeToBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttributeToBottomActionPerformed(evt);
            }
        });

        btnAttributeUpdate.setText("Update");
        btnAttributeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttributeUpdateActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAttributeDescription.setColumns(20);
        txtAttributeDescription.setRows(5);
        jScrollPane3.setViewportView(txtAttributeDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddEquipment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveEquipment, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnEquipmentToTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipmentToBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAttributeToBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAttributeToTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brtnRemoveAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnAddAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAttributeName)
                    .addComponent(btnAttributeUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEquipment)
                            .addComponent(btnAddAttribute))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemoveEquipment)
                            .addComponent(brtnRemoveAttribute))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEquipmentToTop)
                            .addComponent(btnAttributeToTop)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAttributeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEquipmentToBottom)
                    .addComponent(btnAttributeToBottom)
                    .addComponent(btnAttributeUpdate))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEquipmentActionPerformed
        //Request a name from the user
        sHolder = JOptionPane.showInputDialog("Enter name");
        //Check that the user didn't select 'cancel'
        if (sHolder != null)
            //Create new Equipment and update UIs
            equipment.add(new Equipment(sHolder));
            updateAll();
            cSheet.updateAll();
    }//GEN-LAST:event_btnAddEquipmentActionPerformed

    private void btnRemoveEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEquipmentActionPerformed
        //Ensure a piece of equipment is selected
        if (lstEquipment.getSelectedIndex() >= 0)
        {
            //Request confirmation from the user
            if (JOptionPane.showConfirmDialog(null, "Delete this equipment?") == 0)
            {
                //Remove the equipment and update UIs
                equipment.remove(lstEquipment.getSelectedIndex());
                updateAll();
                cSheet.updateAll();
            }
        }
        else
                //Inform the user if no equipment is selected
                JOptionPane.showMessageDialog(null, "No Equipment selected");
    }//GEN-LAST:event_btnRemoveEquipmentActionPerformed

    private void btnEquipmentToTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentToTopActionPerformed
        //Check that a piece of equipment is selected
        if (lstEquipment.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made, accomodating for the fact it will be shifted one position to the right
            iHolder = lstEquipment.getSelectedIndex() + 1;
            //Insert a copy of the selected piece of equipment at the top of the list
            equipment.add(0, new Equipment(equipment.get(lstEquipment.getSelectedIndex())));
            //Remove the original copy
            equipment.remove(iHolder);
            //Update UIs
            updateAll();
            cSheet.updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No equipment selected");
    }//GEN-LAST:event_btnEquipmentToTopActionPerformed

    private void btnEquipmentToBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentToBottomActionPerformed
        //Check that a piece of equipment is selected
        if (lstEquipment.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made
            iHolder = lstEquipment.getSelectedIndex();
            //Insert a copy of the selected piece of equipment at the end of the list
            equipment.add(new Equipment(equipment.get(lstEquipment.getSelectedIndex())));
            //Remove the original copy
            equipment.remove(iHolder);
            //Update UIs
            updateAll();
            cSheet.updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No equipment selected");
    }//GEN-LAST:event_btnEquipmentToBottomActionPerformed

    private void lstEquipmentValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEquipmentValueChanged
        //Check whether a piece of equipment is selected
        if (lstEquipment.getSelectedIndex() >= 0)
        {
            //Easier tracking of the selected item for neater code
            currentEquipment = equipment.get(lstEquipment.getSelectedIndex());
            //Retrieve names and update UI
            getAttributeNames();
            lstAttributes.setListData(attributeNames.toArray(new String[0]));
        }
        else
        {
            //If no item is selected clear the fields, this prevents ghost data upon the deletion of a piece of equipment
            lstAttributes.setListData(new String[0]);
            txtAttributeName.setText("");
            txtAttributeDescription.setText("");
        }
    }//GEN-LAST:event_lstEquipmentValueChanged

    private void btnAddAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAttributeActionPerformed
        //Request a name
        sHolder = JOptionPane.showInputDialog("Enter a name");
        //Check the user didnt cancel
        if (sHolder != null)
            //Create new attribute and update the UI, tracking the selected equipment so the user doesnt have to reselect
            currentEquipment.add(new Attribute(sHolder));
            iHolder = lstEquipment.getSelectedIndex();
            updateAll();
            cSheet.updateAll();
            lstEquipment.setSelectedIndex(iHolder);
    }//GEN-LAST:event_btnAddAttributeActionPerformed

    private void brtnRemoveAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brtnRemoveAttributeActionPerformed
        //Ensure that an attribute is selected
        if (lstAttributes.getSelectedIndex() >= 0)
        {
            //Request confirmation
            if (JOptionPane.showConfirmDialog(null, "Delete this attribute?") == 0)
                //Remove attribute and update UI, tracking the selected equipment so the user doesnt have to reselect
                currentEquipment.remove(lstAttributes.getSelectedIndex());
                iHolder = lstEquipment.getSelectedIndex();
                updateAll();
                cSheet.updateAll();
                lstEquipment.setSelectedIndex(iHolder);
        }
        else
        {
            //Inform user that no attribute is selected
            JOptionPane.showMessageDialog(null, "No attribute selected");
        }
    }//GEN-LAST:event_brtnRemoveAttributeActionPerformed

    private void btnAttributeToTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttributeToTopActionPerformed
        //Check that an attribute is selected
        if (lstAttributes.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made, accomodating for the fact it will be shifted one position to the right
            iHolder = lstAttributes.getSelectedIndex() + 1;
            //Insert a copy of the selected attribute at the top of the list
            currentEquipment.add(0, new Attribute(currentEquipment.get(lstAttributes.getSelectedIndex())));
            //Remove the original copy
            currentEquipment.remove(iHolder);
            //Update UI
            getAttributeNames();
            lstAttributes.setListData(attributeNames.toArray(new String[0]));
            cSheet.updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No attribute selected");
    }//GEN-LAST:event_btnAttributeToTopActionPerformed

    private void btnAttributeToBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttributeToBottomActionPerformed
        //Check that an attribute is selected
        if (lstAttributes.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made
            iHolder = lstAttributes.getSelectedIndex();
            //Insert a copy of the selected attribute at the end of the list
            currentEquipment.add(new Attribute(currentEquipment.get(lstAttributes.getSelectedIndex())));
            //Remove the original copy
            currentEquipment.remove(iHolder);
            //Update UI
            getAttributeNames();
            lstAttributes.setListData(attributeNames.toArray(new String[0]));
            cSheet.updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No attribute selected");
    }//GEN-LAST:event_btnAttributeToBottomActionPerformed

    private void lstAttributesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAttributesValueChanged
        //Check whether an attribute is selected
        if (lstAttributes.getSelectedIndex() >= 0)
        {
            currentAttribute = currentEquipment.get(lstAttributes.getSelectedIndex());
            txtAttributeName.setText(currentAttribute.getName());
            txtAttributeDescription.setText(currentAttribute.getDescription());
        }
        else
        {
            //If no item is selected clear the fields, this prevents ghost data upon the deletion of an attribute
            txtAttributeName.setText("");
            txtAttributeDescription.setText("");
        }
    }//GEN-LAST:event_lstAttributesValueChanged

    private void btnAttributeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttributeUpdateActionPerformed
        //COnfirm that an attribute is selected
        if (lstAttributes.getSelectedIndex() >= 0)
        {
            //Save current user inputs for name and description
            currentAttribute.setName(txtAttributeName.getText());
            currentAttribute.setDescription(txtAttributeDescription.getText());
            cSheet.updateAll();
        } else
            JOptionPane.showMessageDialog(null, "No attribute selected");
        
    }//GEN-LAST:event_btnAttributeUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brtnRemoveAttribute;
    private javax.swing.JButton btnAddAttribute;
    private javax.swing.JButton btnAddEquipment;
    private javax.swing.JButton btnAttributeToBottom;
    private javax.swing.JButton btnAttributeToTop;
    private javax.swing.JButton btnAttributeUpdate;
    private javax.swing.JButton btnEquipmentToBottom;
    private javax.swing.JButton btnEquipmentToTop;
    private javax.swing.JButton btnRemoveEquipment;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstAttributes;
    private javax.swing.JList<String> lstEquipment;
    private javax.swing.JTextArea txtAttributeDescription;
    private javax.swing.JTextField txtAttributeName;
    // End of variables declaration//GEN-END:variables
}
