package store;

import constants.NameConstants;
import com.alibaba.fastjson.JSON;
import utils.PropertiesComponentUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    public static List<CommentDTO> getComments() {
        return getPropertiesComponent().stream()
                .sorted(Comparator.comparing(CommentDTO::getUpdatedDate).reversed())
                .collect(Collectors.toList());
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
                    if (c.getId().equals(comment.getId())) {
                        return comment;
                    } else {
                        return c;
                    }
                })
                .collect(Collectors.toList());
        setComments(commentDTOs);
    }

    public static List<CommentDTO> deleteComment(String deleteId) {
        List<CommentDTO> commentDTOs = getComments();
        if(commentDTOs.size() == 0){
            return Collections.EMPTY_LIST;
        }
        commentDTOs = commentDTOs.stream()
                .filter(c -> !c.getId().equals(deleteId))
                .collect(Collectors.toList());
        setComments(commentDTOs);
        return commentDTOs;
    }

    private static void setPropertiesComponent(List<CommentDTO> comments){
        String commentJson = listToJson(comments);
        PropertiesComponentUtils.setValue(NameConstants.APPLICATION_NAME, commentJson);
    }

    private static List<CommentDTO> getPropertiesComponent(){
        String commentJson = PropertiesComponentUtils.getValue(NameConstants.APPLICATION_NAME);
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
