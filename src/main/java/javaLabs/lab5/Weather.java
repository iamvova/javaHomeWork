package javaLabs.lab5;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Weather implements Serializable {
    @JsonProperty
    private String time;
    @JsonProperty
    private Double temperature;
    @JsonProperty
    private Boolean humid;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Boolean getHumid() { return humid; }
    public void setHumid(Boolean humid) {
        this.humid = humid;
    }
}

