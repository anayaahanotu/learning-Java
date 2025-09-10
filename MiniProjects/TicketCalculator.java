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

public class TicketCalculator {
    //create enumerated type for seating

    //create enumerated type for movie types

    public static void main(String[] args) {
        //initialize movie ticket price
        float REGULAR_TICKET = 12.50f;
        float THREED_TICKET = 16.75f;
        float IMAX_TICKET = 19.25f;
        
        //initialize all discounts
        float CHILD_DISCOUNT = 0.25f;
        float SENIOR_DISCOUNT = 0.20f;
        float STUDENT_DISCOUNT = 0.15f;

        //initialize seating price

        //initialize tax
        //initialize hasID

        //ask customer for their name, age, and day and time of visit

        //calculate the subtotal
        //apply discounts
        //apply tax
        //ask user how much they paid
        //calculate exact change needed
        

        //print reciept: customer name and day of visit
        //Movie selection and seating choice
        //number of tickets purchased
        //base price per ticket
        //all discounts applied
        //subtotal
        //tax
        //final total
        //payment recieved and change breakdown
        //thank you message

    }
}
