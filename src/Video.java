public class Video extends LoanItem {
    private int duration;
    private final static double dailyLateFee = 2.5;

    public Video(String title, int loanDays, int duration){
        super(title, loanDays);
        this.duration = duration;
    }

    @Override
    protected String getDetails(){
        return " | Duration: " + duration + " minutes";
    }

    public double getDailyLateFee(){
        return dailyLateFee;
    }
}
