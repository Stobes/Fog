package business.entities;

public class BOMItem {

    private String materialDescription;
    private int length;
    private int amount;
    private String unit;
    private String contextDescription;

    public BOMItem(String materialDescription, int length, int amount, String unit, String contextDescription) {
        this.materialDescription = materialDescription;
        this.length = length;
        this.amount = amount;
        this.unit = unit;
        this.contextDescription = contextDescription;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public int getLength() {
        return length;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getContextDescription() {
        return contextDescription;
    }
}
