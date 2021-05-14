package business.entities;

public class Material {
    private int id;
    private String unit;
    private String materialDescription;
    private int meterPrice;

    public Material(int id, String unit, String materialDescription, int meterPrice) {
        this.id = id;
        this.unit = unit;
        this.materialDescription = materialDescription;
        this.meterPrice = meterPrice;
    }

    public int getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public int getMeterPrice() {
        return meterPrice;
    }
}
