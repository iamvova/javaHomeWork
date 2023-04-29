package javaLabs.lab17.model;

import lombok.Data;


@Data
public class DeleteRequest extends BaseTrelloExtends {
    private String id;

    public DeleteRequest(String trelloKey, String trelloToken) {
        super(trelloKey, trelloToken);
    }
}
