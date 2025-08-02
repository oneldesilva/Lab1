import java.util.Scanner;

public class Marks {
    static int[][] studentMarks; // studentMarks[studentID][subjectID]
    static int n; // number of students

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        n = sc.nextInt();
        studentMarks = new int[n + 1][4]; 

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student marks: add [studentID]");
            System.out.println("2. Update student mark: update [studentID] [subjectID]");
            System.out.println("3. Get the average for a subject: average_s [subjectID]");
            System.out.println("4. Get the average for a student: average [studentID]");
            System.out.println("5. Get the total mark of a student: total [studentID]");
            System.out.println("6. Display grades of all students: grades");
            System.out.println("7. Exit");

            System.out.print("Enter command: ");
            String command = sc.next();

            if (command.equalsIgnoreCase("add")) {
                int id = sc.nextInt();
                if (id >= 1 && id <= n) {
                    System.out.print("Enter marks for Maths, Chemistry, Physics: ");
                    for (int i = 1; i <= 3; i++) {
                        studentMarks[id][i] = sc.nextInt();
                    }
                    System.out.println("Marks added.");
                } else {
                    System.out.println("Invalid student ID.");
                }
            } else if (command.equalsIgnoreCase("update")) {
                int id = sc.nextInt();
                int subject = sc.nextInt();
                if (id >= 1 && id <= n && subject >= 1 && subject <= 3) {
                    System.out.print("Enter new mark: ");
                    studentMarks[id][subject] = sc.nextInt();
                    System.out.println("Mark updated.");
                } else {
                    System.out.println("Invalid input.");
                }
            } else if (command.equalsIgnoreCase("average_s")) {
                int subject = sc.nextInt();
                if (subject >= 1 && subject <= 3) {
                    double total = 0;
                    for (int i = 1; i <= n; i++) {
                        total += studentMarks[i][subject];
                    }
                    System.out.printf("Average for subject %d: %.2f\n", subject, total / n);
                } else {
                    System.out.println("Invalid subject ID.");
                }
            } else if (command.equalsIgnoreCase("average")) {
                int id = sc.nextInt();
                if (id >= 1 && id <= n) {
                    double total = 0;
                    for (int i = 1; i <= 3; i++) {
                        total += studentMarks[id][i];
                    }
                    System.out.printf("Average for student %d: %.2f\n", id, total / 3);
                } else {
                    System.out.println("Invalid student ID.");
                }
            } else if (command.equalsIgnoreCase("total")) {
                int id = sc.nextInt();
                if (id >= 1 && id <= n) {
                    int total = 0;
                    for (int i = 1; i <= 3; i++) {
                        total += studentMarks[id][i];
                    }
                    System.out.printf("Total marks for student %d: %d\n", id, total);
                } else {
                    System.out.println("Invalid student ID.");
                }
            } else if (command.equalsIgnoreCase("grades")) {
                System.out.println("\nGrades Summary:");
                System.out.printf("%-10s %-12s %-12s %-12s\n", "StudentID", "Maths", "Chemistry", "Physics");

                for (int i = 1; i <= n; i++) {
                    String mathsGrade = getGrade(studentMarks[i][1]);
                    String chemGrade = getGrade(studentMarks[i][2]);
                    String physGrade = getGrade(studentMarks[i][3]);

                    System.out.printf("%-10d %-12s %-12s %-12s\n", i, mathsGrade, chemGrade, physGrade);
                }
            } else if (command.equalsIgnoreCase("7") || command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }

        sc.close();
    }

    // Helper method to convert marks to grades
    public static String getGrade(int mark) {
        if (mark >= 90) return "Grade A";
        else if (mark >= 80) return "Grade B";
        else if (mark >= 70) return "Grade C";
        else if (mark >= 60) return "Grade D";
        else return "Fail";
    }
}
