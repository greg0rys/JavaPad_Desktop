package src.helpers;
import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

/**
 * Loads welcome info for the user - while also reading the stored data file
 * if the data file is not found a new one is created
 * 
*/

public class StartUp {

	private final String WELCOME_MSG = "Welcome to GREGSNOTES V0.0.6";
	private int note_count;
	private String user_name;
	private FileHandler file = new FileHandler(); // handle file setup before constructor is called
	private Scanner data_in = new Scanner(System.in);


	public StartUp() throws IOException {
		out.println(WELCOME_MSG);

		loadFileData();
		menu();

	}

	private void loadFileData() throws IOException {
		if(!file.hasData())
			file.createData();
	}

	private void menu()
	{
		boolean run = true;
		int choice = 0;

		// use do while loop so it will always loop the menu at least once
		do {
			out.print("src.Main Menu\n\t1. Open Note\n\t2. Make Note\n");
			out.print("Enter Choice: ");
			choice = data_in.nextInt();

			if(InputValidator.getValidity()){
				switch(choice)
				{
					case 0:
						run = false;
						break;
					case 1:
						out.println("We need data!");
						out.println("******************\n");
						break;
				}

				InputValidator.setValid(true);
			}
			else {
				out.println("try again");

			}


		} while(run);
	}



}

