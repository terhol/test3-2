package se.terhol.pisemka32;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Tereza Holm
 */
public class VendorImpl implements Vendor {
    private SortedMap<Magazine, Double> magazine = new TreeMap<>();

    @Override
    public double getPrice(Magazine magazine) {
        double price;
        if (magazine == null || !this.magazine.containsKey(magazine)) {
            price = -1;
        } else {
            price = this.magazine.get(magazine);
        }
        return price;
    }

    @Override
    public double setPrice(Magazine magazine, double price) {
        if (price < 0 || magazine == null) {
            throw new IllegalArgumentException();
        }
        double originalPrice = -1;
        if (this.magazine.containsKey(magazine)) {
            originalPrice = this.magazine.get(magazine);
        }
        this.magazine.put(magazine, price);
        return originalPrice;
    }

    @Override
    public Collection<Magazine> getMostExpensive() {
        Set<Magazine> mostExpensive = new TreeSet<>();
        double highestPrice = Collections.max(magazine.values());
        for (Magazine magazine : magazine.keySet()) {
            if (this.magazine.get(magazine) == highestPrice) {
                mostExpensive.add(magazine);
            }
        }
        return mostExpensive;
    }

    @Override
    public void save(OutputStream os) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        for (Magazine magazine : magazine.keySet()) {
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
