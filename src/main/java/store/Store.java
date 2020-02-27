package store;

import com.alibaba.fastjson.JSON;
import utils.PropertiesComponentUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    public List<CommentDTO> getComments() {
        return this.getPropertiesComponent().stream().sorted().collect(Collectors.toList());
    }

    public void setComments(List<CommentDTO> comments) {
        this.setPropertiesComponent(comments);
    }

    public void appendComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = this.getComments();
        commentDTOs.add(comment);
        this.setComments(commentDTOs);
    }

    public void updateComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = this.getComments();
        if(commentDTOs.size() == 0){
            return;
        }
        commentDTOs = commentDTOs.stream()
                .map(c -> {
                    if (c.getId() == comment.getId()) {
                        return comment;
                    } else {
                        return c;
                    }
                })
                .collect(Collectors.toList());
        this.setComments(commentDTOs);
    }

    public void deleteComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = this.getComments();
        if(commentDTOs.size() == 0){
            return;
        }
        int deleteId = comment.getId();
        commentDTOs = commentDTOs.stream()
                .filter(c -> c.getId() != deleteId)
                .collect(Collectors.toList());
        this.setComments(commentDTOs);
    }

    private void setPropertiesComponent(List<CommentDTO> comments){
        String commentJson = listToJson(comments);
        PropertiesComponentUtils.setValue(commentJson);
    }

    private List<CommentDTO> getPropertiesComponent(){
        String commentJson = PropertiesComponentUtils.getValue();
        if(commentJson == null){
            return Collections.EMPTY_LIST;
        }
        return jsonToList(commentJson);
    }


    private String listToJson(List<CommentDTO> comments) {
        return JSON.toJSONString(comments);
    }

    private List<CommentDTO> jsonToList(String commentStrings) {
        return JSON.parseArray(commentStrings, CommentDTO.class);
    }

}
