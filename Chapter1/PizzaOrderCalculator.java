/*
 * Requirements:

Prompt the user to enter the number of pizzas they want to order
Each pizza costs $12.99
Calculate and display the subtotal
Add 8.5% sales tax to the subtotal
Display the final total amount
Format all monetary values to 2 decimal places
 */

package Chapter1;

import java.util.Scanner;

public class PizzaOrderCalculator {
    public static void main(String[] args) {
        //instantiate scanner
        Scanner input = new Scanner(System.in);

        //set the pizza cost as a constant variable
        final double PIZZA_COST = 12.99;

        //set sales tax to a constant variable
        final double SALES_TAX = 0.085;

        //ask user to input how many pizzas to order. save value to num Pizzas
        System.out.print("How many pizzas would you like to order: ");

        int numPizzas = input.nextInt();
        input.nextLine();

        input.close();
        
        //multiply the number of pizzas by the cost
        double total = numPizzas * PIZZA_COST;

        //display the subtotal
        System.out.printf("The total price is $%.2f\n", total);

        //multiply by sales tax
        total *= (1 + SALES_TAX);

        //display the final total rounded to 2 decimal places
        System.out.printf("The total cost is $%.2f\n", total);


    }
}
