import java.util.ArrayList;

//Utility class with all sorting logic (using bubble sort) -IP
public class LoanSorter {

    public static ArrayList<LoanItem> sort(ArrayList<LoanItem> items) { //returns a list of LoanItem and referred to by items
        int n = items.size();
        boolean swapped; //swapped boolean added to initiate early break in case of no swaps to reduce unnecessary iterations

        System.out.println();
        System.out.println("Here's the list - sorted by shortest loan duration - for your convenience: ");
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) { //inner loop that does the comparison between the values of the index
                if (items.get(j).getLoanDays() > items.get(j + 1).getLoanDays()) {
                    LoanItem temp = items.get(j); //LoanItem "datatype" variable called "temp" as a placeholder equals to an element from the index being sorted
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp); //0+1, temporary value of the placeholder determined by which element in the index is being sorted
                    swapped = true; // makes it loop once more
                }
            }

            if (!swapped) {
                break;
            }
        }
        return items;
    }
}
