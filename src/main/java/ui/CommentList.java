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

    public CommentList(List<CommentDTO> commentDTOs) {
        jFrame.setSize(500, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        commentDTOs.stream()
                .map(item -> jPanel.add(new CommentItem(item).getContentPane()))
                .collect(Collectors.toList());

        jFrame.setContentPane(jPanel);
    }

    private void drawCommentItemUI(CommentDTO commentDTO){
        JPanel itemPanel = new CommentItem(commentDTO).getContentPane();
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        this.jFrame.setVisible(false);
    }

    private void drawUI(){

    }

    public static void main(String[] args) {
        List<CommentDTO> commentDTOs  = Arrays.asList(
                CommentDTO.builder().id("1").title("ddd").content("hhh").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id("2").title("hh").content("nihao").createData(11L).updatedDate(11L).build()
        );
        new CommentList(commentDTOs);
    }
}
