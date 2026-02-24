public class Book extends LoanItem {
    private String author;
    private static final double dailyLateFee = 1.5;

    public Book(String title, int loanDays, String author){
        super(title, loanDays);
        this.author = author;
    }

    public double getDailyLateFee(){
        return dailyLateFee;
    }
    public String getAuthor(){return this.author;}

    @Override
    protected String getDetails(){
        return " | Author: " + getAuthor();
    }

}
