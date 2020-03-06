package ui;

import javax.swing.*;
import java.awt.*;

public class CancelModal extends JFrame {
    JFrame jFrame = new JFrame("cancel");
    JPanel contentPanel = new JPanel();
    JLabel textPanel = new JLabel("Do you want to delete this comment?");
    JPanel buttonPanel = new JPanel();
    JButton yesBtn = new JButton("Yes");
    JButton noBtn = new JButton("No");

    public CancelModal()  {
        jFrame.setSize(350, 260);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel.setSize(350, 260);
        textPanel.setBounds(30, 20, 260, 120);
        buttonPanel.setBounds(10, 140, 360, 50);

        yesBtn.setPreferredSize(new Dimension(100, 30));
        noBtn.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(yesBtn);
        buttonPanel.add(noBtn);

        contentPanel.setLayout(null);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);
        jFrame.setContentPane(contentPanel);
    }

    public static void main(String[] args) {
        new CancelModal();
    }
}
