package ui;

import store.CommentDTO;

import javax.swing.*;

public class CommentItem extends JComponent {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextPane textPane;
    private JButton editButton;
    private JButton deleteButton;

    public CommentItem(CommentDTO comment) {
        this.textPane.setText(comment.getContent());
        this.contentPane.add(editButton);
        this.contentPane.add(deleteButton);

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
}
