/*
 * Requirements:

Prompt the user to enter a password
Check the password length (minimum 8 characters)
Verify the password contains at least one uppercase letter
Verify the password contains at least one lowercase letter
Verify the password contains at least one digit
Use boolean variables to track each requirement
Display whether the password is "Strong" or "Weak" based on meeting all criteria
Show which specific requirements are missing if the password is weak
 */

 package Part1;

 import java.util.Scanner;

 public class PasswordChecker{
    public static void main(String[] args){
        //instantiate scanner
        Scanner input = new Scanner(System.in);

        //prompt the user to enter a password
        System.out.print("Enter a password: ");

        //save password to variable, password
        String password = input.nextLine();

        input.close();
        //declare hasEightChar that checks the length of the password
        boolean hasEightChar = password.length() >= 8;

        //declare hasUpperCase that tracks if there is an upper case letter
        boolean hasUpperCase = false;

        //declare hasLowerCase that tracks if ther is a lower case letter
        boolean hasLowerCase = false;

        //declare hasNumber that tracks if there is least one digit
        boolean hasNumber = false;

        //iterate through each character in the string
        for(int i = 0; i < password.length(); i++){
            //declare a variable to represent the character
            char currentCharacter = password.charAt(i);

            //if the variable is uppercase: set hasUpperCase to True
            if (Character.isUpperCase(currentCharacter)){
                hasUpperCase = true;
            }

            //if the variable is lowercase: set hasLowerCase to True
            if (Character.isLowerCase(currentCharacter)){
                hasLowerCase = true;
            }

            //if the variable is numeric: set hasNumber to True
            if (Character.isDigit(currentCharacter)){
                hasNumber = true;
            }
        }

        //if all conditions are met: state there is a strong number
        if (hasEightChar && hasLowerCase && hasUpperCase && hasNumber){
            System.out.println("\nPassword is strong.");
        }

        //else; all conditions are not met
        //tell user the issue.
        else{   
            //if the length of the password < 8 char, state password is weak & why
            if (!hasEightChar){
                System.out.println(
                    "\nYour password is weak. "
                        + "You need at least 8 characters"
                );
            }

            //if there is no upper case letter, say the password is weak. state why
            if(!hasUpperCase){
                System.out.println(
                    "\nPassword is weak. "
                        + "You need at least one uppercase letter"
                );
            }

            //if there is no lowercase letter, state weak password. State why
            if(!hasLowerCase){
                System.out.println(
                    "\nPassword is weak. "
                        + "You need at least one lowercase letter"
                );
            }

            //if there is no number, state weak password. state why
            if (!hasNumber){
                System.out.println(
                    "\nPassword is weak. "
                        + "You need at least one number"
                );
            }

        }

    }
 }