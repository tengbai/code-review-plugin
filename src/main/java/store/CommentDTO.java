package store;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommentDTO {
    private int id;
    private String content;
    private Long createData;
    private Long updatedDate;


    public CommentDTO(int id, String content, Long createData, Long updatedDate) {
        this.id = id;
        this.content = content;
        this.createData = createData;
        this.updatedDate = updatedDate;
    }

}
