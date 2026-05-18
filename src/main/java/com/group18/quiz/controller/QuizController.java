package com.group18.quiz.controller;

import com.group18.quiz.dto.FeedbackItem;
import com.group18.quiz.dto.QuestionView;
import com.group18.quiz.dto.QuizResponse;
import com.group18.quiz.dto.SubmitRequest;
import com.group18.quiz.dto.SubmitResponse;
import com.group18.quiz.model.Question;
import com.group18.quiz.model.QuizAttempt;
import com.group18.quiz.repository.LessonRepository;
import com.group18.quiz.repository.QuestionRepository;
import com.group18.quiz.repository.QuizAttemptRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private static final double PASS_THRESHOLD = 70.0;

    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;
    private final QuizAttemptRepository attemptRepository;

    public QuizController(LessonRepository lessonRepository,
                          QuestionRepository questionRepository,
                          QuizAttemptRepository attemptRepository) {
        this.lessonRepository = lessonRepository;
        this.questionRepository = questionRepository;
        this.attemptRepository = attemptRepository;
    }

    @GetMapping("/{lessonId}")
    public QuizResponse getQuiz(@PathVariable Long lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson " + lessonId + " not found");
        }
        List<QuestionView> questions = new ArrayList<>();
        for (Question q : questionRepository.findByLessonIdOrderById(lessonId)) {
            questions.add(new QuestionView(q.getId(), q.getText(), q.getOptions()));
        }
        return new QuizResponse(lessonId, questions);
    }

    @PostMapping("/{lessonId}/submit")
    public SubmitResponse submitQuiz(@PathVariable Long lessonId, @RequestBody SubmitRequest request) {
        if (!lessonRepository.existsById(lessonId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson " + lessonId + " not found");
        }

        List<Question> questions = questionRepository.findByLessonIdOrderById(lessonId);
        List<Integer> answers = request.answers() == null ? List.of() : request.answers();

        int score = 0;
        List<FeedbackItem> feedback = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            boolean correct = i < answers.size()
                    && answers.get(i) != null
                    && answers.get(i) == q.getCorrectIndex();
            if (correct) {
                score++;
            }
            feedback.add(new FeedbackItem(q.getId(), correct));
        }

        int total = questions.size();
        double percentage = total == 0 ? 0.0 : Math.round(score * 1000.0 / total) / 10.0;
        boolean passed = percentage >= PASS_THRESHOLD;

        attemptRepository.save(new QuizAttempt(lessonId, score, total, percentage, passed));

        return new SubmitResponse(score, total, percentage, passed, feedback);
    }
}
