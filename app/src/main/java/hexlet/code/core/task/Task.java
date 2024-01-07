package hexlet.code.core.task;

public final class Task {
    private final String question;
    private final String answer;

    private Task(String quest, String ans) {
        question = quest;
        answer = ans;
    }

    public static Task of(String quest, String ans) {
        return new Task(quest, ans);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
