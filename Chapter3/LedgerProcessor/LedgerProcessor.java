/**
 * Write a description of class LedgerProcessor here.
 *
 * @author amar
 * @version 09/30
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

public class LedgerProcessor
{
    // adding throws allows java to handle an error
    public static void main(String[] args) throws FileNotFoundException {
        // connect scanner to an external file
        // the file MUST be in the same folder as the project
        File dataFile = new File("transactions.txt");
        Scanner fileScan = new Scanner(dataFile);
        
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        // counter and accumulator variables
        int count = 0;
        double totalSales = 0.0;
        
        System.out.println("=== Daily Transaction Ledger  ===");
        
        // the loop run while another line in file
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            double price = Double.parseDouble(line); // convert to double
            
            // upd count and accumulator
            count++;
            totalSales += price;
            
            System.out.println("Transaction #" + count + ": " + money.format(price));
        }
        
        // always close file stream when finshed
        fileScan.close();
        
        double averageSales = totalSales / count;
        
        System.out.println("Total Items Sold: " + count);
        System.out.println("Total Revenue: " + money.format(totalSales));
        System.out.println("Average Transaction: " + money.format(averageSales));
        
    }
}
