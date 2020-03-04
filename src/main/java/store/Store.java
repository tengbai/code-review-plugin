package store;

import com.alibaba.fastjson.JSON;
import utils.PropertiesComponentUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    public static List<CommentDTO> getComments() {
        return getPropertiesComponent().stream().sorted().collect(Collectors.toList());
    }

    public static void setComments(List<CommentDTO> comments) {
        setPropertiesComponent(comments);
    }

    public static void appendComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = getComments();
        commentDTOs.add(comment);
        setComments(commentDTOs);
    }

    public static void updateComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = getComments();
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
        setComments(commentDTOs);
    }

    public static void deleteComment(CommentDTO comment) {
        List<CommentDTO> commentDTOs = getComments();
        if(commentDTOs.size() == 0){
            return;
        }
        String deleteId = comment.getId();
        commentDTOs = commentDTOs.stream()
                .filter(c -> c.getId() != deleteId)
                .collect(Collectors.toList());
        setComments(commentDTOs);
    }

    private static void setPropertiesComponent(List<CommentDTO> comments){
        String commentJson = listToJson(comments);
        PropertiesComponentUtils.setValue(commentJson);
    }

    private static List<CommentDTO> getPropertiesComponent(){
        String commentJson = PropertiesComponentUtils.getValue();
        if(commentJson == null){
            return Collections.EMPTY_LIST;
        }
        return jsonToList(commentJson);
    }


    private static String listToJson(List<CommentDTO> comments) {
        return JSON.toJSONString(comments);
    }

    private static List<CommentDTO> jsonToList(String commentStrings) {
        return JSON.parseArray(commentStrings, CommentDTO.class);
    }

}
