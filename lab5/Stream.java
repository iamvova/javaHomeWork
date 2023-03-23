package javaHomeWork.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        //1
        List<Weather> weatherList = generateList();
        System.out.println(weatherList);
        //2
        System.out.println(weatherList.stream().sorted());
        //3
        String timeCriteria = "14:45:00";
        Double tempCriteria = 72.5;
        List<Weather> filteredWeather = weatherList.stream()
                .filter(weather -> weather.getTime().equals(timeCriteria) && weather.getTemperature() == tempCriteria)
                .collect(Collectors.toList());
        System.out.println(filteredWeather);
        //4
        System.out.println(weatherList.stream().map(i->i.getTemperature()).collect(Collectors.toList()));
    }

    private static List<Weather> generateList() {
        Random random = new Random();
        List<Weather> weatherList = new ArrayList<>();
        IntStream.range(1, 11).forEach(i -> {
            Weather weather = new Weather();
            weather.setTime(Integer.toString(random.nextInt(24)) + "." + Integer.toString(random.nextInt(60)) + "." + Integer.toString(random.nextInt(60)));
            weather.setTemperature(random.nextDouble(100));
            weather.setHumid(random.nextBoolean());
            weatherList.add(weather);

        });
        return weatherList;
    }
}
