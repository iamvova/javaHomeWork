package javaHomeWork.lab6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name="weather")
@NoArgsConstructor
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String time;

    @Column
    private Double temperature;


    public Weather(String time, Double temperature) {
        this.time = time;
        this.temperature = temperature;
    }
}

