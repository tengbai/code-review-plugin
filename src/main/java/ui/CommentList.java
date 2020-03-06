package ui;

import store.CommentDTO;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommentList extends JFrame {
    private JFrame jFrame = new JFrame("code review list");
    private JPanel jPanel = new JPanel();
    JScrollPane scrollPane = new JScrollPane();

    public CommentList(List<CommentDTO> commentDTOs) {
        jFrame.setSize(500, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        jPanel.setLayout(new GridLayout(commentDTOs.size(), 1));
        this.drawCommentItemsUI(commentDTOs);
        scrollPane.setViewportView(jPanel);
        jFrame.setContentPane(scrollPane);
    }

    public void refreshCommentItemsUI(List<CommentDTO> commentDTOs){
        this.jPanel.removeAll();
        jPanel.setLayout(new GridLayout(commentDTOs.size(), 1));
        this.drawCommentItemsUI(commentDTOs);
        scrollPane.setViewportView(jPanel);
        this.jFrame.setContentPane(scrollPane);
    }

    private void drawCommentItemsUI(List<CommentDTO> commentDTOs) {
        if(commentDTOs.size() == 0){
            JLabel jLabel = new JLabel("no comments");
            jLabel.setBounds(120,200,100,10);
            jPanel.setLayout(null);
            jPanel.add(jLabel);
        }
        CommentList commentListComponent = this;
        commentDTOs.stream()
                .map(item -> jPanel.add(new CommentItem(item, commentListComponent).getContentPane()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<CommentDTO> commentDTOs = Collections.emptyList();
        new CommentList(commentDTOs);
    }

}
