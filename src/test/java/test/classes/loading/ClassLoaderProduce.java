package test.classes.loading;

/**
 * 测试类加载机制.
 *
 * @author heyefu
 * @date 2018-08-07-下午10:58
 **/
public class ClassLoaderProduce {

    static int d = 3;

    static {
        System.out.println("静态代码块 from ClassLoaderProduce!");
    }

    public static void main(String[] args) {
        int b = 0;
        String c = "hello";
        SimpleClass simpleClass = new SimpleClass();
        simpleClass.run();
    }
}
