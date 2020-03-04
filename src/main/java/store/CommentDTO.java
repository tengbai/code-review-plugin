package store;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommentDTO {
    private int id;
    private String title;
    private String content;
    private Long createData;
    private Long updatedDate;


    public CommentDTO(int id, String title, String content, Long createData, Long updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createData = createData;
        this.updatedDate = updatedDate;
    }

}
