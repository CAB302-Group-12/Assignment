package networkExercise.server;

import History.HistoryInfoDataSource;
import History.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;


/**
 * Class for retrieving data from the XML file holding the address list.
 */
public class JDBCHistoryInfoDataSource implements HistoryInfoDataSource {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS address ("
                    + "idx INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE," // from https://stackoverflow.com/a/41028314
                    + "assetname VARCHAR(30),"
                    + "assetcategory VARCHAR(30),"
                    + "assetquantity VARCHAR(20),"
                    + "tradetype VARCHAR(10)" + ");";

    private static final String INSERT_HISTORY = "INSERT INTO address (assetname, assetcategory, assetquantity, tradetype) VALUES (?, ?, ?, ?);";

    private static final String GET_NAMES = "SELECT assetname FROM address";

    private static final String GET_HISTORY = "SELECT * FROM address WHERE assetname=?";

    private static final String DELETE_HISTORY = "DELETE FROM address WHERE assetname=?";

    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM address";

    private Connection connection;

    private PreparedStatement addHistory;

    private PreparedStatement getNameList;

    private PreparedStatement getHistory;

    private PreparedStatement deleteHistory;

    private PreparedStatement rowCount;

    public JDBCHistoryInfoDataSource() {
        connection = DBConnection.getInstance();
        try {
            Statement st = connection.createStatement();
            st.execute(CREATE_TABLE);
            /* BEGIN MISSING CODE */
            addHistory = connection.prepareStatement(INSERT_HISTORY);
            getNameList = connection.prepareStatement(GET_NAMES);
            getHistory = connection.prepareStatement(GET_HISTORY);
            deleteHistory = connection.prepareStatement(DELETE_HISTORY);
            rowCount = connection.prepareStatement(COUNT_ROWS);
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     */
    public void addHistory(History h) {
        try {
            /* BEGIN MISSING CODE */
            addHistory.setString(1, h.getAssetname());
            addHistory.setString(2, h.getAssetcategory());
            addHistory.setString(3, h.getAssetquantity());
            addHistory.setString(4, h.getTradetype());
            
            addHistory.execute();
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     */
    public Set<String> nameSet() {
        Set<String> names = new TreeSet<String>();
        ResultSet rs = null;

        /* BEGIN MISSING CODE */
        try {
            rs = getNameList.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */

        return names;
    }

    /**
     *
     */
    public History getHistory(String name) {
        History h = new History();
        ResultSet rs = null;
        /* BEGIN MISSING CODE */
        try {
            getHistory.setString(1, name);
            rs = getHistory.executeQuery();
            rs.next();
            h.setAssetname(rs.getString("assetname"));
            h.setAssetcategory(rs.getString("assetcategory"));
            h.setAssetquantity(rs.getString("assetquantity"));
            h.setTradetype(rs.getString("Tradetype"));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
        return h;
    }

    /**
     *
     */
    public int getSize() {
        ResultSet rs = null;
        int rows = 0;

        /* BEGIN MISSING CODE */
        try {
            rs = rowCount.executeQuery();
            rs.next();
            rows = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */

        return rows;
    }

    /**
     *
     */
    public void deleteHistory(String name) {
        /* BEGIN MISSING CODE */
        try {
            deleteHistory.setString(1, name);
            deleteHistory.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
    }

    /**
     *
     */
    public void close() {
        /* BEGIN MISSING CODE */
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
    }
}
