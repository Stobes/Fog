package business.entities;

public class Result {

    private int length;
    private int amount;
    private String contextDescription;

    public Result(int length, int amount, String contextDescription) {
        this.length = length;
        this.amount = amount;
        this.contextDescription = contextDescription;

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
}
