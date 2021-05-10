package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

public class OrderMapper {

    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }



    public void insertOrder(int length, int height, int width, int users_id) throws UserException {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog_carport`.`order` (`width`, `length`, `height`, `status`, `users_id`) VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, width);
                ps.setInt(2, length);
                ps.setInt(3, height);
                ps.setString(4, "pending verification");
                ps.setInt(5, users_id);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int order_id = ids.getInt(1);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }
}
