/**
 * Represents a tutorial video available for loan in the TechLab system.
 * Charges a fixed daily late fee of 2.5 kr.
 */
public class Video extends LoanItem {
    private int duration;
    private final static double dailyLateFee = 2.5;

    /**
     * @param title    the title of the video
     * @param loanDays the number of days the video is borrowed for
     * @param duration the runtime of the video in minutes
     */
    public Video(String title, int loanDays, int duration){
        super(title, loanDays);
        this.duration = duration;
    }

    /**
     * Returns the runtime of this video.
     * @return duration in minutes
     */
    public int getDuration(){ return this.duration; }

    /**
     * Returns the duration as the unique detail for this item.
     * Appended by LoanItem.getDescription() between title and loan duration.
     * @return formatted duration string in minutes
     */
    @Override
    protected String getDetails(){
        return " | Duration: " + getDuration() + " minutes";
    }

    /**
     * Returns the fixed daily late fee for videos.
     * @return 2.5 kr per day overdue
     */
    public double getDailyLateFee(){
        return dailyLateFee;
    }
}