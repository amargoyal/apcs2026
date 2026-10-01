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

public class aiUsage
{
    // adding throws allows java to handle an error
    public static void main(String[] args) throws FileNotFoundException {
        // connect scanner to an external file
        // the file MUST be in the same folder as the project
        File dataFile = new File("data.txt");
        Scanner fileScan = new Scanner(dataFile);
        
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        // counter and accumulator variables
        int count = 0;
        double totalSales = 0.0;
        
        System.out.println("=== Which AI Professions Use===");
        
        // the loop run while another line in file
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            
            String userId = lineScan.next();
            int age = lineScan.nextInt();
            String gender = lineScan.next();
            String country = lineScan.next();
            String userType = lineScan.next();
            String education = lineScan.next();
            String profession = lineScan.next();
            double income = lineScan.nextDouble();
            String aiTool = lineScan.next();
            
            System.out.println(profession + ": " + aiTool);
        }
        
        // always close file stream when finshed
        fileScan.close();
        
    }
}
