package test.classes.loading;

/**
 * 测试类加载机制.
 *
 * @author heyefu
 * @date 2018-08-07-下午10:55
 **/
public class SimpleClass {

    static int a = 3;

    static {
        a = 100;
        System.out.println("静态代码块 from SimpleClass!");
    }

    public SimpleClass() {
        System.out.println("SimpleClass 加载！");
    }

    public void run() {
        System.out.println("Run... from SimpleClass!");
    }
}
