import java.util.Scanner;


public class LoanItemFactory {

    public LoanItemFactory(){
    }

    public LoanItem create(String type, Scanner scanner){


        if(type.equalsIgnoreCase("book")){//Checks for type book
            System.out.println("Title: ");
            String title = scanner.nextLine(); //Get title input
            System.out.print("Loan duration: ");
            int loanDays = scanner.nextInt(); //Get loan duration
            scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();

            return new Book(title,loanDays,author);

        }else if(type.equalsIgnoreCase("video")){
            System.out.println("Title: ");
            String title = scanner.nextLine();
            System.out.println("Loan duration: ");
            int loanDays = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine();

            return new Video(title, loanDays, duration);
        }else{
            System.out.println("Invalid input");
        }
        return null;
    }
}
