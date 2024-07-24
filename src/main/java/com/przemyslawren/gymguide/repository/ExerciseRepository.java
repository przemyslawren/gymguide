package com.przemyslawren.gymguide.repository;

import com.przemyslawren.gymguide.model.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    Page<Exercise> findByNameContaining(String name, Pageable pageable);
}
