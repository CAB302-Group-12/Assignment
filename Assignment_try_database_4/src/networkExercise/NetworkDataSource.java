package networkExercise;

import common.UserInfoDataSource;
import common.User;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class NetworkDataSource implements UserInfoDataSource {
    private static final String HOSTNAME = "127.0.0.1";
    private static final int PORT = 10000;

    /**
     * These are the commands which will be sent across the network connection.
     */
    public enum Command {
        ADD_USER,
        GET_USER,
        DELETE_USER,
        GET_SIZE,
        GET_NAME_SET
    }

    private Socket connectToServer() throws IOException {
        return new Socket(HOSTNAME, PORT);
    }

    @Override
    public void addUser(User p) {
        if (p == null)
            throw new IllegalArgumentException("User cannot be null");

        try (Socket socket = connectToServer()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                // tell the server to expect a User's details
                outputStream.writeObject(Command.ADD_USER);

                // send the actual data
                outputStream.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String name) {
        try (Socket socket = connectToServer()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                // tell the server to expect a User's name, and send us back their details
                outputStream.writeObject(Command.GET_USER);
                outputStream.writeObject(name);

                // flush because if we don't, the request might not get sent yet, and we're waiting for a response
                outputStream.flush();

                // read the User's details back from the server
                try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                    return (User)inputStream.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getSize() {
        /**
         * Protocol documentation might look like:
         * GET_SIZE:
         *  - No parameters
         *
         * Server responds with:
         *   - (int) number of entries
         */
        try (Socket socket = connectToServer()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                outputStream.writeObject(Command.GET_SIZE);
                outputStream.flush();

                // read the User's details back from the server
                try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                    return inputStream.readInt();
                }
            }
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void deleteUser(String name) {
        /**
         * Protocol documentation might look like:
         * DELETE_User:
         *  - (String) the User to remove
         *
         * Server does not respond.
         */

        try (Socket socket = connectToServer()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                outputStream.writeObject(Command.DELETE_USER);
                outputStream.writeObject(name);
            }
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
    }

    @Override
    public Set<String> nameSet() {
        try (Socket socket = connectToServer()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                outputStream.writeObject(Command.GET_NAME_SET);
                outputStream.flush();

                try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                    return (Set<String>) inputStream.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }
}
