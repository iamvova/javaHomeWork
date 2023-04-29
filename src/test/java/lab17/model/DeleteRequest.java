package lab17.model;

import lab17.model.BaseTrelloExtends;
import lombok.Data;


@Data
public class DeleteRequest extends BaseTrelloExtends {
    private String id;

    public DeleteRequest(String trelloKey, String trelloToken) {
        super(trelloKey, trelloToken);
    }
}
