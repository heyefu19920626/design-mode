package test.classes.loading;

/**
 * 类加载器和双亲委派机制.
 *
 * @author heyefu
 * @date 2018-08-08-下午10:14
 **/
public class ClassLoaderParents {

    public static void main(String[] args) {

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统/应用类加载器: " + appClassLoader);

        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println("扩展类加载器: " + extClassLoader);
        System.out.println("扩展类加载器的类路径: " + System.getProperty("java.ext.dirs"));

        System.out.println("扩展类的父类加载器: " + extClassLoader.getParent());
    }
}
