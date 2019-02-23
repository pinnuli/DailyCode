
package the21_调整数组顺序使奇数位于偶数前面;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 23, 2019</pre>
 */
public class SolutionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: reOrderArray(int [] array)
     */
    @Test
    public void testReOrderArray() throws Exception {
        int[] test1 = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] test2 = {2, 4, 6, 8, 1, 3, 5, 7};
        int[] test3 = {1, 4, 2, 5, 7, 3, 6, 8};
        int[] test4 = null;

        /*Solution solution = new Solution();
        solution.reOrderArray2(test1);
        printArray(test1);
        solution.reOrderArray2(test2);
        printArray(test2);
        solution.reOrderArray2(test3);
        printArray(test3);
        solution.reOrderArray2(test4);
        printArray(test4);*/

        Solution solution = new Solution();
        solution.reOrderArray3(test1);
        printArray(test1);
        solution.reOrderArray3(test2);
        printArray(test2);
        solution.reOrderArray3(test3);
        printArray(test3);
        solution.reOrderArray3(test4);
        printArray(test4);

    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    /**
     * Method: isEven(int number)
     */
    @Test
    public void testIsEven() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = Solution.getClass().getMethod("isEven", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
