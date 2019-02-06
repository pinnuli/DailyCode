package the10_斐波那契数列;

/**
 * @author: pinnuli
 * @date: 2019-02-06
 */

public class JumpFloor {
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int jumpOne = 2;
        int jumpTwo = 1;
        int jumpTotal = 0;
        for (int i = 3; i <= target; i++) {
            jumpTotal = jumpOne + jumpTwo;
            jumpTwo = jumpOne;
            jumpOne = jumpTotal;
        }
        return jumpTotal;
    }
}
