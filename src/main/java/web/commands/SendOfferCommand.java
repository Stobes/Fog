package web.commands;

import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendOfferCommand extends CommandProtectedPage {

    OrderFacade orderFacade;

    public SendOfferCommand(String pageToShow, String role) {
        super(pageToShow, "employee");
        this.orderFacade = new OrderFacade(database);

    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int id = 0;
        int total = 0;

        try {
            id = Integer.parseInt(request.getParameter("orderId"));
            total = Integer.parseInt(request.getParameter("total"));
        } catch (NumberFormatException exception) {
            request.setAttribute("error", "Id did not exist");
            return "index";
        }

        orderFacade.SendOffer(id, total);

        return pageToShow;
    }
}
