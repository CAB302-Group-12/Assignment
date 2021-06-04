package common;



import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class OrgBalanceFileDataSource implements OrgBalanceInfoDataSource {
    private static final String FILENAME = "organizationBalance.dat";

    /**
     * Storage for the OrgBalance objects, name is the unique key per OrgBalance.
     */
    private HashMap<String, OrgBalance> data;

    /**
     * If any of the data has changed, this will be set to true.
     */
    private boolean dataChanged = false;

    public OrgBalanceFileDataSource() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            // recursively read in the objects from the hash map (keys and people)
            data = (HashMap<String, OrgBalance>) stream.readObject();
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
    public void addOrganization(OrgBalance o) {
        if (o == null)
            throw new IllegalArgumentException("OrgBalance cannot be null");

        // map[name] = p
        data.put(o.getUnitname(), o);
        dataChanged = true;
    }

    @Override
    public OrgBalance getOrganization(String name) {
        // look the OrgBalance up by their name, if they exist, return the OrgBalance,
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
        // remove the OrgBalance from the map with this name (or key)
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
            // it's recursive in this case, so it saves all the keys as well as the values (OrgBalance)
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
