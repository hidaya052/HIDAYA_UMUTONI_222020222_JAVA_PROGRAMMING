package classattendance;
import java.util.Scanner;

public class classattendancetracker {
    public static void main(String[] args) {
        Scanner ca = new Scanner(System.in);
        
        System.out.println("=== CLASS ATTENDANCE TRACKER ===");
        
        // Get total number of students
        System.out.print("Enter total number of students in the class: ");
        int totalStudents = ca.nextInt();
        
        // Array to store daily attendance (max 30 days)
        int[] attendance = new int[30];
        int dayCount = 0;
        String continueInput = null;
        
        // Do-while loop for daily attendance
        do {
            System.out.print("Enter number of students present for day " + (dayCount + 1) + ": ");
            int present = ca.nextInt();
            
            // Validate input
            if (present < 0 || present > totalStudents) {
                System.out.println("Invalid input! Must be between 0 and " + totalStudents);
                continue;
            }
            
            attendance[dayCount] = present;
            dayCount++;
            
            // Check if we've reached maximum days
            if (dayCount >= 30) {
                System.out.println("Maximum 30 days reached.");
                break;
            }
            
            System.out.print("Enter attendance for another day? (yes/no): ");
            continueInput = ca.next().toLowerCase();
            
        } while (continueInput.equals("yes") || continueInput.equals("y"));
        
        // Calculate statistics
        int totalAttendance = 0;
        int lowAttendanceDays = 0;
        
        System.out.println("\n=== ATTENDANCE REPORT ===");
        System.out.println("Day\tPresent\tPercentage");
        System.out.println("---------------------------");
        
        for (int i = 0; i < dayCount; i++) {
            double percentage = (double) attendance[i] / totalStudents * 100;
            totalAttendance += attendance[i];
            
            System.out.print(i + 1);
            
            // Check for low attendance (below 50%)
            if (percentage < 50) {
                lowAttendanceDays++;
            }
        }
        
        // Calculate averages and percentages
        if (dayCount > 0) {
            double averageAttendance = (double) totalAttendance / dayCount;
            System.out.println("---------------------------");
            System.out.print(averageAttendance);
            System.out.print(lowAttendanceDays);
        } else {
            System.out.println("No attendance data recorded.");
        }
        
        ca.close();
    }
}


