
/**
 * base class for all Note Objects. This will spawn the need for subclasses
 */
package src.BaseClasses;
import src.Constants.NoteType;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Note {

    private String note_name;
    private NoteType type;
    private String note_body;
    private int index;




    public Note(String name, NoteType note_type, String body, int idx)
    {
        note_name = name;
        type = note_type;
        note_body = body;
        index = idx;
    }

    // no args makes a note with no name, default type short note, also adds a random index to the note
    public Note()
    {
        // once you have the primary constructor (with args) you can call this() on all others
        this("", NoteType.SHORT, "empty for now",0);
        index = generate_random_index();
    }

    // setters
    public void setName(String name){note_name = name;}
    public void setType(@NotNull String T){
        if(T.equals("LONG"))
            type = NoteType.LONG;
        if(T.equals("SHORT"))
            type = NoteType.SHORT;
        if(T.equals("ARTICLE"))
            type = NoteType.ARTICLE;
        if(T.equals("MEMO"))
            type = NoteType.MEMO;
        if(T.equals("TODO"))
            type = NoteType.TODO;
        if(T.equals("REMINDER"))
            type = NoteType.REMINDER;
    }
    public void setBody(String bod){note_body = bod;}

    //getters
    public String getName(){return note_name;}
    public String getType(){return type.toString();}
    public String getBody(){return note_body;}
    public int get_index(){return index;}


    /**
     * Generate a random index number for the note, so we have a value to use as the key when a dynamic index cannot be generated
     *
     * @return index the randomly generated index number
     *
     * TODO the bound of 2500 cannot be hard coded it will need to be dynamic. It will create duplicate indexs stored in the db
     * TODO we will need to do some math to always ensure we are creating unique indexs.
     */
    public int generate_random_index()
    {
        // this returns a random int and assigns it to index.
        index = new Random().nextInt(5,2500);

        return index;
    }


}
