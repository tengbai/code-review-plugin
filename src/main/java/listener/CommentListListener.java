package listener;

import store.CommentDTO;
import ui.CommentList;

import java.util.List;

public class CommentListListener {
    private CommentList commentList;

    public CommentListListener(CommentList commentList) {
        this.commentList = commentList;
    }

    public void cancelEvent(List<CommentDTO> commentDTOs){
        this.commentList.refreshCommentItemsUI(commentDTOs);
    }
}
