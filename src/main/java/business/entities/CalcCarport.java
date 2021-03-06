package business.entities;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class CalcCarport {

    double excessMaterial = 1.20;

    // calcPosts constants.
    int postDist = 310;
    int postburied = 90;
    int defaultPostAmount = 4;
    int postsTotalOffset = 130;

    // calcBeams constants
    int beamsTotal = 2;

    // calcRafters constants
    int rafterDist = 55;

    // Stern constants
    int sternDivisor = 2;
    int sternAmountSidesAndFAB = 4;
    int sternAmountFront = 2;

    // calcRoof constants
    double roofAmountPrLength = 0.014;

    protected double roundSingleCentimeters(double measure) {

        measure = (measure/10)*10;

        return measure;
    }


    public Result calcPosts(int height, int length, Result result) {


        length -= postsTotalOffset;
        int amount;
        if(length <= postDist) {
            amount = defaultPostAmount;
            result.setAmount(amount);
        } else {
            amount = (int) (ceil((double)length/postDist)) * 2;
            result.setAmount(amount);
        }

        int measurement = height + postburied;
        result.setLength(measurement);

        String description = "Stolper nedgraves 90 cm. i jord";
        result.setContextDescription(description);

        return result;
    }

    public Result calcBeams(int length, Result result) {

        int amount = beamsTotal;
        result.setAmount(amount);

        int measurement = length;
        result.setLength(measurement);

        String description = "Remme i sider, sadles ned i stolper";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRafters(int width, int length, Result result) {

        int amount = (int) ceil(length/rafterDist);
        result.setAmount(amount);

        int measurement = width;
        result.setLength(measurement);

        String description = "Spær monteres på rem";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternFAB(int width, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(measurement);

        String description = "Understernbrædder til for & bag ende";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(length * excessMaterial / sternDivisor));
        result.setLength(measurement);

        String description = "Understernbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternFront(int width, Result result) {

        int amount = sternAmountFront;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(measurement);

        String description = "Oversternbrædder til forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(length*excessMaterial/sternDivisor));
        result.setLength(measurement);

        String description = "Oversternbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(length * excessMaterial / sternDivisor));
        result.setLength(measurement);

        String description = "Vandbrædt på stern i siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsFront(int width, Result result) {

        int amount = sternAmountFront;
        result.setAmount(amount);

        int measurement = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(measurement);

        String description = "Vandbrædt på stern i forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRoof(int width, int length, Result result) {

        int amount = (int) ceil(length*roofAmountPrLength);
        result.setAmount(amount);

        int measurement = width;
        result.setLength(measurement);

        String description = "Tagplader monteres på spær";
        result.setContextDescription(description);

        return result;
    }

}
