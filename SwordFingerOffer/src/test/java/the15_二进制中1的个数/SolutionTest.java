
package the15_二进制中1的个数;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 17, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: numberOf1(int number)
     */
    @Test
    public void testNumberOf1() throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution3(0));
        System.out.println(solution.solution3(3));
        System.out.println(solution.solution3(-3));

    }


} 
