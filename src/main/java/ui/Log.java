package ui;

import javax.swing.*;
import java.awt.*;

public class Log extends JFrame {
    private JFrame jFrame = new JFrame();
    private JPanel contentPanel = new JPanel();
    private JTextArea jTextArea = new JTextArea();

    public Log(String text) {
        jFrame.setSize(400, 340);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        jTextArea.setText(text);
        jTextArea.setPreferredSize(new Dimension(400, 300));

        contentPanel.add(jTextArea);
        jFrame.setContentPane(contentPanel);
    }

    private void onCancel() {
        // add your code here if necessary
        this.jFrame.setVisible(false);
    }


    public static void main(String[] args) {
        new Log("ddd");
    }
}
