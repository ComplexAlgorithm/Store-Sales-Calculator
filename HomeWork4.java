/*
 * Create a modular program using structured programming to store the amount of money a local
store made in sales for each day of the past week. The user will be given the option to enter an
amount for the next day, compute the average, find the highest amount, find the lowest amount,
or print all the information including the daily sales with the average, highest, and lowest
amount.
When the user chooses an option to enter an amount for the next day, the user will be prompted
to enter the amount. The amount must be greater than or equal to 0. If a negative amount is
entered the user will be given an error message and prompted to enter a value greater than or
equal to 0 for the same day. Once the user has entered a value greater than or equal to 0, that
amount will be saved. If the user attempts to enter more than seven days the program will give
the user an error message informing them the information for the entire week has already been
entered.
If the user chooses to compute the average, find the highest amount, or find the lowest amount
that amount will be printed to screen.
This program will only have one class which has static methods and uses a single array of size
seven to save the daily sales amounts. There should be a main method, a static method to get an
amount from the user, compute the average, find the lowest amount, find the highest amount, and
print out all the information.

Design:
1. Create array to hold 7 slots to save daily sales amounts
2. Create number of days variable and set to 0 
3. Create option variable
4. Do
5. Create options==>1. amount for next day;2. compute average; 3.highest amount; 4. lowest amount; 5.print all info;6. end
6. Save options
7. Create static methods for amount for user, compute average, find lowest amount, highest amount, print all info

 */
import java.util.Scanner;
public class HomeWork4 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double [] salesArray = new double [7];
		int option;
		int numberOfDays = 0;
		do {
			System.out.println("Press 1 to enter the amount of sales for the next day.");
			System.out.println("Press 2 to compute the average of the sales.");
			System.out.println("Press 3 to find the lowest amount.");
			System.out.println("Press 4 to find the highest amount.");
			System.out.println("Press 5 to print all information out.");
			System.out.println("Press 6 to end program.");
			option = keyboard.nextInt();
			
			if(option == 1) {
				if(numberOfDays < 7) {
					numberOfDays = enterAmount(salesArray, numberOfDays);
				}
				else {
					System.out.println("All sales amounts have been entered for this week.");
				}
			}
			else if(option == 2) {
				double average = computeAverage(salesArray, numberOfDays);
				System.out.println("The sales average is: " + average);
			}
			else if(option == 3) {
				double lowestAmount = findLowestAmount(salesArray, numberOfDays);
				System.out.println("The lowest amount is: " + lowestAmount);
			}
			else if(option == 4) {
				double highestAmount = findHighestAmount(salesArray, numberOfDays);
				System.out.println("The highest amount is:  " + highestAmount);
			}
			else if(option == 5) {
				print(salesArray, numberOfDays);
			}
			else if(option == 6) {
				System.out.println("Goodbye!");
			}
			else {
				System.out.println("Error! Please type a valid option!");
			}
		}while(option != 6);

	}
	//Prompt user to enter amount
	//save amount
	//amount must be >= 0
	//while / if amount < 0 --> print error message and prompt user to enter amount >= 0
	//if user enters > 7 days ---> print error message and let user know the weeks info has been filled already
	public static int enterAmount(double [] sArray, int index) {
		Scanner keyboard = new Scanner(System.in);
		double amount;
		do {
			System.out.println("Enter the sales amount for the next day.");
			amount = keyboard.nextDouble();
			if(amount < 0) 
				System.out.println("Error! You cannot enter an amount less than 0!");
			
		}while(amount < 0);
		sArray[index] = amount;
		index++;
		return index;
	}
	
	public static double computeAverage(double [] salesArray, int numberOfDays) {
		double sum = 0.0;
		double average = 0.0;
		for(int index = 0; index < numberOfDays; index++) {
			sum = sum + salesArray[index];
		}
		if(numberOfDays > 0) { 
			average = sum / (double)numberOfDays;
		}
		return average;
	}
	public static double findLowestAmount(double [] Array, int numberOfDays) {
		Scanner keyboard = new Scanner(System.in);
		double lowestAmount = Array[0];
		for(int i = 0; i < numberOfDays; i++) {
			if(Array[i] < lowestAmount) 
				lowestAmount = Array[i];
		}
		return lowestAmount;
	}
	public static double findHighestAmount(double [] myArray, int days) {
		Scanner keyboard = new Scanner(System.in);
		double highestAmount = myArray[0];
		for(int i = 0; i < days; i++) {
			if(myArray[i] > highestAmount)
				highestAmount = myArray[i];
		}
		return highestAmount;
	}
	public static void print(double [] salesArray, int numberOfDays) {
		for(int i = 0; i < numberOfDays; i++) {
			System.out.println("Amount of sales for this day: " + salesArray[i]);
		}
		System.out.println("The average is: " + computeAverage(salesArray,numberOfDays));
		System.out.println("The lowest amount is: " + findLowestAmount(salesArray, numberOfDays));
		System.out.println("The highest amount is: " + findHighestAmount(salesArray, numberOfDays));
	}
	
}
