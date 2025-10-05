/*
 * Scenario: A teacher needs a program to validate and categorize student test 
 * scores. The program should ensure valid input and provide letter grades.
Requirements:

Create a Student class with private attributes: name (String) and score (double)
Implement getter and setter methods with proper encapsulation
In the setter for score, validate that the score is between 0-100 using data
validation
Create a constructor that takes name and score as parameters
Write a public method getLetterGrade() that returns the letter grade based on
score:

A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60


Use conditionals and logical operators for grade determination
In the main method, use a while loop with sentinel control to input multiple
students
Use a final variable for the sentinel value (-1)
Display each student's name, numeric score, and letter grade
Handle invalid input with appropriate error messages
 */

package Part2;

import java.util.Scanner;

public class GradeCalc {

    public static void main(String[] args) {
        int keepGoing = 1;
        double newScore;
        Scanner input2 = new Scanner(System.in);
        Student currentStudent = new Student("null", 0, input2);
        
        while (keepGoing != 0){
            //get the student's name
            System.out.print("Enter the student's name: ");
            currentStudent.changeName(input2.nextLine());

            //get the student's score
            System.out.printf(
                "Enter %s's score: ",
                currentStudent.getName()
                );
            newScore = input2.nextDouble();
            input2.nextLine();
            currentStudent.changeScore(newScore);


            //print out the user's name, score, and letter grade
            System.out.printf(
                "Name: %s\tScore: %.2f (%s)\n",
                currentStudent.getName(),
                currentStudent.getScore(),
                currentStudent.getLetterGrade()
            );

            //prompt the user to decide whether or not they want to go again
            System.out.print(
                "Enter 0 to stop entering students and 1 to" 
                    + " keep going: "
                );
            keepGoing = input2.nextInt();
            input2.nextLine();
        }

        input2.close();

    }
}

class Student {
    //initialize local variables
    private String name;
    private double score;
    private Scanner stuInput;

    public Student(String givenName, double marks, Scanner input) {
        //initialize the student with their name and score
        name = givenName;
        changeScore(marks);
        stuInput = input;
    }
    
    //allow programmer to access the values of name and score
    public String getName() {
        return name;
    }

    public double getScore(){
        return score;
    }

    //allow programmer to modify the name and score
    public void changeName(String newName) {
        name = newName;
    }

    //allow the user to modify the student's score
    public void changeScore(double newScore){
        //make sure the score is between 0 and 100
        while (newScore < 0 || newScore > 100) {
            System.out.printf(
            "%s's score must be between 0 and 100.\n",
            name
            );

            System.out.print("Please enter a new score: ");

            newScore = stuInput.nextDouble();
            stuInput.nextLine();
        }
        //update the score of self
        score = newScore;
    }

    //get the lettergrade

    public char getLetterGrade(){
        char grade;

        if (score >= 90){
            grade = 'A';
        }
        else if (score >= 80){
            grade = 'B';
        }
        else if (score >= 70){
            grade = 'C';
        }
        else if (score >= 60) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }

        return grade;

    }

}