
package the9_用两个栈实现队列;

import org.junit.Test;

/**
 * SimpleStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 31, 2019</pre>
 */
public class SimpleStackTest {


    /**
     * Method: push(int node)
     */
    @Test
    public void testPush() throws Exception {
        SimpleStack simpleStack = new SimpleStack();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
        simpleStack.push(4);
        System.out.println(simpleStack.pop());
    }

    /**
     * Method: pop()
     */
    @Test
    public void testPop() throws Exception {
//TODO: Test goes here... 
    }


} 
