package Data;

import BaseClasses.Note;

import java.util.ArrayList;

public class NoteCollection {
    private ArrayList<Note> note_list;

    public NoteCollection()
    {
        fill_notes();
    }

    private ArrayList<Note> fill_notes()
    {
        note_list = new ArrayList<>();

        for(Note n : note_list)
            note_list.add(n);
    }
}
