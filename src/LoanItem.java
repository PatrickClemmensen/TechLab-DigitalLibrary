public abstract class LoanItem {
    private String title;
    private int loanDays;

    public LoanItem(String title, int loanDays){
        this.title = title;
        this.loanDays = loanDays;
    }

    public String getTitle(){
        return this.title;
    }

    public int getLoanDays(){
        return this.loanDays;
    }

    public abstract double getDailyLateFee();
    protected abstract String getDetails();

    public String getDescription(){
        return "Title: " + getTitle() + getDetails() + " | Loan duration: " + getLoanDays()+" | Daily late fee: "+getDailyLateFee()+" kr.";
    }
}
