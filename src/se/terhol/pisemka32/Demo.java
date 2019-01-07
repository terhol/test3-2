package se.terhol.pisemka32;

import java.io.File;
import java.io.IOException;

/**
 * Write a description of class Demo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main(String[] args) throws IOException {
        Vendor vendor = new VendorImpl();
        
        vendor.setPrice(new Magazine("Alarm Revue", 1), 12.0);
        vendor.setPrice(new Magazine("ABC", 1), 9.0);
        vendor.setPrice(new Magazine("ABC", 2), 9.0);
        vendor.setPrice(new Magazine("Nature", 3), 12.5);
        vendor.setPrice(new Magazine("Alarm Revue", 8), 12.0);
        vendor.setPrice(new Magazine("Alarm Revue", 2), 10.0);
        vendor.setPrice(new Magazine("ABC", 3), 9.0);
        vendor.setPrice(new Magazine("Alarm Revue", 1), 12.5);
        
        try {
            System.out.print("Pokus o vlozeni spatne ceny: ");
            vendor.setPrice(new Magazine("Alarm Revue", 1), -1.0);
            System.out.println("ERROR, no exception :-(");
        } catch(IllegalArgumentException ex) {
            System.out.println("OK");
        }
        
        System.out.println("Nejdrazsi casopisy: " + vendor.getMostExpensive());

        System.out.println("Zapisuji do souboru vendor-out.txt...");
        vendor.save("vendor-out.txt");
    }
}
