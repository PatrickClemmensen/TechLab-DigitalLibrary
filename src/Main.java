import java.util.ArrayList;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);

        ui.collectItems();
        ui.displaySummary();













        /*
        Book book = new Book("Intro to java", 7, "Aniko");
        Book book2 = new Book("Intro to java 2", 7, "Aniko");
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<LoanItem> loanItems = new ArrayList<>();

        loanItems.add(book);
        loanItems.add(book2);


        for(LoanItem item : loanItems){
            System.out.println(item.getDescription());
        }
         */

    }
}
