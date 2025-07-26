
import java.io.*;
import java.util.ArrayList;

/**
 * Storage is a utility class that helps with the retrieval,
 * and storage of an ArrayList of Expense items.
 * @class
 */
public class Storage {
    // Assume that the filename for the records will be "expenses.txt"
    private static final String FILENAME = "expenses.txt";

    // Prevents the class from being instantiated through the constructor
    private Storage() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
    * Save an ArrayList of Expense items to a file
    * @param expenses ArrayList of Expense items 
    * @return Nothing
    */
    public static void saveExpenses(ArrayList<Expense> expenses) {
        // Begin with creating a PrintWriter that uses FileWriter as writer for simplicity,
        //  and the filename for location.
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            // Iterate through each Expense item and print it on the file with the PrintWriter. 
            for (Expense e : expenses) {
                writer.println(e.getDate() + "," + e.getDescription() + "," + e.getAmount());
            }
        // Error handling
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    /**
    * Return an ArrayList of Expense items from a file
    * @return ArrayList of Expense items.
    */
    public static ArrayList<Expense> loadExpenses() {
        // Create an empty ArrayList
        ArrayList<Expense> expenses = new ArrayList<>();
        // Use a FileReader with the filename for location, and wrap it 
        // inside a BufferedRader for performance.
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            // Go through each line until it is null
            while ((line = reader.readLine()) != null) {
                // Split the contents of the line by the "," symbol
                String[] parts = line.split(",");
                // Instantiate new Expense items with the parts and add them to the ArrayList
                expenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        // Error handling
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
        // Return the ArrayList
        return expenses;
    }
}
