package ui;

import store.CommentDTO;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
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
        CommentList commentListComponent = this;
        commentDTOs.stream()
                .map(item -> jPanel.add(new CommentItem(item, commentListComponent).getContentPane()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<CommentDTO> commentDTOs = Arrays.asList(
                CommentDTO.builder().id("1").title("ddd").content("hhh").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id("2").title("hh").content("nihao").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id("2").title("hh").content("nihao").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id("2").title("hh").content("dfhkdhfkd 即可收到回复剋舒服   是速度速度速度说的说的哈哈哈哈").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id("2").title("hh").content("nihao").createData(11L).updatedDate(11L).build()
        );
        new CommentList(commentDTOs);
    }

}
