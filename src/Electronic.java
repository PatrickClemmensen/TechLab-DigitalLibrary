public abstract class Electronic extends LoanItem {
    private double baseValue;

    public Electronic(String title, int loanDays, double baseValue){
        super(title, loanDays);
        this.baseValue = baseValue;
    }

    public double getBaseValue(){return this.baseValue;}
    @Override
    public double getDailyLateFee(){
        return baseValue*0.08;
    }

    public abstract String getDescription();


}
