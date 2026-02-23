import java.util.Scanner;


public class LoanItemFactory {

    public LoanItemFactory(){
    }

    InputValidation validation = new InputValidation();

    public LoanItem create(ItemType type, String title, int loanDays, Scanner scanner){

        switch(type){
            case book:
                System.out.print("Author: ");
                String author = scanner.nextLine();
                return new Book(title, loanDays, author);

            case video:
                int duration = validation.promptInt(scanner, "Duration (minutes): ");
                return new Video(title, loanDays, duration);

            case raspberry_pi:
                String model = validation.promptOptions(scanner, "Model ", "4B", "5");
                double piValue = validation.promptDouble(scanner, "Base value: ");
                return new RaspberryPi(title, loanDays, piValue, model);

            case arduino_kit:
                String kitLevel = validation.promptOptions(scanner, "Kit level ", "Beginner", "Advanced", "Ultra");
                double kitValue = validation.promptDouble(scanner, "Base value: ");
                return new ArduinoKit(title, loanDays, kitLevel, kitValue);

            default:
                throw new IllegalArgumentException("Unhandled item type: " + type);
        }
    }

}
