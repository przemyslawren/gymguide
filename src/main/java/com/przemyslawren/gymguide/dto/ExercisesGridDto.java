package com.przemyslawren.gymguide.dto;

import java.util.List;

public record ExercisesGridDto(
        long total,
        int totalPages,
        List<SimpleExerciseDto> data
) {
}
