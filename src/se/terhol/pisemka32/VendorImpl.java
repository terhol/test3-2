package se.terhol.pisemka32;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Tereza Holm
 */
public class VendorImpl implements Vendor {
    private SortedMap<Magazine, Double> myMagazines = new TreeMap<>();

    @Override
    public double getPrice(Magazine magazine) {
        double price;
        if (magazine == null || !myMagazines.containsKey(magazine)) {
            price = -1;
        } else {
            price = myMagazines.get(magazine);
        }
        return price;
    }

    @Override
    public double setPrice(Magazine magazine, double price) {
        if (price < 0 || magazine == null) {
            throw new IllegalArgumentException();
        }
        double originalPrice;
        myMagazines.put(magazine, price);
        if (!myMagazines.containsKey(magazine)) {
            originalPrice = -1;
        } else {
            originalPrice = myMagazines.get(magazine);
        }
        return originalPrice;
    }

    @Override
    public Collection<Magazine> getMostExpensive() {
        Collection<Magazine> mostExpensive = new TreeSet<>();
        double highestPrice = 0;
        for (Double magazinePrice : myMagazines.values()) {
            if (magazinePrice > highestPrice) {
                highestPrice = magazinePrice;
            }
        }
        for (Magazine magazine : myMagazines.keySet()) {
            if (myMagazines.get(magazine) == highestPrice) {
                mostExpensive.add(magazine);
            }
        }
        return mostExpensive;
    }

    @Override
    public void save(OutputStream os) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        for (Magazine magazine : myMagazines.keySet()) {
            writer.write(magazine.getName() + " /" + magazine.getIssue() + "/: " + this.getPrice(magazine));
            writer.newLine();
            writer.flush();
        }
    }

    @Override
    public void save(String file) throws IOException {
        OutputStream os = new FileOutputStream(file);

        this.save(os);
    }
}
