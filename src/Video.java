public class Video extends LoanItem {

    private int duration;

    public Video(String title, int loanDays, int duration){
        super(title, loanDays);
        this.duration = duration;
    }

    public String getDescription(){
        return "Title: " + this.getTitle() + "LoanDays: " + this.getLoanDays() +
                "Duration" + this.duration;
    }

    public double calculateFee(){
        return 500;
    }
}
