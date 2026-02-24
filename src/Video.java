public class Video extends LoanItem {
    private int duration;
    private final static double dailyLateFee = 2.5;

    public Video(String title, int loanDays, int duration){
        super(title, loanDays);
        this.duration = duration;
    }

    public int getDuration(){return this.duration;}

    @Override
    protected String getDetails(){
        return " | Duration: " + getDuration() + " minutes";
    }

    public double getDailyLateFee(){
        return dailyLateFee;
    }
}
