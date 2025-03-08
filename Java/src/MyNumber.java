

public class MyNumber implements Comparable<MyNumber> {
    int num;
    int originalIndex;

    public MyNumber(int num, int originalIndex) {
        this.num = num;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(MyNumber o) {
        return num - o.num;
    }
}
