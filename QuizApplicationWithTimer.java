import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT = 30; // 30 seconds
    private static final int NUM_QUESTIONS = 5;

    private static String[] questions = {
        "What is the capital of France?",
        "Who is the CEO of Tesla?",
        "What is the largest planet in our solar system?",
        "Who is the author of 'To Kill a Mockingbird'?",
        "What is the chemical symbol for gold?"
    };

    private static String[] answers = {
        "Paris",
        "Elon Musk",
        "Jupiter",
        "Harper Lee",
        "Au"
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Timer timer = new Timer();

        int score = 0;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                System.exit(0);
            }
        }, TIME_LIMIT * 1000); // convert seconds to milliseconds

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            String userAnswer = input.nextLine();

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + answers[i]);
            }
        }

        timer.cancel();

        System.out.println("Your final score is " + score + " out of " + NUM_QUESTIONS);
    }
}
