package business.persistence;

import business.entities.BOMItem;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BOMMapper {

    private Database database;

    public BOMMapper(Database database) { this.database = database; }

    public List<BOMItem> getBOMMaterials(int id) throws UserException
    {
        List<BOMItem> bomItemList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT material_description, order_item.length, order_item.amount, unit, context_description, `order`.id FROM material, order_item, `order`, users\n" +
                    "WHERE material.id = order_item.material_id\n" +
                    "AND order_item.order_id = order.id\n" +
                    "AND `order`.users_id = users.id;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String materialDescription = rs.getString("material_description");
                    int length = rs.getInt("length");
                    int amount = rs.getInt("amount");
                    String unit = rs.getString("unit");
                    String contextDescription = rs.getString("context_description");
                    bomItemList.add(new BOMItem(materialDescription, length, amount, unit, contextDescription));
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
        return bomItemList;
    }

}
