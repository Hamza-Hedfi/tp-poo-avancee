import java.awt.*;

public class TFPanel extends Panel {

    private Label label;
    private TextField textField;

    public TFPanel() {
        label = new Label("TextField");
        textField = new TextField("abcdefg");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(label);
        add(textField);
    }
}
