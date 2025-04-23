import java.util.ArrayList;
import java.util.List;

public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        angleClock(12,30);
    }

    public static final double degreeRangeBetween2NeighborHoursForHourPointer = 30;
    public static final double degreeRangeBetween2NeighborMinutesForHourPointer = 0.5;
    public static final double degreeRangeBetween2NeighborMinutesForMinutePointer = 6;

    public static double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double hourPointerLocation = hour * degreeRangeBetween2NeighborHoursForHourPointer + minutes * degreeRangeBetween2NeighborMinutesForHourPointer;
        double minutesPointerLocation = minutes * degreeRangeBetween2NeighborMinutesForMinutePointer;
        double option1 = getDifferenceAndNormalize(hourPointerLocation, minutesPointerLocation);
        double option2 = getDifferenceAndNormalize(minutesPointerLocation, hourPointerLocation);


        return Math.min(option1, option2);
    }

    public static double getDifferenceAndNormalize(double num1,double num2) {
        double res = num1-num2;
        if (res<0) res+=360;

        return res;
    }
}
