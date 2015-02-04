package org.netbeans.mc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.StatusDisplayer;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;

@ActionID(
        category = "Edit",
        id = "org.netbeans.mc.EnableMultiCursorAction"
)
@ActionRegistration(
        displayName = "#CTL_EnableMultiCursorAction"
)
@ActionReference(path = "Shortcuts", name = "F2")
@Messages("CTL_EnableMultiCursorAction=Enable Multi Cursor")
public final class EnableMultiCursorAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NbPreferences.forModule(MarkSelectedOccurrencesHighlighter.class).putBoolean("multi-cursor-enabled", true);
        StatusDisplayer.getDefault().setStatusText("Enabled multi cursor...");
    }

}
