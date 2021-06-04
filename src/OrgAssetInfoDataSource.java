package common;

import java.util.Set;

/**
 * Provides functionality needed by any data source for the Address Book
 * application.
 *
 * @author Malcolm Corney<BR>
 *         SEDC, FIT, QUT
 * @version - 24/05/2006
 */
public interface OrgAssetInfoDataSource {

    /**
     * Adds a Person to the address list, if they are not already in the list
     *
     * @param o Person to add
     */
    void addOrganization(OrgAsset o);

    /**
     * Extracts all the details of a Person from the address book based on the
     * name passed in.
     *
     * @param name The name as a String to search for.
     * @return all details in a Person object for the name
     */
    OrgAsset getOrganization(String name);

    /**
     * Gets the number of addresses in the address book.
     *
     * @return size of address book.
     */
    int getSize();

    /**
     * Deletes a Person from the address book.
     *
     * @param name The name to delete from the address book.
     */
    void deleteOrganization(String name);

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