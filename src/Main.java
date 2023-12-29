package src;

import src.BaseClasses.Note;
import src.Data.NoteCache;
import src.helpers.TestRun;

import java.io.IOException;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) throws IOException {
		Note test_note = new Note();
		NoteCache cache = new NoteCache();
		cache.add_note(test_note);
		cache.add_note(new Note());

		out.println(cache.get_count());


	}
}
