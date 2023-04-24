package javaLabs.lab5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLParse {
    public static void main(String[] args) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        Weather weather = xmlMapper.readValue(new File("C:/Users/ME/IdeaProjects/labJava/src/main/java/task5/input.xml"), Weather.class);

        weather.setTemperature(12.2);

        xmlMapper.writeValue(new File("C:/Users/ME/IdeaProjects/labJava/src/main/java/task5/output.xml"), weather);
    }
}