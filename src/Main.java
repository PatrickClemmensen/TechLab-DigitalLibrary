import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);

        ArrayList<LoanItem> items = ui.collectItems();
        ui.displaySummary(items);

    }
}
