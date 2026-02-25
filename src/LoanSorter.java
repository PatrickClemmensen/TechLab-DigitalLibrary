import java.util.ArrayList;
import java.util.Comparator;

/**
 * Utility class providing sorting functionality for lists of LoanItems.
 * Uses bubble sort with an early-exit optimisation — if no swaps occur
 * in a pass, the list is already sorted and the algorithm stops early.
 * All methods are static — this class is not intended to be instantiated.
 */
public class LoanSorter {

    /** Comparator that sorts LoanItems alphabetically by title. */
    public static final Comparator<LoanItem> BY_TITLE =
            (a, b) -> a.getTitle().compareTo(b.getTitle());

    /** Comparator that sorts LoanItems by daily late fee, ascending. */
    public static final Comparator<LoanItem> BY_LATE_FEE =
            (a, b) -> Double.compare(a.getDailyLateFee(), b.getDailyLateFee());

    /** Comparator that sorts LoanItems by loan duration, ascending. */
    public static final Comparator<LoanItem> BY_LOAN_DAYS =
            (a, b) -> Integer.compare(a.getLoanDays(), b.getLoanDays());

    /** Comparator that sorts LoanItems by item type, following the order declared in ItemType. */
    public static final Comparator<LoanItem> BY_TYPE =
            (a, b) -> Integer.compare(
                    ItemType.valueOf(a.getClass().getSimpleName()).ordinal(),
                    ItemType.valueOf(b.getClass().getSimpleName()).ordinal()
            );

    /**
     * Sorts the given list of LoanItems in-place using bubble sort.
     * The sort criteria is determined by the provided Comparator.
     * Includes an early-exit optimisation via swapped flag.
     * @param items      the list of LoanItems to sort — modified in place
     * @param comparator defines the sort order — use LoanSorter.BY_TITLE,
     *                   BY_LATE_FEE, BY_LOAN_DAYS, or BY_ITEM_TYPE
     * @return the sorted list of LoanItems
     */
    public static ArrayList<LoanItem> sort(ArrayList<LoanItem> items, Comparator<LoanItem> comparator) {
        int n = items.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(items.get(j), items.get(j + 1)) > 0) {
                    LoanItem temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return items;
    }
}