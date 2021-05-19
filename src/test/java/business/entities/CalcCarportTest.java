package business.entities;

import org.junit.jupiter.api.*;

import static java.lang.Math.ceil;
import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class CalcCarportTest {

    private Result result;
    private CalcCarport calcCarport;

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

    @BeforeEach
    void setUp() {
        calcCarport = new CalcCarport();
        result = new Result();
    }

    @Test
    void testCalcPosts() {
        int length = 500;
        int height = 400;

        length -= postsTotalOffset;
        double amount = 0;
        if(length <= postDist) {
            amount = defaultPostAmount;
        } else {
            amount = ceil(((double)length/postDist)) * 2;
            result.setAmount((int) amount);
        }

        int mesurment = height + postburied;
        result.setLength(mesurment);

        assertEquals(amount, result.getAmount());
    }

    @Test
    void testCalcBeams() {
        int length = 800;
        result.setAmount(beamsTotal);
        calcCarport.calcBeams(length,result);
        int amount = result.getAmount();
        assertEquals(amount,result.getAmount());
    }

    @Test
    void testCalcRafters() {

        int length = 200;
        int width = 500;

        int amount = (int) ceil((double)length/rafterDist);
        result.setAmount(amount);

        int measurement = width;
        result.setLength(measurement);

        assertEquals(amount, result.getAmount());
    }

    @Test
    void testCalcUndersternFAB() {

        int width = 200;
        int amount = sternAmountSidesAndFAB;
        result.setAmount(amount);

        int measurement = (int) round(calcCarport.roundSingleCentimeters(width*excessMaterial/sternDivisor));
        result.setLength(measurement);

        assertEquals(result.getLength(), measurement);
    }


}