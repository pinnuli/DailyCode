package the10_斐波那契数列;

/**
 * @author: pinnuli
 * @date: 2019-02-06
 */

public class JumpFloorII {
    public int jumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }

        return 2 * jumpFloorII(target - 1);
    }
}
