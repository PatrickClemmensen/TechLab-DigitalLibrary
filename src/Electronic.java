/**
 * Abstract class representing electronic loan items in the TechLab system.
 * Extends LoanItem with a base value field used to calculate the daily late fee.
 * Provides shared behaviour for all hardware items — RaspberryPi and ArduinoKit.
 * Cannot be instantiated directly.
 */
public abstract class Electronic extends LoanItem {
    private double baseValue;

    /**
     * @param title     the title or name of the device
     * @param loanDays  the number of days the item is borrowed for
     * @param baseValue the monetary value of the device in kr, used to calculate the late fee
     */
    public Electronic(String title, int loanDays, double baseValue){
        super(title, loanDays);
        this.baseValue = baseValue;
    }

    /**
     * Returns the base monetary value of this electronic item.
     * @return the base value in kr
     */
    public double getBaseValue(){ return this.baseValue; }

    /**
     * Calculates the daily late fee as 8% of the base value.
     * Shared across all electronic subclasses — RaspberryPi and ArduinoKit
     * do not need to override this unless their fee calculation differs.
     * @return baseValue * 0.08
     */
    public double getDailyLateFee(){
        return baseValue * 0.08;
    }

    /**
     * Returns the base value as a formatted detail string.
     * Called by subclasses via super.getDetails() to append base value
     * after their own unique details in the description chain.
     * @return formatted base value string
     */
    @Override
    protected String getDetails(){
        return " | Base value: " + getBaseValue();
    }
}