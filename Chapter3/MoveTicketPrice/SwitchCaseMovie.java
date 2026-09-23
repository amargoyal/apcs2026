import java.util.Scanner;
import java.text.NumberFormat;

public class SwitchCaseMovie
{
    public static void main(String[] args) {
        // constant vars CAN'T be changed
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
        int format = scan.nextInt();

        System.out.print("Enter the customer's age: ");
        int age = scan.nextInt();

        System.out.print("Is this a matinee showtime? (y/n) ");
        boolean matinee = scan.next().toLowerCase().equals("y");

        System.out.print("Does customer have pass? (y/n) ");
        boolean pass = scan.next().toLowerCase().equals("y");

        double ticketPrice;

        switch (format) {
            case 1:
                // discount if kid, senior, or matinee with pass
                if (age < 13 || age >= 65 || (matinee && pass)) {
                    ticketPrice = DISCOUNT_PRICE;
                    System.out.println("Status: Discount Applied!");
                } else {
                    ticketPrice = REGULAR_PRICE;
                    System.out.println("Status: Regular Rate Applied.");
                }
                break;
            case 2:
                ticketPrice = REGULAR_PRICE + IMAX_SURCHARGE;
                System.out.println("Status: IMAX Surcharge Applied.");
                break;
            case 3:
                ticketPrice = REGULAR_PRICE + IMAX_70MM_SURCHARGE;
                System.out.println("Status: IMAX 70mm Surcharge Applied.");
                break;
            default:
                ticketPrice = REGULAR_PRICE;
                System.out.println("Status: Incorrect entry. Regular Price Applied.");
        }

        System.out.println("Total Due: " + money.format(ticketPrice));
    }
}