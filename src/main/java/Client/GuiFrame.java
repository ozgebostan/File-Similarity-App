package Client;

import javax.swing.*;

public class GuiFrame extends JFrame {

    public GuiFrame() {
        setTitle("File Similarity Calculator");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GuiPanel());
        setVisible(true);
    }

}
