package lab16;

import javaLabs.lab14.AllureListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


//@Listeners({AllureListener.class})
public class TrelloApiTest {
    Properties properties = new Properties();
    @BeforeTest
    void initProperties() throws IOException {
        try (Reader reader = new FileReader("src/main/resources/applocation.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create
    @Test
    void crudTest(){
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        String newBoardName = UUID.randomUUID().toString().substring(2, 10);

        String boardId = given()
                .contentType("application/json").accept("application/json")
                .log().all()
                .when().post("https://api.trello.com/1/boards/?name="+newBoardName+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("name", equalTo(newBoardName)).extract().jsonPath().getString("id");

        //get
        given()
                //.contentType("application/json")
                .accept("application/json")
                .log().all()
                .when().get("https://api.trello.com/1/boards/"+boardId+"?key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("name", equalTo(newBoardName));

        //update
        String updateBoardName = UUID.randomUUID().toString().substring(2, 10);
        given()
                //.contentType("application/json")
                .accept("application/json")
                .log().all()
                .when().put("https://api.trello.com/1/boards/"+boardId+"?name="+updateBoardName+"&key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("name", equalTo(updateBoardName));


        //delete
        given()
                //.contentType("application/json")
                .accept("application/json")
                .log().all()
                .when().delete("https://api.trello.com/1/boards/"+boardId+"?key="+trelloKey+"&token="+trelloToken)
                .then().assertThat().statusCode(200)
                .and().assertThat().body("_value", equalTo(null));
    }


}
