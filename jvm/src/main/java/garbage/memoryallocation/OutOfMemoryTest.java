package garbage.memoryallocation;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: linxiaoyi
 * @date: 2021/1/19
 */
public class OutOfMemoryTest {
    static String  base = "string";
    public static void main(String[] args) {
        testJavaMethodAreaOOM();
    }

    private static void testRuntimeConstantPoolOOM() {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }

    private static void testJavaMethodAreaOOM() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    new MethodInterceptor() {
                        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                            return methodProxy.invokeSuper(o, objects);
                        }
                    }
            );
            enhancer.create();
        }
    }

    static class OOMObject {
    }


}
