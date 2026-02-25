/**
 * Abstract base class representing a borrowable item in the TechLab loan system.
 * Defines the shared contract that all loan items must fulfil — every item
 * must have a title, loan duration, a daily late fee, and a description.
 * Cannot be instantiated directly — use Book, Video, RaspberryPi, or ArduinoKit.
 */
public abstract class LoanItem {
    private String title;
    private int loanDays;

    /**
     * @param title    the title or name of the loan item
     * @param loanDays the number of days the item is borrowed for
     */
    public LoanItem(String title, int loanDays){
        this.title = title;
        this.loanDays = loanDays;
    }

    /**
     * Returns the title of this loan item.
     * @return the item title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Returns the loan duration for this item.
     * @return the number of days borrowed
     */
    public int getLoanDays(){
        return this.loanDays;
    }

    /**
     * Calculates the total late fee for a given number of days overdue.
     * Uses the item's daily late fee rate, resolved polymorphically.
     * @param daysOverdue the number of days the item is overdue
     * @return the total late fee in kr
     */
    public double calculateFee(int daysOverdue){
        return (getDailyLateFee() * daysOverdue);
    }

    /**
     * Returns the daily late fee rate for this item.
     * Each subclass defines its own rate — books, videos, and electronics
     * all charge differently.
     * @return the fee charged per day overdue in kr
     */
    public abstract double getDailyLateFee();

    /**
     * Returns a string describing the unique attributes of this item type.
     * Called by getDescription() to build the full item description.
     * Each subclass defines only what is unique to it — shared fields
     * are handled by this class and Electronic.
     * @return type-specific details as a formatted string
     */
    protected abstract String getDetails();

    /**
     * Builds and returns the full description of this item.
     * Combines title, type-specific details from getDetails(), loan duration,
     * and daily late fee rate into a single formatted string.
     * @return the complete formatted description
     */
    public String getDescription(){
        return "Title: " + getTitle() + getDetails() + " | Loan duration: " + getLoanDays() + " days | Daily late fee rate: " + getDailyLateFee() + " kr.";
    }
}