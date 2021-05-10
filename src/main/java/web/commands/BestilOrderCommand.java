package web.commands;

import  business.exceptions.UserException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BestilOrderCommand extends CommandUnprotectedPage {
    public BestilOrderCommand(String pageToShow) { super(pageToShow); }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int length = 0;
        int width = 0;
        int height = 0;
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("adress");
        int zipCode = 0;

        try {
            length = Integer.parseInt(request.getParameter("length"));
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
        }
        catch (NumberFormatException ex) {
            request.setAttribute("error", "Husk at indtaste et heltal i 'længde', 'hæjde' og 'bredte'");
            return "index";
        }

        request.setAttribute("length", length);
        request.setAttribute("height", height);
        request.setAttribute("width", width);
        request.setAttribute("email", email);
        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("zipCode", zipCode);

        return pageToShow;
    }
}
