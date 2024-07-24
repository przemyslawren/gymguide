package com.przemyslawren.gymguide.service;

import com.przemyslawren.gymguide.dto.ExercisesGridDto;
import com.przemyslawren.gymguide.dto.SimpleExerciseDto;
import com.przemyslawren.gymguide.mapper.ExerciseMapper;
import com.przemyslawren.gymguide.model.Exercise;
import com.przemyslawren.gymguide.repository.ExerciseRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public ExercisesGridDto searchExercises(String name, Pageable pageable) {
        if (name == null) {
            return getAllExercises(pageable);
        }
        Page<Exercise> page = exerciseRepository.findByNameContaining(name, pageable);
        List<SimpleExerciseDto> exerciseDtoList = page.map(exerciseMapper::toSimpleDto).getContent();

        long total = page.getTotalElements();
        int totalPages = page.getTotalPages();

        return new ExercisesGridDto(total, totalPages, exerciseDtoList);
    }

    public ExercisesGridDto getAllExercises(Pageable pageable) {
        Page<Exercise> page = exerciseRepository.findAll(pageable);
        List<SimpleExerciseDto> exerciseDtoList = page.map(exerciseMapper::toSimpleDto).getContent();

        long total = page.getTotalElements();
        int totalPages = page.getTotalPages();

        return new ExercisesGridDto(total, totalPages, exerciseDtoList);
    }
}
