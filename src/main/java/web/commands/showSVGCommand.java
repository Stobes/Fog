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
        int startMål = 100;
        int startMålMedMeter = 200;
        int stolpedimensioner = 10;
        int stolpeTillægsKordinatX = 70;
        int stolpeAfstand = 310;
        int øvreStolpeYKordinat = 28;
        int nedreStolpeYKordinat = 38;
        int yLineForskel = 30 ;
        int xLineforskel = 104;
        int nedreYSpær = 34;
        int øvreYspær = 30;
        int spærHøjde = 4;
        int spærAfstand = 55;
        int spærBredde = 4;


        //Laver skur
        svg.addCarport(startMål,0,drawing.getLength(),drawing.getWidth());


        //Laver spær vertikalt
        for(int x = 0; x <= (drawing.getLength() / spærAfstand); x++){
            svg.addSpær(startMål + spærAfstand * x,0,spærBredde,drawing.getWidth());
        }

        //laver spær horisontalt
        svg.addSpær(startMål,øvreYspær,drawing.getLength(),spærHøjde);
        svg.addSpær(startMål,drawing.getWidth() - nedreYSpær,drawing.getLength(),spærHøjde);

        //slut spær
        //svg.addSpær(drawing.getLength()+100,0,4, drawing.getWidth());


       //Laver stolper

        if(drawing.getLength() - 130 < stolpeAfstand){
            svg.addStolpe(startMålMedMeter,øvreStolpeYKordinat,stolpedimensioner,stolpedimensioner);
            svg.addStolpe(startMålMedMeter ,drawing.getWidth()-nedreStolpeYKordinat,stolpedimensioner,stolpedimensioner);
        } else {

            for (int x = 0; x < (drawing.getLength() / stolpeAfstand); x++) {
                svg.addStolpe(startMålMedMeter + stolpeAfstand * x, øvreStolpeYKordinat, stolpedimensioner, stolpedimensioner);
                svg.addStolpe(startMålMedMeter + stolpeAfstand * x, drawing.getWidth() - nedreStolpeYKordinat, stolpedimensioner, stolpedimensioner);

            }
        }

       //Laver ende stolper
        svg.addStolpe(drawing.getLength()+stolpeTillægsKordinatX,øvreStolpeYKordinat,stolpedimensioner, stolpedimensioner);
        svg.addStolpe(drawing.getLength()+stolpeTillægsKordinatX,drawing.getWidth()-nedreStolpeYKordinat,stolpedimensioner,stolpedimensioner);

        //Laver de stiplede linjer
        svg.addLine(startMål, yLineForskel, drawing.getLength()+xLineforskel, drawing.getWidth()-yLineForskel);
        svg.addLine(startMål,drawing.getWidth()-yLineForskel,drawing.getLength()+xLineforskel,yLineForskel);



        request.setAttribute("SVG",svg.toString());
        return pageToShow;
    }
}
