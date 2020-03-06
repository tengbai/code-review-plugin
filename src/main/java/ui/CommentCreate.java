package ui;

import store.CommentDTO;
import store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.UUID;

public class CommentCreate extends JFrame {
    private JFrame jFrame = new JFrame("Create Comment");
    private JLabel projectPannel = new JLabel();
    private JLabel projectLabelPannel = new JLabel();
    private JLabel filePannel = new JLabel();
    private JLabel fileLabelPannel = new JLabel();
    private JLabel linePannel = new JLabel();
    private JLabel lineLabelPannel = new JLabel();
    private JLabel contentLabelPannel = new JLabel();
    private JPanel buttonPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
    private JTextArea textPanel = new JTextArea(10, 4);
    private JButton cancelButton = new JButton("cancel");
    private JButton confirmButton = new JButton("confirm");

    public CommentCreate(String projectName, String fileName, int lineNumber) {
        textPanel.setLineWrap(true);
        this.createUI(projectName, fileName, lineNumber);
        this.confirmButton.addActionListener(e -> this.handleConfirmBtnClick(e));
        this.cancelButton.addActionListener(e -> this.handleCancelBtnClick(e));
    }

    private void handleConfirmBtnClick(ActionEvent e) {
        CommentDTO commentDTO = CommentDTO.builder()
                .id(UUID.randomUUID().toString())
                .title(this.projectPannel.getText())
                .content(this.textPanel.getText())
                .createData(new Date().getTime())
                .updatedDate(new Date().getTime())
                .build();
        Store.appendComment(commentDTO);
        this.jFrame.setVisible(false);
    }

    private void handleCancelBtnClick(ActionEvent e) {
        this.jFrame.setVisible(false);
    }

    private void createUI(String projectName, String fileName, int lineNumber) {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 340);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        projectLabelPannel.setText("Project");
        projectLabelPannel.setBounds(30, 10, 360, 30);
        projectPannel.setText(": " + projectName);
        projectPannel.setBounds(90, 10, 360, 30);

        fileLabelPannel.setText("File");
        fileLabelPannel.setBounds(30, 40, 360, 30);
        filePannel.setText(": " + fileName);
        filePannel.setBounds(90, 40, 360, 30);

        lineLabelPannel.setText("Line");
        lineLabelPannel.setBounds(30, 70, 360, 30);
        linePannel.setText(": " + lineNumber);
        linePannel.setBounds(90, 70, 360, 30);

        contentLabelPannel.setText("Content");
        contentLabelPannel.setBounds(30, 100, 360, 30);

        textPanel.setBounds(90, 100, 280, 70);

        buttonPanel.setBounds(30, 240, 360, 50);
        contentPanel.setSize(400, 300);

        confirmButton.setPreferredSize(new Dimension(100, 40));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        contentPanel.setLayout(null);

        contentPanel.add(projectLabelPannel);
        contentPanel.add(projectPannel);
        contentPanel.add(fileLabelPannel);
        contentPanel.add(filePannel);
        contentPanel.add(lineLabelPannel);
        contentPanel.add(linePannel);
        contentPanel.add(contentLabelPannel);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);
        jFrame.setContentPane(contentPanel);
    }
}
