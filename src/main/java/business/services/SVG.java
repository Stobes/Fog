package business.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;
    private int length;



    private  String templateHeader = "<svg height=\"%d%%\" "
            + "width =\"%d%%\"" + "viewBox=\"%s\" "
            + "x=\"%d\" "
            + "y=\"%d\" "
            + "preserveAspectRatio=\"xMinYMin\">";


    private  String rectTemplate = "<rect x=\"%d\" y=\"%d\" width=\"%f\" height=\"%f\" style=\"stroke: black; fill: white\"/>";
    private String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:black; stroke-dasharray:5,5; fill: white\"/>";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;


        svg.append(String.format(templateHeader,height,width, viewBox, x, y));
    }

    //Bruges til at lave spær
    public void addRect (int x, int y, double width, double height){
    svg.append(String.format(rectTemplate,x,y,width,height));
    }

    public void addLine (int x1,int y1,int x2, int y2){
        svg.append(String.format(lineTemplate,x1,y1,x2,y2));
    }

    public void addSVG (SVG innerSVg){
        svg.append(innerSVg.toString());
    }

    @Override
    public String toString() {

        return svg.toString() + "</svg>";
    }
}
