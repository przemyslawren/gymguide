package com.przemyslawren.gymguide.dto;

import java.util.List;

public record ExerciseGridDto(
        long total,
        int totalPages,
        List<SimpleExerciseDto> data
) {
}
