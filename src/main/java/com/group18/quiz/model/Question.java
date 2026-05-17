package com.group18.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Question {

    @Id
    private Long id;

    private Long lessonId;

    private String text;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private int correctIndex;

    protected Question() {
    }

    public Long getId() {
        return id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return List.of(option1, option2, option3, option4);
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
