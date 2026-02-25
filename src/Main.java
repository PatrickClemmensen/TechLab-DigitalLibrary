import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point for the TechLab Loan System.
 * Initialises all dependencies and orchestrates the loan collection,
 * sorting, and display flow. Intentionally kept minimal — each step
 * is delegated to a class with a single, dedicated responsibility.
 */
public class Main {

    /**
     * Creates the Scanner, UserInterface, and LoanItemFactory,
     * then collects items, displays the unsorted list, sorts by loan duration,
     * and displays the sorted summary.
     * @param args command-line arguments, not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner, new LoanItemFactory());
        ArrayList<LoanItem> items = ui.collectItems();
        ui.displaySummary(items);
        LoanSorter.sort(items, LoanSorter.BY_LOAN_DAYS);
        ui.displaySummary(items);
    }
}