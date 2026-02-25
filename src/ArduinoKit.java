/**
 * Represents an Arduino starter kit available for loan in the TechLab system.
 * Daily late fee is calculated as 8% of the base value, inherited from Electronic.
 */
public class ArduinoKit extends Electronic {
    private String kitLevel;

    /**
     * @param title     the name or title of the kit
     * @param loanDays  the number of days the kit is borrowed for
     * @param kitLevel  the difficulty level of the kit — "Beginner", "Advanced", or "Ultra"
     * @param baseValue the monetary value of the kit in kr
     */
    public ArduinoKit(String title, int loanDays, String kitLevel, double baseValue) {
        super(title, loanDays, baseValue);
        this.kitLevel = kitLevel;
    }

    /**
     * Returns the difficulty level of this Arduino kit.
     * @return "Beginner", "Advanced", or "Ultra"
     */
    public String getKitLevel() {
        return kitLevel;
    }

    /**
     * Returns the kit level as the unique detail for this item.
     * Calls super.getDetails() to append Electronic's base value afterwards,
     * ensuring kit level appears before base value in the description.
     * @return formatted kit level string followed by base value from Electronic
     */
    @Override
    protected String getDetails(){
        return " | Kit level: " + getKitLevel() + super.getDetails();
    }
}