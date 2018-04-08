import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface DecisionNode {
    int countObjects();
    DecisionNode guess(Scanner in);
    void write(FileWriter out) throws IOException;
}
