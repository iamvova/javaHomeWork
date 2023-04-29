package lab17.model;


import lombok.Data;

@Data
public class CreateBoardRequest extends BaseTrelloExtends {
    private String name;
}
