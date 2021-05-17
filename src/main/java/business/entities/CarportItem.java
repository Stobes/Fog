package business.entities;

public class CarportItem {

    private int length;
    private int amount;
    private String contextDescription;
    private int materialId;

    public CarportItem( int length, int amount, String contextDescription, int materialId) {

        this.length = length;
        this.amount = amount;
        this.contextDescription = contextDescription;
        this.materialId = materialId;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getContextDescription() {
        return contextDescription;
    }

    public void setContextDescription(String contextDescription) {
        this.contextDescription = contextDescription;
    }

    public int getMaterialId() {
        return materialId;
    }
}

