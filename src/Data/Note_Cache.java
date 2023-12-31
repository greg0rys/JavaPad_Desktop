package src.Data;

import src.BaseClasses.Note;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import static java.lang.System.out;

/**
 * Container for GroovyPad.Note objects. Includes methods to manage the data struct
 */
public class Note_Cache
{
    private HashMap<Integer, Note> note_map = new HashMap<>();
    private final HashSet<Integer> used_index = new HashSet<>();
    private int note_count = 0;
    private int next_index = 0;


    public Note_Cache( int num_notes, int next_idx )
    {
        note_count = num_notes;
        next_index = next_idx;

    }

    public Note_Cache( int num_notes )
    {

        this( num_notes, 0 );

    }

    public Note_Cache()
    {
        this( 0, 0);
    }

    public boolean has_key( int idx )
    {
        return note_map.containsKey(idx);
    }

    public Note get_note( int idx )
    {
        if ( has_key(idx) )
            return note_map.get(idx);

        return null; // caller will need to test for null before continuing.
    }

    /**
     * Add a note to the HashMap
     *
     * @param note the GroovyPad.Note object that we wish to add to the map.
     *             <p>
     *             use next_index++ to increment the index value each time we add a new
     *             note
     */
    public void add_note( Note note )
    {
        note_map.put(next_index++,
                     note);
        note_count++;
    }

    public int get_count()
    {
        return note_map.size();
    }

    // we need a delete method for more than one type of delete. IF we don't know the idx what other things
    // can be used to search and delete?
    public boolean delete_by_index( int idx )
    {
        // this if statement and the catch statement do the same thing remove one.
        if ( ! note_map.containsKey(idx) || note_map.get(idx) == null )
            return false;

        // make sure to delete without error then return true
        try
        {
            note_map.remove(idx);
            return true;
        }
        catch ( Exception ex ) // this does the same as the if statement implicitly
        {
            // if anything goes wrong at all return false to caller.
            return false;
        }
    }


    /* loop through the maps values and have them print formatted */
    public void print()
    {
        // make sure our map isn't empty before doing work to print it
        if ( note_map.isEmpty() )
        {
            out.printf("Ooops there are %d notes to see right now", used_index.size());
            return;
        }

        for ( Note n : note_map.values() )
            n.display_note();


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
    public int generate_random_index()
    {
        // this returns a random int and assigns it to index.
        return validate_index(new Random().nextInt(5, 2500));
    }

    /**
     * if the index is already in the set recurse this method by having a random index
     * passed as input else return the index value submitted for validation
     *
     * @param idx an int representing this notes index number
     *
     * @return a unique index number
     */
    private int validate_index( int idx )
    {
        // if contained recurse with a random index, else use this index.
        return has_key(idx) ? validate_index(generate_random_index()) : idx;
    }
}
