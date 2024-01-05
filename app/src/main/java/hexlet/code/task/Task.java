package hexlet.code.task;

public final class Task {
    private final String question;
    private final String answer;

    public Task(String quest, String ans) {
        question = quest;
        answer = ans;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
