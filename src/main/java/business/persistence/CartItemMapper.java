package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

public class CartItemMapper {

    private Database database;

    public void insertCartItem(int length, int height, int width, int users_id) throws UserException {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog_carport`.`order_item` (`amount`, `length`, `context_description`, `order_id`, `material_id`) VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, width);
                ps.setInt(2, length);
                ps.setInt(3, height);
                ps.setString(4, "pending");
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
