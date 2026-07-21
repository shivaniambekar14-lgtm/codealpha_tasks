 import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tracker tracker = new Tracker();

        System.out.println("===== Student Grade Tracker =====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 1; i <= n; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); // Consume newline

            tracker.addStudent(name, marks);
        }

        System.out.println();
        tracker.displayReport();

        sc.close();
    }
}
