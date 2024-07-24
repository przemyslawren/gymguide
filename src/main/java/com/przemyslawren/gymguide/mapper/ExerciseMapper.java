package com.przemyslawren.gymguide.mapper;

import com.przemyslawren.gymguide.dto.DetailExerciseDto;
import com.przemyslawren.gymguide.dto.SimpleExerciseDto;
import com.przemyslawren.gymguide.model.Exercise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExerciseMapper {

    public SimpleExerciseDto toSimpleDto(Exercise exercise) {

        return new SimpleExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getPrimaryMuscles()
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
                exercise.getImages()
        );
    }
}
