package ui;

import store.CommentDTO;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommentList extends JFrame {
    private JFrame jFrame = new JFrame("code review list");
    private JPanel jPanel =new JPanel();

    public CommentList(List<CommentDTO> commentDTOs) {
        jFrame.setSize(400, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                CommentDTO.builder().id(1).content("hhh").createData(11L).updatedDate(11L).build(),
                CommentDTO.builder().id(2).content("nihao").createData(11L).updatedDate(11L).build()
        );
        new CommentList(commentDTOs);
    }
}
