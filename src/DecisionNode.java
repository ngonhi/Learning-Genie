import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface DecisionNode {

    /**
     * Returns a count of the number of objects this decision tree records
     * @return count, an integer
     */
    int countObjects();

    /**
     * Performs the guessing game starting at this node using the given Scanner object
     *        to query the user for input
     * @param in
     * @return guessNode  an updated node that is the result of any knowledge learned
     *              during the game
     */
    DecisionNode guess(Scanner in);

    /**
     * Writes this node in the serialized format to the given file represented by out
     * @param out
     * @throws IOException
     */
    void write(FileWriter out) throws IOException;
}
