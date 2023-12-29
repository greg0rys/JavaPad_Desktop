package src.Helpers;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Runs the program using a test sequence - calls all methods does all functions.
 * This allows us to just have one init object in main() at a time. One for test, another for true run.
 * 
*/

public class Test_Run {

	private final String WELCOME_MSG = "Welcome to GREGSNOTES V0.0.6";
	private int note_count;
	private String user_name;
	private File_Handler file = new File_Handler(); // handle file setup before constructor is called
	private Scanner data_in = new Scanner(System.in);


	public Test_Run() throws IOException {
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
		int choice;

		// use do while loop so it will always loop the menu at least once
		do {
			out.print("src.Main Menu\n\t1. Open GroovyPad.Note\n\t2. Make GroovyPad.Note\n");
			out.print("Enter Choice: ");
			choice = data_in.nextInt();

			if( Input_Validator.getValidity()){
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

				Input_Validator.setValid(true);
			}
			else {
				out.println("try again");

			}


		} while(run);
	}



}

