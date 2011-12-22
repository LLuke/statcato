/*
 * CorrelationRegressionDialog.java
 *
 * Created on July 8, 2008, 2:43 PM
 */

package org.statcato.dialogs.stat.correg;

import org.statcato.graph.StatcatoChartFrame;
import org.statcato.*;
import org.statcato.spreadsheet.*;
import org.statcato.utils.HelperFunctions;
import org.statcato.statistics.inferential.*;
import org.statcato.graph.GraphFactory;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.*;

import java.util.*;
import javax.swing.*;

/**
 * A dialog for linear correlation and regression between two variables.
 * Allows the user to specify the independent and dependent variable and
 * significance level.  Computes linear correlation coefficient, 
 * critical value, p-Value, regression equation, explained, unexplained
 * and total variations, coefficient of determination, and standard error
 * of estimate.  Displays results in the log window.
 * Provides the option of creating a scatterplot of the data.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.statcato.statistics.inferential.CorrelationRegression
 * @since 1.0
 */
public class CorrelationRegressionDialog extends StatcatoDialog {

    /** Creates new form CorrelationRegressionDialog */
    public CorrelationRegressionDialog(java.awt.Frame parent, boolean modal,
            Statcato app) {
        super(parent, modal);
        this.app = app;
        ParentSpreadsheet = app.getSpreadsheet(); 
      
        initComponents();
        customInitComponents();    
        setHelpFile("stat-reg-two-variables");
        name = "Linear Correlation and Regression";
        description = "For performing computations that determine the " +
                "correlation and regression between two variables. ";
        helpStrings.add("Select the columns containing data values for " +
                "the input variables.");
        helpStrings.add("A correlation and regression analysis is done for " +
                "each pair of variables."); 
        helpStrings.add("Enter the significance level of the hypothesis test for correlation.");
        helpStrings.add("Select the Show a scatterplot for all pairs of data " +
                "values check box to display a scatter plot " +
                "showing data values in each pair of input variables.");
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
        updateComboBox(XComboBox);
        updateComboBox(YComboBox);
        clearMutableColumnsList(SeriesList);
    }
    
    public void customInitComponents() {  
        ParentSpreadsheet.populateComboBox(XComboBox);
        ParentSpreadsheet.populateComboBox(YComboBox);
        SeriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        GraphPanel.setVisible(false);
        getRootPane().setDefaultButton(OKButton);
        pack();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SeriesList = new JList(new DefaultListModel());
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        XComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        YComboBox = new javax.swing.JComboBox();
        AddButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        RemoveButton = new javax.swing.JButton();
        ClearButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SigTextField = new javax.swing.JTextField();
        GraphCheckBox = new javax.swing.JCheckBox();
        GraphPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LegendCheckBox = new javax.swing.JCheckBox();
        YTextField = new javax.swing.JTextField();
        TitleTextField = new javax.swing.JTextField();
        XTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LineCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Linear Correlation and Regression");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Independent/dependent variable series");

        SeriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                SeriesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(SeriesList);

        jLabel2.setText("<html>Select the independent (x) and the <br>\ndependent (y) variables of a new series:");

        jLabel3.setText("X variable:");

        XComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                XComboBoxItemStateChanged(evt);
            }
        });

        jLabel4.setText("y variable:");

        YComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                YComboBoxItemStateChanged(evt);
            }
        });

        AddButton.setText("Add Series");
        AddButton.setEnabled(false);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Select the series to be removed:");

        RemoveButton.setText("Remove Series");
        RemoveButton.setEnabled(false);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        ClearButton1.setText("Clear Input List");
        ClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(YComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(XComboBox, 0, 110, Short.MAX_VALUE)))
                                    .addComponent(AddButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(RemoveButton)))
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClearButton1)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(XComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(RemoveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClearButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap(154, Short.MAX_VALUE))
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

        GraphCheckBox.setText("Show a scatterplot for all pairs of data values");
        GraphCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GraphCheckBoxStateChanged(evt);
            }
        });

        GraphPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph Options"));

        jLabel7.setText("Plot Title:");

        jLabel8.setText("X-axis Label:");

        LegendCheckBox.setSelected(true);
        LegendCheckBox.setText("Show legend");

        YTextField.setText("y");

        TitleTextField.setText("Scatterplot");

        XTextField.setText("x");

        jLabel5.setText("Y-axis Label:");

        LineCheckBox.setSelected(true);
        LineCheckBox.setText("Show regression line");

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LineCheckBox)
                    .addComponent(LegendCheckBox)
                    .addGroup(GraphPanelLayout.createSequentialGroup()
                        .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitleTextField)
                            .addComponent(XTextField)
                            .addComponent(YTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(XTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(YTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LegendCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LineCheckBox)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GraphCheckBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(OKButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CancelButton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(319, 319, 319))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, OKButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GraphCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OKButton)
                            .addComponent(CancelButton)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        app.compoundEdit = new DialogEdit("correlation & regression");
        
        double significance = 0;
        String heading = "Correlation and Regression:";
        String text = "";

        if (SeriesList.getModel().getSize() == 0) {
            app.showErrorDialog("Add at least one series.");
            return;
        }

        // get confidence level from dialog
        try {
            significance = Double.parseDouble(SigTextField.getText());
        } catch (NumberFormatException e) {
            app.showErrorDialog("Enter a number between 0 and 1 for the confidence level.");
            return;
        }
        if (significance <= 0 || significance >= 1) {
            app.showErrorDialog("Enter a number between 0 and 1 for the confidence level.");
            return;
        }        
        heading += "  Significance level = " + significance;

        XYSeriesCollection seriesCollection = new XYSeriesCollection();
        double min = 0, max = 0;

        for (int i = 0; i < SeriesList.getModel().getSize(); ++i) {
            String xy = (String) SeriesList.getModel().getElementAt(i);
            text += "--------------------------<br>";
            text += "Series: " + xy + "<br>";
            String[] items = xy.split(",");
            text += "x = " + items[0] + "<br>";
            text += "y = " + items[1] + "<br>";
            int selectedXColumn = ParentSpreadsheet.parseColumnNumber(items[0]);
            int selectedYColumn = ParentSpreadsheet.parseColumnNumber(items[1]);

            Vector<Cell> StrColumnVector = ParentSpreadsheet.getColumn(selectedXColumn);
            // get x input column of doubles
            Vector<Double> XColumnVector =
                    HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);

            if (XColumnVector == null) {
                app.showErrorDialog("Invalid input column " + items[0] +
                        ": all data must be numbers.");
                return;
            }
            XColumnVector = HelperFunctions.removeNullValues(XColumnVector);

            StrColumnVector = ParentSpreadsheet.getColumn(selectedYColumn);
            // get x input column of doubles
            Vector<Double> YColumnVector =
                    HelperFunctions.ConvertInputVectorToDoubles(StrColumnVector);

            if (YColumnVector == null) {
                app.showErrorDialog("Invalid input column " + items[1] +
                        ": all data must be numbers.");
                return;
            }
            YColumnVector = HelperFunctions.removeNullValues(YColumnVector);

            if (XColumnVector.size() != YColumnVector.size()) {
                app.showErrorDialog("The number of x values must be the " +
                        "same as the number of y values.");
                return;
            }

            // compute linear correlation and regression
            CorrelationRegression CG = new CorrelationRegression(
                            XColumnVector, YColumnVector, significance);
                    text += CG + "</td>";

            // create new series
            XYSeries series = new XYSeries(xy);
            for (int j = 0; j < XColumnVector.size(); ++j) {
                double x = XColumnVector.elementAt(j).doubleValue();
                if (x < min)
                    min = x;
                if (x > max)
                    max = x;
                series.add(x,
                        YColumnVector.elementAt(j).doubleValue());
            }
            seriesCollection.addSeries(series);
        }
     
        app.addLogParagraph(heading, text);

        // create scatterplot
        if (GraphCheckBox.isSelected()) {
            JFreeChart chart = GraphFactory.createScatterplot(
                    seriesCollection, 
                    TitleTextField.getText(), 
                    XTextField.getText(), 
                    YTextField.getText(), 
                    LegendCheckBox.isSelected(), 
                    LineCheckBox.isSelected(),
                    min, 
                    max);        
            StatcatoChartFrame frame = 
                    new StatcatoChartFrame(TitleTextField.getText(), chart, app);
            frame.pack();
            frame.setVisible(true);
        }
        
        app.compoundEdit.end();
        app.addCompoundEdit(app.compoundEdit);
        
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void GraphCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GraphCheckBoxStateChanged
        if (GraphCheckBox.isSelected()) {
            GraphPanel.setVisible(true);
            pack();
        }
        else {
            GraphPanel.setVisible(false);
            pack();
        }
}//GEN-LAST:event_GraphCheckBoxStateChanged

    private void SeriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_SeriesListValueChanged
        if (SeriesList.getSelectedIndex() != -1)
            RemoveButton.setEnabled(true);
        else
            RemoveButton.setEnabled(false);
}//GEN-LAST:event_SeriesListValueChanged

    private void XComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_XComboBoxItemStateChanged
        if (XComboBox.getSelectedIndex() == 0 || YComboBox.getSelectedIndex() == 0)
            AddButton.setEnabled(false);
        else
            AddButton.setEnabled(true);
}//GEN-LAST:event_XComboBoxItemStateChanged

    private void YComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_YComboBoxItemStateChanged
        if (XComboBox.getSelectedIndex() == 0 || YComboBox.getSelectedIndex() == 0)
            AddButton.setEnabled(false);
        else
            AddButton.setEnabled(true);
}//GEN-LAST:event_YComboBoxItemStateChanged

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // add selected series to list
        if (XComboBox.getSelectedIndex() == 0) {
            app.showErrorDialog("Select x variable of the new series.");
            return;
        }
        if (YComboBox.getSelectedIndex() == 0) {
            app.showErrorDialog("Select y variable of the new series.");
            return;
        }
        String x = XComboBox.getSelectedItem().toString();
        String y = YComboBox.getSelectedItem().toString();
        String z = x.trim()+","+y.trim();
        ((DefaultListModel)SeriesList.getModel()).addElement(z);
        SeriesList.setSelectedValue(z, true);
        OKButton.requestFocusInWindow();
}//GEN-LAST:event_AddButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // remove selected series from list
        if (SeriesList.getSelectedValue() != null) {
            ((DefaultListModel)SeriesList.getModel()).removeElementAt(
                    SeriesList.getSelectedIndex());
            AddButton.requestFocusInWindow();
        }
}//GEN-LAST:event_RemoveButtonActionPerformed

    private void ClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButton1ActionPerformed
        clearMutableColumnsList(SeriesList);
}//GEN-LAST:event_ClearButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton1;
    private javax.swing.JCheckBox GraphCheckBox;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JCheckBox LegendCheckBox;
    private javax.swing.JCheckBox LineCheckBox;
    private javax.swing.JButton OKButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JList SeriesList;
    private javax.swing.JTextField SigTextField;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JComboBox XComboBox;
    private javax.swing.JTextField XTextField;
    private javax.swing.JComboBox YComboBox;
    private javax.swing.JTextField YTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
