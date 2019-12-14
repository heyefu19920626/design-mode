package mode.structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Cglib子类代理.
 * <p>
 * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入spring-core-3.2.5.jar即可.
 * <p>
 * 2.引入功能包后,就可以在内存中动态构建子类
 * <p>
 * 3.代理的类不能为final,否则报错
 * <p>
 * 4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 13:02
 **/
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数(代理人)
        enhancer.setCallback(this);
        //创建子类对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---Start Transaction From Cglib---");
        Object result = method.invoke(target, objects);
        System.out.println("---Commit Transaction From Cglib---");
        return result;
    }
}
