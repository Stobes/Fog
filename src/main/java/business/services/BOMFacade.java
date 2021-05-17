package business.services;

import business.entities.BOMItem;
import business.exceptions.UserException;
import business.persistence.BOMMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class BOMFacade {

    private BOMMapper bomMapper;

    public BOMFacade(Database database) { this.bomMapper = new BOMMapper(database); }

    public List<BOMItem> getBOMMaterials(int id) throws UserException {
        return bomMapper.getBOMMaterials(id);
    }
}
