package com.group18.quiz.dto;

import java.util.List;

public record QuizResponse(Long lessonId, List<QuestionView> questions) {
}
