import javax.swing.*;
import java.awt.*;

public class BTPanel extends Panel {
    private Button okButton;
    private Button cancelButton;

    public BTPanel() {
        okButton = new Button("OK");
        cancelButton = new Button("Cancel");

//        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(okButton);
        add(cancelButton);
    }
}
