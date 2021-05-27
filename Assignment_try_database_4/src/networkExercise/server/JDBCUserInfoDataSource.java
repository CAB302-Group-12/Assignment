package networkExercise.server;

import common.UserInfoDataSource;
import common.User;

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
public class JDBCUserInfoDataSource implements UserInfoDataSource {

   public static final String CREATE_TABLE =
           "CREATE TABLE IF NOT EXISTS address ("
                   + "idx INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE," // from https://stackoverflow.com/a/41028314
                   + "name VARCHAR(30),"
                   + "email VARCHAR(30),"
                   + "password VARCHAR(20),"
                   + "usertype VARCHAR(10),"
                   + "organization VARCHAR(30)" + ");";

   private static final String INSERT_USER = "INSERT INTO address (name, email, password, usertype, organization) VALUES (?, ?, ?, ?, ?);";

   private static final String GET_NAMES = "SELECT name FROM address";

   private static final String GET_USER = "SELECT * FROM address WHERE name=?";

   private static final String DELETE_USER = "DELETE FROM address WHERE name=?";

   private static final String COUNT_ROWS = "SELECT COUNT(*) FROM address";

   private Connection connection;

   private PreparedStatement addUser;

   private PreparedStatement getNameList;

   private PreparedStatement getUser;

   private PreparedStatement deleteUser;

   private PreparedStatement rowCount;

   public JDBCUserInfoDataSource() {
      connection = DBConnection.getInstance();
      try {
         Statement st = connection.createStatement();
         st.execute(CREATE_TABLE);
         /* BEGIN MISSING CODE */
         addUser = connection.prepareStatement(INSERT_USER);
         getNameList = connection.prepareStatement(GET_NAMES);
         getUser = connection.prepareStatement(GET_USER);
         deleteUser = connection.prepareStatement(DELETE_USER);
         rowCount = connection.prepareStatement(COUNT_ROWS);
         /* END MISSING CODE */
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
   }

   /**
    * @see dataExercise.AddressBookDataSource#addUser(dataExercise.User)
    */
   public void addUser(User u) {
      try {
         /* BEGIN MISSING CODE */
         addUser.setString(1, u.getName());
         addUser.setString(2, u.getEmail());
         addUser.setString(3, u.getPassword());
         addUser.setString(4, u.getUsertype());
         addUser.setString(5, u.getOrganization());
         addUser.execute();
         /* END MISSING CODE */
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
   }

   /**
    * @see dataExercisenew.AddressBookDataSource#nameSet()
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
    * @see dataExercise.AddressBookDataSource#getUser(java.lang.String)
    */
   public User getUser(String name) {
      User u = new User();
      ResultSet rs = null;
      /* BEGIN MISSING CODE */
      try {
         getUser.setString(1, name);
         rs = getUser.executeQuery();
         rs.next();
         u.setName(rs.getString("name"));
         u.setEmail(rs.getString("email"));
         u.setPassword(rs.getString("password"));
         u.setUsertype(rs.getString("usertype"));
         u.setOrganization(rs.getString("organization"));
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      /* END MISSING CODE */
      return u;
   }

   /**
    * @see dataExercise.AddressBookDataSource#getSize()
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
    * @see dataExercise.AddressBookDataSource#deleteUser(java.lang.String)
    */
   public void deleteUser(String name) {
      /* BEGIN MISSING CODE */
      try {
         deleteUser.setString(1, name);
         deleteUser.executeUpdate();
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      /* END MISSING CODE */
   }

   /**
    * @see dataExercise.AddressBookDataSource#close()
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
