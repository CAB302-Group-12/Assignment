package common.User;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class UserFileDataSource implements UserInfoDataSource {
    private static final String FILENAME = "user.dat";

    /**
     * Storage for the user objects, name is the unique key per user.
     */
    private HashMap<String, User> data;

    /**
     * If any of the data has changed, this will be set to true.
     */
    private boolean dataChanged = false;

    public UserFileDataSource() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            // recursively read in the objects from the hash map (keys and people)
            data = (HashMap<String, User>) stream.readObject();
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
    public void addUser(User p) {
        if (p == null)
            throw new IllegalArgumentException("User cannot be null");

        // map[name] = p
        data.put(p.getName(), p);
        dataChanged = true;
    }

    @Override
    public User getUser(String name) {
        // look the user up by their name, if they exist, return the user,
        // otherwise return null
        return data.getOrDefault(name, null);
    }

    @Override
    public int getSize() {
        // return the number of entries or keys in our hash map
        return data.size();
    }

    @Override
    public void deleteUser(String name) {
        // remove the user from the map with this name (or key)
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
            // it's recursive in this case, so it saves all the keys as well as the values (user)
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
