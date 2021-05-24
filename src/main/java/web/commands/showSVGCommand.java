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
        SVG svg = new SVG(0,0,"0 0 1000 800",100,100);

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
