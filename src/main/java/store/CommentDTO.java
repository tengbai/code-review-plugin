package store;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommentDTO {
    private String id;
    private String title;
    private String content;
    private Long createData;
    private Long updatedDate;


    public CommentDTO(String id, String title, String content, Long createData, Long updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createData = createData;
        this.updatedDate = updatedDate;
    }

}
