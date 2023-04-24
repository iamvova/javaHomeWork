package javaLabs.lab6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="weather")
@NoArgsConstructor
public class Weather implements Serializable {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "weather_social_media",
            joinColumns = @JoinColumn(name = "weather_id"),
            inverseJoinColumns = @JoinColumn(name = "social_media_id"))
    private List<SocialMedia> socialMedia;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Device> devices;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String time;

    @Column
    private Double temperature;

    @OneToOne(mappedBy = "weather", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Phone phone;


    public Weather(String time, Double temperature) {
        this.time = time;
        this.temperature = temperature;
    }
}

