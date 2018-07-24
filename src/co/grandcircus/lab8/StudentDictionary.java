package co.grandcircus.lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDictionary {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		String[] students = { "Abbie", "Brad", "Carly", "Dewey", "Efraim", "Georgette" };
		String[] favoriteFoods = { "A Sandwich", "Burger", "Carrots", "Dill Pickle", "Edamame", "Garbonzo Beans" };
		String[] hometowns = { "Ann Arbor", "Birmingham", "Canton", "Detroit", "East Lansing", "Grand Rapids" };

		String[] navOptions = { "Pick A Different Student", "Favorite Food", "Hometown", "Quit Program" };

		int studentChoice = 0;
		int navChoice = 0;
		boolean quitProgram = false;

		do {
			// Prompt user to pick a student
			System.out.println("Welcome to our Java Class. Which student would you like to learn about?");
			printOptions(students);
			studentChoice = getValidMenuChoice(scnr, students.length);

			// Display information menu and prompt for nav choice
			System.out.println("What would you like to know about " + students[studentChoice - 1] + "?");
			printOptions(navOptions);
			navChoice = getValidMenuChoice(scnr, navOptions.length);

			// TODO: Add method for fetching student information
			if (navOptions[navChoice - 1].equals("Pick a Different Student")) {
				continue; // this is a hack
			} else if (navOptions[navChoice - 1].equals("Favorite Food")) {
				System.out.println(
						students[studentChoice - 1] + "'s favorite food is: " + favoriteFoods[studentChoice - 1]);
			} else if (navOptions[navChoice - 1].equals("Hometown")) {
				System.out.println(
						students[studentChoice - 1] + "'s hometown is: " + hometowns[studentChoice - 1]);
			} else {
				quitProgram = true;
			}

		} while (!quitProgram);

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

	private static int getStudentMenuChoice(String[] options) {
		int navChoice = 0;

		// print options for the user
		printOptions(options);
		return navChoice;

		// retrieve String from navOptions array

		// If/else block for performing action

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
