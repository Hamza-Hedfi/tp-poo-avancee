import javax.swing.*;
import java.awt.*;
import java.awt.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {

    private TFPanel tfPanel;
    private CHPanel chPanel;
    private LSTPanel lstPanel;
    private CBPanel cbPanel;
    private RBPanel rbPanel;
    private BTPanel btPanel;

    public MainFrame() {
        super("Frame Example");

        tfPanel = new TFPanel();
        chPanel = new CHPanel();
        lstPanel = new LSTPanel();
        cbPanel= new CBPanel();
        rbPanel = new RBPanel();
        btPanel = new BTPanel();

        MenuBar mb = new MenuBar();
        Menu language = new Menu("Language");
        language.add(new MenuItem("bla bla"));
        mb.add(language);
        setMenuBar(mb);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(tfPanel);
        add(chPanel);
        add(lstPanel);
        add(cbPanel);
        add(rbPanel);
        add(btPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        pack();
        Dimension dimension = getPreferredSize();
        System.out.println(dimension);
        setSize(dimension.width + 15, dimension.height + 15);
        setResizable(false);

        setLocationRelativeTo(null);

    }
}
