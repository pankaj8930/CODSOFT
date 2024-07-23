import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}

class Student {
    private String studentId;
    private String studentName;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course " + course.getCourseCode() + " registered successfully!");
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println("Course " + course.getCourseCode() + " dropped successfully!");
    }
}

public class StudentCourseRegistrationSystem {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public StudentCourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void registerStudentForCourse(Student student, Course course) {
        student.registerCourse(course);
    }

    public void dropStudentFromCourse(Student student, Course course) {
        student.dropCourse(course);
    }

    public void displayStudentCourses(Student student) {
        System.out.println("Courses registered by " + student.getStudentName() + ":");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName() + " (" + course.getCredits() + " credits)");
        }
    }

    public static void main(String[] args) {
        StudentCourseRegistrationSystem system = new StudentCourseRegistrationSystem();

        // Add courses
        system.addCourse(new Course("CS101", "Introduction to Computer Science", 3));
        system.addCourse(new Course("MATH102", "Calculus II", 4));
        system.addCourse(new Course("ENGL103", "English Composition", 3));

        // Add students
        system.addStudent(new Student("S101", "John Doe"));
        system.addStudent(new Student("S102", "Jane Smith"));

        // Register students for courses
        system.registerStudentForCourse(system.students.get(0), system.courses.get(0));
        system.registerStudentForCourse(system.students.get(0), system.courses.get(1));
        system.registerStudentForCourse(system.students.get(1), system.courses.get(2));

        // Display student courses
        system.displayStudentCourses(system.students.get(0));
        system.displayStudentCourses(system.students.get(1));

        // Drop student from course
        system.dropStudentFromCourse(system.students.get(0), system.courses.get(1));

        // Display student courses again
        system.displayStudentCourses(system.students.get(0));
    }
}
