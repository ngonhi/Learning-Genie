import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{
    // Fields
    private final String question;
    private DecisionNode yesTree;
    private DecisionNode noTree;

    // Constructor

    /**
     * Construct a Question Node
     *
     * @param question
     * @param yesTree
     * @param noTree
     */
    QuestionNode(String question, DecisionNode yesTree, DecisionNode noTree) {
        this.question = question;
        this.yesTree = yesTree;
        this.noTree = noTree;
    }

    // Methods
    public int countObjects() {
        return this.yesTree.countObjects() + this.noTree.countObjects();
    }

    public DecisionNode guess(Scanner in) {
        System.out.print(question);
        String ans = in.nextLine().trim().toLowerCase();

        while (!ans.equals("yes") && !ans.equals("no")) {
            System.out.println("Incorrect response! Please enter yes/no");
            System.out.print(question + " ");
            ans = in.nextLine().trim().toLowerCase();
        }

        // Update the subtrees during the game
        if (ans.equals("yes")) {
            this.yesTree = this.yesTree.guess(in);
        } else {
            this.noTree = this.noTree.guess(in);
        }

        return new QuestionNode(question, yesTree, noTree);
    } // guess

    public void write(FileWriter out) throws IOException {
        out.write("#" + question + System.lineSeparator());
        this.yesTree.write(out);
        this.noTree.write(out);
    } // write
} // class QuestionNode
