package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BOM {
    private List<Material> BOMList = new ArrayList<>();

    public BOM() {}

    public List<Material> getBOMList() {
        return BOMList;
    }

    public void addToCart(Material material) { BOMList.add(material); }

//    public double retailPrice() {
//        double sum = 0.0;
//        for (Material material : BOMList) {
//            sum += material.getmPrice();
//        }
//        return sum;
//    }
}
