import javax.swing.*;
import java.awt.*;

public class RBPanel extends Panel {
    private CheckboxGroup checkboxGroup;
    private Checkbox solarisCheckbox;
    private Checkbox linuxCheckbox;
    private Checkbox aixCheckbox;

    public RBPanel(){
        checkboxGroup = new CheckboxGroup();
        solarisCheckbox = new Checkbox("Solaris", checkboxGroup, false);
        linuxCheckbox = new Checkbox("Solaris", checkboxGroup, true);
        aixCheckbox = new Checkbox("Solaris", checkboxGroup, true);

//        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(solarisCheckbox);
        add(linuxCheckbox);
        add(aixCheckbox);
    }
}
