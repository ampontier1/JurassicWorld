/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Sep 16, 2021
 */

import java.util.List;
import java.util.Scanner;

import controller.DinosaurHelper;
import model.Dinosaur;

public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static DinosaurHelper dh = new DinosaurHelper();

	private static void addADino() {
		// TODO Auto-generated method stub
		System.out.print("Enter a species: ");
		String species = in.nextLine();
		System.out.print("Enter an color: ");
		String color = in.nextLine();
		Dinosaur toAdd = new Dinosaur(species,color);
		dh.insertDino(toAdd);

	}

	private static void deleteADino() {
		// TODO Auto-generated method stub
		System.out.print("Enter the species to delete: ");
		String species = in.nextLine();
		System.out.print("Enter the color to delete: ");
		String color = in.nextLine();
		Dinosaur toDelete = new Dinosaur(species,color);
		dh.deleteDino(toDelete);

	}

	private static void editADino() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Species");
		System.out.println("2 : Search by Color");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Dinosaur> foundDinos;
		if (searchBy == 1) {
			System.out.print("Enter the species name: ");
			String speciesName = in.nextLine();
			foundDinos = dh.searchForDinoBySpecies(speciesName);
			
		} else {
			System.out.print("Enter the color: ");
			String colorName = in.nextLine();
			foundDinos = dh.searchForDinoByColor(colorName);
			

		}

		if (!foundDinos.isEmpty()) {
			System.out.println("Found Results.");
			for (Dinosaur d : foundDinos) {
				System.out.println(d.getId() + " : " + d.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Dinosaur toEdit = dh.searchForDinoById(idToEdit);
			System.out.println("Retrieved " + toEdit.getColor() + " from " + toEdit.getSpecies());
			System.out.println("1 : Update Species");
			System.out.println("2 : Update Color");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Species: ");
				String newSpecies = in.nextLine();
				toEdit.setSpecies(newSpecies);
			} else if (update == 2) {
				System.out.print("New Color: ");
				String newColor = in.nextLine();
				toEdit.setColor(newColor);
			}

			dh.updateDino(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the Jurassic World Database! ---");
		System.out.println("-------- Please enter the new species: --------");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a species");
			System.out.println("*  2 -- Edit a species");
			System.out.println("*  3 -- Delete a species");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Cause mass extnction event :( ");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addADino();
			} else if (selection == 2) {
				editADino();
			} else if (selection == 3) {
				deleteADino();
			} else if (selection == 4) {
				viewTheList();
			} else {
				dh.cleanUp();
				System.out.println("   BOOM!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Dinosaur> allDinos = dh.showAllDinos();
		for(Dinosaur singleDino : allDinos) {
			System.out.println(singleDino.returnDinos());
		}

	}



}
