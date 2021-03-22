
package the16_数值的整数次方;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 19, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: Power(double base, int exponent)
     */
    @Test
    public void testPower() throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.Power(2, 5));
        System.out.println(solution.Power(2, -5));
//        System.out.println(solution.Power(0, -1));
        System.out.println(solution.Power(2, 0));
        System.out.println(solution.Power(-2, -5));
        System.out.println(solution.Power(-2, 5));

    }

    /**
     * Method: powerWithUnsignedExponent(double base, int absExponent)
     */
    @Test
    public void testPowerWithUnsignedExponent() throws Exception {
//TODO: com.pinnuli.leetcode.Test goes here...
    }


} 
