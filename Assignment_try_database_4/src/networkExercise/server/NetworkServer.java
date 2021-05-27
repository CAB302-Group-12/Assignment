package networkExercise.server;

import common.UserInfoDataSource;
import common.User;
import networkExercise.NetworkDataSource;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetworkServer {
    private static final int PORT = 10000;

    /**
     * this is the timeout in between accepting clients, not reading from the socket itself.
     */
    private static final int SOCKET_ACCEPT_TIMEOUT = 100;

    /**
     * This timeout is used for the actual clients.
     */
    private static final int SOCKET_READ_TIMEOUT = 5000;

    private AtomicBoolean running = new AtomicBoolean(true);

    /**
     * The connection to the database where everything is stored.
     */
    private UserInfoDataSource database;

    /**
     * Handles the connection received from ServerSocket
     * @param socket The socket used to communicate with the currently connected client
     */
    private void handleConnection(Socket socket) throws Exception {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            // read the command, this tells us what to send the client back
            final NetworkDataSource.Command command = (NetworkDataSource.Command) inputStream.readObject();
            switch (command) {
                case ADD_USER: {
                    // client is sending us a new user
                    final User u = (User) inputStream.readObject();
                    database.addUser(u);
                    System.out.println(String.format("Added user '%s' to database", u.getName()));
                }
                break;

                case GET_USER: {
                    // client sends us the name of the user to retrieve
                    final String userName = (String)inputStream.readObject();
                    final User user = database.getUser(userName);

                    // send the client back the user's details, or null
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                        outputStream.writeObject(user);
                    }
                    if (user != null)
                        System.out.println(String.format("Sent user '%s' to client", user.getName()));
                }
                break;

                case GET_SIZE: {
                    // no parameters sent by client

                    // send the client back the size of the database
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                        outputStream.writeInt(database.getSize());
                    }

                    System.out.println(String.format("Sent size of %d to client", database.getSize()));
                }
                break;

                case DELETE_USER: {
                    // one parameter - the person's name
                    final String userName = (String)inputStream.readObject();
                    database.deleteUser(userName);

                    System.out.println(String.format("Deleted user '%s'", userName));
                }
                break;

                case GET_NAME_SET: {
                    // no parameters sent by client

                    // send the client back the name set
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                        outputStream.writeObject(database.nameSet());
                    }

                    System.out.println("Sent name set to the client");
                }
                break;
            }
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the port the server is configured to use
     *
     * @return The port number
     */
    public static int getPort() {
        return PORT;
    }

    /**
     * Starts the server running on the default port
     */
    public void start() throws IOException {
        database = new JDBCUserInfoDataSource();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            serverSocket.setSoTimeout(SOCKET_ACCEPT_TIMEOUT);
            for (;;) {
                if (!running.get()) {
                    // The server is no longer running
                    break;
                }
                try {
                    try (Socket socket = serverSocket.accept()) {
                        socket.setSoTimeout(SOCKET_READ_TIMEOUT);
                        handleConnection(socket);
                    }
                } catch (SocketTimeoutException ignored) {
                    // Do nothing. A timeout is normal- we just want the socket to
                    // occasionally timeout so we can check if the server is still running
                } catch (Exception e) {
                    // We will report other exceptions by printing the stack trace, but we
                    // will not shut down the server. A exception can happen due to a
                    // client malfunction (or malicious client)
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // If we get an error starting up, show an error dialog then exit
            e.printStackTrace();
            System.exit(1);
        }

        // Close down the server
        System.exit(0);
    }

    /**
     * Requests the server to shut down
     */
    public void shutdown() {
        // Shut the server down
        running.set(false);
    }
}
