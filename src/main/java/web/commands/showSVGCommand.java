package web.commands;

import business.entities.OrderEntry;
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
        OrderEntry drawing = orderFacade.getOrderId();
        SVG svg = new SVG(0,0,"0 0 900 700",100,100);
        //svg.addSVG(svg);

        //Laver skur
        svg.addCarport(100,0,drawing.getLength(),drawing.getWidth());


        //Laver spær vertikalt
        for(int x = 0; x <= (drawing.getLength() / 55); x++){
            svg.addSpær(100 + 55 * x,0,4,drawing.getWidth());
        }

        //laver spær horisontalt
        svg.addSpær(100,30,drawing.getLength(),4);
        svg.addSpær(100,drawing.getWidth() - 34,drawing.getLength(),4);

        //slut spær
        svg.addSpær(drawing.getLength()+100,0,4, drawing.getWidth());

        
       //Laver stolper
        for(int x = 0; x < (drawing.getLength() / 310); x++){
            svg.addStolpe(200 + 310 * x,28,10,10);
            svg.addStolpe(200 + 310 * x,drawing.getWidth()-38,10,10);
        }

       //Laver ende stolper
        svg.addStolpe(drawing.getLength()+70,28,10, 10);
        svg.addStolpe(drawing.getLength()+70,drawing.getWidth()-38,10,10);

        //Laver de stiplede linjer
        svg.addLine(100,30, drawing.getLength()+104, drawing.getWidth()-30);
        svg.addLine(100,drawing.getWidth()-30,drawing.getLength()+104,30);



        request.setAttribute("SVG",svg.toString());
        return pageToShow;
    }
}
