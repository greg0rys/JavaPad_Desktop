package src.Data;

import com.sun.source.tree.BinaryTree;
import src.BaseClasses.Note;

import java.util.HashMap;

/**
 * Container for Note objects. Includes methods to manage the data struct
 */
public class NoteCache {
    private HashMap<Integer, Note> note_map; // store the notes in Key => Value sequence
    private int note_count;
    private int next_index;


    public NoteCache(HashMap<Integer, Note> note_struct, int num_notes, int next_idx)
    {
        note_map = note_struct;
        note_count = num_notes;
        next_index = next_idx;

    }

    public NoteCache(int num_notes)
    {
        this(null, num_notes, 0);

    }

    public NoteCache()
    {
        this(null, 0,0);
    }

    public boolean has_key(int idx)
    {
        return note_map.containsKey(idx);
    }

    public Note get_note(int idx)
    {
        if(has_key(idx))
            return note_map.get(idx);

        return null;
    }

    /**
     * Add a note to the HashMap
     * @param note  the Note object that we wish to add to the map.
     *
     * use next_index++ to increment the index value each time we add a new note
     */
    public void add_note(Note note)
    {
        note_map.put(next_index++, note); // get index will get the index number from the note obj; We should assign this based on our data source. IE same index as DB record
    }

}
