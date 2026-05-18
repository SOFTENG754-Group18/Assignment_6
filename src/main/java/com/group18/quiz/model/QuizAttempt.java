package com.group18.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lessonId;
    private int score;
    private int total;
    private double percentage;
    private boolean passed;
    private Instant submittedAt;

    protected QuizAttempt() {
    }

    public QuizAttempt(Long lessonId, int score, int total, double percentage, boolean passed) {
        this.lessonId = lessonId;
        this.score = score;
        this.total = total;
        this.percentage = percentage;
        this.passed = passed;
        this.submittedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }
}
