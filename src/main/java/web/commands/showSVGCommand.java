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

        SVG svg = new SVG(0,0,"0 0 900 700",100,100);
        //svg.addSVG(svg);


        //Laver skur
        svg.addRect(100,0,650.0,600.0);

        //Laver de stiplede linjer
        svg.addLine(150,36,540,570);
        svg.addLine(150,570,540,36);

        //Laver spær
        svg.addRect(100,30,650.0,6.0);
        svg.addRect(100,570,650.0,6.0);

        //Laver spær
        for(int x = 0; x < 14; x++){
            svg.addRect(100 + 50 * x,0,4,600.0);
        }

        //Laver de små fede firkanter
        svg.addRect(197,28,10.0,10.0);
        svg.addRect(197,568,10.0,10.0);
        svg.addRect(422,28,10.0,10.0);
        svg.addRect(422,568,10.0,10.0);
        svg.addRect(540,28,10.0,10.0);
        svg.addRect(540,568,10.0,10.0);
        svg.addRect(722,28,10.0,10.0);
        svg.addRect(722,568,10.0,10.0);

        //svg.addRect(10,10,100,100);

        request.setAttribute("SVG",svg.toString());
        return pageToShow;
    }
}
