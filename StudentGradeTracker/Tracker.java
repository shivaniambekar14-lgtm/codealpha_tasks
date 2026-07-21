import java.util.ArrayList;

public class Tracker {

    private ArrayList<Student> students;

    // Constructor
    public Tracker() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(String name, int marks) {
        students.add(new Student(name, marks));
    }

    // Calculate average marks
    public double getAverage() {
        if (students.size() == 0) {
            return 0;
        }

        int total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        return (double) total / students.size();
    }

    // Find highest marks
    public int getHighest() {
        if (students.size() == 0) {
            return 0;
        }

        int highest = students.get(0).getMarks();

        for (Student s : students) {
            if (s.getMarks() > highest) {
                highest = s.getMarks();
            }
        }

        return highest;
    }

    // Find lowest marks
    public int getLowest() {
        if (students.size() == 0) {
            return 0;
        }

        int lowest = students.get(0).getMarks();

        for (Student s : students) {
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
            }
        }

        return lowest;
    }

    // Display report
    public void displayReport() {

        System.out.println("\n------ Student Report ------");

        for (Student s : students) {
            System.out.println("Name : " + s.getName() +
                               " | Marks : " + s.getMarks());
        }

        System.out.println("----------------------------");
        System.out.println("Average Marks : " + getAverage());
        System.out.println("Highest Marks : " + getHighest());
        System.out.println("Lowest Marks  : " + getLowest());
    }
}