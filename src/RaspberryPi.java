/**
 * Represents a Raspberry Pi board available for loan in the TechLab system.
 * Daily late fee is calculated as 8% of the base value, inherited from Electronic.
 */
public class RaspberryPi extends Electronic {
    private String model;

    /**
     * @param title     the name or title of the device
     * @param loanDays  the number of days the device is borrowed for
     * @param baseValue the monetary value of the device in kr
     * @param model     the model of the Raspberry Pi — either "4B" or "5"
     */
    public RaspberryPi(String title, int loanDays, double baseValue, String model){
        super(title, loanDays, baseValue);
        this.model = model;
    }

    /**
     * Returns the model of this Raspberry Pi.
     * @return model string, either "4B" or "5"
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the model as the unique detail for this item.
     * Calls super.getDetails() to append Electronic's base value afterward,
     * ensuring model appears before base value in the description.
     * @return formatted model string followed by base value from Electronic
     */
    @Override
    protected String getDetails(){
        return " | Model: " + model + super.getDetails();
    }
}