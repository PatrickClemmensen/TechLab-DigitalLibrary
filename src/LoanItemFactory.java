import java.util.Scanner;

/**
 * Responsible for creating LoanItem instances based on item type.
 * Handles all type-specific user prompting and object construction,
 * keeping creation logic in one place and out of UserInterface.
 * Uses InputValidation for all validated input collection.
 */
public class LoanItemFactory {

    /**
     * Default constructor. LoanItemFactory requires no initial configuration.
     */
    public LoanItemFactory(){
    }

    /**
     * Creates and returns a LoanItem of the specified type.
     * Prompts the user for type-specific attributes via InputValidation,
     * then constructs and returns the appropriate LoanItem subclass.
     * @param type     the type of item to create, from the ItemType enum
     * @param title    the title of the item, collected by UserInterface
     * @param loanDays the loan duration in days, collected by UserInterface
     * @param scanner  the Scanner to pass to InputValidation for type-specific prompts
     * @return a fully constructed LoanItem subclass instance
     * @throws IllegalArgumentException if an unhandled ItemType is passed in
     */
    public LoanItem create(ItemType type, String title, int loanDays, Scanner scanner){
        switch(type){
            case book:
                System.out.print("Author: ");
                String author = scanner.nextLine();
                return new Book(title, loanDays, author);

            case video:
                int duration = InputValidation.promptInt(scanner, "Duration (minutes): ");
                return new Video(title, loanDays, duration);

            case raspberry_pi:
                String model = InputValidation.promptOptions(scanner, "Model ", "4B", "5");
                double piValue = InputValidation.promptDouble(scanner, "Base value: ");
                return new RaspberryPi(title, loanDays, piValue, model);

            case arduino_kit:
                String kitLevel = InputValidation.promptOptions(scanner, "Kit level ", "Beginner", "Advanced", "Ultra");
                double kitValue = InputValidation.promptDouble(scanner, "Base value: ");
                return new ArduinoKit(title, loanDays, kitLevel, kitValue);

            default:
                throw new IllegalArgumentException("Unhandled item type: " + type);
        }
    }
}