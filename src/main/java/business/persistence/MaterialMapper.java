package business.persistence;
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
            String sql = "SELECT * FROM materials";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("material_id");
                    String description = rs.getString("material_description");
                    String unit = rs.getString("unit");
                    String helpDescription = rs.getString("help_description");
                    double mprice = rs.getDouble("meter_price");
//                    materialList.add(new Material(id,description,unit,helpDescription,);
                }
                return materialList;
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
