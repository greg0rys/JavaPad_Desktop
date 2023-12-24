package src.helpers;

public class InputValidator {
    private static boolean is_valid = false;

    public InputValidator(){}

    public static boolean getValidity(){
        return is_valid;
    }

    public static void setValid(boolean f)
    {
        is_valid = f;
    }
}
