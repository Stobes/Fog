package business.persistence;
import business.entities.CarportItem;
import business.entities.Material;
import business.exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class MaterialMapper {

    private Database database;

    public MaterialMapper(Database database)
    {
        this.database = database;
    }


    public List<Material> getMaterials() throws UserException
    {
        List<Material> materialList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM material";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String unit = rs.getString("unit");
                    String description = rs.getString("material_description");
                    int mprice = rs.getInt("meter_price");
                    materialList.add(new Material(id, unit, description, mprice));
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
        return materialList;
    }

}
