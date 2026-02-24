import java.util.Scanner;

public class InputValidation {

    public static int promptInt(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                int count = Integer.valueOf(scanner.nextLine());
                if(count > 0){return count;}
                System.out.println("Enter a number higher than 0");
            }catch(NumberFormatException e){
                System.out.println("Invalid input - enter whole number ");
            }
        }
    }

    public static double promptDouble(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if(value > 0){return value;}
                System.out.println("Enter a number higher than 0");
            }catch(NumberFormatException e){
                System.out.println("Invalid input - enter a valid number");
            }
        }
    }

    public static String promptOptions(Scanner scanner, String prompt, String... validOptions) {
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

    public static ItemType promptItemType(Scanner scanner){
        while(true){
            System.out.print("Choose one of the following types ");
            ItemType[] types = ItemType.values();
            for(int i = 0; i < types.length; i++){
                System.out.print(types[i]);
                if(i < types.length-1){
                    System.out.print(", ");
                }
            }
            System.out.print(": ");

            try{
                return ItemType.valueOf(scanner.nextLine().toLowerCase());
            }catch(IllegalArgumentException e){
                System.out.println("Invalid type ");
            }
        }
    }
}


