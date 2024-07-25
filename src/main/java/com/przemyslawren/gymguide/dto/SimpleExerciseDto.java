package com.przemyslawren.gymguide.dto;

import java.util.List;
import java.util.Set;

public record SimpleExerciseDto(
        String id, String name, Set<String> primaryMuscles, List<String> imagesURL
) {
}
