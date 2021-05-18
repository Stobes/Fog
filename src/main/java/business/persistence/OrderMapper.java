package business.persistence;

import business.entities.CarportItem;
import business.entities.OrderEntry;

import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private Database database;


    public OrderMapper(Database database) {
        this.database = database;
    }

    public OrderEntry getOrderById(int id) throws UserException {

        OrderEntry orderId = new OrderEntry(1,1,1,1,"");



        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `order` WHERE id = "+id+";";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int order_id = rs.getInt(1);
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");


                    orderId.setId(order_id);
                    orderId.setWidth(width);
                    orderId.setLength(length);

                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }

        return orderId;
    }

    public OrderEntry getOrderId() throws UserException {

        OrderEntry orderId = new OrderEntry(1,1,1,1,"");



        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `order` WHERE id = ( SELECT MAX( id ) FROM `order` );";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt(1);
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");


                    orderId.setId(id);
                    orderId.setWidth(width);
                    orderId.setLength(length);

                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }

        return orderId;
    }





    public List<OrderEntry> getAllOrderEntries() throws UserException {

        List<OrderEntry> orderEntryList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `fog_carport`.`order`;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int height = rs.getInt("height");
                    String status = rs.getString("status");
//                    int userId = rs.getInt("users_id");

                    orderEntryList.add(new OrderEntry(id, length, width, height, status));

                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }

        return orderEntryList;
    }


    public int insertOrder(int length, int height, int width, int users_id) throws UserException {

        int orderId = 0;

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog_carport`.`order` (`width`, `length`, `height`, `status`, `users_id`) VALUES (?, ?, ?, ?, ?);";

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

                orderId = order_id;
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
        return orderId;
    }

    public void insertOrderItem(List<CarportItem> carportItemList, int orderId) throws UserException {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `fog_carport`.`order_item` (`amount`, `length`, `context_description`, `order_id`, `material_id`) VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                for (CarportItem carportItem : carportItemList) {

                    ps.setInt(1, carportItem.getAmount());
                    ps.setInt(2, carportItem.getLength());
                    ps.setString(3, carportItem.getContextDescription());
                    ps.setInt(4, orderId);
                    ps.setInt(5, carportItem.getMaterialId());
                    ps.executeUpdate();
                    ResultSet ids = ps.getGeneratedKeys();
                    ids.next();
                    int order_item_id = ids.getInt(1);

                }

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
    public OrderEntry getOrderById(int id) throws UserException {

        OrderEntry orderId = new OrderEntry(1,1,1,1,"");



        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM `order` WHERE id = "+id+";";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int order_id = rs.getInt(1);
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");


                    orderId.setId(order_id);
                    orderId.setWidth(width);
                    orderId.setLength(length);

                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }

        return orderId;
    }

}
