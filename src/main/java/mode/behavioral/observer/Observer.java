package mode.behavioral.observer;

/**
 * 观察者抽象类.
 *
 * @author heyefu
 * @date 2018-08-09-下午10:40
 **/
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}
