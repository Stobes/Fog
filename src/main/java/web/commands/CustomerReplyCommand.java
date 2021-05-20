package web.commands;

import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CustomerReplyCommand extends CommandProtectedPage{

    private OrderFacade orderFacade;


    public CustomerReplyCommand(String pageToShow, String role) {
        super(pageToShow, "customer");
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        System.out.println("fik: " + request.getParameter("reply"));
        int id = -1;
        String reply;
        try{
            id = Integer.parseInt(request.getParameter("orderID"));
        } catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
        }

        reply = request.getParameter("reply");

        orderFacade.replyToOffer(id, reply);

        return pageToShow;
    }
}
