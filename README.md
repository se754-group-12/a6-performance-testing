# Quiz Feedback Submission

A Spring Boot service that delivers immediate, explanatory feedback to learners submitting answers to quiz questions.

## Running

```bash
./mvnw spring-boot:run
```

The service listens on `http://localhost:8080`.

## Submitting an answer

POST a JSON body with an `answer` field to `/api/quizzes/{quizId}/submit`:

```bash
curl -X POST http://localhost:8080/api/quizzes/q1/submit \
     -H "Content-Type: application/json" \
     -d '{"answer": "true"}'
```

The response is JSON with three fields: a boolean `correct`, a short `feedback` message, and a longer `explanation`. Blank answers return 400. Unknown quiz IDs return 404. A `GET /api/quizzes/health` endpoint returns `{"status":"ok"}` for liveness checks.
