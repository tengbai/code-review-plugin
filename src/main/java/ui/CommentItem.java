package ui;

import store.CommentDTO;

import javax.swing.*;
import java.awt.*;

public class CommentItem extends JComponent {
    private JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JTextPane textPane = new JTextPane();
    private JButton editButton = new JButton("edit");
    private JButton deleteButton = new JButton("delete");

    public CommentItem(CommentDTO comment) {
        JPanel buttonPanel = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(400, 200);
        this.textPane.setSize(300,200);
        buttonPanel.setSize(100, 200);

        this.textPane.setText(comment.getContent());
        this.textPane.setBackground(Color.blue);

        buttonPanel.add(editButton, BorderLayout.NORTH);
        buttonPanel.add(deleteButton, BorderLayout.SOUTH);

        this.contentPane.add(textPane, BorderLayout.WEST);
        this.contentPane.add(buttonPanel, BorderLayout.EAST);
    }

    public JPanel getContentPane(){
        return this.contentPane;
    }

    private void onOK() {
        // add your code here
    }

    private void onCancel() {
        // add your code here if necessary
    }

    public static void main(CommentDTO commentDTO) {
//        CommentItem dialog = new CommentItem(commentDTO);
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public static void main(String[] args) {
        new CommentItem(CommentDTO.builder().id(1).content("hhh").createData(11L).updatedDate(11L).build());
    }
}
