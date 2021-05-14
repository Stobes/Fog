package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showSVGCommand extends CommandUnprotectedPage {

    public showSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        SVG svg = new SVG(0,0,"0 0 900 700",100,100);
        //svg.addSVG(svg);

        //For at lave spær
        for(int x = 0; x < 14; x++){
            svg.addRect(100 + 50 * x,0,600.0,4.5);
        }
        //svg.addRect(10,10,100,100);
        //svg.addLine(0,0,100,200);

        request.setAttribute("SVG",svg.toString());

        return pageToShow;
    }
}
