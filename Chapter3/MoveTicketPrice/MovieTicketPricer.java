
/**
 * Write a description of class MovieTicketPricer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.text.NumberFormat;

public class MovieTicketPricer
{
    public static void main(String[] args) {
        //create constant vas
        //constant var CAN'T be changed
        final double REGULAR_PRICE = 12.50;
        final double DISCOUNT_PRICE = 8.00;
        final double IMAX_SURCHARGE = 5.00;
        final double IMAX_70MM_SURCHARGE = 8.00;
        
        Scanner scan = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        System.out.println("---Movie Ticket Calculator---");
        System.out.println("Select movie Format:");
        System.out.println("1 - Standard Format");
        System.out.println("2 - IMAX");
        System.out.println("3 - IMAX 70mm (As Nolan Intended)");
        System.out.print("Enter choice (1-3): ");
        int format  = scan.nextInt();
        
        System.out.println("Enteer the customer's age: ");
        int age = scan.nextInt();
        
        System.out.print("Is this a matinee showtime? ");
        String isMatinee = scan.next();
        boolean matinee = false;
        if (isMatinee.toLowerCase().equals("y")) {
            matinee = true;
        }
        
        // set pass to true if user enters "y"
        System.out.print("does customer have pass?");
        boolean pass = scan.next().toLowerCase().equals("y");
        
        double ticketPrice;
        
        //discount applies if ages good or matinee + path
        if (format==1){
            
            if (age<13 || age >= 65 || matinee && pass) {
                ticketPrice = DISCOUNT_PRICE;
                System.out.println("Status: Discount Applied!");
            }
            else {
                ticketPrice = REGULAR_PRICE;
                System.out.println("Status: Regular Rate Applied.");
            }
        }
        else if (format == 2) {
            ticketPrice = REGULAR_PRICE + IMAX_SURCHARGE;
            System.out.println("Status: IMAX Surcharge Applied.");
        }
        else if (format == 3) {
            ticketPrice = REGULAR_PRICE + IMAX_70MM_SURCHARGE;
            System.out.println("Status: IMAX 70mm Surcharge Applied.");
        }
        else{
            ticketPrice = REGULAR_PRICE;
            System.out.println("Status: Incorrect emtry. Regular Price Applied.");
        }
                
        System.out.println("Total Due: " + money.format(ticketPrice));
        
        }
    }


