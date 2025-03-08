import java.util.*;

public class GetMinRemovals {
    public static void main(String[] args) {
        int[] data = {1,2,3,2,1};
        int max_distinct = 2;
        System.out.println("Num of elements to remove from array is " + getMinRemovals(data,max_distinct));
    }

    public static int getMinRemovals(int[] data,int max_distinct) {
        Map<Integer,Integer> element2AppearanceCounter = new HashMap<>();
        int numOfCurrentDistinctElement;
        int elementsToRemove = 0;
        for (int num : data) {
            element2AppearanceCounter.put(num, element2AppearanceCounter.getOrDefault(num, 0) + 1);
        }
        numOfCurrentDistinctElement  = element2AppearanceCounter.size();
        if (numOfCurrentDistinctElement > max_distinct) {
            List<Integer> apeearanceCounters = new ArrayList<>(element2AppearanceCounter.values());
            Collections.sort(apeearanceCounters);
            int differenceDistinctNumberToRemove = numOfCurrentDistinctElement - max_distinct;
            for (int i = 0; i < differenceDistinctNumberToRemove; i++) {
                elementsToRemove+=apeearanceCounters.get(i);
            }
        }

        return elementsToRemove;
    }
}
