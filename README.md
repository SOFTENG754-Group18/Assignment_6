# Assignment_6 — Quiz Submission Feature (Group 18)

Spring Boot REST API for the Quiz Submission feature (US-17).

## Quiz endpoint

- `GET /api/quiz/{lessonId}` — returns the lesson's questions and options as JSON; `200`, or `404` if the lesson is unknown.
- `POST /api/quiz/{lessonId}/submit` — body `{"answers":[0,1,1]}`; scores the attempt against stored answers and returns `score`, `total`, `percentage`, `passed` (70% threshold) and per-question `feedback`.

Three lessons, three questions each, are seeded at startup.

## Run

Requires Java 17. Use the bundled Maven Wrapper:

    ./mvnw spring-boot:run     (macOS/Linux)
    mvnw.cmd spring-boot:run   (Windows)

Starts on http://localhost:8080.
