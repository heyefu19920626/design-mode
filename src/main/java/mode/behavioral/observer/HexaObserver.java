package mode.behavioral.observer;

/**
 * 十六进制观察者.
 *
 * @author heyefu
 * @date 2018-08-09-下午10:52
 **/
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Hoxa String: " + Integer.toHexString(subject.getState()));
    }
}
