/*
 * Requirements:
Core Functionality:

Get customer information: name, age, and day of visit
Allow customer to select one movie from 3 options:

Regular Movie ($12.50)
3D Movie ($16.75)
IMAX Movie ($19.25)


Allow customer to choose seating section:

Standard (no extra charge)
Premium (+$3.50)
VIP Recliner (+$7.00)


Ask how many tickets they want to purchase

Discount Logic:

Age-based discounts:

Children (under 13): 25% off
Seniors (65 and older): 20% off
Students (13-22): 15% off (ask for student ID confirmation with boolean)
Adults (23-64): no discount


Day-based discounts:

Tuesday: All tickets $8.00 (overrides other discounts)
Matinee discount: If movie time is before 5 PM, apply additional $2.50 off per ticket



Payment Processing:

Calculate subtotal before tax
Apply appropriate discounts using conditional statements
Add sales tax (8.75%)
Get payment amount from customer
Calculate change needed
Break down change into bills and coins ($20, $10, $5, $1, quarters, dimes, nickels, pennies)

Technical Requirements:

Use enumerated types for movie types and seating sections
Use final variables for all pricing constants and tax rates
Implement boolean variables for student ID check and matinee timing
Use proper variable casting when handling money calculations
Apply multiple conditional statements for discount calculations
Use string concatenation to build the receipt
Format all currency displays to show exactly 2 decimal places

Output Requirements:

Display a formatted receipt showing:

Customer name and visit day
Movie selection and seating choice
Number of tickets purchased
Base price per ticket
All discounts applied with amounts saved
Subtotal, tax amount, and final total
Payment received and change breakdown
Thank you message with customer's first name only


Use escape sequences (\n, \t) for proper receipt formatting
Include theater name and "Thank you for visiting!" message
 */

package MiniProjects;

import java.util.Scanner;
import java.lang.Math;

public class TicketCalculator {
    //create enumerated type for seating
    public enum Seating{
        STANDARD, PREMIUM, VIP
    }

    //create enumerated type for movie types
    public enum MovieType{
        REGULAR, THREED, IMAX
    }

    public enum DaysOfWeek{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        //initialize movie ticket price
        final float REGULAR_TICKET = 12.50f;
        final float THREED_TICKET = 16.75f;
        final float IMAX_TICKET = 19.25f;
        final float TUESDAY_PRICE = 8.00f;
        
        //initialize all discounts
        //these discounts are percentage off
        final float CHILD_DISCOUNT = 0.25f;
        final float SENIOR_DISCOUNT = 0.20f;
        final float STUDENT_DISCOUNT = 0.15f;
        //matinee disount is $2.50 off
        final float MATINEE_DISCOUNT = 2.50f;

        //initialize seating price
        final float PREMIUM_PRICE = 3.50f;
        final float VIP_PRICE = 7.00f;

        //initialize tax
        final float TAX = 0.0875f;

        //initialize hasID
        boolean hasID;

        //keep track of number of tickets the user wants
        int numTickets;

        //instantiate scanner
        Scanner input = new Scanner(System.in);

        //ask customer for their name, age, and day and time of visit
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("\nEnter your age: ");
        short age = input.nextShort();
        input.nextLine();

        //ask day of visit
        System.out.print(
            "\nEnter the number that corresponds"
                +"with which day you are going:\n"
                + "0: Sunday\n"
                + "1: Monday\n"
                + "2: Tuesday\n"
                + "3: Wednesday\n"
                + "4: Thursday\n"
                + "5: Friday\n"
                + "6: Saturday\n"
        );        

        DaysOfWeek visitDay = DaysOfWeek.values()[input.nextShort()];
        input.nextLine();

        //ask for time of visit

        System.out.print(
            "\nPut in the hour you "
                +"are going (24-hour time format): "
        );
        
        short hourOfVisit = input.nextShort();
        input.nextLine();

        //ask user for the seats they want
        System.out.print(
            "\nEnter the number that corresponds to your seat choice:\n"
                +"0: Standard\n1: Premium\n2: VIP\n> "
        );

        Seating userSeat = Seating.values()[input.nextShort()];
        input.nextLine();

        //ask for movie type
        System.out.print(
            "\nEnter the number that is the type of movie"
                +"you will be watching:\n"
                +"0: Regular\n1: 3D\n2: IMAX\n> "
        );

        MovieType userMovie = MovieType.values()[input.nextShort()];
        input.nextLine();

        //calculate the subtotal
        float subtotal;

        //initial price based off of movie type
        switch (userMovie){
            case REGULAR:{
                subtotal = REGULAR_TICKET;
                break;
            }

            case THREED:{
                subtotal = THREED_TICKET;
                break;
            }

            case IMAX:{
                subtotal = IMAX_TICKET;
                break;
            }
            default:{
                subtotal = 0;
            }
            
        }

        //add to the subtotal based on the seating type
        switch (userSeat){
            case PREMIUM:{
                subtotal += PREMIUM_PRICE;
                break;
            }
            
            case VIP:{
                subtotal += VIP_PRICE;
                break;
            }

            default:{
                subtotal += 0;
            }
        }

        System.out.print("Do you have a student ID?\n0: no\n1: yes\n> ");

        hasID = (input.nextInt() == 0)? false:true;
        input.nextLine();



        //apply age-based discounts
        if (age < 13){
            subtotal *= 1 - CHILD_DISCOUNT;
        }
        else if (age >= 65){
            subtotal *= 1 - SENIOR_DISCOUNT;
        }
        else if (age >= 13 && age < 23 && hasID){
            subtotal *= 1 - STUDENT_DISCOUNT;
        }

        //apply day/time-based discounts
        if (hourOfVisit < 17 && hourOfVisit >= 0){
            subtotal -= MATINEE_DISCOUNT;
        }

        if (visitDay == DaysOfWeek.TUESDAY){
            subtotal = TUESDAY_PRICE;
        }

        //ask user how many tickets they want
        System.out.print("How many tickets do you want? > ");
        numTickets = input.nextInt();
        input.nextLine();

        //calculate subtotal including number of tickets
        subtotal *= numTickets;

        //apply tax
        float total = subtotal * (1 + TAX);

        //ask user how much they paid
        System.out.printf("The total is %.2f.", total);

        System.out.print(" How much are you paying us? > ");
        float userPayment = input.nextFloat();
        input.nextLine();

        input.close();

        //calculate exact change needed
        float change = userPayment - total;

        //instantiate change tracker variables
        int num20s = 0;
        int num10s = 0;
        int num5s = 0;
        int num1s = 0;
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int numPennies = 0;

        if (change < 0){
            change = 0.0f;
        }
        else {
            //calculate the number of 20s remaining
            num20s = (int)((userPayment - total) / 20);
            float remainingChange = userPayment - (20 * num20s);

            //calculate the number of 10s remaining
            num10s = (int)((remainingChange - total) / 10);
            remainingChange -= 10 * num10s;

            //calculate the number of 5s remaining
            num5s = (int)((remainingChange - total) / 5);
            remainingChange -= 5 * num5s;

            //calculate the number of 1s remaining
            num1s = (int)((remainingChange - total) / 1);
            remainingChange -= 1 * num1s;

            //calculate the number of Quarters remaining
            numQuarters = (int)((remainingChange - total) / 0.25);
            remainingChange -= 0.25 * numQuarters;

            //calculate the number of dimes remaining
            numDimes = (int)((remainingChange - total) / 0.10);
            remainingChange -= 0.10 * numDimes;

            //calculate the number of nickels remaining
            numNickels = (int)((remainingChange - total) / 0.05);
            remainingChange -= 0.05 * numNickels;

            //calculate the number of pennies remaining
            numPennies = (int)((remainingChange - total) / 0.01);
            remainingChange -= 0.01 * numPennies;
        }
        

        //print reciept: customer name and day of visit
        System.out.println(
            "\n" + name 
                + "'s ticket for "
                + visitDay 
                + " at " 
                + hourOfVisit 
                + ":00"
        );

        System.out.println("-----------------------------------------\n");

        //Movie selection and seating choice
        System.out.println(
            "Movie type: " + userMovie
                + "\nSeat Choice: " + userSeat
        );

        //number of tickets purchased
        System.out.println("Number of tickets purchased: " + numTickets);

        //base price per ticket
        System.out.printf("Price per ticket: $%.2f\n", (subtotal/numTickets));

        //all discounts applied
        System.out.println("Discounts applied: ");

        if (age < 13){
            System.out.println("\t- Child discount (25% off)");
        }
        else if (age >= 65){
            System.out.println("\t- Senior Discount (20% off)");
        }
        else if (age >= 13 && age < 23 && hasID){
            System.out.println("\t- Student Discount (15% off)");
        }

        if (hourOfVisit < 17 && hourOfVisit >= 0){
            System.out.println("\t- Matinee Discount ($2.50 off)");
        }
        if (visitDay == DaysOfWeek.TUESDAY){
            System.out.println("\t- Tuesday Price: $8");
        }

        //subtotal
        System.out.printf("subtotal: $%.2f\n", subtotal);

        //tax
        System.out.println("tax: " + (TAX * 100) + "%");
        
        //final total
        System.out.printf("total: $%.2f\n", total);

        //payment recieved and change breakdown
        System.out.println(
            "Amount in Cash Change:\n" 
                + "20s: " + num20s
                + "\n10s: " + num10s
                + "\n5s: " + num5s
                + "\n1s: " + num1s
                + "\nQuarters: " + numQuarters
                + "\nDimes: " + numDimes
                + "\nnickels: " + numNickels
                + "\npennies: " + numPennies
            );

        //thank you message
        System.out.println("Thank you :)");


    }
}
