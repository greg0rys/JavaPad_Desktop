package src.BaseClasses;


import src.Constants.Note_Type;
import src.Helpers.Input_Validator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import static java.lang.System.out;


/**
 * CHANGELOG<br/>
 *  ------------------------------------------------------------ <br/>
 * 12/29/23: Changed:<br/> <pre>note_body : String => StringBuilder</pre> to take
 *   advantage of the class methods of <pre>StringBuilder</pre>
 *   ------------------------------------------------------------
 *
 */
public class Note {

    private final String date_string =
            LocalDate.now().getMonthValue() + "-" +
            LocalDate.now().getDayOfMonth() + "-" +
            LocalDate.now().getYear();
    private String note_name;
    private Note_Type type;
    private StringBuilder note_body;
    private int index;
    private HashSet<Integer> idx_used = new HashSet<>();

    /**
     * Default constructor
     *
     * @param name      name of the note
     * @param note_type note type *SEE: ..\constants\Note_Type*
     * @param body      blob of text representing the body
     * @param idx       the unique index number of this note
     */
    public Note(String name, Note_Type note_type, String body, int idx) {
        note_name = name;
        type = note_type;
        note_body = new StringBuilder(body);
        index = validate_index(idx);
        idx_used.add(index);
    }

    /**
     * No argument constructor - all fields will be initialized to some default value.
     * using this() as the way to set up the object it enforces that I will never have a
     * null field as all params must be filled
     */
    public Note() {
        // once you have the primary constructor (with args) you can call this() on all others
        this("", Note_Type.SHORT, "", 0);
        index = validate_index(generate_random_index()); // ensure we don't reuse an
        // index value
    }


    public Note(Note copy)
    {
        // make deep copies by calling new on each assignment
        note_name = copy.getName();
        note_body = new StringBuilder(copy.getBody());

    }

    /**
     * get the name of this note
     *
     * @return <pre>note_name</pre>
     */
    public String getName() {
        return note_name;
    }

    /**
     * Set the name of this note
     *
     * @param name a String representing the name of the GroovyPad.Note
     */
    public void setName(String name) {
        note_name = name;
    }

    public String getType() {
        return type.toString();
    }

    /**
     * Set this Notes type by passing in a string that denotes what this notes type
     * should be.
     * User input will be compared against the acceptable values ignoring the case on
     * the String i.e. lOnG, long, and LONG will all = true when compared to LONG.
     * The string will then be mapped to its proper enum type in the Note_Type enum
     *
     * @param T a String that only accepts the values:<br>
     *          + long - general note with a long body<br/>
     *          + short - general note with a short body (140 chars or less)<br/>
     *          + article - GroovyPad.Note with long body of text + other frills<br/>
     *          + memo - a note with intent to be distro <br/>
     *          + todo - something that must be done, not < 100 chars<br/>
     *          + reminder - reminder with Date objects<br/>
     *          TODO make a validation method to ensure the user passes in one of the
     *               valid options long, short, article, etc.
     */
    public void setType(String T) {

        if(Input_Validator.is_valid_type(T)){

        }
        if (T.equalsIgnoreCase("LONG"))
            type = Note_Type.LONG;
        if (T.equalsIgnoreCase("SHORT"))
            type = Note_Type.SHORT;
        if (T.equalsIgnoreCase("ARTICLE"))
            type = Note_Type.ARTICLE;
        if (T.equalsIgnoreCase("MEMO"))
            type = Note_Type.MEMO;
        if (T.equalsIgnoreCase("TODO"))
            type = Note_Type.TODO;
        if (T.equalsIgnoreCase("REMINDER"))
            type = Note_Type.REMINDER;
    }

    public String getBody() {
        return note_body.toString();
    }

    /**
     * Set the Notes body text
     *
     * @param bod a String that contains the body of text for this note
     */
    public void setBody(String bod) {
        note_body = new StringBuilder(bod);
    }

    public int get_index() {
        return index;
    }

    public String get_date_string() {
        return date_string;
    }


    /**
     * Generate a random index number for the note, so we have a value to use as the key
     * when a dynamic index cannot be generated
     *
     * @return index the randomly generated index number
     * TODO the bound of 2500 cannot be hard coded it will need to be dynamic.
     *  It will create duplicate indexs stored in the db
     * TODO we will need to do some math to always ensure we are creating unique indexs.
     */
    public int generate_random_index() {

        // this returns a random int and assigns it to index.
        index = new Random().nextInt(5, 2500);

        return index;
    }

    /**
     * if the index is already in the set recurse this method by having a random index passed as input
     * else return the index value submitted for validation
     *
     * @param idx an int representing this notes index number
     * @return a unique index number
     */
    private int validate_index(int idx) {
        // if contained recurse with a random index, else use this index.
        return idx_used.contains(idx) ? validate_index(generate_random_index()) : idx;
    }

    /**
     * Display a notes metadata
     * prints: subject, index number, creation date
     */
    public void display_note()
    {
        out.printf("Subject: %s\nIndex: %d\nCreated: %s",
                   note_name, index, date_string);
    }

    /* Overrides */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o; // cast the Object to type note.
        return (index == note.index) && Objects.equals(note_name, note.note_name)
                && (type == note.type)
                && Objects.equals(note_body, note.note_body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note_name, type, note_body, index);
    }


}
