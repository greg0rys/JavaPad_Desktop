// TODO figure out if StringBuilder is the best choice all the time, if we aren't using
//  methods of the class in a give string should we worry about creatinga  new class it
//  just slows this down.
/**
 * base class for all Note Objects. This will spawn the need for subclasses
 */
package src.BaseClasses;

import org.jetbrains.annotations.NotNull;
import src.Constants.Note_Type;

import java.util.Objects;
import java.util.Random;

public class Note {

    private String note_name;
    private Note_Type type;
    private String note_body;
    private int index;

    /**
     * Default constructor
     * @param name name of the note
     * @param note_type note type *SEE: ..\constants\Note_Type*
     * @param body blob of text representing the body
     * @param idx the unique index number of this note
     *
     */
    public Note( String name, Note_Type note_type, String body, int idx)
    {
        note_name = name;
        type = note_type;
        note_body = body;
        index = idx;
    }

    /**
     * No argument constructor - all fields will be initalized to some default value.
     *
     * using this() as the way to set up the object it enforces that I will never have a
     * null field as all params must be filled
     */
    public Note()
    {
        // once you have the primary constructor (with args) you can call this() on all others
        this("", Note_Type.SHORT, "empty for now",0);
        index = generate_random_index();
    }

    // setters

    /**
     * Set the name of this note
     * @param name a String representing the name of the Note
     */
    public void setName(String name){note_name = name;}

    /**
     * Set this Notes type by passing in a string that denotes what this notes type
     * should be.
     * User input will be compared against the acceptable values ignoring the case on
     * the String i.e lOnG, long, and LONG will all = true when compared to LONG.
     * The string will then be mapped to it's proper enum type in the Note_Type enum
     *
     * @param T a String that only accepts the values<br>
     *          + long - general note with a long body<br/>
     *          + short - general note with a short body (140 chars or less)<br/>
     *          + article - Note with long body of text + other frills<br/>
     *          + memo - a note with intent to be distro <br/>
     *          + todo - something that must be done, not < 100 chars<br/>
     *          + reminder - reminder with Date objects<br/>
     *
     *
     */
    public void setType(@NotNull String T){
        if(T.equalsIgnoreCase("LONG"))
            type = Note_Type.LONG;
        if(T.equalsIgnoreCase("SHORT"))
            type = Note_Type.SHORT;
        if(T.equalsIgnoreCase("ARTICLE"))
            type = Note_Type.ARTICLE;
        if(T.equalsIgnoreCase("MEMO"))
            type = Note_Type.MEMO;
        if(T.equalsIgnoreCase("TODO"))
            type = Note_Type.TODO;
        if(T.equalsIgnoreCase("REMINDER"))
            type = Note_Type.REMINDER;
    }

    /**
     * Set the Notes body text
     * @param bod a String that contains the body of text for this note
     */
    public void setBody(String bod){note_body = bod;}

    //getters

    /**
     * get the name of this note
     * @return <pre>note_name</pre>
     */
    public String getName(){return note_name;}
    public String getType(){return type.toString();}
    public String getBody(){return note_body;}
    public int get_index(){return index;}


    /**
     * Generate a random index number for the note, so we have a value to use as the key
     * when a dynamic index cannot be generated
     *
     * @return index the randomly generated index number
     * TODO the bound of 2500 cannot be hard coded it will need to be dynamic.
     *  It will create duplicate indexs stored in the db
     * TODO we will need to do some math to always ensure we are creating unique indexs.
     */
    public int generate_random_index()
    {
        // this returns a random int and assigns it to index.
        index = new Random().nextInt(5,2500);

        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o; // cast the Object to type note.
        return index == note.index && Objects.equals(note_name, note.note_name) && type == note.type && Objects.equals(note_body, note.note_body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note_name, type, note_body, index);
    }
}
