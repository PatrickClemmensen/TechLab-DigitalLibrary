import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private ArrayList<LoanItem> loanItems;
    private Scanner scanner;

    public UserInterface(Scanner scanner){
        this.loanItems = new ArrayList<>();
        this.scanner = scanner;
    }

    public void collectItems(){
        LoanItemFactory loanItemFactory = new LoanItemFactory();
        System.out.print("How many items would you like to loan? Please enter a number: ");
        int itemsToLoan = scanner.nextInt(); //receive loan count
        scanner.nextLine(); // clears buffer

        while(itemsToLoan > 0){

            System.out.print("Which type of item would you like to loan? Pick a book/video/electronic by typing it: ");

            String type = scanner.nextLine();
            LoanItem itemToLoan = loanItemFactory.create(type, scanner);

            if(itemToLoan != null){
                loanItems.add(itemToLoan);
                itemsToLoan--;
            }
        }
    }

    public void displaySummary(){
        for(LoanItem i : loanItems){
            System.out.println(i.getDescription());
        }
    }

}
