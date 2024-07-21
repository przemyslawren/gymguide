package com.przemyslawren.gymguide.mapper;

import com.przemyslawren.gymguide.dto.SimpleExerciseDto;
import com.przemyslawren.gymguide.model.Exercise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExerciseMapper {

    public SimpleExerciseDto toDto(Exercise entity) {

        return new SimpleExerciseDto(
                entity.getId(),
                entity.getName(),
                entity.getLevel()
        );
    }
}
