package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BOMList {

    private List<BOMItem> bomItemList = new ArrayList<>();

    public BOMList() {}

    public List<BOMItem> getBomItemList() { return bomItemList; }

    public int getTotalPrice(List<BOMItem> bomItemList) {
        int total = 0;

        for (BOMItem bomItem: bomItemList) {
            total += bomItem.getPrice() * (bomItem.getLength()/10) * bomItem.getAmount();
        }

        return total;
    }


}
