/*
Copyright 2008-2010 Gephi
Authors : Eduardo Ramos <eduramiba@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.datalab.plugin.manipulators.edges.ui;

import javax.swing.JPanel;
import org.gephi.datalab.plugin.manipulators.edges.DeleteEdgesWithNodes;
import org.gephi.datalab.spi.DialogControls;
import org.gephi.datalab.spi.Manipulator;
import org.gephi.datalab.spi.ManipulatorUI;
import org.openide.util.NbPreferences;

/**
 * UI for DeleteEdgesWithNodes edges manipulator.
 * @author Eduardo Ramos <eduramiba@gmail.com>
 */
public class DeleteEdgesWithNodesUI extends javax.swing.JPanel implements ManipulatorUI {
    private static final String DELETE_SOURCE_SAVED_PREFERENCES = "DeleteEdgesWithNodesUI_deleteSource";
    private static final String DELETE_TARGET_SAVED_PREFERENCES = "DeleteEdgesWithNodesUI_deleteTarget";
    private DeleteEdgesWithNodes del;

    /** Creates new form DeleteEdgesWithNodesUI */
    public DeleteEdgesWithNodesUI() {
        initComponents();
    }

    public void setup(Manipulator m, DialogControls dialogControls) {
        del=(DeleteEdgesWithNodes) m;
        deleteSource.setSelected(NbPreferences.forModule(DeleteEdgesWithNodesUI.class).getBoolean(DELETE_SOURCE_SAVED_PREFERENCES, true));
        deleteTarget.setSelected(NbPreferences.forModule(DeleteEdgesWithNodesUI.class).getBoolean(DELETE_TARGET_SAVED_PREFERENCES, true));
    }

    public void unSetup() {
        del.setDeleteSource(deleteSource.isSelected());
        del.setDeleteTarget(deleteTarget.isSelected());
        NbPreferences.forModule(DeleteEdgesWithNodesUI.class).putBoolean(DELETE_SOURCE_SAVED_PREFERENCES, deleteSource.isSelected());
        NbPreferences.forModule(DeleteEdgesWithNodesUI.class).putBoolean(DELETE_TARGET_SAVED_PREFERENCES, deleteTarget.isSelected());
    }

    public String getDisplayName() {
        return del.getName();
    }

    public JPanel getSettingsPanel() {
        return this;
    }

    public boolean isModal() {
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteSource = new javax.swing.JCheckBox();
        deleteTarget = new javax.swing.JCheckBox();
        descriptionLabel = new javax.swing.JLabel();

        deleteSource.setSelected(true);
        deleteSource.setText(org.openide.util.NbBundle.getMessage(DeleteEdgesWithNodesUI.class, "DeleteEdgesWithNodesUI.deleteSource.text")); // NOI18N

        deleteTarget.setSelected(true);
        deleteTarget.setText(org.openide.util.NbBundle.getMessage(DeleteEdgesWithNodesUI.class, "DeleteEdgesWithNodesUI.deleteTarget.text")); // NOI18N

        descriptionLabel.setText(org.openide.util.NbBundle.getMessage(DeleteEdgesWithNodesUI.class, "DeleteEdgesWithNodesUI.description")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(deleteSource)
                        .addGap(18, 18, 18)
                        .addComponent(deleteTarget)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteSource)
                    .addComponent(deleteTarget))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox deleteSource;
    private javax.swing.JCheckBox deleteTarget;
    private javax.swing.JLabel descriptionLabel;
    // End of variables declaration//GEN-END:variables

}
