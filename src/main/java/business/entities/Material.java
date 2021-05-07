package business.entities;

public class Material {
    private final int id;
    private String materialDescription;
    private String unit;
    private String helpDescription;
    private double mPrice;

    public Material(int id, String materialDescription, String unit, String helpDescription, double mPrice) {
        this.id = id;
        this.materialDescription = materialDescription;
        this.unit = unit;
        this.helpDescription = helpDescription;
        this.mPrice = mPrice;
    }

    public int getId() {
        return id;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHelpDescription() {
        return helpDescription;
    }

    public void setHelpDescription(String helpDescription) {
        this.helpDescription = helpDescription;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }
}
