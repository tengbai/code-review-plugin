package ui;

import store.CommentDTO;

import javax.swing.*;
import java.awt.*;

public class CommentItem extends JComponent {
    private JPanel contentPane = new JPanel();

    private JLabel titlePanel = new JLabel();
    private JTextPane text = new JTextPane();
    private JPanel textPane = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton editButton = new JButton("edit");
    private JButton deleteButton = new JButton("delete");

    public CommentItem(CommentDTO comment) {
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(400, 200));
        titlePanel.setPreferredSize(new Dimension(400,20));
        textPane.setPreferredSize(new Dimension(300,200));
        buttonPanel.setPreferredSize(new Dimension(100, 200));
        buttonPanel.setLayout(null);

        this.titlePanel.setText(comment.getTitle());
        this.text.setText(comment.getContent());
        this.textPane.setBackground(Color.blue);
        this.textPane.add(this.text);

        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        editButton.setBounds(10 ,20,60, 20);
        deleteButton.setBounds(10, 60, 60 ,20);

        this.contentPane.add(titlePanel, BorderLayout.NORTH);
        this.contentPane.add(textPane, BorderLayout.CENTER);
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
        new CommentItem(CommentDTO.builder().id(1).title("hhh").content("hhh").createData(11L).updatedDate(11L).build());
    }
}
