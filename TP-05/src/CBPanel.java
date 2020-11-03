import javax.swing.*;
import java.awt.*;

public class CBPanel extends Panel {
    private Checkbox solarisCheckbox;
    private Checkbox linuxCheckbox;
    private Checkbox aixCheckbox;

    public CBPanel(){
        solarisCheckbox = new Checkbox("Solaris", true);
        linuxCheckbox = new Checkbox("Linux", true);
        aixCheckbox = new Checkbox("Aix", false);

//        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(solarisCheckbox);
        add(linuxCheckbox);
        add(aixCheckbox);
    }
}
