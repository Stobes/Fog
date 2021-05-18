package business.entities;

import java.text.DecimalFormat;

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

    private double roundSingleCentimeters(double mesure) {

        mesure = (mesure/10)*10;

        return mesure;
    }


    public Result calcPosts(int height, int length, Result result) {


        length -= postsTotalOffset;
        int amount;
        if(length <= postDist) {
            amount = defaultPostAmount;
        } else {
            amount = (int) ceil((length/postDist)) * 2;
            result.setAmount(amount);
        }

        int mesurment = height + postburied;
        result.setLength(mesurment);

        String description = "Stolper nedgraves 90 cm. i jord";
        result.setContextDescription(description);

        return result;
    }

    public Result calcBeams(int length, Result result) {

        int amount = beamsTotal;
        result.setAmount(amount);

        int mesurement = length;
        result.setLength(mesurement);

        String description = "Remme i sider, sadles ned i stolper";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRafters(int width, int length, Result result) {

        int amount = (int) ceil(length/rafterDist);
        result.setAmount(amount);

        int mesurment = width;
        result.setLength(mesurment);

        String description = "Spær monteres på rem";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternFAB(int width, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(mesurment);

        String description = "Understernbrædder til for & bag ende";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(length * excessMaterial / sternDivisor));
        result.setLength(mesurment);

        String description = "Understernbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternFront(int width, Result result) {

        int amount = sternAmountFront;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(mesurment);

        String description = "Oversternbrædder til forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(length*excessMaterial/sternDivisor));
        result.setLength(mesurment);

        String description = "Oversternbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsSides(int length, Result result) {

        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(length * excessMaterial / sternDivisor));
        result.setLength(mesurment);

        String description = "Vandbrædt på stern i siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsFront(int width, Result result) {

        int amount = sternAmountFront;
        result.setAmount(amount);

        int mesurment = (int) round(roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(mesurment);

        String description = "Vandbrædt på stern i forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRoof(int width, int length, Result result) {

        int amount = (int) ceil(length*roofAmountPrLength);
        result.setAmount(amount);

        int mesurment = width;
        result.setLength(mesurment);

        String description = "Tagplader monteres på spær";
        result.setContextDescription(description);

        return result;
    }

}
