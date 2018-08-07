package mode.create.singleton;

/**
 * 懒汉式单例模式.
 *
 * @auther heyefu
 * @date 2018/8/6 18:21
 */
public class IdlerSingletonPattern {

    private IdlerSingletonPattern() {

    }

    private static class IdlerSingletonHolder {

        private static final IdlerSingletonPattern INSTANCE = new IdlerSingletonPattern();

    }

    public static IdlerSingletonPattern getIdlerSingletonPattern() {

        return IdlerSingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Singleton from lazy!");
    }
}
