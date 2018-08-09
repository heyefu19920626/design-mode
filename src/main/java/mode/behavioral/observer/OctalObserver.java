package mode.behavioral.observer;

/**
 * 八进制观察者.
 *
 * @author heyefu
 * @date 2018-08-09-下午10:46
 **/
public class OctalObserver extends Observer {


    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()) );
    }
}
