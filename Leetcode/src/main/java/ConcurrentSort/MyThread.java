package ConcurrentSort;

import java.util.concurrent.Callable;

/**
 * @author: pinnuli
 * @date: 2018-12-17
 */

public class MyThread implements Callable<temp> {

    private int left;
    private int right;
    private int middle;
    private int str[];

    public MyThread(int left, int right, int str[]) {
        this.left = left;
        this.right = right;
        this.str = str;
    }

    public temp call() {
        oneSort();
        return new temp(left, right, middle);
    }

    public void oneSort() {
        int i, j, pos;
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        pos = str[i];
        while (i < j) {
            while (i < j && pos <= str[j]) {
                j--;
            }
            if (i < j) {
                str[i] = str[j];
            }

            while (i < j && pos >= str[i]) {
                i++;
            }
            if (i < j) {
                str[j] = str[i];
            }
            str[i] = pos;
        }
        middle = i;
    }

}
