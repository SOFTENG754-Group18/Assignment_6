package com.group18.quiz.dto;

import java.util.List;

public record SubmitRequest(Long lessonId, List<Integer> answers) {
}
