package org.example.winemanagementapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Grape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String description;
    @ManyToMany(mappedBy = "grapes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wine> wines = new ArrayList<>();
}
