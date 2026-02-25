import java.util.Scanner;
import java.util.ArrayList;

/**
 * Handles all user interaction for the TechLab loan system.
 * Responsible for collecting loan item input and displaying the loan summary.
 * Delegates input validation to InputValidation and item creation to LoanItemFactory.
 */
public class UserInterface {
    private LoanItemFactory factory;
    private Scanner scanner;

    /**
     * @param scanner the Scanner to read user input from
     * @param factory the factory used to create LoanItem instances
     */
    public UserInterface(Scanner scanner, LoanItemFactory factory){
        this.factory = factory;
        this.scanner = scanner;
    }

    /**
     * Guides the user through entering all loan items for this session.
     * Prompts for item count, then collects type, title, loan duration,
     * and type-specific details for each item via LoanItemFactory.
     * @return a list of fully constructed LoanItem objects
     */
    public ArrayList<LoanItem> collectItems(){
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("------------------------------------------");

        int count = InputValidation.promptInt(scanner, "How many items would you like to borrow? ");

        ArrayList<LoanItem> loanItems = new ArrayList<>();

        for(int i = 0; i < count; i++){
            System.out.println("Item #" + (i + 1));
            ItemType type = InputValidation.promptItemType(scanner);

            System.out.print("Title: ");
            String title = scanner.nextLine();

            int loanDays = InputValidation.promptInt(scanner, "Loan duration (days): ");

            loanItems.add(factory.create(type, title, loanDays, scanner));
        }
        System.out.println();
        System.out.println("Here's a list of the items you've borrowed: ");
        return loanItems;
    }

    /**
     * Prints the full description of each item in the list,
     * followed by a summary of the total number of items borrowed.
     * @param items the list of LoanItems to display
     */
    public void displaySummary(ArrayList<LoanItem> items){
        for(LoanItem i : items){
            System.out.println(i.getDescription());
        }
        System.out.println();
        System.out.println("Summary: ");
        System.out.println("You've borrowed " + items.size() + " items today.");
    }
}