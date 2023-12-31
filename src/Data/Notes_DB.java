package src.Data;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.System.out;

/**
 * This class makes all interactions with our MySQL DB
 */
public class Notes_DB {

    AtomicBoolean tf = new AtomicBoolean(false);

    public void printfmt() {
        out.printf("%s is %d %b", "greg", 25, tf.get());
    }
}
