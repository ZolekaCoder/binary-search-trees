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
 * This class represents an application for managing and interacting with a knowledge base using an array.
 */
public class GenericsKbArrayApp
{
   /**
    * The main method of the application where execution begins.
    * @param args Command-line arguments passed to the program.
    */  
   public static void main (String[] args)
   {      
      String fileName;
      int n = 0;
      String[] line;
      GenericsFile[] objs;
      int count = 0;
      boolean flag=true;
      objs = new GenericsFile[200000];
      
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
                  
               while (myReader.hasNextLine()) 
               {
                  String data = myReader.nextLine();
                  line = data.split("\t", 3);
                  count += 1;
                  GenericsFile obj = new GenericsFile(line[0], line[1], Double.parseDouble(line[2]));
                  objs[n] = obj;
                  n += 1;
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
          
            boolean changed = false;
            
            // Iterate through existing items to check for updates.
            for (int i = 0; i < count; i++)
            {
               if (term2.equals(objs[i].getTerm()) && (!statement2.equals(objs[i].getStatement())) && (Double.parseDouble(conf2) > objs[i].getConf()))
               {  
                  objs[i].setStatement(statement2);
                  objs[i].setConf(Double.parseDouble(conf2));
                  System.out.println("Statement for term " +term2+ " has been updated.");
                  changed = true;
                  break;
               }
            }
                  
            // If no update occurred, add a new statement.
            if (changed == false)
            {
               GenericsFile newObj = new GenericsFile (term2, statement2, Double.parseDouble(conf2));
               objs[count] = newObj;
               count += 1;
               System.out.println("The term " +term2+ " has been added to the list.");
            }
         }
         else if (num == 3)
         {
            // Search for an item in the knowledge base by term.
            System.out.println("Enter the term to search: ");
            String term3 = scanner.nextLine();
            boolean exists = false;
            for (int i = 0; i<count; i++)
            {   
               if (term3.equals(objs[i].getTerm()))
               {
                  System.out.println("Statement found: " + objs[i].getStatement() + " (Confidence score: " + objs[i].getConf() + ")");
                  exists = true;
                  break;
               }
            }
        
            if (exists == false)
            {
               System.out.println("Oops, looks like that word doesn't exist in this textfile. Please try again :)");
            }
         }
         else if (num == 4)
         {
            // Search for an item in the knowledge base by term and sentence.
            System.out.println("Enter the term: ");
            String term4 = scanner.nextLine();
            System.out.println("Enter the statement to search for: ");
            String statement4 = scanner.nextLine();
          
            boolean exists4 = false;
          
            for (int i = 0; i<count; i++)
            {   
               if ((term4.equals(objs[i].getTerm())) && (statement4.equals(objs[i].getStatement())))
               {   
                  exists4 = true;
                  System.out.println("The statement was found and has a confidence score of " + objs[i].getConf() + ".");
               
               }
            }
        
            if (exists4 == false)
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
