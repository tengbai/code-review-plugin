package ui;

import javax.swing.*;
import java.awt.*;

public class CommentCreate extends JFrame{
    private JFrame jFrame = new JFrame("create comment");
    private JPanel buttonPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
    private JTextArea textPanel = new JTextArea(10, 4);
    private JButton cancelButton = new JButton("cancel");
    private JButton confirmButton = new JButton("confirm");
    public CommentCreate() {
        jFrame.setSize(400, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        contentPanel.setSize(400, 300);
        textPanel.setBounds(10, 10, 380, 200);
        buttonPanel.setBounds(10, 210, 380, 100);

        confirmButton.setPreferredSize(new Dimension(100, 40));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        contentPanel.setLayout(null);
        contentPanel.add(textPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        jFrame.setContentPane(contentPanel);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        new CommentCreate();
    }
}
