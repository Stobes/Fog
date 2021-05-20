package web.commands;

import business.entities.BOMItem;
import business.entities.BOMList;
import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.services.BOMFacade;
import business.services.OrderFacade;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class InspectOrderCommand extends CommandProtectedPage {

    BOMFacade bomFacade;
    BOMList bomList;
    private OrderFacade orderFacade;

    public InspectOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.bomFacade = new BOMFacade(database);
        this.bomList = new BOMList();
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int id = 0;
        int startMeasurement = 100;
        int startMeasurementInMeters = 200;
        int postDimensions = 10;
        int postCoordinateX = 70;
        int postSpacing = 310;
        int upperPostCoordinateY = 28;
        int lowerPostCoordinateY = 38;
        int yLineDifference = 30 ;
        int xLineDifference = 104;
        int lowerYRafter = 34;
        int upperYRafter = 30;
        int rafterHeight = 4;
        int rafterSpacing = 55;
        int rafterWidth = 4;
        try {
            id = Integer.parseInt(request.getParameter("Inspect Order"));
        } catch (NumberFormatException exception) {
            request.setAttribute("error", "Id did not exist");
            return "index";
        }

        request.setAttribute("Inspect Order", id);
        orderFacade.getOrderById(id);
        List<BOMItem> bomItemList = bomFacade.getBOMMaterials(id);
        int total = bomList.getTotalPrice(bomItemList);

        request.setAttribute("orderId", id);
        request.setAttribute("BOMList", bomItemList);
        request.setAttribute("total", total);

        OrderEntry drawing = orderFacade.getOrderById(id);
        SVG svg = new SVG(0,0,"0 0 900 700",100,100);
        //svg.addSVG(svg);


        //Laver skur
        svg.addCarport(startMeasurement,0,drawing.getLength(),drawing.getWidth());


        //Laver spær vertikalt
        for(int x = 0; x <= (drawing.getLength() / rafterSpacing); x++){
            svg.addRafters(startMeasurement + rafterSpacing * x,0,rafterWidth,drawing.getWidth());
        }

        //laver spær horisontalt
        svg.addRafters(startMeasurement,upperYRafter,drawing.getLength(),rafterHeight);
        svg.addRafters(startMeasurement,drawing.getWidth() - lowerYRafter,drawing.getLength(),rafterHeight);

        //slut spær
        //svg.addSpær(drawing.getLength()+100,0,4, drawing.getWidth());


        //Laver stolper

        if(drawing.getLength() - 130 < postSpacing){
            svg.addPosts(startMeasurementInMeters,upperPostCoordinateY,postDimensions,postDimensions);
            svg.addPosts(startMeasurementInMeters ,drawing.getWidth()-lowerPostCoordinateY,postDimensions,postDimensions);
        } else {

            for (int x = 0; x < (drawing.getLength() / postSpacing); x++) {
                svg.addPosts(startMeasurementInMeters + postSpacing * x, upperPostCoordinateY, postDimensions, postDimensions);
                svg.addPosts(startMeasurementInMeters + postSpacing * x, drawing.getWidth() - lowerPostCoordinateY, postDimensions, postDimensions);

            }
        }

        //Laver ende stolper
        svg.addPosts(drawing.getLength()+postCoordinateX,upperPostCoordinateY,postDimensions, postDimensions);
        svg.addPosts(drawing.getLength()+postCoordinateX,drawing.getWidth()-lowerPostCoordinateY,postDimensions,postDimensions);

        //Laver de stiplede linjer
        svg.addLine(startMeasurement, yLineDifference, drawing.getLength()+xLineDifference, drawing.getWidth()-yLineDifference);
        svg.addLine(startMeasurement,drawing.getWidth()-yLineDifference,drawing.getLength()+xLineDifference,yLineDifference);



        request.setAttribute("SVG",svg.toString());
        return pageToShow;
    }
}
