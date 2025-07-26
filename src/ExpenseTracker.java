
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ExpenseTracker is a console program that helps users track 
 * their daily expenses. The user is capable of creating new entries, 
 * viewing them, remove a specific entry and price of an item.
 * @class
 */
public class ExpenseTracker {
    /**
     * This is the main method for the ExpenseTracker program.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        // Use a Scanner to parse console text input
        try (Scanner scanner = new Scanner(System.in)) {
            // If it exists, load the items from the local file 
            // into a new ArrayList of Expense items.
			ArrayList<Expense> expenses = Storage.loadExpenses();

            // Menu which will continue to show after each action 
            // until the user selects the option to exit.
			while (true) {
			    System.out.println("\nExpense Tracker Menu:");
			    System.out.println("1. Add Expense");
			    System.out.println("2. View Expenses");
			    System.out.println("3. Remove Expense");
			    System.out.println("4. Exit");
			    System.out.print("Enter your choice: ");
			    
                // Get the choice of the user
                int choice = scanner.nextInt();
			    switch (choice) {
                    // Case 1: Add an expense
			        case 1:
                        // Get the necessary data.
			            System.out.print("Enter date (YYYY-MM-DD): ");
			            String date = scanner.next();
			            scanner.nextLine();

			            System.out.print("Enter description: ");
			            String desc = scanner.nextLine();

			            System.out.print("Enter amount: ");
			            double amount = scanner.nextDouble();
                        
                        // Add a new Expense item to the ArrayList and Save it locally
			            expenses.add(new Expense(date, desc, amount));
			            Storage.saveExpenses(expenses);
			            break;
                    // Case 2: View expenses
			        case 2:
                        // Iterate through each Expense item in the ArrayList
                        // and print it.
			            for (Expense e : expenses) {
			                System.out.println(e);
			            }
			            break;
                    // Case 3: Delete an expense
			        case 3:
                        // Get the item position
			        	System.out.print("Enter entry number for removal: ");
			            int index = scanner.nextInt();

                        // Remove 1 to the value to align with Array index
                        // so long as it is higher than 0.
			            if (index > 0) {
                            index -=1;
                        }
			            
                        // Get the information of the item, remove it, 
                        // and print a notice of the items removal
			            Expense item = expenses.get(index);
			            expenses.remove(index);
			            System.out.println(String.format("Successfully removed %s.", item.getDescription()));
			            
                        // Save the new ArrayList
			            Storage.saveExpenses(expenses);
			            break;
                    // Case 4: Exit the program
			        case 4:
			            System.out.println("Session Finished.");
			            return;
                    // If not in one of the options, prompt the user about it 
                    // and return them to the menu.
			        default:
			            System.out.println("Invalid choice. Please select a number from the menu.");
			    }
			}
		}
    }
}
