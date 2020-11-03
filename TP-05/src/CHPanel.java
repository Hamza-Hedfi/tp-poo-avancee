import java.awt.*;

public class CHPanel extends Panel {

    private Label label;
    private Choice choice;

    public CHPanel() {
        this.label = new Label("Choice");

        choice = new Choice();
        choice.add("Solaris");
        choice.add("Linux");
        choice.add("Aix");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(label);
        add(choice);
    }
}
