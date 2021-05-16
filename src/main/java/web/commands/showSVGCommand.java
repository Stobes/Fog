package web.commands;

import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showSVGCommand extends CommandUnprotectedPage {

    private OrderFacade orderFacade;

    public showSVGCommand(String pageToShow) {
        super(pageToShow);
        this.orderFacade = new OrderFacade(database);
    }



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        
        SVG svg = new SVG(0,0,"0 0 900 700",100,100,100);
        svg.addSVG(svg);
        svg.addRect(0,0,900,700);
        svg.addLine(0,0,100,200);

        request.setAttribute("SVG",svg.toString());

        return pageToShow;
    }
}
