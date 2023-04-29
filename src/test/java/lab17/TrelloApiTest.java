package lab17;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javaLabs.lab17.TrelloBO;
import javaLabs.lab17.model.CreateBoardRequest;
import javaLabs.lab17.model.CreateBoardResponse;
import javaLabs.lab17.model.DeleteRequest;
import javaLabs.lab17.model.TrelloBoard;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;


//@Listeners({AllureListener.class})
public class TrelloApiTest {
    TrelloBO trelloBO = new TrelloBO();
    Properties properties = new Properties();
    String trelloKey;
    String trelloToken;

    @BeforeTest
    void initProperty() throws IOException, URISyntaxException, InterruptedException {
        properties.load(new FileReader("src/main/resources/application.properties"));
        trelloKey= properties.getProperty("trello.key");
        trelloToken= properties.getProperty("trello.token");
        //clearAldBoard();
    }

    private void clearAldBoard() throws IOException, URISyntaxException, InterruptedException {
        trelloBO.getAllBoardsID(trelloKey, trelloToken).forEach(id->{
            DeleteRequest deleteRequest = new DeleteRequest(trelloKey, trelloToken);
            deleteRequest.setId(id);
            try {
                trelloBO.deleteBoardByID(deleteRequest);
            } catch (IOException | InterruptedException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Test
    void crudRestClientTest() throws IOException, URISyntaxException, InterruptedException {
        String newBoardName = UUID.randomUUID().toString().substring(2, 10);

        CreateBoardRequest createBoardRequest = new CreateBoardRequest();

        createBoardRequest.setName(newBoardName);
        createBoardRequest.setKey(trelloKey);
        createBoardRequest.setToken(trelloToken);

        CreateBoardResponse createBoardResponse = trelloBO.createBoard(createBoardRequest);

        //Assert.assertEquals(createBoardResponse.getStatusCode(), 200);
        CreateBoardResponse expectedCreateBoardResponse = new CreateBoardResponse();

        expectedCreateBoardResponse.setBody(new TrelloBoard());
        expectedCreateBoardResponse.getBody().setName(null);
        expectedCreateBoardResponse.setStatusCode(400);
        expectedCreateBoardResponse.getBody().setId(createBoardResponse.getBody().getId());
        expectedCreateBoardResponse.getBody().setDesc(null);
        expectedCreateBoardResponse.getBody().setClosed(null);
        expectedCreateBoardResponse.getBody().setIdOrganization(createBoardResponse.getBody().getIdOrganization());
        expectedCreateBoardResponse.getBody().setPinned(null);
        expectedCreateBoardResponse.getBody().setUrl(createBoardResponse.getBody().getUrl());
        expectedCreateBoardResponse.getBody().setShortUrl(createBoardResponse.getBody().getShortUrl());
        expectedCreateBoardResponse.getBody().setPrefs(createBoardResponse.getBody().getPrefs());
        expectedCreateBoardResponse.getBody().setLabelNames(createBoardResponse.getBody().getLabelNames());
        expectedCreateBoardResponse.getBody().setLimits(createBoardResponse.getBody().getLimits());

        Assert.assertEquals(createBoardResponse, expectedCreateBoardResponse);
    }



}
