package the10_斐波那契数列;

import java.lang.annotation.Target;

/**
 * @author: pinnuli
 * @date: 2019-02-06
 */

public class RectCover {
    public int rectCover(int target) {
        if (target <= 0) {
            return -1;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int rectOne = 2;
        int rectTwo = 1;
        int rectTotal = 0;
        for (int i = 3; i <= target; i++) {
            rectTotal = rectOne + rectTwo;
            rectTwo = rectOne;
            rectOne = rectTotal;
        }
        return rectTotal;
    }
}
