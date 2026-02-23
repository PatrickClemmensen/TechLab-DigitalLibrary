import java.util.Scanner;

public class InputValidation {

    public int promptInt(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                int count = Integer.valueOf(scanner.nextLine());
                if(count > 0){return count;}
                System.out.println("Enter a number higher than 0");
            }catch(NumberFormatException e){
                System.out.println("Invalid input - enter whole number");
            }
        }
    }

    public double promptDouble(Scanner scanner, String prompt){
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

    public String promptOptions(Scanner scanner, String prompt, String... validOptions) {
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


