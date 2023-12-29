package src.Helpers;

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
}
