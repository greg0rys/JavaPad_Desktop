
/**
 * base class for all Note Objects. This will spawn the need for subclasses
 */
package src.BaseClasses;
import src.Constants.NoteType;
import org.jetbrains.annotations.NotNull;

public class Note {

    private String note_name;
    private NoteType type;
    private String note_body;




    public Note(String name, NoteType note_type, String body)
    {
        note_name = name;
        type = note_type;
        note_body = body;
    }

    // no args makes a note with no name, default type short note
    public Note()
    {
        // once you have the primary constructor (with args) you can call this() on all others
        this("", NoteType.SHORT, "empty for now");
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


}
