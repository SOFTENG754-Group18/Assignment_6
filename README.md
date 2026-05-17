# Assignment_6 — Quiz Submission Feature (Group 18)

Spring Boot REST API for the Quiz Submission feature (US-17), used for
SOFTENG 754 Assignment 6 performance testing.

## Quiz endpoint

- `GET /api/quiz/{lessonId}` — returns the lesson's questions and answer
  options as JSON (`200`, or `404` if the lesson does not exist).
- `POST /api/quiz/submit` — accepts `{"lessonId":1,"answers":[0,1,1]}`,
  scores the attempt against stored correct answers, persists it, and
  returns `score`, `total`, `percentage`, `passed` (70% threshold) and
  per-question `feedback`.

Three lessons (IDs 1–3), each with three questions, are seeded on startup.

## How to run

Requires Java 17. Maven is not needed — use the bundled wrapper:

```
./mvnw spring-boot:run        # macOS / Linux
mvnw.cmd spring-boot:run      # Windows
```

The app starts on `http://localhost:8080`.
