import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private LoanItemFactory factory;
    private Scanner scanner;

    public UserInterface(Scanner scanner, LoanItemFactory factory){
        this.factory = factory;
        this.scanner = scanner;
    }

    public ArrayList<LoanItem> collectItems(){
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("------------------------------------------");

        int count = promptInt("How many items would you like to borrow? ");

        ArrayList<LoanItem> loanItems = new ArrayList<>();

        for(int i = 0; i < count; i++){
            System.out.println("Item #"+(i+1));
            ItemType type = promptItemType();

            System.out.print("Title: ");
            String title = scanner.nextLine();

            int loanDays = promptInt("Loan duration (days): ");

            loanItems.add(factory.create(type, title, loanDays, scanner));
        }
        return loanItems;
    }

    public void displaySummary(ArrayList<LoanItem> items){
        for(LoanItem i : items){
            System.out.println(i.getDescription());
        }
        System.out.println("Summary: ");
        System.out.println("You borrowed "+ items.size() + " items today.");
    }

    private int promptInt(String prompt){
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

    private ItemType promptItemType(){
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
