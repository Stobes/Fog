package business.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewbox;
    private int width;
    private int height;
    private int length;


    private String templateHeader = "";

    private String rectTemplate = "kode for rectangel";
    private String lineTemplate = "Kode for linje";

    public SVG(int x, int y, String viewbox, int width, int height, int length) {
        this.x = x;
        this.y = y;
        this.viewbox = viewbox;
        this.width = width;
        this.height = height;
        this.length = length;

        svg.append(String.format(templateHeader,height,width, viewbox, x, y));
    }

    public void addRect (int x, int y, int width, int height){
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
