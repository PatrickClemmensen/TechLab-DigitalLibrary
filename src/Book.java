public class Book extends LoanItem {
    private String author;
    private static final double lateFee = 1.5;

    public Book(String title, int loanDays, String author){
        super(title, loanDays);
        this.author = author;
    }

    public double getDailyLateFee(){
        return lateFee;
    }

    @Override
    protected String getDetails(){
        return " | Author: " + author;
    }


}
