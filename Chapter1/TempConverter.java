/*
 * Requirements:

Ask the user to input a temperature in Fahrenheit
Convert the temperature to Celsius using the formula: C = (F - 32) × 5/9
Display both the original Fahrenheit temperature and the converted Celsius temperature
Round the Celsius result to 1 decimal place
Include appropriate labels and units in the output
 */

package Chapter1;

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args){
        //instantiate the scanner
        Scanner input = new Scanner(System.in);

        //ask the user for temperature in Farenheit
        System.out.print("Enter the temperature in Farenheit: ");

        double farenheit = input.nextDouble();
        input.nextLine();

        //close the input
        input.close();

        //Convert the temperature to celcius
        double celcius = (farenheit - 32) * (5.0/9.0);

        //Display the farenheit and celcius temperature
        //Celcius rounded to one decimal place. Include appropiate units
        System.out.printf(
            farenheit +
                " degrees farenheit is equal to %.1f degrees celcius.\n",
            celcius
            );
    }
}
