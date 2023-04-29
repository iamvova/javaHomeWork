package javaLabs.lab17.model;

import lombok.Data;

@Data
public class CreateBoardResponse {

    private Integer statusCode;
    private TrelloBoard body;

}
