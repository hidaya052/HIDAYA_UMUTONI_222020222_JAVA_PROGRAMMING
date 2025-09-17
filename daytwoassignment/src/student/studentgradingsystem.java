package student;
import java.util.Scanner;

public class studentgradingsystem {
    public static void main(String[] args) {
        Scanner sg = new Scanner(System.in);
        
        System.out.println("=== STUDENT GRADING SYSTEM ===");
        System.out.println("Enter student marks (0-100) or -1 to stop:");
        
        int totalStudents = 0;
        int passedStudents = 0;
        int failedStudents = 0;
        int mark;
        
        // While loop for unknown number of students
        while (true) {
            System.out.print("Enter mark for student " + (totalStudents + 1) + ": ");
            mark = sg.nextInt();
            
            // Check for sentinel value
            if (mark == -1) {
                break;
            }
            
            // Validate input
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark! Please enter between 0-100.");
                continue;
            }
            
            totalStudents++;
            
            // Determine grade
            String grade;
            if (mark >= 80) {
                grade = "A";
                passedStudents++;
            } else if (mark >= 70) {
                grade = "B";
                passedStudents++;
            } else if (mark >= 60) {
                grade = "C";
                passedStudents++;
            } else if (mark >= 50) {
                grade = "D";
                passedStudents++;
            } else {
                grade = "F";
                failedStudents++;
            }
            
            System.out.println("Grade: " + grade);
        }
        
        // Print summary report
        System.out.println("\n=== SUMMARY REPORT ===");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Passed: " + passedStudents);
        System.out.println("Failed: " + failedStudents);
        
        if (totalStudents > 0) {
            double passRate = (double) passedStudents / totalStudents * 100;
            System.out.print(passRate);
        } else {
            System.out.println("No students entered.");
        }
        
        sg.close();



	}

}
