/**
 * Expense holds data for the date, description,
 * and price of an item.
 * @param date string Date of the expense record
 * @param description string Description of the expense item
 * @param amount double Price of the expense item 
 * @class
 */
public class Expense {
    private String date;
    private String description;
    private double amount;

    /**
     * Builds an Expense item
     * @param date string Date of the expense record
     * @param description string Description of the expense item
     * @param amount double Price of the expense item 
     * @constructor
     * @see Expense
     */
    public Expense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Functions to get the data 

    /**
    * This method is used to get the value of the date property.
    * @return string This returns the value of the date property.
    */
    public String getDate() {
        return date;
    }

    /**
    * This method is used to get the value of the description property.
    * @return string This returns the value of the description property.
    */
    public String getDescription() {
        return description;
    }

    /**
    * This method is used to get the value of the amount property.
    * @return double This returns the value of the amount property.
    */
    public double getAmount() {
        return amount;
    }
    
    /**
    * This method overrides the toString() method to
    * replace the outcome with the desired message.
    * @return string This returns a formatted message of the Expense Item data.
    */
    @Override
    public String toString() {
        return String.format("Date: %s | Description: %s | Amount: %s$", date, description, amount);
    }
}
