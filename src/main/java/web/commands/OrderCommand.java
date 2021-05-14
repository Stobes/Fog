package web.commands;

import business.entities.User;
import business.entities.*;
import business.exceptions.UserException;
import business.persistence.MaterialMapper;
import business.services.MaterialFacade;
import business.services.OrderFacade;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class OrderCommand extends CommandProtectedPage {

    private OrderFacade orderFacade;
    private MaterialFacade materialFacade;
    private CarportItemList carportItemList;
    private User user;

    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, "customer");
        this.orderFacade = new OrderFacade(database);
        this.materialFacade = new MaterialFacade(database);
        this.carportItemList = new CarportItemList();
    }


    @Override

    public String getRole() {
        return role;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int user_id = 1;

        if (session.getAttribute("user") != null) {
            user = (User)session.getAttribute("user");
            user_id = user.getId();
        }


        int length = 0;
        int width = 0;
        int height = 0;


        try {
            length = Integer.parseInt(request.getParameter("length"));
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Husk at indtaste et heltal i 'længde', 'højde' og 'bredde'");
            return "index";
        }

        request.setAttribute("length", length);
        request.setAttribute("height", height);
        request.setAttribute("width", width);

        int orderId = orderFacade.insertOrder(length, height, width, user_id);


        List<Material> materialList = materialFacade.getAllMaterials();
        List<CarportItem> _carportItemList = new ArrayList<>();
        carportItemList.assembleList(length, width, height, materialList, _carportItemList);

        orderFacade.insertOrderItem(_carportItemList, orderId);

        return pageToShow;
    }
}
