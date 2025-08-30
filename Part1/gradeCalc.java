/*
 * Requirements:

Prompt the user to enter a numerical grade (0-100)
Use conditional statements to assign letter grades:

90-100: A
80-89: B
70-79: C
60-69: D
Below 60: F


Display the numerical grade and corresponding letter grade
Handle invalid input (grades outside 0-100 range) with an error message
 */

package Part1;

import java.util.Scanner;

public class gradeCalc {
    public static void main(String[] args) {
        //instantiate the scanner
        Scanner input = new Scanner(System.in);

        //prompt the user to enter a grade from 0 to 100
        System.out.print("Enter the grade percentage > ");

        //save grade to numGrade
        double numGrade = input.nextDouble();
        input.nextLine();

        //close scanner
        input.close();

        //declare a character variable, grade
        char grade;

        //if the grade is between 90 and 100, inclusive, assign 'A' to grade
        if (numGrade <= 100 && numGrade >= 90){
            grade = 'A';
        }
        // else if score >= 80, assign 'B' to grade
        else if (numGrade >= 80){
            grade = 'B';
        }
        // else if score >= 70, assign 'C' to grade
        else if (numGrade >= 70){
            grade = 'C';
        }
        // else if score >= 60, assign 'D' to grade
        else if (numGrade >= 60){
            grade = 'D';
        }
        // else if grade >= 0, assign 'F' to grade
        else if (numGrade >= 0){
            grade = 'F';
        }
        // else, print an error message and exit the function
        else{
            System.out.println(
                "Error: the value you inputed ("
                    + numGrade
                    +") is invalid."
            );

            return;
        }

        //print the final grade
        System.out.println(numGrade + "% is a grade " + grade);
    }
}
