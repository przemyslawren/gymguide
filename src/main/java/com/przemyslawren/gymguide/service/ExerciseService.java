package com.przemyslawren.gymguide.service;

import com.przemyslawren.gymguide.dto.SimpleExerciseDto;
import com.przemyslawren.gymguide.mapper.ExerciseMapper;
import com.przemyslawren.gymguide.model.Exercise;
import com.przemyslawren.gymguide.repository.ExerciseRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public Exercise getExerciseByName(String name) {
        return exerciseRepository.findExerciseByName(name);
    }

    public List<Exercise> getAllExercises() {
        return new ArrayList<>(exerciseRepository.findAll());
    }

    public List<SimpleExerciseDto> getSimpleExercises() {
        return exerciseRepository.findAll().stream().map(exerciseMapper::toDto).toList();
    }
}
