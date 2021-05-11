package web.commands;

import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowOrdersCommand extends CommandProtectedPage {

    OrderFacade orderFacade;

    public ShowOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        List<OrderEntry> orderEntryList = orderFacade.getAllOrderEntries();
        request.setAttribute("orderEntryList", orderEntryList);
        return pageToShow;
    }
}
