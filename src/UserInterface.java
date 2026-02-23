import java.util.Scanner;
import java.util.ArrayList;

public class    UserInterface {
    private LoanItemFactory factory;
    private Scanner scanner;

    public UserInterface(Scanner scanner, LoanItemFactory factory){
        this.factory = factory;
        this.scanner = scanner;
    }


    public ArrayList<LoanItem> collectItems(){
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("------------------------------------------");

        int count = InputValidation.promptInt(scanner, "How many items would you like to borrow? ");

        ArrayList<LoanItem> loanItems = new ArrayList<>();

        for(int i = 0; i < count; i++){
            System.out.println("Item #"+(i+1));
            ItemType type = InputValidation.promptItemType(scanner);

            System.out.print("Title: ");
            String title = scanner.nextLine();

            int loanDays = InputValidation.promptInt(scanner, "Loan duration (days): ");

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


}
