/*
 * OneWayANOVADialog.java
 *
 * Created on July 16, 2008, 4:31 PM
 */

package org.statcato.dialogs.stat.anova;

import org.statcato.statistics.inferential.OneWayANOVA;
import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import java.util.*;
import javax.swing.*;

/**
 * A dialog for one-way ANOVA (analysis of variance).
 * Allows the user to select columns in the Datasheet to be included in the 
 * analysis, as well as the significance level.
 * Computes and displays in the log window the SS and MS values, 
 * the test statistic, critical value, and p-Value.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.OneWayANOVA
 * @since 1.0
 */
public class OneWayANOVADialog extends StatcatoDialog {
 
    /** Creates new form OneWayANOVADialog */
    public OneWayANOVADialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        this.app = app;
        ParentSpreadsheet = app.getSpreadsheet();
        initComponents();
        customInitComponents();
        setHelpFile("stat-anova1");
        name = "One-Way Analysis of Variance";
        description = "For performing one-way ANOVA.";
        helpStrings.add("Provide sample values for different populations in " +
                "separate columns and add the columns to the list of responses.");
        helpStrings.add("Specify the significance level.");
    }

    private void customInitComponents() {
        ParentSpreadsheet.populateMutableColumnsList(ColList);
        ColList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        VarList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        getRootPane().setDefaultButton(OKButton);
    }
    
    /**
     * Updates elements on the dialog so that they have the most
     * current values.  Called by {@link #setVisible} to make
     * sure the dialog displays current values when made visible again.
     * 
     * @see #setVisible(boolean)
     */
    @Override
    public void updateElements() {
        // update column list
        clearMutableColumnsList(ColList);
        clearMutableColumnsList(VarList);        
        ParentSpreadsheet.populateMutableColumnsList(ColList);
        /*
        // columns list should have no element present in the variables list
        for (int i = 0; i < VarList.getModel().getSize(); ++i) {
            String x = (String) VarList.getModel().getElementAt(i);
            ((DefaultListModel)ColList.getModel()).removeElement(x);
        }*/
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VarList = new JList(new DefaultListModel());
        RemoveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ColList = new JList(new DefaultListModel());
        jLabel1 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SigTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("One-Way Analysis of Variance");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        VarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                VarListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(VarList);

        RemoveButton.setText("Remove from list >>");
        RemoveButton.setEnabled(false);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("<html>Select the column to be <br>included in the analysis<br>\n(Ctrl-click or Shift-click to <br>\nselect multiple columns):");

        ColList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ColListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ColList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Responses:");

        AddButton.setText("<< Add to list");
        AddButton.setEnabled(false);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear Input List");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RemoveButton)
                                    .addComponent(AddButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ClearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddButton, RemoveButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(RemoveButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearButton)
                        .addGap(10, 10, 10))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Significance"));

        jLabel6.setText("Significance level:");

        SigTextField.setText("0.05");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SigTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OKButton)
                            .addComponent(CancelButton))
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VarListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_VarListValueChanged
        if (VarList.getSelectedIndex() != -1) {
            RemoveButton.setEnabled(true);
            RemoveButton.requestFocusInWindow();
        }
        else
            RemoveButton.setEnabled(false);
    }//GEN-LAST:event_VarListValueChanged

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        Object[] list = VarList.getSelectedValues();
        for (int i = 0; i < list.length; ++i) {
            String x = (String)list[i];
            ((DefaultListModel)ColList.getModel()).addElement(x);
            ((DefaultListModel)VarList.getModel()).removeElement(x);
        }
        OKButton.requestFocusInWindow();
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        Object[] list = ColList.getSelectedValues();
        for (int i = 0; i < list.length; ++i) {
            String x = (String)list[i];
            ((DefaultListModel)VarList.getModel()).addElement(x);
            ((DefaultListModel)ColList.getModel()).removeElement(x);
        }
        OKButton.requestFocusInWindow();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("one-way ANOVA");
        
        String heading = "One-way ANOVA:";
        String text = "";
        Vector<Vector<Double>> vectors = new Vector<Vector<Double>>();
        double significance = 0;
        
        // get confidence level from dialog
        try {
            significance = Double.parseDouble(SigTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a number between 0 and 1 for the significance level.");
            return;
        }
        if (significance <= 0 || significance >= 1) {
            app.showErrorDialog("Enter a number between 0 and 1 for the significance level.");
            return;
        }        
        heading += "  Significance level = " + significance;
        
        if (VarList.getModel().getSize() < 3) {
            app.showErrorDialog("Select at least three columns " +
                    "to include in the analysis.");
            return;
        }
        
        Vector<Cell> StrColumnVector;

        text += "Selected column variables:  ";
        
        for (int i = 0; i < VarList.getModel().getSize(); ++i) {
            String x = (String) VarList.getModel().getElementAt(i);
            int selectedXColumn = ParentSpreadsheet.parseColumnNumber(x);
            
            StrColumnVector = ParentSpreadsheet.getColumn(selectedXColumn);
            // get x input column of doubles
            Vector<Double> XColumnVector =
                    HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (XColumnVector == null) {
                app.showErrorDialog("Invalid input column " + x +
                        ": all data must be numbers.");
                return;
            }
            
            XColumnVector = HelperFunctions.removeNullValues(XColumnVector);
            if (XColumnVector.size() == 0) {
                app.showErrorDialog("Invalid input column " + x + 
                        ": empty column.");
            }
            vectors.addElement(XColumnVector);
            text += x + "  ";
        }
        text += "<br><br>";
        
        OneWayANOVA anova = new OneWayANOVA(vectors);
        
        text += "<table border='1'>";
        text += "<tr align='right'><th>Source of Variation</th><th>DOF</th><th>SS</th><th>MS</th>" +
                "<th>Test statistic F</th><th>Critical value F</th>" +
                "<th>p-Value</th></tr>";
        text += "<tr align='right'><th>Treatment (Between Groups)</th><td>" + anova.DOFTreatment() + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.SSTreatment(), 5) + "</td>" 
                + "<td>" + HelperFunctions.formatFloat(anova.MSTreatment(), 5) + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.TestStatisticsF(), 5) + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.CriticalValue(significance), 5) + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.PValue(), 5) + "</td></tr>";
        text += "<tr align='right'><th>Error (Within Groups)</th><td>" + anova.DOFError() + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.SSError(), 5) + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.MSError(), 5) + "</td>"
                + "<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
        text += "<tr align='right'><th>Total</th><td>" + anova.DOFTotal() + "</td>"
                + "<td>" + HelperFunctions.formatFloat(anova.SSTotal(), 5) + "</td>"
                + "<td>&nbsp;</td>"
                + "<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
        text += "</table>";
        
        app.addLogParagraph(heading, text);

        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ColListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ColListValueChanged
        if (ColList.getSelectedIndex() != -1) {
            AddButton.setEnabled(true);
            AddButton.requestFocusInWindow();
        }
        else
            AddButton.setEnabled(false);
}//GEN-LAST:event_ColListValueChanged

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clearMutableColumnsList(ColList);
        clearMutableColumnsList(VarList);
        ParentSpreadsheet.populateMutableColumnsList(ColList);
    }//GEN-LAST:event_ClearButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JList ColList;
    private javax.swing.JButton OKButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField SigTextField;
    private javax.swing.JList VarList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
}