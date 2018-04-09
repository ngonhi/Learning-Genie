import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DecisionTree {
    // Field
    private DecisionNode root;

    /**
     * Construct a DecisionTree with an initial guess node containing Dog
     */
    DecisionTree() {
        this.root = new GuessNode("Dog");
    }

    /**
     * Constructs a DecisionTree stored in a serialized form in the given file
     * @param file
     * @throws FileNotFoundException
     */
    public DecisionTree(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        root = DecisionTreeHelper(in);
        in.close();
    }

    /**
     * Gets the nodes stored in a serialized form in the given file
     * @param in
     * @return
     */
    private DecisionNode DecisionTreeHelper(Scanner in) {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.charAt(0) != '#') {
                return new GuessNode(line);
            } else {
                return new QuestionNode(line.substring(1, line.length()), DecisionTreeHelper(in),
                        DecisionTreeHelper(in));
            }
        }

        // If file is empty
        return root;
    }

    // Methods
    /**
     * Returns a count of the number of objects this decision tree records
     * @return count, an integer
     */
    public int countObjects() {
        return root.countObjects();
    } // countObjects

    /**
     * Performs the guessing game starting at the root of the tree using the given 
     *   Scanner object to query the user for input and modify the the decision tree 
     *   if the genie learns any additional information in playing the game.
     */
    public void guess(Scanner in) {
        root = root.guess(in);
    } // guess

     /**
     * Writes this node in the serialized format to the given file represented by out
     * @param out
     * @throws IOException
     */
    public void write(FileWriter out) throws IOException {
        root.write(out);
        out.close();
    } // write
}
