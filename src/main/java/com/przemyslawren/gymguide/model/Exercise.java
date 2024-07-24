package com.przemyslawren.gymguide.model;

import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("exercises")
public class Exercise {
    @Id
    private String id;

    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private Set<String> primaryMuscles;
    private Set<String> secondaryMuscles;
    private List<String> instructions;
    private String category;
    private List<String> images;
}
