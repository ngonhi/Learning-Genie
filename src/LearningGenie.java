import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class LearningGenie {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        DecisionTree DTree = new DecisionTree();

        System.out.println("I am the learning genie!");
        System.out.println("I can figure out whatever you are thinking of by asking questions.");
        System.out.println("I know " + DTree.countObjects() + " things!\n");

        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Think of an object.\n");
            DTree.guess(in);
            System.out.print("Do you want to continue? ");
            String userAnswer = in.nextLine().toLowerCase();

            while (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("Incorrect response! Please enter yes/no");
                System.out.print("Do you want to continue? ");
                userAnswer = in.nextLine();
            }

            if(userAnswer.equals("no")) {
                shouldContinue = false;
            }
        }

        try {
            FileWriter f = new FileWriter("");
            DTree.write(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        in.close();
        System.exit(0);
    }
}
