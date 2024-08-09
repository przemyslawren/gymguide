package com.przemyslawren.gymguide.service;

import com.przemyslawren.gymguide.dto.DetailExerciseDto;
import com.przemyslawren.gymguide.dto.ExerciseGridDto;
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

    public ExerciseGridDto searchExercises(String name, Pageable pageable) {
        if (name == null) {
            return getAllExercises(pageable);
        }
        Page<Exercise> page = exerciseRepository.findByNameContaining(name, pageable);
        List<SimpleExerciseDto> exerciseDtoList = page.map(exerciseMapper::toSimpleDto).getContent();

        int totalPages = page.getTotalPages();
        return new ExerciseGridDto(totalPages, exerciseDtoList);
    }

    public ExerciseGridDto getAllExercises(Pageable pageable) {
        Page<Exercise> page = exerciseRepository.findAll(pageable);
        List<SimpleExerciseDto> exerciseDtoList = page.map(exerciseMapper::toSimpleDto).getContent();

        int totalPages = page.getTotalPages();
        return new ExerciseGridDto(totalPages, exerciseDtoList);
    }

    public DetailExerciseDto getExercise(String id) {
        Exercise exercise = exerciseRepository.findExerciseById(id);

        return exerciseMapper.toDetailDto(exercise);
    }
}
