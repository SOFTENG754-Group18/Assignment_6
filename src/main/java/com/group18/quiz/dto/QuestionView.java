package com.group18.quiz.dto;

import java.util.List;

public record QuestionView(Long id, String text, List<String> options) {
}
