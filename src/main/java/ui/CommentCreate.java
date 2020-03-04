package ui;

import store.CommentDTO;
import store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.UUID;

public class CommentCreate extends JFrame {
    private JFrame jFrame = new JFrame("create comment");
    private JLabel titlePanel = new JLabel();
    private JPanel buttonPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
    private JTextArea textPanel = new JTextArea(10, 4);
    private JButton cancelButton = new JButton("cancel");
    private JButton confirmButton = new JButton("confirm");

    public CommentCreate(String title) {
        this.createUI(title);
        this.confirmButton.addActionListener(e -> this.handleConfirmBtnClick(e));
        this.cancelButton.addActionListener(e -> this.handleCancelBtnClick(e));
    }

    private void handleConfirmBtnClick(ActionEvent e) {
        CommentDTO commentDTO = CommentDTO.builder()
                .id(UUID.randomUUID().toString())
                .title(this.titlePanel.getText())
                .content(this.textPanel.getText())
                .createData(new Date().getTime())
                .updatedDate(new Date().getTime())
                .build();
        Store.appendComment(commentDTO);
    }

    private void handleCancelBtnClick(ActionEvent e) {
        this.jFrame.setVisible(false);
    }

    private void createUI(String title) {
        jFrame.setSize(400, 340);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        titlePanel.setText(title);
        contentPanel.setSize(400, 300);
        titlePanel.setBounds(25, 10, 360, 10);
        textPanel.setBounds(20, 30, 360, 200);
        buttonPanel.setBounds(20, 240, 360, 50);

        confirmButton.setPreferredSize(new Dimension(100, 40));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        contentPanel.setLayout(null);
        contentPanel.add(titlePanel);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);
        jFrame.setContentPane(contentPanel);
    }

    public String getText() {
        return this.textPanel.getText();
    }

    public void setText(String t) {
        this.textPanel.setText(t);
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
        new CommentCreate("title");
    }
}
