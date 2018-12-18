package ConcurrentSort;

/**
 * @author: pinnuli
 * @date: 2018-12-17
 */

public class temp {
    private int left = 0;
    private int right = 0;
    private int middle = 0;

    public temp(int left, int right, int middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getMiddle() {
        return middle;
    }

    public boolean cmpLeftMiddle() {
        return left < middle - 1;
    }

    public boolean cmpMiddleRight() {
        return middle + 1 < right;
    }
}
