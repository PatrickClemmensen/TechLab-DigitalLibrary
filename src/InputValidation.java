import java.util.Scanner;

/**
 * Utility class providing validated user input methods.
 * All methods loop until the user provides valid input, preventing
 * invalid data from entering the system.
 * All methods are static — this class is not intended to be instantiated.
 */
public class InputValidation {

    /**
     * Prompts the user for a positive integer, looping until valid input is received.
     * Catches non-numeric input via NumberFormatException and rejects values below 1.
     * @param scanner the Scanner to read user input from
     * @param prompt  the message displayed to the user
     * @return a validated positive integer greater than 0
     */
    public static int promptInt(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                int count = Integer.valueOf(scanner.nextLine());
                if(count > 0){ return count; }
                System.out.println("Enter a number higher than 0");
            } catch(NumberFormatException e){
                System.out.println("Invalid input - enter whole number ");
            }
        }
    }

    /**
     * Prompts the user for a positive decimal number, looping until valid input is received.
     * Catches non-numeric input via NumberFormatException and rejects values below 0.
     * @param scanner the Scanner to read user input from
     * @param prompt  the message displayed to the user
     * @return a validated positive double greater than 0
     */
    public static double promptDouble(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if(value > 0){ return value; }
                System.out.println("Enter a number higher than 0");
            } catch(NumberFormatException e){
                System.out.println("Invalid input - enter a valid number");
            }
        }
    }

    /**
     * Prompts the user to select from a set of valid options, looping until valid input is received.
     * Comparison is case-insensitive. Valid options are displayed inline with the prompt.
     * @param scanner       the Scanner to read user input from
     * @param prompt        the message displayed to the user
     * @param validOptions  the accepted input values
     * @return the matched option exactly as defined in validOptions
     */
    public static String promptOptions(Scanner scanner, String prompt, String... validOptions) {
        while (true) {
            System.out.print(prompt + "(" + String.join(", ", validOptions) + "): ");
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

    /**
     * Prompts the user to enter a valid ItemType, looping until valid input is received.
     * Displays all available types from the ItemType enum dynamically —
     * no changes needed here when new types are added to ItemType.
     * @param scanner the Scanner to read user input from
     * @return the validated ItemType entered by the user
     */
    public static ItemType promptItemType(Scanner scanner){
        while(true){
            System.out.print("Choose one of the following types ");
            ItemType[] types = ItemType.values();
            for(int i = 0; i < types.length; i++){
                System.out.print(types[i]);
                if(i < types.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print(": ");
            try{
                return ItemType.valueOf(scanner.nextLine().toLowerCase());
            } catch(IllegalArgumentException e){
                System.out.println("Invalid type ");
            }
        }
    }
}