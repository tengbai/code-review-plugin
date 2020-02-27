package store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<CommentDTO> comments = new ArrayList<>();

    public List<CommentDTO> getComments() {
        return comments.stream().sorted().collect(Collectors.toList());
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public void appendComment(CommentDTO comment) {
        this.comments.add(comment);
    }

    public void updateComment(CommentDTO comment) {
        if(comments.size() == 0){
            return;
        }
        comments = comments.stream()
                .map(c -> {
                    if (c.getId() == comment.getId()) {
                        return comment;
                    } else {
                        return c;
                    }
                })
                .collect(Collectors.toList());
    }

    public void deleteComment(CommentDTO comment) {
        if(comments.size() == 0){
            return;
        }
        int deleteId = comment.getId();
        comments = comments.stream()
                .filter(c -> c.getId() != deleteId)
                .collect(Collectors.toList());
    }
}
