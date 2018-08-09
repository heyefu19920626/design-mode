package mode.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知类.
 *
 * @author heyefu
 * @date 2018-08-09-下午10:41
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    /**
     * 增加观察者.
     *
     * @param observer 观察者
     * @author heyefu 下午10:45 18-8-9
     **/
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察者.
     *
     * @author heyefu 下午10:43 18-8-9
     **/
    private void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
