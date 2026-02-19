public class ArduinoKit extends Electronic {
    private String kitLevel;

    public ArduinoKit(String title, int loanDays, String kitLevel, double baseValue) {
        super(title, loanDays, baseValue);
        this.kitLevel = kitLevel;
    }

    public String getKitLevel() {
        return kitLevel;
    }

    @Override
    public String getDescription() {
        return "Title: " + getTitle()
                + " | Kit level: " + this.kitLevel
                + " | Loan duration: " + getLoanDays()
                + " | Base value: " + getBaseValue();
    }
}