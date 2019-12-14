package mode.structure.proxy;

import java.lang.reflect.Proxy;

/**
 * Description:
 * <p>
 * 动态代理模式
 * <p>
 * 主要借助Jdk附带的java.lang.reflect.Proxy类,不需要再专门去实现一个接口.
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 12:48
 **/
public class DynamicProxyFactory {

    Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("---Start Transaction From Dynamic---");
                    Object result = method.invoke(target, args);
                    System.out.println("---Commit Transaction From Dynamic===");
                    return result;
                });
    }

}
