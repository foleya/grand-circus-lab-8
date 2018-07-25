package co.grandcircus.lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDictionary {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// Initialize "Database"
		String[] students = { "Abbie", "Brad", "Carly", "Dewey", "Efraim", "Georgette" };
		String[] favoriteFoods = { "A Sandwich", "Burger", "Carrots", "Dill Pickle", "Edamame", "Garbonzo Beans" };
		String[] hometowns = { "Ann Arbor", "Birmingham", "Canton", "Detroit", "East Lansing", "Grand Rapids" };
		
		
		// Display Main Menu
		System.out.println("Welcome to our Java Class. What would you like to do?");
		String[] mainMenuOptions = {
				"Learn More About Students",
				"Quit Program" 
		};
		int mainMenuChoice = 0;
		mainMenuChoice = getValidMenuChoice(scnr, mainMenuOptions);

		if (mainMenuChoice == 1) {
			boolean loopStudentMenu = true;
			
			// Choice: Learn More About Students!
			do {
				// Display Student Menu
				System.out.println("\nWhich student would you like to learn about?");
				int studentChoice = getValidMenuChoice(scnr, students);
				
				boolean loopSubMenu = true;
				// Student has been chosen
				do {
					// Student has been chosen
					// Display student sub menu
					
					System.out.println("\nWhat would you like to know about " + students[studentChoice - 1] + "?");
					String[] subMenuOptions = {
							"Pick A Different Student",
							"Favorite Food",
							"Hometown", 
							"Quit Program"
					};
					int subMenuChoice = getValidMenuChoice(scnr, subMenuOptions);

					if (subMenuChoice == 1) {
						// Choice: Go back to Student Menu
						break;
						
					} else if (subMenuChoice == 2) {
						// Choice: Reveal Student's Favorite Food
						System.out.println(students[studentChoice - 1] + "'s favorite food is: "
								+ favoriteFoods[studentChoice - 1] + "!");
						
					} else if (subMenuChoice == 3) {
						// Choice: Reveal Student's Hometown
						System.out.println(
								students[studentChoice - 1] + "'s hometown is: " + hometowns[studentChoice - 1] + "!");
						
					} else {
						// Choice: Quit the Program
						loopSubMenu = false;
						loopStudentMenu = false;
						break; /* break out of this student menu loop */
						
					}

					System.out
							.println("\nWould you like to know more about " + students[studentChoice - 1] + "? (Y/n)");
					System.out.println("Choose 'n' to see other students...");
					if (scnr.nextLine().trim().toLowerCase().equals("n")) {
						loopSubMenu = false;
					}

				} while (loopSubMenu);

			} while (loopStudentMenu);

		}

		System.out.println("\nOk! Goodbye!");

		scnr.close();
	}

	private static int getValidMenuChoice(Scanner scnr, String[] menuOptions) {
		int menuChoice = 0;
		boolean inputIsValid = false;
		printOptions(menuOptions);
		do {
			try {
				menuChoice = scnr.nextInt();
				validateChoiceInMenu(menuChoice, menuOptions.length);
				inputIsValid = true;
			} catch (InputMismatchException | IllegalArgumentException ex) {
				System.out.println("Sorry, you must enter a number between 1 and " + menuOptions.length + ": ");
			}
			scnr.nextLine(); /* clear garbage */
		} while (!inputIsValid);
		return menuChoice;
	}

	public static void validateChoiceInMenu(int input, int menuLength) {
		if (input < 1 || input > menuLength) {
			throw new IllegalArgumentException();
		}
	}

	private static void printOptions(String[] options) {
		int i = 1;
		for (String option : options) {
			System.out.println(i + ". " + option);
			i++;
		}
		System.out.println("Enter a number (1-" + (options.length) + "): ");
	}

}
