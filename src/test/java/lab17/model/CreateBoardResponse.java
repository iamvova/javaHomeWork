package lab17.model;

import lab17.model.TrelloBoard;
import lombok.Data;

@Data
public class CreateBoardResponse {

    private Integer statusCode;
    private TrelloBoard body;

}
