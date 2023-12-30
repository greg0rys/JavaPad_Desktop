package src.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input_Validator {
    private static boolean is_valid = false;

    public Input_Validator(){}

    public static boolean getValidity(){
        return is_valid;
    }

    public static void setValid(boolean f)
    {
        is_valid = f;
    }

    public static boolean is_valid_type(String T)
    {
        ArrayList<String> types = new ArrayList<>(
                Arrays.asList("long", "short","article",
                         "memo","todo", "reminder"));

        return types.contains(T.toLowerCase());

    }
}
