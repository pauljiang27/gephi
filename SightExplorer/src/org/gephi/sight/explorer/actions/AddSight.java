/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.sight.explorer.actions;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.gephi.data.network.api.DhnsController;
import org.gephi.data.network.api.SightManager;
import org.gephi.sight.explorer.SightsNode;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Mathieu Bastian
 */
public class AddSight extends AbstractAction {

    public AddSight() {
        putValue(Action.NAME, NbBundle.getMessage(SightsNode.class, "SightsNode_addSight"));
    }

    public void actionPerformed(ActionEvent e) {
        DhnsController controller = Lookup.getDefault().lookup(DhnsController.class);
        SightManager sightManager = controller.getSightManager();
        sightManager.createSight();
    }
}
