package com.group18.quiz.repository;

import com.group18.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByLessonIdOrderById(Long lessonId);
}
