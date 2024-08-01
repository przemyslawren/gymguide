package com.przemyslawren.gymguide.dto;

import java.util.List;

public record ExerciseGridDto(
        int totalPages,
        List<SimpleExerciseDto> data
) {
}
