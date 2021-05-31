package Organization;

import Organization.OrganizationInfoDataSource;
import Organization.Organization;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class OrganizationFileDataSource implements OrganizationInfoDataSource {
    private static final String FILENAME = "organization.dat";

    /**
     * Storage for the Organization objects, name is the unique key per Organization.
     */
    private HashMap<String, Organization> data;

    /**
     * If any of the data has changed, this will be set to true.
     */
    private boolean dataChanged = false;

    public OrganizationFileDataSource() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            // recursively read in the objects from the hash map (keys and people)
            data = (HashMap<String, Organization>) stream.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            // if the file does not exist (we're running for the first time)
            // or the serial number does not match (class has changed)
            // start with an empty data store
            data = new HashMap<>();

            // we definitely want to save this data, because we're started empty
            dataChanged = true;
        }
    }

    @Override
    public void addOrganization(Organization o) {
        if (o == null)
            throw new IllegalArgumentException("Organization cannot be null");

        // map[name] = p
        data.put(o.getAssetname(), o);
        dataChanged = true;
    }

    @Override
    public Organization getOrganization(String name) {
        // look the Organization up by their name, if they exist, return the Organization,
        // otherwise return null
        return data.getOrDefault(name, null);
    }

    @Override
    public int getSize() {
        // return the number of entries or keys in our hash map
        return data.size();
    }

    @Override
    public void deleteOrganization(String name) {
        // remove the Organization from the map with this name (or key)
        data.remove(name);
        dataChanged = true;
    }

    @Override
    public void close() {
        // has the data changed? do we need to update the file?
        if (!dataChanged)
            return;

        // open up the stream for writing the objects to
        // if this file already exists, it will be overwritten
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            // save the hash map to the file
            // it's recursive in this case, so it saves all the keys as well as the values (Organization)
            stream.writeObject(data);

            // make sure it's all written
            // this doesn't matter so much for files, since there's an implicit flush() before closing
            // but for network sockets it absolutely does matter, see the readme.
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> nameSet() {
        // return the keys (the people's names) from the hash map
        return data.keySet();
    }
}
