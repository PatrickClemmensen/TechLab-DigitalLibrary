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
        System.out.println();
        System.out.println("Here's a list of the items you've borrowed: ");
        return loanItems;
    }

    public void displaySummary(ArrayList<LoanItem> items){
        for(LoanItem i : items){
            System.out.println(i.getDescription());
        }
        System.out.println();
        System.out.println("Summary: ");
        System.out.println("You've borrowed "+ items.size() + " items today.");
    }

    public void displayFinalSummary(ArrayList<LoanItem> items){
        for(LoanItem i : items){
            System.out.println(i.getDescription());
        }
        System.out.println();
        //System.out.println("Don't forget to return your items within the time limit to avoid a late fee charge.\nThank you for using the TechLab Loan System and enjoy your borrowed items! (づ ◕‿◕ )づ\n\nAlso... we have ties with the mafia, in case you forget to pay your late fee charge... ᕦ(▀̿ ̿ -▀̿ ̿ )つ/̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿\n... Sleeping with the fishes ain't as fun as it sounds... (－_－) zzZ");

    }
}