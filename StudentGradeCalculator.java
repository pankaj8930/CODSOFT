import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = input.nextLine();

        System.out.print("Enter student's score in Math (out of 100): ");
        int mathScore = input.nextInt();

        System.out.print("Enter student's score in Science (out of 100): ");
        int scienceScore = input.nextInt();

        System.out.print("Enter student's score in English (out of 100): ");
        int englishScore = input.nextInt();

        int totalScore = mathScore + scienceScore + englishScore;
        double averageScore = totalScore / 3.0;

        String grade;
        if (averageScore >= 90) {
            grade = "A";
        } else if (averageScore >= 80) {
            grade = "B";
        } else if (averageScore >= 70) {
            grade = "C";
        } else if (averageScore >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Student's Name: " + name);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);
    }
}
