public class RaspberryPi extends Electronic {
    private String model;
    public RaspberryPi(String title, int loanDays, double baseValue, String model){
        super(title, loanDays, baseValue);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    protected String getDetails(){
        return " | Model: " + model + super.getDetails();
    }
}
