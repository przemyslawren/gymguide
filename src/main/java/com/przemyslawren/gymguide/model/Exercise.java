package com.przemyslawren.gymguide.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exercise {
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private List<String> primaryMuscles;
    private List<String> secondaryMuscles;
    private List<String> instructions;
    private String category;
    private List<String> images;
    private String id;
}
