import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode{
    // Field
    private final String object;

    // Constructor
    GuessNode(String object) {
        this.object = object;
    }

    // Methods
    public int countObjects () {
        return 1;
    } // countObjects

    public DecisionNode guess (Scanner in) {
        System.out.print("Are you thinking of " + object + "? ");
        String userAnswer = in.nextLine().trim().toLowerCase();

        while (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
            System.out.println("Incorrect response! Please enter yes/no!");
            System.out.print("Are you thinking of " + object + "?");
            userAnswer = in.nextLine();
            System.out.println(userAnswer);
        }

        if (userAnswer.equals("yes")) {
            System.out.println("Excellent, thanks!");
            return this;
        } else {
            System.out.println("Oh no, I was wrong");
            System.out.print("What were you thinking of? ");
            String newObject = in.nextLine();
            System.out.println("What is a yes/no question that distinguishes a " + object + " from a " + newObject + "?");
            System.out.print("(Yes corresponds to " + object + "; No corresponds to " + newObject +") ");
            String question = in.nextLine();
            System.out.println("Thanks! I'll learn from this experience!");
            return new QuestionNode(question, this, new GuessNode(newObject));
        }
    } // guess

    public void write(FileWriter out) throws IOException {
        out.write(object + System.lineSeparator());
    }

}
