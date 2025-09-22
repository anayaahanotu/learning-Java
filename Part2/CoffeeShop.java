/*
 * Scenario: You work at a coffee shop and need to create a program that calculates the total cost of a customer's order, including tax.
Requirements:

Declare and initialize variables for coffee price ($3.50), pastry price ($2.25), and tax rate (8.5%)
Use Scanner to get user input for number of coffees and pastries ordered
Use math operators to calculate subtotal, tax amount, and final total
Use casting to ensure proper decimal calculations
Format and display the receipt using printf() with proper decimal places
Include at least one comment explaining the tax calculation
Use appropriate data types (double for prices, int for quantities)
 */

 package Part2;

 import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        //define the prices of coffee, pastries, and tax rate
        final float COFFEE_PRICE = 3.50f;
        final float PASTRY_PRICE = 2.25f;
        final float TAX = 0.085f;

        //initialize variables to keep track of the amount of coffees
        int numCoffees, numPastries;

        //initialize variables to keep track of the price
        double subtotal, taxPrice, finalTotal;

        //initialize scanner
        Scanner input = new Scanner(System.in);

        //prompt the user for number of coffees they are ordering 
        //--> assign to numCoffies
        System.out.print("How many coffees are you ordering? > ");
        numCoffees = input.nextInt();
        input.nextLine();

        //prompt the user for the number of pastries they are ordering
        // --> assign to numPastries
        System.out.print("How many pastries are you ordering? > ");
        numPastries = input.nextInt();
        input.nextLine();

        //calculate the subtotal
        subtotal = numCoffees * COFFEE_PRICE;
        subtotal += numPastries * PASTRY_PRICE;

        //calculate the tax amount
        taxPrice = subtotal * (1 + TAX);

        //calculate the final total
        finalTotal = taxPrice + subtotal;



        //close the scanner
        input.close();


    }
    
}
