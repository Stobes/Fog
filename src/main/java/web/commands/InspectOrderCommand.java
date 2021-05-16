package web.commands;

import business.entities.BOMItem;
import business.exceptions.UserException;
import business.services.BOMFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class InspectOrderCommand extends CommandProtectedPage {

    BOMFacade bomFacade;

    public InspectOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.bomFacade = new BOMFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int id = 0;

        try {
            id = Integer.parseInt(request.getParameter("Inspect Order"));
        } catch (NumberFormatException exception) {
            request.setAttribute("error", "Id did not exist");
            return "index";
        }

        request.setAttribute("Inspect Order", id);

        List<BOMItem> bomItemList = bomFacade.getBOMMaterials(id);

        request.setAttribute("BOMList", bomItemList);
        return pageToShow;
    }
}
