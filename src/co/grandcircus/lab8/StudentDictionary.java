package co.grandcircus.lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDictionary {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		String[] students = { "Abbie", "Brad", "Carly", "Dewey", "Efraim", "Georgette" };
		String[] favoriteFoods = { "A Sandwich", "Burger", "Carrots", "Dill Pickle", "Edamame", "Garbonzo Beans" };
		String[] hometowns = { "Ann Arbor", "Birmingham", "Canton", "Detroit", "East Lansing", "Grand Rapids" };

		String[] mainMenuOptions = { "Learn More About Students", "Quit Program" };
		String[] subMenuOptions = { "Pick A Different Student", "Favorite Food", "Hometown", "Quit Program" };

		int mainMenuChoice = 0;
		int studentChoice = 0;
		int subMenuChoice = 0;
		boolean loopStudentMenu = true;
		boolean loopSubMenu = true;

		// Student Menu Loop

		System.out.println("Welcome to our Java Class. What would you like to do?");
		printOptions(mainMenuOptions);
		mainMenuChoice = getValidMenuChoice(scnr, mainMenuOptions.length);

		if (mainMenuChoice == 1) {
			do {
				// Learn More About Students
				System.out.println("Which student would you like to learn about?");
				printOptions(students);
				studentChoice = getValidMenuChoice(scnr, students.length);

				do {
					System.out.println("\nWhat would you like to know about " + students[studentChoice - 1] + "?");
					// Display information menu and prompt for nav choice
					printOptions(subMenuOptions);
					subMenuChoice = getValidMenuChoice(scnr, subMenuOptions.length);

					// TODO: Add method for fetching student information
					if (subMenuChoice == 1) {
						loopSubMenu = false;
					}

					else if (subMenuChoice == 2) {
						System.out.println(students[studentChoice - 1] + "'s favorite food is: "
								+ favoriteFoods[studentChoice - 1] + "!");
					} else if (subMenuChoice == 3) {
						System.out.println(
								students[studentChoice - 1] + "'s hometown is: " + hometowns[studentChoice - 1] + "!");
					} else {
						loopSubMenu = false;
						loopStudentMenu = false;
						break;
					}

					System.out
							.println("Would you like to know more about " + students[studentChoice - 1] + "? (Y/n): ");
					if (scnr.nextLine().trim().toLowerCase().equals("n")) {
						loopSubMenu = false;
					}

				} while (loopSubMenu);

			} while (loopStudentMenu);

		} else {
			// Exit Program
			System.out.println("Goodbye!");
		}

		scnr.close();
	}

	private static int getValidMenuChoice(Scanner scnr, int menuLength) {
		int menuChoice = 0;
		boolean inputIsValid = false;
		do {
			try {
				menuChoice = scnr.nextInt();
				validateChoiceInMenu(menuChoice, menuLength);
				inputIsValid = true;
			} catch (InputMismatchException | IllegalArgumentException ex) {
				System.out.println("Sorry, you must enter a number between 1 and " + menuLength + ": ");
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
