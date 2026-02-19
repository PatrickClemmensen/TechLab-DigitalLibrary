public class Book extends LoanItem {
    private String author;

    public Book(String title, int loanDays, String author){
        super(title, loanDays);
        this.author = author;
    }

    public double calculateFee(){
        return 30;
    }

    public String getDescription(){
        return "Title: "+this.getTitle()+" Author: "+this.author;
    }


}
