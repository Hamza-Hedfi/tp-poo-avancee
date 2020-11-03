import java.awt.*;

public class LSTPanel extends Panel {
    private Label label;
    private List list;

    public LSTPanel() {
        this.label = new Label("List");
        list = new List(4);
        list.add("Solaris");
        list.add("Linux");
        list.add("Aix");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(label);
        add(list);
    }
}
