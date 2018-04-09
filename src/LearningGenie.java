import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

class LearningGenie {

    private static String savePath = Paths.get(System.getProperty("user.dir"), "src", "FoodData.txt").toString();

    public static void main (String[] args) throws FileNotFoundException {

        //read from the file
        Scanner in = new Scanner(System.in);
        DecisionTree DTree = new DecisionTree(new File(savePath));

        //play the game
        System.out.println("I am the learning genie!");
        System.out.println("I can figure out whatever you are thinking of by asking questions.");
        System.out.println("I know " + DTree.countObjects() + " things!\n");

        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Think of an object.\n");
            DTree.guess(in);
            System.out.print("Do you want to continue? ");
            String userAnswer = in.nextLine().trim().toLowerCase();

            while (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("Incorrect response! Please enter yes/no");
                System.out.print("Do you want to continue? ");
                userAnswer = in.nextLine().trim().toLowerCase();
            }

            if(userAnswer.equals("no")) {
                shouldContinue = false;
            }
        }

        //write into file
        try {
            FileWriter f = new FileWriter(savePath);
            DTree.write(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        in.close();
        System.exit(0);
    }
}
