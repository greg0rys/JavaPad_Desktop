package src.Data;

import src.BaseClasses.Note;

import java.util.HashMap;

/**
 * Container for Note objects. Includes methods to manage the data struct
 */
public class Note_Cache {
    private HashMap<Integer, Note> note_map; // store the notes in Key => Value sequence
    private int note_count;
    private int next_index;


    public Note_Cache( HashMap<Integer, Note> note_struct, int num_notes, int next_idx)
    {
        note_map = note_struct;
        note_count = num_notes;
        next_index = next_idx;

    }

    public Note_Cache( int num_notes)
    {
        this(new HashMap<>(), num_notes, 0);

    }

    public Note_Cache()
    {
        this(new HashMap<>(), 0,0);
    }

    public boolean has_key(int idx)
    {
        return note_map.containsKey(idx);
    }

    public Note get_note(int idx)
    {
        if(has_key(idx))
            return note_map.get(idx);

        return null; // caller will need to test for null before continuing.
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
        note_count++;
    }

    public int get_count(){return note_count;}

    // we need a delete method for more than one type of delete. IF we don't know the idx what other things
    // can be used to search and delete?
    public boolean delete_by_index(int idx)
    {
        // this if statement and the catch statement do the same thing remove one.
        if(!note_map.containsKey(idx) || note_map.get(idx) == null)
            return false;

        // make sure to delete without error then return true
        try{
            note_map.remove(idx);
            return true;
        }
        catch(Exception ex) // this does the same as the if statement implicitly
        {
            // if anything goes wrong at all return false to caller.
            return false;
        }
    }


    // we need to be able to print the entire collection
    public void print()
    {
        // make sure our map isn't empty before doing work to print it
        if(note_map.isEmpty())
            return;



    }
}
