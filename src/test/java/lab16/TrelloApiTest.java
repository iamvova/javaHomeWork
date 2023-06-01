package lab16;

import javaLabs.lab14.AllureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


//@Listeners({AllureListener.class})
public class TrelloApiTest {
    Properties properties = new Properties();


    @BeforeTest
    void initProperties(){
        try (Reader reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create
    @Test
    void crudRestAssuredTest(){
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        String newBoardName = UUID.randomUUID().toString().substring(2, 10);
        String newListName = UUID.randomUUID().toString().substring(2, 10);
        String newCardName = UUID.randomUUID().toString().substring(2, 10);
        String dueDate = "2023-05-10T10:00:00.000Z";

        //Create Board
        String boardId = given()
                .contentType("application/json").accept("application/json")
                .log().all()
                .when().post("https://api.trello.com/1/boards/?name="+newBoardName+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("name", equalTo(newBoardName)).extract().jsonPath().getString("id");

        //Create List
        String listId = given()
                .contentType("application/json").accept("application/json")
                .log().all()
                .when().post("https://api.trello.com/1/lists?name="+newListName+"&idBoard="+boardId+""+newBoardName+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("List", equalTo(newListName)).extract().jsonPath().getString("id");

        //Create card
        String cardId = given()
                .contentType("application/json").accept("application/json")
                .log().all()
                .when().post("https://api.trello.com/1/card?name="+newCardName+"&idList="+listId+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("Card", equalTo(newListName)).extract().jsonPath().getString("id");

        // Add or update Due Date
        given()
                .contentType("application/json").accept("application/json")
                .log().all()
                .when().put("https://api.trello.com/1/cards/"+cardId+"?due="+dueDate+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("Due Date", equalTo(newListName)).extract().jsonPath().getString("id");

        //Delete Due Date
        given()
                //.contentType("application/json")
                .accept("application/json")
                .log().all()
                .when().delete("https://api.trello.com/1/cards/"+cardId+"?due="+dueDate+"?key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("_value", equalTo(null));

    }


    @Test
    void crudRestClientTest() throws IOException, URISyntaxException, InterruptedException {
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        String newBoardName = UUID.randomUUID().toString().substring(2, 10);

        HttpRequest createBoardRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL("https://api.trello.com/1/boards/?name="+newBoardName+"&key="+trelloKey+"&token="+trelloToken).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse createBoardResponse = HttpClient.newBuilder().build().send(createBoardRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(createBoardResponse.statusCode(), 200);


    }



}
