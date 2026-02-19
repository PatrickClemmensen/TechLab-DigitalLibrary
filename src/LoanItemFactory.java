import java.util.Scanner;


public class LoanItemFactory {

    public LoanItemFactory(){
    }

    public LoanItem create(String type, Scanner scanner){


        if(type.equalsIgnoreCase("book")){ //Checks for type: book
            System.out.print("Title: ");
            String title = scanner.nextLine(); //Get title input
            System.out.print("Loan duration: ");
            int loanDays = scanner.nextInt(); //Get loan duration input
            scanner.nextLine();
            System.out.print("Author: "); //Get author input
            String author = scanner.nextLine();

            return new Book(title,loanDays,author);

        } else if(type.equalsIgnoreCase("video")){ //Checks for type: video
            System.out.print("Title: ");
            String title = scanner.nextLine(); //Get title input
            System.out.print("Loan duration: ");
            int loanDays = scanner.nextInt(); //Get loan duration input
            scanner.nextLine();
            System.out.print("Duration: "); //Get video duration input
            int duration = scanner.nextInt();
            scanner.nextLine();

            return new Video(title, loanDays, duration);

        } else if(type.equalsIgnoreCase("electronic")){ //Checks for type: electronic
            System.out.print("Title: ");
            String title = scanner.nextLine(); //Get title input
            System.out.print("Loan duration: ");
            int loanDays = scanner.nextInt(); //Get loan duration
            scanner.nextLine();
            System.out.print("Model: "); //Get model input
            String modelName = scanner.nextLine();

            return new Electronic(title,loanDays,modelName);

        } else {
            System.out.println("Invalid input - please try again. † Valid inputs are (book/video/electronic).\nThanks in advance!");
        }
        return null;
    }
}
