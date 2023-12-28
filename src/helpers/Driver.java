package src.helpers;
import java.util.Scanner;

import static java.lang.System.out;

public class Driver {
    private boolean run;
    private Scanner IO = new Scanner(System.in);


    public Driver(){run = true;}

    private void init(){
        run = true;
        intro();
    }

    private void intro()
    {
        out.println("JavaPad: Your thoughts captured.\n\t v 1.0.0");





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
     * @return void
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
