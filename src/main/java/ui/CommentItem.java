package ui;

import store.CommentDTO;
import store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.function.Function;

public class CommentItem extends JComponent {
    private JPanel contentPane = new JPanel();
    private JLabel titlePanel = new JLabel();
    private JTextArea text = new JTextArea(10, 30);
    private JPanel textPane = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton editButton = new JButton("edit");
    private JButton deleteButton = new JButton("delete");

    private CommentDTO commentDTO;

    public CommentItem(CommentDTO comment, CommentList commentList) {
        this.commentDTO = comment;
        this.createUI(comment);
        this.editButton.addActionListener(e -> this.handleEditBtnClick(e, commentList));
        this.deleteButton.addActionListener(e -> this.handleDeleteBtnClick(e, commentList));
    }

    private void createUI(CommentDTO comment){
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(400, 200));
        titlePanel.setPreferredSize(new Dimension(360,20));
        textPane.setPreferredSize(new Dimension(300,200));
        buttonPanel.setPreferredSize(new Dimension(100, 200));
        buttonPanel.setLayout(null);

        this.titlePanel.setText(comment.getTitle());
        this.text.setText(comment.getContent());
        this.text.setEditable(false);
        this.text.setLineWrap(true);
        this.text.setBounds(10,10,300,200);
        this.textPane.add(this.text);

        editButton.setBounds(10 ,20,70, 35);
        deleteButton.setBounds(10, 60, 70 ,35);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        this.contentPane.add(titlePanel, BorderLayout.NORTH);
        this.contentPane.add(textPane, BorderLayout.CENTER);
        this.contentPane.add(buttonPanel, BorderLayout.EAST);
    }

    private void handleEditBtnClick(ActionEvent e, CommentList commentList){
        new CommentEdit(commentDTO, commentList);
    }

    private void handleDeleteBtnClick(ActionEvent e, CommentList commentList) {
        new CancelModal(new Function() {
            @Override
            public Object apply(Object o) {
                CommentItem.this.handleDeleteConfirm(commentList);
                return null;
            }
        });
    }

    private void handleDeleteConfirm(CommentList commentList) {
        List<CommentDTO> commentDTOs = Store.deleteComment(this.commentDTO.getId());
        commentList.refreshCommentItemsUI(commentDTOs);
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
//        new CommentItem(CommentDTO.builder().id("1").title("hhh").content("hhh").createData(11L).updatedDate(11L).build());
    }


    private void setCommentDTO(CommentDTO commentDTO){
        this.commentDTO = commentDTO;
    }

    private CommentDTO getCommentDTO(){
        return this.commentDTO;
    }
}
