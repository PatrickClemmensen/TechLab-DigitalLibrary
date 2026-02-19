public class Electronic extends LoanItem {
    private String modelName;

    public Electronic(String title, int loanDays, String modelName){
        super(title, loanDays);
        this.modelName = modelName;
    }

    public double calculateFee(){
        return 100;
    }

    public String getDescription(){
        return "Title: " + this.getTitle() + " | Model: "+ this.modelName + " | Loan duration: " + this.getLoanDays();
    }


}
