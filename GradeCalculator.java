import java.util.Scanner;

public class GradeCalculator {

    public static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take marks obtained (out of 100) in each subject
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = sc.nextInt();
        double[] marks = new double[numOfSubjects];
        
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();
        }

        // Calculates Total Marks
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        // Calculates Average Percentage
        double averagePercentage = totalMarks / numOfSubjects;

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Displaying Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        
        sc.close();
    }
}
