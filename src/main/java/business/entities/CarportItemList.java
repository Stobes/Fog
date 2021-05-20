package business.entities;

import java.util.ArrayList;
import java.util.List;

public class CarportItemList extends CalcCarport{
    private List<CarportItem> carportItemList = new ArrayList<>();

    public CarportItemList() {}

    public List<CarportItem> getBOMList() {
        return carportItemList;
    }

    public List<CarportItem> assembleList(int length, int width, int height, List<Material> materialList, List<CarportItem> carportItemList) {

        Result result = new Result();

        for (Material material : materialList) {

            switch (material.getId()) {

                case 1:
                    calcUndersternFAB(width, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));

                    calcUndersternSides(length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));
                    break;

                case 2:
                    calcOversternFront(width, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));

                    calcOversternSides(length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));
                    break;

                case 3:
                    calcBeams(length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));

                    calcRafters(width, length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));
                    break;

                case 4:
                    calcPosts(height, length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));
                    break;

                case 5:
                    calcWaterBoardsSides(length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));

                    calcWaterBoardsFront(width, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));
                    break;

                case 6:
                    calcRoof(width, length, result);
                    carportItemList.add(new CarportItem(
                            result.getLength(),
                            result.getAmount(),
                            result.getContextDescription(),
                            material.getId()));

            }

        }

        return carportItemList;
    }

}
