
package the14_剪绳子;

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
     * Method: maxProductAfterCutting(int length)
     */
    @Test
    public void testMaxProductAfterCutting() throws Exception {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println("长度为" + i + ":" + solution.maxProductAfterCutting(i));
            System.out.println("长度为" + i + ":" + solution.maxProductAfterCutting2(i));
        }
    }
}
