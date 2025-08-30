/*
 * Requirements:

Create an enumerated type for book categories: FICTION, NONFICTION, REFERENCE, DVD, AUDIOBOOK
Set different daily fine rates for each category:

Fiction/Nonfiction: $0.25 per day
Reference: $0.50 per day
DVD: $1.00 per day
Audiobook: $0.35 per day


Set maximum fine limits: $10.00 for books, $25.00 for DVDs/Audiobooks
Prompt for: borrower name, item title, category, number of days you had the book, number of renewals used
Calculate days overdue (each renewal adds 14 days to due date)
Apply appropriate daily fine rate up to the maximum limit
Use boolean variables to track if the item was returned on time
Display a detailed receipt showing: item info, days overdue, daily rate, calculated fine, and final amount owed
Handle edge cases like early returns (no fine) and maximum fine reached
Use final variables for constants like renewal period and maximum fines
 */

package Part1;

import java.util.Scanner;



public class FineCalculator {

    //instantiate enumerated type "Categories"
    //give it values Fiction, Nonfiction, reference, Dvd, audiobook 
    public enum Categories{
        FICTION, NONFICTION, REFERENCE, DVD, AUDIOBOOK
    }

    public static void main(String[] args) {

        //set the daily fine rates for each category as a constant variable
        final double BOOK_FINE = 0.25;
        final double REFERENCE_FINE = 0.50;
        final double DVD_FINE = 1.00;
        final double AUDIOBOOK_FINE = 0.35;

        //set maximum fine limits: $10(Books), $25 (other)
        final double BOOK_FINE_LIMIT = 10.00;
        final double MISC_FINE_LIMIT = 25.00;

        //instantiate scanner
        Scanner input = new Scanner(System.in);

        //prompt user for borrower name, save to variable name
        System.out.print("What is your name? > ");
        String name = input.nextLine();

        //prompt user for item title, save to variable title
        System.out.print("What is the title of the work you checked out? > ");
        String title = input.nextLine();

        //prompt user for category. Save value as an integer as var, categoryIndex.
        System.out.print(
            "Type in the number that corresponds to the category of the work"
                + "you checked out:\n"
                +"0: Fiction\n1: Non-fiction\n2: Reference\n3: DVD\n"
                + "4: Audiobook\n> "
            );

        int categoryIndex = input.nextInt();
        input.nextLine();

        //convert categoryIndex to Categories value based on number.
        //Save to category
        Categories category = Categories.values()[categoryIndex];

        //prompt the user for number of days they had the book
        System.out.print("How many days did you have the work? > ");
        int numDays = input.nextInt();
        input.nextLine();
        
        //prompt user for the number of returns used
        System.out.print("How many times have you returned the work? > ");
        int numTimesReturned = input.nextInt();
        input.nextLine();

        //close the input
        input.close();

        //set num overdue days to be <number of days they had the book>
        //- (<number of returns> + 1) * 14
        int numOverdueDays = numDays - (numTimesReturned + 1) * 14;

        if (numOverdueDays < 0){
            numOverdueDays = 0;
        }

        //delcare variable to see if there are any overdue days
        boolean isOverdue = numOverdueDays >= 1;

        //declare the fee variable
        double fee;

        //if the item is not overdue set return fee to 0
        if (!isOverdue){
            fee = 0;
        }
        //else, set the number of overdue days
        else{

            switch(category){
            //if item is Fiction/Nonfiction, the fee is $0.25 per overdue day
            case FICTION, NONFICTION:
                fee = BOOK_FINE * numOverdueDays;
                break;

            //else if item is Reference, the fee is $0.50 per overdue day
            case REFERENCE:
                fee = REFERENCE_FINE * numOverdueDays;
                break;

            //else if item is DVD, the fee is $1.00 per day
            case DVD:
                fee = DVD_FINE * numOverdueDays;
                break;

            //else if item is audiobook, the fee is $0.35 per day
            case AUDIOBOOK:
                fee = AUDIOBOOK_FINE * numOverdueDays;
                break;

            //else, there is no return fee
            default:
                fee = 0;

            }
        }
        
        //if book is non-fiction/fiction/audiobook & fee > $10, set fee to $10
        //else if fee > $25, set fee to $25
        switch (category) {
            case FICTION, NONFICTION, REFERENCE:
                if (fee > BOOK_FINE_LIMIT){
                    fee = 10;
                }
                break;
            default:
                if(fee > MISC_FINE_LIMIT){
                    fee = 25;
                }
                
        }

        //print out the name
        System.out.println(name);
        System.out.println("===================\n");

        //print out item info
        System.out.println("Item checked out: " + title + ": " + category);

        //print out number of overdue days
        System.out.println("Number of overdue days: " + numOverdueDays + "\n");

        //print out the daily rate for overdue fines
        System.out.print("Overdue fine daily rate: ");
        
        //print the fine that corresponds with each book title
        switch(category){
            case FICTION, NONFICTION:
                System.out.printf("$%.2f\n", BOOK_FINE);
                break;
            case REFERENCE:
                System.out.printf("$%.2f\n", REFERENCE_FINE);
                break;
            case DVD:
                System.out.printf("$%.2f\n", DVD_FINE);
                break;
            case AUDIOBOOK:
                System.out.printf("$%.2f\n", AUDIOBOOK_FINE);
                break;
            default:
                System.out.println("$0.00");
        }

        //print the calculated fine
        System.out.printf("Your fine: $%.2f\n", fee);

        //print final amount owed
        System.out.printf("Final amount owed: $%.2f\n", fee);
    }
}
