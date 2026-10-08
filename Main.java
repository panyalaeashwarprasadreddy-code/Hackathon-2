import java.util.Scanner;

class Student {
    // Data members
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    // Method to calculate scholarship amount
    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (marks >= 85) {
            return totalFee * 0.20; // 20% scholarship
        } else if (marks >= 70) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after deducting scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display student and course details
    public void displayDetails() {
        System.out.println("\n-------------------------------------------");
        System.out.println("      STUDENT REGISTRATION DETAILS");
        System.out.println("-------------------------------------------");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks Obtained     : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.printf("Total Fee          : Rs. %.2f\n", calculateFee());
        System.out.printf("Scholarship        : Rs. %.2f\n", calculateScholarship());
        System.out.printf("Final Fee Payable  : Rs. %.2f\n", calculateFinalFee());
        System.out.println("-------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Student and Course Details
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Create Student object using the parameterized constructor
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        // Check eligibility and take action accordingly
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\n-------------------------------------------");
            System.out.println("Registration Failed: Student " + studentName + 
                               " is NOT eligible for course registration due to low marks (Minimum required: 50).");
            System.out.println("-------------------------------------------");
        }

        scanner.close();
    }
}