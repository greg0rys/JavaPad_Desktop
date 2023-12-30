package src.Helpers;

import src.Data.Note_Cache;

import java.util.Scanner;

import static java.lang.System.out;

public class Driver {
    private boolean run; // run app Y / N
    private Note_Cache cache; // data struct holding all notes
    private final Scanner IO = new Scanner(System.in); // user input object.


    public Driver(){
        run = true;
        init();
    }

    private void init(){
        run = true;
        cache = new Note_Cache();
        intro();
    }

    private void intro()
    {
        out.println("JavaPad: Your thoughts captured.\n\t v 1.0.0");
        out.println();

        start();

    }
    public void start()
    {
        int menu_choice;
        do{

            display_menu(); // display the menu choices
            out.print("Enter Menu Choice: ");
            menu_choice = IO.nextInt(); // collect the input choice
            navigate(menu_choice); // navigate the menu

        } while(run);
    }

    /**
     * Creates the menu output for the program.
     *
     */
    private void display_menu()
    {
        out.println("Main Menu:\n\t" +
                "1. List Notes\n\t"  +
                "2. Upcoming ToDos\n\t" +
                "3. Search Notes\n\t");

        out.println("************");
    }

    public void navigate(int choice)
    {
        switch(choice){
            case 0:
                run = false;
                break;
            case 1:
                out.println("Here are all of your notes:");
                break;
            case 2:
                out.println("Here is the upcoming todos:");
                break;
            case 3:
                out.println("Lets search...");
                break;

        }
    }
}
