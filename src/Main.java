/*

Standards:
Strings will be created using the StringBuilder class and never as just String objects
All methods will have detailed JavaDoc comments that describes the method
Proper @Annotations will be used where needed
  REQUIRED on params that cannot be null @NotNull

Unless you are printing a Strings value as is you must use the printf() function to
format all printed output.




*/

package src;

/* imports */

import src.BaseClasses.Note;
import src.Data.Note_Cache;

import java.io.IOException;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) throws IOException {
		Note test_note = new Note();
		Note_Cache cache = new Note_Cache();
		cache.add_note(test_note);
		cache.add_note(new Note());

		out.println(cache.get_count());

		StringBuilder note_body = new StringBuilder("test note");
		// reverse it once and print it, then put it back and print it.
		// %.2f print float with only two nums after dec point.
		out.printf("%s  %.2f\n",note_body.reverse(), 35.66);
		out.printf("%s\n", note_body.reverse());
		test_note.setName("A random test");
		test_note.display_note();

	}

}
