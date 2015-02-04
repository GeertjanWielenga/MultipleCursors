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
        id = "org.netbeans.mc.DisableMultiCursorAction"
)
@ActionRegistration(
        displayName = "#CTL_DisableMultiCursorAction"
)
@ActionReference(path = "Shortcuts", name = "F10")
@Messages("CTL_DisableMultiCursorAction=Disable Multi Cursor")
public final class DisableMultiCursorAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NbPreferences.forModule(MarkSelectedOccurrencesHighlighter.class).putBoolean("multi-cursor-enabled", false);
        StatusDisplayer.getDefault().setStatusText("Disabled multi cursor...");
    }

}
