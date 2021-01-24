import javax.swing.*;

public class SwingMVCDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new View();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
