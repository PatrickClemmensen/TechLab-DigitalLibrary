public class Video extends LoanItem {

    private int duration;

    public Video(String title, int loanDays, int duration){
        super(title, loanDays);
        this.duration = duration;
    }

    public String getDescription(){
        return "Title: " + this.getTitle() + " | Movie duration (in minutes): " + this.duration + " | Loan duration: " + this.getLoanDays();
    }

    public double calculateFee(){
        return 500;
    }
}
