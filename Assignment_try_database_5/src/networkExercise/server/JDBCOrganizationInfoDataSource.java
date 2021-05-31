package networkExercise.server;

import Organization.Organization;
import Organization.OrganizationInfoDataSource;


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
public class JDBCOrganizationInfoDataSource implements OrganizationInfoDataSource {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS address ("
                    + "idx INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE," // from https://stackoverflow.com/a/41028314
                    + "unitname VARCHAR(30),"
                    + "credit VARCHAR(30),"
                    + "assetname VARCHAR(20),"
                    + "assetquantity VARCHAR(10),"
                     + ");";

    private static final String INSERT_ORGANIZATION = "INSERT INTO address (unitname, credit, password, usertype) VALUES (?, ?, ?, ?);";

    private static final String GET_NAMES = "SELECT name FROM address";

    private static final String GET_ORGANIZATION = "SELECT * FROM address WHERE name=?";

    private static final String DELETE_ORGANIZATION = "DELETE FROM address WHERE name=?";

    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM address";

    private Connection connection;

    private PreparedStatement addOrganization;

    private PreparedStatement getNameList;

    private PreparedStatement getOrganization;

    private PreparedStatement deleteOrganization;

    private PreparedStatement rowCount;

    public JDBCOrganizationInfoDataSource() {
        connection = DBConnection.getInstance();
        try {
            Statement st = connection.createStatement();
            st.execute(CREATE_TABLE);
            /* BEGIN MISSING CODE */
            addOrganization = connection.prepareStatement(INSERT_ORGANIZATION);
            getNameList = connection.prepareStatement(GET_NAMES);
            getOrganization = connection.prepareStatement(GET_ORGANIZATION);
            deleteOrganization = connection.prepareStatement(DELETE_ORGANIZATION);
            rowCount = connection.prepareStatement(COUNT_ROWS);
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see
     */
    public void addOrganization(Organization o) {
        try {
            /* BEGIN MISSING CODE */
            addOrganization.setString(1, o.getUnitname());
            addOrganization.setString(2, o.getCredit());
            addOrganization.setString(3, o.getAssetname());
            addOrganization.setString(4, o.getAssetquantity());
            addOrganization.execute();
            /* END MISSING CODE */
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @see
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
    public Organization getOrganization(String name) {
        Organization o = new Organization();
        ResultSet rs = null;
        /* BEGIN MISSING CODE */
        try {
            getOrganization.setString(1, name);
            rs = getOrganization.executeQuery();
            rs.next();
            o.setUnitname(rs.getString("unitname"));
            o.setCredit(rs.getString("credit"));
            o.setAssetname(rs.getString("assetname"));
            o.setAssetquantity(rs.getString("assetquantity"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* END MISSING CODE */
        return o;
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
    public void deleteOrganization(String name) {
        /* BEGIN MISSING CODE */
        try {
            deleteOrganization.setString(1, name);
            deleteOrganization.executeUpdate();
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
