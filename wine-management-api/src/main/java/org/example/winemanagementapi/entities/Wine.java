package org.example.winemanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private Integer year;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "wine_grapes", joinColumns = @JoinColumn(name = "wines_id"), inverseJoinColumns = @JoinColumn(name = "grapes_id"))
    //@JsonIgnore
    @JsonManagedReference
    private List<Grape> grapes = new ArrayList<>();
    @ManyToOne
    private Region region;
}
