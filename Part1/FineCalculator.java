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
    public static void main(String[] args) {
        //instantiate enumerated type "Categories" 
        //give it values Fiction, Nonfiction, reference, Dvd, audiobook

        //set the daily fine rates for each category as a constant variable

        //set maximum fine limits: $10(Books), $25 (other)

        //prompt user for borrower name, save to variable name

        //prompt user for item title, save to variable title

        //prompt user for category. Save value as an integer as var, category.

        //convert category to Categories value based on number

        //prompt the user for number of days they had the book
        
        //prompt user for the number of returns used

        //set num overdue days to be <number of days they had the book>
        //- (<number of returns> + 1) * 14

        //delcare variable to see if there are any overdue days

        //if the number of overdue days is less than 1, set return fee to 0
        //else, set the number of overdue days
            //if item is Fiction/Nonfiction, the fee is $0.25 per overdue day
            //else if item is Reference, the fee is $0.50 per overdue day
            //else if item is DVD, the fee is $1.00 per day
            //else if item is audiobook, the fee is $0.35 per day

        //if book is non-fiction/fiction/audiobook & fee > $10, set fee to $10
        //else if fee > $25, set fee to $25

        //print out the name
        //print out item info
        //print out number of overdue days
        //print out the daily rate for overdue fines
        //print the calculated fine
        //print the final amount owed
    }
}
