package com.przemyslawren.gymguide.mapper;

import com.przemyslawren.gymguide.dto.DetailExerciseDto;
import com.przemyslawren.gymguide.dto.SimpleExerciseDto;
import com.przemyslawren.gymguide.model.Exercise;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExerciseMapper {
    private final String imageUrl = "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/";

    public SimpleExerciseDto toSimpleDto(Exercise exercise) {

        return new SimpleExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getPrimaryMuscles(),
                exercise.getImages().stream().map(imageUrl::concat).collect(Collectors.toList())
        );
    }

    public DetailExerciseDto toDetailDto(Exercise exercise) {

        return new DetailExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getForce(),
                exercise.getLevel(),
                exercise.getMechanic(),
                exercise.getEquipment(),
                exercise.getPrimaryMuscles(),
                exercise.getSecondaryMuscles(),
                exercise.getInstructions(),
                exercise.getCategory(),
                exercise.getImages().stream().map(imageUrl::concat).collect(Collectors.toList())
        );
    }
}
