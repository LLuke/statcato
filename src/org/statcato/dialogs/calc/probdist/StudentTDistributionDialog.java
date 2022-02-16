/*
 * StudentTDistributionDialog.java
 *
 * Created on May 9, 2008, 2:16 PM
 */

package org.statcato.dialogs.calc.probdist;

import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import org.statcato.statistics.*;
import java.util.Vector;
import javax.swing.*;


/**
 * A dialog for Student's t probability distribution.
 * Provides options to compute the probability density, cumulative
 * probability, and inverse cumulative probability.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @since 1.0
 */
public class StudentTDistributionDialog extends StatcatoDialog {

    /** Creates new form StudentTDistributionDialog */
    public StudentTDistributionDialog(java.awt.Frame parent, boolean modal, Statcato app) {
        super(parent, modal);
        this.app = app;
        this.ParentSpreadsheet = app.getSpreadsheet();        
        initComponents();
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(ProbDensityRadioButton);
        group1.add(CumProbRadioButton);
        group1.add(InvCumProbRadioButton);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(ConstRadioButton);
        group2.add(ColumnRadioButton);
        
        ParentSpreadsheet.populateComboBox(ColumnComboBox);
        
        getRootPane().setDefaultButton(OKButton);
        setHelpFile("calc-student");
        name = "Student's t Probability Distribution";
        description = "For calculations on Student's probability distribution.";
        helpStrings.add("Enter a positive integer for the degrees of freedom.");
        helpStrings.add("Choose probability density for P(x), cumulative " +
                "probability for (P(<= x), and inverse cumulative probability " +
                "for finding x given a such that P(<= x) = a.");
        helpStrings.add("Inputs can be numbers within a column or a single " +
                "constant.");
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
        updateComboBox(ColumnComboBox);
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
        jLabel2 = new javax.swing.JLabel();
        ProbDensityRadioButton = new javax.swing.JRadioButton();
        DOFTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        InvCumProbRadioButton = new javax.swing.JRadioButton();
        CumProbRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ConstTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ColumnComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        StoreTextField = new javax.swing.JTextField();
        ConstRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ColumnRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student's t Probability Distribution");

        OKButton.setText("Compute");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Close");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Distribution"));

        jLabel2.setText("Degrees of freedom:");

        ProbDensityRadioButton.setSelected(true);
        ProbDensityRadioButton.setText("Probability density");

        DOFTextField.setText("1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Compute:");

        InvCumProbRadioButton.setText("Inverse cumulative probability");

        CumProbRadioButton.setText("Cumulative probability");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Distribution Parameters:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(InvCumProbRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ProbDensityRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(CumProbRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(DOFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DOFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProbDensityRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CumProbRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvCumProbRadioButton)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs and Outputs"));

        ConstTextField.setEnabled(false);

        jLabel7.setText("(e.g. C1 for column label, or variable name)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Input(s):");

        ConstRadioButton.setText("Constant:");
        ConstRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ConstRadioButtonStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Store Results in: (optional)");

        ColumnRadioButton.setSelected(true);
        ColumnRadioButton.setText("Column:");
        ColumnRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ColumnRadioButtonStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConstRadioButton)
                            .addComponent(ColumnRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ConstTextField)
                            .addComponent(ColumnComboBox, 0, 119, Short.MAX_VALUE)))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(StoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColumnRadioButton)
                    .addComponent(ColumnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConstRadioButton)
                    .addComponent(ConstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(OKButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ColumnRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ColumnRadioButtonStateChanged
        if (ColumnRadioButton.isSelected()) {
            ColumnComboBox.setEnabled(true);
            ConstTextField.setEnabled(false);
        } else {
            ColumnComboBox.setEnabled(false);
            ConstTextField.setEnabled(true);
        }
    }//GEN-LAST:event_ColumnRadioButtonStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("Student T");
        
        int DOF = 0;
        String heading = "Student's t Distribution: DOF = ";
        String text = "";
        // get degrees of freedom from dialog
        try {
            DOF = Integer.parseInt(DOFTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a valid number for the degrees of freedom.");
            return;
        }
        if (DOF < 1) {
            app.showErrorDialog("Enter a valid number for the degrees of freedom.");
            return;
        }
        
        heading += DOF;
        
        Vector<Double> ColumnVector = new Vector<Double>();
        
        // get input
        if (ColumnRadioButton.isSelected()) {
            // get data for selected input column
            String columnLabel = ColumnComboBox.getSelectedItem().toString();
            if (columnLabel.equals("")) { // no input variable
                app.showErrorDialog("Select the input column.");
                return;
            }
            int column = ParentSpreadsheet.parseColumnNumber(columnLabel);
            Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(column);
            ColumnVector = HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);
            if (ColumnVector == null) {
                app.showErrorDialog("Invalid input column " + columnLabel +
                        ": all data must be numbers.");
                return;
            }
            text += "Input: " + columnLabel + "<br>";
        } else {
            // get input from constant text field
            try {
                double num = Double.parseDouble(ConstTextField.getText());
                ColumnVector.addElement(num);
                text += "Input: " + num + "<br>";
                
            } catch (NumberFormatException e) {
                app.showErrorDialog("Invalid constant input.  Enter a valid number.");
                return;
            }
        }
        
        // compute results
        StudentTProbabilityDistribution npd = new StudentTProbabilityDistribution(DOF);
        Vector<String> ResultVector = new Vector<String>();
        if (ProbDensityRadioButton.isSelected()) {
            text += "Type: Probability density<br>";
            text += "<table>";
            text += "<tr><td>X</td><td>P(X)</td></tr>";
            for (int i = 0; i < ColumnVector.size(); ++i) {
                Double elm = ColumnVector.elementAt(i);
                if (elm != null) {
                    double x = elm.doubleValue();
                    double density = npd.density(x);
                    text += "<tr><td>" + x + "</td><td>" +
                            HelperFunctions.formatFloat(density, 6) + "</td></tr>";
                    ResultVector.addElement(density+"");
                }
            }
            text += "</table>";
        } else if (CumProbRadioButton.isSelected()) {
            text += "Type: Cumulative probability<br>";
            text += "<table>";
            text += "<tr><td>X</td><td>P(<&lt;=X)</td></tr>";
            for (int i = 0; i < ColumnVector.size(); ++i) {
                Double elm = ColumnVector.elementAt(i);
                if (elm != null) {
                    double x = elm.doubleValue();
                    double density = npd.cumulativeProbability(x);
                    text += "<tr><td>" + x + "</td><td>" +
                            HelperFunctions.formatFloat(density, 6) + "</td></tr>";
                    ResultVector.addElement(density+"");
                }
            }
            text += "</table>";
        } else if (InvCumProbRadioButton.isSelected()) {
            text += "Type: Inverse cumulative probability<br>";
            text += "<table>";
            text += "<tr><td>P(<&lt;=X)</td><td>X</td></tr>";
            for (int i = 0; i < ColumnVector.size(); ++i) {
                Double elm = ColumnVector.elementAt(i);
                if (elm != null) {
                    double area = elm.doubleValue();
                    double x = npd.inverseCumulativeProbability(area);
                    text += "<tr><td>" + area + "</td><td>" +
                            HelperFunctions.formatFloat(x, 4) + "</td></tr>";
                    ResultVector.addElement(HelperFunctions.formatFloat(x, 4)+"");
                }
            }
            text += "</table>";
        }
        
        String storeColumn = StoreTextField.getText();
        if (!storeColumn.equals("")) {
            // check if Column is valid
            int storeColumnNum = ParentSpreadsheet.getColumnNumber(storeColumn);
            if (storeColumnNum == -1) { // invalid column
                app.showErrorDialog("Enter a valid column name (e.g. C1) or a valid variable name to store the results.");
                return;
            }
            ParentSpreadsheet.setColumn(storeColumnNum, ResultVector);
        }
        
        app.addLogParagraph(heading, text);
        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ConstRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ConstRadioButtonStateChanged
        if (ConstRadioButton.isSelected()) {
            ColumnComboBox.setEnabled(false);
            ConstTextField.setEnabled(true);
        } else {
            ColumnComboBox.setEnabled(true);
            ConstTextField.setEnabled(false);
        }
    }//GEN-LAST:event_ConstRadioButtonStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox ColumnComboBox;
    private javax.swing.JRadioButton ColumnRadioButton;
    private javax.swing.JRadioButton ConstRadioButton;
    private javax.swing.JTextField ConstTextField;
    private javax.swing.JRadioButton CumProbRadioButton;
    private javax.swing.JTextField DOFTextField;
    private javax.swing.JRadioButton InvCumProbRadioButton;
    private javax.swing.JButton OKButton;
    private javax.swing.JRadioButton ProbDensityRadioButton;
    private javax.swing.JTextField StoreTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
}
