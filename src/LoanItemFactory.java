import java.util.Scanner;


public class LoanItemFactory {

    public LoanItemFactory(){
    }

    public LoanItem create(ItemType type, String title, int loanDays, Scanner scanner){

        switch(type){
            case book:
                System.out.print("Author: ");
                String author = scanner.nextLine();
                return new Book(title, loanDays, author);

            case video:
                System.out.print("Duration (minutes): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                return new Video(title, loanDays, duration);

            case raspberry_pi:
                String model = promptOptions(scanner, "Model ", "4B", "5");

                System.out.print("Base value: ");
                double piValue = Double.parseDouble(scanner.nextLine().trim());
                return new RaspberryPi(title, loanDays, piValue, model);

            case arduino_kit:
                String kitLevel = promptOptions(scanner, "Kit level ", "Beginner", "Advanced", "Ultra");
                System.out.print("Base value: ");
                double kitValue = Double.parseDouble(scanner.nextLine().trim());
                return new ArduinoKit(title, loanDays, kitLevel, kitValue);

            default:
                throw new IllegalArgumentException("Unhandled item type: " + type);
        }
    }
    private String promptOptions(Scanner scanner, String prompt, String... validOptions) {
        while (true) {
            System.out.print(prompt+"("+String.join(", ", validOptions)+"): ");
            String input = scanner.nextLine().trim();
            for (String option : validOptions) {
                if (input.equalsIgnoreCase(option)) {
                    return option;
                }
            }
            System.out.print("Invalid input — valid options are: ");
            System.out.println(String.join(", ", validOptions));
        }
    }
}
