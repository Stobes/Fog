package business.entities;

public class OrderEntry {

    private int id;
    private int length;
    private int width;
    private int height;
    private int price;
    private String status;
    private User user;

    public OrderEntry(int id, int length, int width, int height, String status) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;

        this.status = status;
        this.user = null;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
