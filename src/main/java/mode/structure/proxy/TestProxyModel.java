package mode.structure.proxy;

/**
 * Description:
 * <p>
 * 代理模式。
 * <p>
 * 意图：为其他对象提供一种代理以控制对这个对象的访问.
 * <p>
 * 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 * <p>
 * 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制.
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 12:42
 **/
public class TestProxyModel {

    public static void main(String[] args) {
        testStaticProxy();
        testDynamicProxy();
        testCglibProxy();
    }

    public static void testStaticProxy() {
        IUserDao userDao = new Userdao();
        UserDaoStaticProxy staticProxy = new UserDaoStaticProxy(userDao);
        staticProxy.save();
    }

    public static void testDynamicProxy() {
        IUserDao target = new Userdao();
        DynamicProxyFactory proxyFactory = new DynamicProxyFactory(target);
        IUserDao proxy = (IUserDao) proxyFactory.getProxyInstance();
        proxy.save();
    }

    public static void testCglibProxy() {
        StandaloneUserDao target = new StandaloneUserDao();
        CglibProxyFactory cglib = new CglibProxyFactory(target);
        StandaloneUserDao proxy = (StandaloneUserDao) cglib.getProxyInstance();
        proxy.save();
    }
}
