package business.persistence;

import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private final static String DATABASE = "FOG_Carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";

    private final static String PASSWORD = "290696-1329Seb";

    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;
    private static OrderMapper orderMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
            orderMapper = new OrderMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {

            //users
            stmt.execute("drop table if exists users" );
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;" );
            stmt.execute(
                    "insert into users values " +
                            "(1,'jens@somewhere.com','jensen','customer'), " +
                            "(2,'ken@somewhere.com','kensen','customer'), " +
                            "(3,'robin@somewhere.com','batman','employee')");

            //orders
            stmt.execute("drop table if exists ´order´" );
            stmt.execute("create table " + TESTDATABASE + ".order LIKE " + DATABASE + ".order;" );
            stmt.execute(
                    "insert into ´order´ values " +
                            "(1, 400, 600, 300, 10000, 20000, 'accept', 5)," +
                            "(2, 300, 500, 500, 17000, 30000, 'accept', 5), " +
                            "(3, 700, 400, 400, 15000, 25000, 'pending', 7)");
        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    void insertOrder() throws UserException {

        int orderId = 0;
        int width = 300;
        int length = 500;
        int height = 300;
        int users_id = 5;

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `fog_carport_test`.`order` (`width`, `length`, `height`, `status`, `users_id`) VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, width);
                ps.setInt(2, length);
                ps.setInt(3, height);
                ps.setString(4, "pending");
                ps.setInt(5,users_id);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int order_id = ids.getInt(1);

                orderId = order_id;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        assertEquals(5, users_id);
    }
}