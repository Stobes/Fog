package web.commands;

import business.entities.OrderEntry;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCustomerOrdersCommand extends CommandProtectedPage {

    private User user;
    private OrderFacade orderFacade;

    public ShowCustomerOrdersCommand(String pageToShow, String role) {
        super(pageToShow, "customer");
        orderFacade = new OrderFacade(database);
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int user_id = 1;

        if (session.getAttribute("user") != null) {
            user = (User)session.getAttribute("user");
            user_id = user.getId();
        }

        List<OrderEntry> customerOrders = orderFacade.getSpecificOrderEntries(user_id);

        request.setAttribute("customerOrders", customerOrders);


        return pageToShow;
    }
}
