package business.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;




    private  String templateHeader = "<svg height=\"%d%%\" "
            + "width =\"%d%%\"" + "viewBox=\"%s\" "
            + "x=\"%d\" "
            + "y=\"%d\" "
            + "preserveAspectRatio=\"xMinYMin\">";


    private  String carportTemplate = "<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"stroke: black; fill: none\"/>";
    private String spærTemplate = "<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"stroke: black; fill: none\"/>";
    private String stolpeTemplate = "<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"stroke: black; fill: none\"/>";
    private String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:black; stroke-dasharray:5,5; fill: none\"/>";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;


        svg.append(String.format(templateHeader,height,width, viewBox, x, y));
    }

    //Bruges til at lave carport
    public void addCarport (int x, int y, int width, int height){
    svg.append(String.format(carportTemplate,x,y,width,height));
    }

    //bruges til at lave spær
    public void addSpær (int x, int y, int width, int height){
        svg.append(String.format(spærTemplate,x,y,width,height));
    }

    //Bruges til at lave stolper
    public void addStolpe (int x, int y, int width, int height) {
        svg.append(String.format(stolpeTemplate, x, y, width, height));
    }

    //Bruges til at lave bånd.
    public void addLine (int x1,int y1,int x2, int y2){
        svg.append(String.format(lineTemplate,x1,y1,x2,y2));
    }

    //bruges til at lave indre svg
    public void addSVG (SVG innerSVg){
        svg.append(innerSVg.toString());
    }

    @Override
    public String toString() {

        return svg.toString() + "</svg>";
    }
}
