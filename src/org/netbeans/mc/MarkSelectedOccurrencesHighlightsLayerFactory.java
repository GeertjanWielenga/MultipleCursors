package org.netbeans.mc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.Document;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.spi.editor.highlighting.HighlightsLayer;
import org.netbeans.spi.editor.highlighting.HighlightsLayerFactory;
import org.netbeans.spi.editor.highlighting.ZOrder;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
//@ActionID(
//        category = "Edit",
//        id = "org.netbeans.mc.MarkSelectedOccurrencesHighlighter"
//)
//@ActionRegistration(
//        displayName = "UNUSED"
//)
//@ActionReferences({
//    @ActionReference(path = "Shortcuts", name = "F2")
//})
@MimeRegistrations({
    @MimeRegistration(mimeType = "text/plain", service = HighlightsLayerFactory.class),
    @MimeRegistration(mimeType = "text/html", service = HighlightsLayerFactory.class),
    @MimeRegistration(mimeType = "text/x-java", service = HighlightsLayerFactory.class),
    @MimeRegistration(mimeType = "text/xml", service = HighlightsLayerFactory.class)
})
public class MarkSelectedOccurrencesHighlightsLayerFactory implements HighlightsLayerFactory {
    public static MarkSelectedOccurrencesHighlighter getMarkOccurrencesHighlighter(Document doc) {
        MarkSelectedOccurrencesHighlighter highlighter
                = (MarkSelectedOccurrencesHighlighter) doc.getProperty(MarkSelectedOccurrencesHighlighter.class);
        if (highlighter == null) {
            doc.putProperty(MarkSelectedOccurrencesHighlighter.class,
                    highlighter = new MarkSelectedOccurrencesHighlighter(doc));
        }
        return highlighter;
    }
    @Override
    public HighlightsLayer[] createLayers(Context context) {
        return new HighlightsLayer[]{
            HighlightsLayer.create(
            MarkSelectedOccurrencesHighlighter.class.getName(),
            ZOrder.CARET_RACK.forPosition(2000),
            true,
            getMarkOccurrencesHighlighter(context.getDocument()).getHighlightsBag())
        };
    }
}
