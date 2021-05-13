package business.entities;

public class CarportItem {
    private int length;
    private int amount;
    private int price;
    private String description;

    public CarportItem(int length, int amount, int price, String description) {
        this.length = length;
        this.amount = amount;
        this.price = price;
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

