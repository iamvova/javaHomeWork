package task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File inputFile = new File("C:/Users/ME/IdeaProjects/labJava/src/main/java/task5/input.json");
            Weather weather = objectMapper.readValue(inputFile, Weather.class);

            weather.setTemperature(44.6);

            File outputFile = new File("C:/Users/ME/IdeaProjects/labJava/src/main/java/task5/output.json");
            objectMapper.writeValue(outputFile, weather);
            System.out.println("Updated POJO saved to output.json");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


//    -----------V16---------
//    {
//        "time": "14:45:00",
//        "temperature": 72.5,
//        "isHumid": true
//    }
//<data>
//    <time>14:45:00</time>
//        <temperature>72.5</temperature>
//    <isHumid>true</isHumid>
//</data>
