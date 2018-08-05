package mode.create.singleton;

/**
 * 单例模式.
 *
 * @author heyefu
 * @date 2018-08-05-下午10:09
 **/
public class SingletonPattern {


    private static SingletonPattern singletonPattern = new SingletonPattern();

    /**
     * 构造方法私有化.
     *
     * @author heyefu
     **/
    private SingletonPattern() {

    }

    public static SingletonPattern getSinletonPattern(){

        return singletonPattern;
    }

    public void showMessage(){
        System.out.println("Hello world from SingletonPattern!");
    }
}
