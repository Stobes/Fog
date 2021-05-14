package business.entities;

import java.text.DecimalFormat;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class CalcCarport {

    double excessMaterial = 1.20;

    public Result calcPosts(int height, int length, Result result) {


        length -= 130;
        int amount = (int) ceil((length/310)) * 2;
        result.setAmount(amount);

        int mesurment = height + 90;
        result.setLength(mesurment);

        String description = "Stolper nedgraves 90 cm. i jord";
        result.setContextDescription(description);

        return result;
    }

    public Result calcBeams(int length, Result result) {

        int amount = 2;
        result.setAmount(amount);

        int mesurement = length;
        result.setLength(mesurement);

        String description = "Remme i sider, sadles ned i stolper";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRafters(int width, int length, Result result) {

        int amount = (int) ceil(length/55);
        result.setAmount(amount);

        int mesurment = width;
        result.setLength(mesurment);

        String description = "Spær monteres på rem";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternFAB(int width, Result result) {

        int amount = 4;
        result.setAmount(amount);

        int mesurment = (int) round((width*excessMaterial/2)/10)*10;
        result.setLength(mesurment);

        String description = "Understernbrædder til for & bag ende";
        result.setContextDescription(description);

        return result;
    }

    public Result calcUndersternSides(int length, Result result) {

        int amount = 4;
        result.setAmount(amount);

        int mesurment = (int) round((length * excessMaterial / 2) / 10) * 10;
        result.setLength(mesurment);

        String description = "Understernbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternFront(int width, Result result) {

        int amount = 2;
        result.setAmount(amount);

        int mesurment = (int) round((width*excessMaterial/2)/10)*10;
        result.setLength(mesurment);

        String description = "Oversternbrædder til forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcOversternSides(int length, Result result) {

        int amount = 4;
        result.setAmount(amount);

        int mesurment = (int) round((length*excessMaterial/2)/10)*10;
        result.setLength(mesurment);

        String description = "Oversternbrædder til siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsSides(int length, Result result) {

        int amount = 4;
        result.setAmount(amount);

        int mesurment = (int) round((length * excessMaterial / 2) / 10) * 10;
        result.setLength(mesurment);

        String description = "Vandbrædt på stern i siderne";
        result.setContextDescription(description);

        return result;
    }

    public Result calcWaterBoardsFront(int width, Result result) {

        int amount = 2;
        result.setAmount(amount);

        int mesurment = (int) round((width*excessMaterial/2)/10)*10;
        result.setLength(mesurment);

        String description = "Vandbrædt på stern i forenden";
        result.setContextDescription(description);

        return result;
    }

    public Result calcRoof(int width, int length, Result result) {

        int amount = (int) ceil(length*1.025);
        result.setAmount(amount);

        int mesurment = width;
        result.setLength(mesurment);

        String description = "Tagplader monteres på spær";
        result.setContextDescription(description);

        return result;
    }

}
