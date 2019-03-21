
package the50_第一个只出现一次的字符.题目一_1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution2 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 21, 2019</pre>
 */
public class Solution2Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: deleteFirstExistSecondByBitSet(String str1, String str2)
     */
    @Test
    public void testDeleteFirstExistSecondByBitSet() throws Exception {
        Solution2 solution = new Solution2();
        String str1 = "We are students.";
        String str2 = "aeviou";
        System.out.println(solution.deleteFirstExistSecondByBitSet(str1, str2));
    }


} 
