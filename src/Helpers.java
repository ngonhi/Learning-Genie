public class Helpers {

    public static boolean IsPositiveResponse(String answer) {
        switch (answer.trim().toLowerCase()){
            case "yes":
            case "yes!":
            case "yup":
            case "yup!":
            case "yeah":
            case "yeah!":
                return true;
            default: return false;
        }
    }

    public static boolean IsNegativeResponse(String answer) {
        switch (answer.trim().toLowerCase()){
            case "no":
            case "no!":
            case "nah":
            case "nah!":
            case "nope":
            case "nope!":
                return true;
            default: return false;
        }
    }

}
