package common.Create;

import java.util.Set;

/**
 * Provides functionality needed by any data source for the Address Book
 * application.
 *
 * @author Malcolm Corney<BR>
 *         SEDC, FIT, QUT
 * @version - 24/05/2006
 */
public interface CreateInfoDataSource {
    /**
     * Adds a asset to the address list, if they are not already in the list
     *
     * @param c asset to add
     */
    void addCreate(Create c);

    /**
     * Extracts all the details of a Person from the address book based on the
     * name passed in.
     *
     * @param name The name as a String to search for.
     * @return all details in a Person object for the name
     */
    Create getCreate(String name);

    /**
     * Gets the number of addresses in the address book.
     *
     * @return size of address book.
     */
    int getSize();

    /**
     * Finalizes any resources used by the data source and ensures data is
     * persisited.
     */
    void close();

    /**
     * Retrieves a set of names from the data source that are used in
     * the name list.
     *
     * @return set of names.
     */
    Set<String> nameSet();
}
