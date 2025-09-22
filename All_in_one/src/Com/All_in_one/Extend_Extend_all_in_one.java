package Com.All_in_one;

import java.util.Scanner;

public class Extend_Extend_all_in_one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many students are in your class?");
        int numStd = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        String[] studentnames = new String[numStd];
        
        // Add names of the students
        for (int i = 0; i < numStd; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            studentnames[i] = sc.nextLine();
        }
        
        System.out.println("How many courses are there?");
        int numcourse = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        String[] courses = new String[numcourse];
        double[] marks = new double[numcourse];
        double totalmarks = 0;
        double average = 0;
        double overhundred = 0;
        char category = 'A';
        
        // Add course names
        for (int i = 0; i < numcourse; i++) {
            System.out.println("Enter course name " + (i + 1) + ":");
            courses[i] = sc.nextLine();
        }
        
        // Add marks for each course
        for (int i = 0; i < numcourse; i++) {
            System.out.println("Enter marks for: " + courses[i]);
            marks[i] = sc.nextDouble();
            totalmarks += marks[i];
        }
        
        // Calculate average and percentage
        average = totalmarks / numcourse;
        overhundred = (totalmarks * 100) / (numcourse * 100);
        
        // Determine category
        if (average >= 80) {
            category = 'A';
        } else if (average >= 70) {
            category = 'B';
        } else if (average >= 60) {
            category = 'C';
        } else if (average >= 50) {
            category = 'D';
        } else {
            category = 'F';
        }
        
        // Display results
        System.out.println("courses name\tmarks");
        System.out.println("---------------------------------------");
        
        for (int i = 0; i < numcourse; i++) {
            System.out.println(courses[i] + "\t\t" + marks[i]);
        }
        
        System.out.println("---------------------------------------");
        System.out.println("Total marks: " + totalmarks + " which is " + overhundred + "%");
        System.out.println("Average: " + average);
        System.out.println("Category: " + category);
        
        sc.close();
    }
}
