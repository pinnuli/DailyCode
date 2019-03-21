
package the20_表示数值的字符串;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 22, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isNumeric(char[] str)
     */
    @Test
    public void testIsNumeric() throws Exception {
        Solution solution = new Solution();
        String[] test = new String[]{"100", "+100", "-100", ".100", "100.", "100.67", "100.67e10", "100.67E10", "100.67e-10",
                "100.67e-10", "100.67e+10", "100.67e+10.89", "", null};

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i] + solution.isNumeric(test[i].toCharArray()));
        }
    }



} 
