import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; 
import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

/**
 * This class represents an application for managing and interacting with a knowledge base using a binary search tree.
 */
public class GenericsKbBSTApp
{
   /**
    * The main method of the application where execution begins.
    * @param args Command-line arguments passed to the program.
    */  
   public static void main (String[] args)
   {  
      // Create an instance of BinarySearchTree to store the knowledge base.
      BinarySearchTree bt = new BinarySearchTree();
        
      // Declare variables for file input.
      String fileName;
      String[] line;
      boolean flag=true;
      int count = 0;
    
      // Loop for displaying menu and taking user actions.
      while (flag == true)
      {
         // Display menu options.
         System.out.println("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for an item in the knowledge base by term and sentence\n5. Quit");
         System.out.println("Enter your choice: ");
         Scanner scanner = new Scanner(System.in);
         int num = Integer.parseInt(scanner.nextLine());
      
         // Action based on user's choice.
         if (num == 1 )
         {
            // Load knowledge base from a file.
            System.out.println("Enter your file name:");
            fileName = scanner.nextLine();
       
            try
            {  
               File myObj = new File(fileName);
               Scanner myReader = new Scanner(myObj);

               // Read each line from the file, split it, create GenericsFile object, and insert into the binary search tree.
               while (myReader.hasNextLine()) 
               {
                  String data = myReader.nextLine();
                  line = data.split("\t", 3);
                  GenericsFile obj = new GenericsFile(line[0], line[1], Double.parseDouble(line[2]));
                  bt.insert(obj);
                  count += 1;
               }
               System.out.println("Knowledge loaded successfully.");
            }
            catch (FileNotFoundException e)
            {
               System.out.println("File not found.");
            }  
         }
         else if (num == 2)
         {
            // Add a new statement to the knowledge base.
            System.out.println("Enter the term: ");
            String term2 = scanner.nextLine();
          
            System.out.println("Enter the statement: ");
            String statement2 = scanner.nextLine();
          
            System.out.println("Enter the confidence score:");
            String conf2 = scanner.nextLine();
          
            GenericsFile gf2 = new GenericsFile(term2, statement2, Double.parseDouble(conf2));
          
            if (bt.find(gf2) == null)
            {
               bt.insert(gf2);
               System.out.println("The term " + term2 + " has been added to the list.");
            }
         }
         else if (num == 3)
         {
            // Search for an item in the knowledge base by term.
            System.out.println("Enter the term to search: ");
            String term3 = scanner.nextLine();
            GenericsFile gf3 = new GenericsFile(term3, "", 0);
            if (bt.find(gf3) != null)
               System.out.println("Statement found: " + bt.find(gf3).getData().getStatement() + ". Confidence score: (" + bt.find(gf3).getData().getConf() + ")");
            else
            {
               System.out.println("Term does not exist.");
            }                                                                                                                                                                                                                      
         }
         else if (num == 4)
         {
            // Search for an item in the knowledge base by term and sentence.
            System.out.println("Enter the term: ");
            String term4 = scanner.nextLine();
            System.out.println("Enter the statement to search for: ");
            String statement4 = scanner.nextLine();
            GenericsFile gf4 = new GenericsFile(term4, statement4, 0);
         
            if (bt.findStat(gf4) != null)
            {
               System.out.println("The statement was found and has a confidence score " + bt.find(gf4).getData().getConf());
            }
            else
            {
               System.out.println("Sorry, seems like either your term or statement do not exist in this textfile :(");
            }
         }
         else if (num == 5)
         {
            // Quit the application.
            flag = false;
         }
      }
   }
}
