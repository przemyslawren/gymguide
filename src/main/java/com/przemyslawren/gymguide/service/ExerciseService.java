package com.przemyslawren.gymguide.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.przemyslawren.gymguide.model.Exercise;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ExerciseService {
    private List<Exercise> exercises;

    @PostConstruct
    public void init() {
        try {
            ClassPathResource resource = new ClassPathResource("exercises.json");
            ObjectMapper objectMapper = new ObjectMapper();
            exercises = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read exercises.json", e);
        }
    }

    public Exercise getExerciseByName(String name) {
        return exercises.stream()
                .filter(exercise -> exercise.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
