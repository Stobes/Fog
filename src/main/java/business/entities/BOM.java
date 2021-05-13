package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BOM {
    private List<CarportItem> BOMList = new ArrayList<>();

    public BOM() {}

    public List<CarportItem> getBOMList() {
        return BOMList;
    }

    public void addToCart(CarportItem carportItem) { BOMList.add(carportItem); }

    public double retailPrice() {
        double sum = 0.0;
        for (CarportItem carportItem : BOMList) {
            sum += carportItem.getPrice();
        }
        return sum;
    }
}
