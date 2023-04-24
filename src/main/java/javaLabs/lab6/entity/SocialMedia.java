package javaLabs.lab6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="social_media")
@NoArgsConstructor
public class SocialMedia implements Serializable {

    public SocialMedia(String name) {this.name = name;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "socialMedia", fetch = FetchType.LAZY)
    private List<Weather> users;



}

