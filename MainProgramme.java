import java.util.Scanner;

/**
 * This class represents the main program that allows users to choose between two options.
 * Option 1 leads to the execution of the GenericsKbArrayApp class, while option 2 leads to 
 * the execution of the GenericsKbBSTApp class.
 */
public class MainProgramme {
    /**
     * The main method of the program where execution begins.
     * @param args Command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // Display a welcome message prompting the user to choose between options 1 or 2.
        System.out.println("Welcome,choose option 1 for the array and option 2 for the binary search tree");

        // Create a Scanner object to read user input.
        Scanner input = new Scanner(System.in);

        // Read the user's choice.
        int option = input.nextInt();

        // Based on the user's choice, execute the corresponding option.
        if (option == 1) {
            // Execute the GenericsKbArrayApp class.
            GenericsKbArrayApp.main(args);
        } else if (option == 2) {
            // Execute the GenericsKbBSTApp class.
            GenericsKbBSTApp.main(args);
        }
    }
}
