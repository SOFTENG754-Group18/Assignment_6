package com.group18.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Lesson {

    @Id
    private Long id;

    private String title;

    protected Lesson() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
