package org.example.winemanagementapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private List<Wine> wines;
}
