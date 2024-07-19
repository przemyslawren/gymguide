package com.przemyslawren.gymguide.controller;

import com.przemyslawren.gymguide.model.Exercise;
import com.przemyslawren.gymguide.service.ExerciseService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getExercises();
    }

    @GetMapping("/{name}")
    public Exercise getExerciseByName(@PathVariable String name) {
        return exerciseService.getExerciseByName(name);
    }
}
