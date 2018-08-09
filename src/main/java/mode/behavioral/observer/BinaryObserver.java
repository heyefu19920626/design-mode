package mode.behavioral.observer;

/**
 * 二进制观察者.
 *
 * @author heyefu
 * @date 2018-08-09-下午10:51
 **/
public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
