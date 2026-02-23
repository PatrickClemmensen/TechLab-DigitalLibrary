import java.util.Scanner;
import java.util.ArrayList;

public class    UserInterface {
    private LoanItemFactory factory;
    private Scanner scanner;

    public UserInterface(Scanner scanner, LoanItemFactory factory){
        this.factory = factory;
        this.scanner = scanner;
    }

    InputValidation validation = new InputValidation();

    public ArrayList<LoanItem> collectItems(){
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("------------------------------------------");

        int count = validation.promptInt(scanner, "How many items would you like to borrow? ");

        ArrayList<LoanItem> loanItems = new ArrayList<>();

        for(int i = 0; i < count; i++){
            System.out.println("Item #"+(i+1));
            ItemType type = promptItemType();

            System.out.print("Title: ");
            String title = scanner.nextLine();

            int loanDays = validation.promptInt(scanner, "Loan duration (days): ");

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
