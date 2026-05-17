package com.group18.quiz.dto;

import java.util.List;

public record SubmitResponse(int score, int total, double percentage, boolean passed,
                             List<FeedbackItem> feedback) {
}
