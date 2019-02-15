package singleton;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * volatile + 双重检测机制 -> 禁止指令重排
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample5 {

    private SingleExample5() {}

    private static volatile SingleExample5 instance = null;

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    public static SingleExample5 getInstance() {
        if (instance == null) {
            synchronized (SingleExample5.instance) {
                if (instance == null) {
                    instance = new SingleExample5();
                }
            }
        }
        return instance;
    }
}
