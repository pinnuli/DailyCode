package singleton;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 双重检测机制
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample4 {

    private SingleExample4() {}

    private static SingleExample4 instance = null;

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    public static SingleExample4 getInstance() {
        if (instance == null) {
            synchronized (SingleExample4.instance) {
                if (instance == null) {
                    instance = new SingleExample4();
                }
            }
        }
        return instance;
    }
}
