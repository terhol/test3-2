package se.terhol.pisemka32;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

/**
 * Magazines seller.
 *
 * @author Radek Oslejsek
 * @version 2010-12-11
 */
public interface Vendor {
    /**
     * Returns price of the magazine.
     *
     * @param magazine Magazine
     * @return Magazine's price, -1.0 if given magazine is null or does not exist
     */
    double getPrice(Magazine magazine);

    /**
     * Appends new magazine or changes price of existing magazine.
     *
     * @param magazine New or existing magazine
     * @param price    Price to be set
     * @return Previous price, -1.0 if the magazine is new
     * @throws IllegalArgumentException if price is < 0 or magazine is null
     */
    double setPrice(Magazine magazine, double price);

    /**
     * Returns the most expensive magazines (there can be more magazines of the same price).
     *
     * @return Collection of the most expensive magazines.
     */
    Collection<Magazine> getMostExpensive();

    /**
     * Writes magazines to given output stream as follow:
     * 1. Data are written in text mode.
     * 2. Each magazine is written to a single line.
     * 3. Magazines are sorted according to the comparator.
     * 4. Each line has the form "name /issue/: price" where name is magazine's name, issue is
     * magazine's issue number and price is magazine's price.
     *
     * @param os Output stream
     * @throws IOException on I/O failure
     */
    void save(OutputStream os) throws IOException;

    /**
     * Writes magazines to text file, see write(OutputStream os) for more details.
     *
     * @param file Path to text file
     * @throws IOException on I/O failure
     */
    void save(String file) throws IOException;
}
