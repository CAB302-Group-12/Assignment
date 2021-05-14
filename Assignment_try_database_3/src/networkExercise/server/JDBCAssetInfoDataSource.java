package networkExercise.server;

import common.AssetInfoDataSource;
import common.Asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;


/**
 * Class for retrieving data from the XML file holding the asset list.
 */
public class JDBCAssetInfoDataSource implements AssetInfoDataSource {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS asset ("
                    + "idx INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE," // from https://stackoverflow.com/a/41028314
                    + "name VARCHAR(30),"
                    + "category VARCHAR(30),"
                    + "price VARCHAR(20),"
                    + "quantity VARCHAR(10),"
                    + "description VARCHAR(30)" + ");";

    private static final String INSERT_ASSET = "INSERT INTO asset (name, category, price, quantity, description) VALUES (?, ?, ?, ?, ?);";

    private static final String GET_NAMES = "SELECT name FROM asset";

    private static final String GET_ASSET = "SELECT * FROM asset WHERE name=?";

    private static final String DELETE_ASSET = "DELETE FROM asset WHERE name=?";

    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM asset";

    private Connection connection;

    private PreparedStatement addAsset;

    private PreparedStatement getNameList;

    private PreparedStatement getAsset;

    private PreparedStatement deleteAsset;

    private PreparedStatement rowCount;

    public JDBCAssetInfoDataSource() {
        connection = DBConnection.getInstance();
        try {
            Statement st = connection.createStatement();
            st.execute(CREATE_TABLE);
            /* BEGIN MISSING CODE */
            addAsset = connection.prepareStatement(INSERT_ASSET);
            getNameList = connection.prepareStatement(GET_NAMES);
            getAsset = connection.prepareStatement(GET_ASSET);
            deleteAsset = connection.prepareStatement(DELETE_ASSET);
            rowCount = connection.prepareStatement(COUNT_ROWS);
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see dataExercise.AssetBookDataSource#addAsset(dataExercise.Asset)
     */
    public void addAsset(Asset a) {
        try {
            /* BEGIN MISSING CODE */
            addAsset.setString(1, a.getName());
            addAsset.setString(2, a.getCategory());
            addAsset.setString(3, a.getPrice());
            addAsset.setString(4, a.getQuantity());
            addAsset.setString(5, a.getDescription());
            addAsset.execute();
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see dataExercisenew.AssetBookDataSource#nameSet()
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
     * @see dataExercise.AssetBookDataSource#getAsset(java.lang.String)
     */
    public Asset getAsset(String name) {
        Asset a = new Asset();
        ResultSet rs = null;
        /* BEGIN MISSING CODE */
        try {
            getAsset.setString(1, name);
            rs = getAsset.executeQuery();
            rs.next();
            a.setName(rs.getString("name"));
            a.setCategory(rs.getString("category"));
            a.setPrice(rs.getString("price"));
            a.setQuantity(rs.getString("quantity"));
            a.setDescription(rs.getString("description"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
        return a;
    }

    /**
     * @see dataExercise.AssetBookDataSource#getSize()
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
     * @see dataExercise.assetBookDataSource#deleteAsset(java.lang.String)
     */
    public void deleteAsset(String name) {
        /* BEGIN MISSING CODE */
        try {
            deleteAsset.setString(1, name);
            deleteAsset.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
    }

    /**
     * @see dataExercise.AssetBookDataSource#close()
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
