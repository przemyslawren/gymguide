package com.przemyslawren.gymguide.dto;

import java.util.List;
import java.util.Set;

public record DetailExerciseDto(
        String id,
        String name,
        String force,
        String level,
        String mechanic,
        String equipment,
        Set<String> primaryMuscles,
        Set<String> secondaryMuscles,
        List<String> instructions,
        String category,
        List<String> images
) {}