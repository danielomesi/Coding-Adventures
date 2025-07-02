import java.util.Arrays;

public class LatestTimeToCatchTheBus {
    public static void main(String[] args) {
        int[] buses = {3};
        int[] passengers = {2};
        int capacity = 2;
        System.out.println("Latest time to catch the bus is: " + latestTimeCatchTheBus(buses,passengers,capacity));
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int busIndex = 0, passengerIndex = 0;
        int busArrivalTime = buses[0], passengerArrivalTime;
        int indexOfLastPassengerToCatchTheBus = -1;
        int occupiedSeatsInBus = 0;
        int result;
        Arrays.sort(buses);
        Arrays.sort(passengers);

        while (busIndex < buses.length) {
            busArrivalTime = buses[busIndex];
            occupiedSeatsInBus = 0;
            while ((passengerIndex < passengers.length)
                    && (passengers[passengerIndex] <= busArrivalTime)
                    && (occupiedSeatsInBus < capacity)) {
                occupiedSeatsInBus++;
                indexOfLastPassengerToCatchTheBus = passengerIndex;
                passengerIndex++;
            }
            busIndex++;
        }

        if (indexOfLastPassengerToCatchTheBus == -1) result = buses[buses.length-1];
        else if ((occupiedSeatsInBus < capacity) && (busArrivalTime - passengers[indexOfLastPassengerToCatchTheBus] > 0)) {
            result = busArrivalTime;
        }
        else {
            result = getNearestBottomNumberOutSideArray(passengers,indexOfLastPassengerToCatchTheBus);
        }

        return result;
    }

    public static int getNearestBottomNumberOutSideArray(int[] passengers,int index) {
        int res = -1;

        while (index < passengers.length && index >=0) {
            if ((index-1)<0) {
                res =  passengers[index]-1;
                break;
            }
            else {
                int currentArrivalTime = passengers[index];
                int prevArrivalTime = passengers[index-1];
                if (currentArrivalTime != prevArrivalTime+1) {
                    res = currentArrivalTime-1;
                    break;
                }
            }
            index--;
        }

        return res;
    }
}
