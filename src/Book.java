/**
 * Represents a programming book available for loan in the TechLab system.
 * Charges a fixed daily late fee of 1.5 kr.
 */
public class Book extends LoanItem {
    private String author;
    private static final double dailyLateFee = 1.5;

    /**
     * @param title    the title of the book
     * @param loanDays the number of days the book is borrowed for
     * @param author   the name of the book's author
     */
    public Book(String title, int loanDays, String author){
        super(title, loanDays);
        this.author = author;
    }

    /**
     * Returns the fixed daily late fee for books.
     * @return 1.5 kr per day overdue
     */
    public double getDailyLateFee(){
        return dailyLateFee;
    }

    /**
     * Returns the author of this book.
     * @return the author's name
     */
    public String getAuthor(){ return this.author; }

    /**
     * Returns the author as the unique detail for this item.
     * Appended by LoanItem.getDescription() between title and loan duration.
     * @return formatted author string
     */
    @Override
    protected String getDetails(){
        return " | Author: " + getAuthor();
    }
}