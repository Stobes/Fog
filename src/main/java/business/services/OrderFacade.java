package business.services;

import business.entities.CarportItem;
import business.entities.CarportItemList;
import business.entities.Material;
import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class OrderFacade {

    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }


    public int insertOrder(int length, int height, int width, int users_id) throws UserException {
        int orderId = orderMapper.insertOrder(length, height, width, users_id);
        return orderId;
    }

    public List<OrderEntry> getAllOrderEntries() throws UserException {

        return orderMapper.getAllOrderEntries();

    }

    public OrderEntry getOrderId() throws UserException {

        return orderMapper.getOrderId();

    }

    public void insertOrderItem(List<CarportItem> _carportItemList, int orderId) throws UserException {

        orderMapper.insertOrderItem(_carportItemList, orderId);

    }

    public OrderEntry getOrderById(int id) throws UserException {
        return orderMapper.getOrderById(id);
    }

    public void SendOffer(int id, int total) throws UserException {
        orderMapper.SendOffer(id, total);
    }

    public List<OrderEntry> getSpecificOrderEntries(int userId) throws UserException {
        return orderMapper.getSpecificOrderEntries(userId);
    }

    public void replyToOffer(int id, String reply) throws UserException {
        orderMapper.replyToOffer(id, reply);
    }
}
