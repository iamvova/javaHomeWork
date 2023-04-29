package javaLabs.lab17;

import com.fasterxml.jackson.databind.ObjectMapper;
import javaLabs.lab17.model.CreateBoardRequest;
import javaLabs.lab17.model.CreateBoardResponse;
import javaLabs.lab17.model.DeleteRequest;
import javaLabs.lab17.model.TrelloBoard;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TrelloBO {

    private static final String BASE_URL = "https://api.trello.com/";
    private ObjectMapper objectMapper = new ObjectMapper();
    public CreateBoardResponse createBoard(CreateBoardRequest createBoardRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+"1/boards/?name="+createBoardRequest.getName()+"&key="+createBoardRequest.getKey()+"&token="+createBoardRequest.getToken()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse createBoardResponse = HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CreateBoardResponse res = new CreateBoardResponse();
        res.setStatusCode(createBoardResponse.statusCode());

        System.out.println(createBoardResponse.body());

        TrelloBoard createBoardResponseBody = objectMapper.readValue(createBoardResponse.body()+"" , TrelloBoard.class);
        res.setBody(createBoardResponseBody);
        return res;
    }

    public List<String> getAllBoardsID(String trelloKey, String trelloToken) throws IOException, InterruptedException, URISyntaxException {
        //GET https://api.trello.com/1/members/me/boards
        HttpRequest httpRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+"1/members/me/boards/?key="+trelloKey+"&token="+trelloToken).toURI())
                .GET().build();

        HttpResponse createBoardResponse = HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        JSONArray jsonArray = new JSONArray(createBoardResponse.body());
        List<String> list = new ArrayList<>();
        for (int i=0; i < jsonArray.length(); i++){
            list.add(jsonArray.getJSONObject(i).getString("id"));
        }

        return list;
    }

    public void deleteBoardByID(DeleteRequest deleteRequest) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest httpRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+"1/boards/"+deleteRequest.getId()+"?key="+deleteRequest.getKey()+"&token="+deleteRequest.getToken()).toURI())
                .DELETE().build();

        HttpResponse createBoardResponse = HttpClient.newBuilder().build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

    }
}
