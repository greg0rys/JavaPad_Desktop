package src.Helpers;

import src.BaseClasses.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class File_Handler {
    private boolean file_found = findFile();
    private static final String FILE_PATH = "./user_info.txt";
    private static final File working_file = new File(FILE_PATH);
    private static FileWriter writer;
    private static final Scanner data_in = new Scanner(System.in);


    //nor args constructor
    public File_Handler() throws IOException {

        if(!file_found)
            writer = new FileWriter(FILE_PATH);

        // at object init the file is searched for pass the found status to the setup func
        init(file_found);
    }

    /**
     * If the file hasn't been found create it else let the user know which file was loaded.
     * @param found_status boolean representing file being found t is found f all else
     * @throws IOException thrown from the file handling and creating.
     */
    private void init(boolean found_status) throws IOException {
        if(!found_status)
        {
            create_file();
            return;
        }

        out.println("Loaded: " + FILE_PATH);
    }

    /**
     * Create the user_info file if it's not already found in the program directory
     * @throws IOException
     */
    private void create_file() throws IOException {

      try {
          out.println(working_file.createNewFile() ? "Created " + FILE_PATH : "File already found");
      } catch(IOException ex) {
          out.println(ex.getMessage());
      }

    }

    /**
     * called at object init to look for the file
     * @return true if file found false if else
     */
    private boolean findFile()
    {
        return working_file.exists();
    }

    public boolean hasData()
    {
        return working_file.length() > 0;
    }

    // grab some random user input and throw it into a text file for processing.
    public void createData() throws IOException {

        if(writer == null)
            writer = new FileWriter(FILE_PATH);

        out.print("Enter your first name: ");
        writer.write(data_in.nextLine() + " ");
        out.print("Enter total notes in path: ");
        writer.append(data_in.nextLine()).append(" ");
        writer.close();

    }


    public ArrayList<Note> load_file()
    {
        ArrayList<Note> notes = new ArrayList<>();
        return new ArrayList<>();

    }
}
