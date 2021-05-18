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
        try {
            id = Integer.parseInt(request.getParameter("Inspect Order"));
        } catch (NumberFormatException exception) {
            request.setAttribute("error", "Id did not exist");
            return "index";
        }

        request.setAttribute("Inspect Order", id);

        List<BOMItem> bomItemList = bomFacade.getBOMMaterials(id);
        int total = bomList.getTotalPrice(bomItemList);

        request.setAttribute("BOMList", bomItemList);
        request.setAttribute("total", total);

        OrderEntry drawing = orderFacade.getOrderById(id);
        SVG svg = new SVG(0,0,"0 0 900 700",100,100);
        //svg.addSVG(svg);


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
