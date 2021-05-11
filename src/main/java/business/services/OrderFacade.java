package business.services;

import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {

    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }

    public void insertOrder(int length, int height, int width, int users_id) throws UserException {
        orderMapper.insertOrder(length, height, width, users_id);
    }

    public List<OrderEntry> getAllOrderEntries() throws UserException {

        return orderMapper.getAllOrderEntries();

    }
}
