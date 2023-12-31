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

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		Note test_note = new Note();
		Note test_two = new Note();
		Note copy = test_note; // shallow same hash
		Note t3 = new Note(test_note); // deep copy != same hashcode
		Note_Cache cache = new Note_Cache(); // holds the notes when loaded from data
		// source
		cache.add_note(test_note);
		cache.add_note(new Note());

		out.println(cache.get_count());
		test_note.setName("A random test");
		test_note.display_note();
		out.printf("\nthe hash of test_note: is %d\nthe hash of test_two is: %d\n",
				   test_note.hashCode(), test_two.hashCode());

		out.println((t3.hashCode() == test_note.hashCode()) ? "Same Obj" : "Diff " +
				"obj");

	}

}
