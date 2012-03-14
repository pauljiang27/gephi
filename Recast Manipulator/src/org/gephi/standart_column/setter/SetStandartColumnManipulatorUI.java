/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.standart_column.setter;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeType;
import org.gephi.datalab.spi.DialogControls;
import org.gephi.datalab.spi.Manipulator;
import org.gephi.datalab.spi.ManipulatorUI;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.Node;
import org.gephi.recast_manipulator.RecastImplementation;
import org.gephi.standart_column.utilities.StandartColumn;
import org.gephi.standart_column.utilities.StandartColumns;
import org.openide.util.Lookup;

/**
 *
 * @author megaterik
 */
public class SetStandartColumnManipulatorUI extends javax.swing.JPanel implements ManipulatorUI {

    /**
     * Creates new form SetStandartColumnManipulatorUI
     */
    public SetStandartColumnManipulatorUI() {
        initComponents();
        initComboBox();
    }
    private static final String NODE_TABLE = "(Node table)";
    private static final String EDGE_TABLE = "(Edge table)";

    private void initComboBox() {
        AttributeController ac = Lookup.getDefault().lookup(AttributeController.class);
        ArrayList<String> columnTitle = new ArrayList<String>();
        for (AttributeColumn column : ac.getModel().getNodeTable().getColumns()) {
            columnTitle.add(column.getTitle() + NODE_TABLE);//warning: we rely that columnTitle ends with NODE_TABLE or EDGE_TABLE
        }
        for (AttributeColumn column : ac.getModel().getEdgeTable().getColumns()) {
            columnTitle.add(column.getTitle() + EDGE_TABLE);
        }
        columnCheckBox.setModel(new DefaultComboBoxModel(columnTitle.toArray()));

        ArrayList<StandartColumn> columns = new ArrayList<StandartColumn>();
        columns.add(StandartColumns.nodeX);
        columns.add(StandartColumns.nodeY);
        columns.add(StandartColumns.nodeZ);

        columns.add(StandartColumns.nodeSize);

        columns.add(StandartColumns.nodeColor);
        columns.add(StandartColumns.nodeRedColor);
        columns.add(StandartColumns.nodeGreenColor);
        columns.add(StandartColumns.nodeBlueColor);

        columns.add(StandartColumns.edgeSize);
        copyToComboBox.setModel(new DefaultComboBoxModel(columns.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        columnCheckBox = new javax.swing.JComboBox();
        copyToComboBox = new javax.swing.JComboBox();
        columnLabel = new javax.swing.JLabel();
        copyToLabel = new javax.swing.JLabel();
        setColumnButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        columnCheckBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        copyToComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        columnLabel.setText(org.openide.util.NbBundle.getMessage(SetStandartColumnManipulatorUI.class, "SetStandartColumnManipulatorUI.columnLabel.text")); // NOI18N

        copyToLabel.setText(org.openide.util.NbBundle.getMessage(SetStandartColumnManipulatorUI.class, "SetStandartColumnManipulatorUI.copyToLabel.text")); // NOI18N

        setColumnButton.setText(org.openide.util.NbBundle.getMessage(SetStandartColumnManipulatorUI.class, "SetStandartColumnManipulatorUI.setColumnButton.text")); // NOI18N
        setColumnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setColumnButtonActionPerformed(evt);
            }
        });

        errorLabel.setText(org.openide.util.NbBundle.getMessage(SetStandartColumnManipulatorUI.class, "SetStandartColumnManipulatorUI.errorLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copyToLabel)
                    .addComponent(columnLabel)
                    .addComponent(setColumnButton))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(columnCheckBox, 0, 435, Short.MAX_VALUE)
                    .addComponent(copyToComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnLabel)
                    .addComponent(columnCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copyToLabel)
                    .addComponent(copyToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setColumnButton)
                    .addComponent(errorLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setColumnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setColumnButtonActionPerformed
        String title = columnCheckBox.getSelectedItem().toString();
        AttributeColumn column;
        
        if (title.endsWith(NODE_TABLE) != ((StandartColumn) copyToComboBox.getSelectedItem()).isNodeTable())
        {
            errorLabel.setText("Impossible to copy column from edge table to node table");
            return;
        }
        
        if (title.endsWith(NODE_TABLE)) {
            column = Lookup.getDefault().lookup(AttributeController.class).getModel().getNodeTable().
                    getColumn(title.substring(0, title.length() - NODE_TABLE.length()));
        } else {
            column = Lookup.getDefault().lookup(AttributeController.class).getModel().getEdgeTable().
                    getColumn(title.substring(0, title.length() - EDGE_TABLE.length()));
        }

        StandartColumn standartColumn = (StandartColumn) copyToComboBox.getSelectedItem();

        AttributeTable table;
        if (standartColumn.isNodeTable()) {
            table = Lookup.getDefault().lookup(AttributeController.class).getModel().getNodeTable();
        } else {
            table = Lookup.getDefault().lookup(AttributeController.class).getModel().getEdgeTable();
        }

        StringBuilder error = new StringBuilder();
        if (!RecastImplementation.possibleToConvertColumn(table, column, standartColumn.getType(), error)) {
            errorLabel.setText(error.toString());
            return;
        }
        System.err.println("ok");
        if (standartColumn.isNodeTable()) {
            for (Node node : Lookup.getDefault().lookup(GraphController.class).getModel().getGraph().getNodes()) {
                standartColumn.setValue(node, node.getAttributes().getValue(column.getId()));
            }
        } else {
            for (Edge edge : Lookup.getDefault().lookup(GraphController.class).getModel().getGraph().getEdges()) {
                standartColumn.setValue(edge, edge.getAttributes().getValue(column.getId()));
            }
        }
        errorLabel.setText("OK");
    }//GEN-LAST:event_setColumnButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox columnCheckBox;
    private javax.swing.JLabel columnLabel;
    private javax.swing.JComboBox copyToComboBox;
    private javax.swing.JLabel copyToLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton setColumnButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setup(Manipulator m, DialogControls dialogControls) {
    }

    @Override
    public void unSetup() {
    }

    @Override
    public String getDisplayName() {
        return "Set standart column";
    }

    @Override
    public JPanel getSettingsPanel() {
        return this;
    }

    @Override
    public boolean isModal() {
        return false;
    }
}