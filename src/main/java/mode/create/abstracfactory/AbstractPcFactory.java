package mode.create.abstracfactory;

/**
 * PC设备抽象类.
 * <p>
 * 抽象工厂模式：
 * １.　具有多个产品族
 * 2. 一次只能使用一个族
 *
 * @author heyefu
 * @date 2018-08-04-下午10:56
 **/
public abstract class AbstractPcFactory {

    /**
     * 创建鼠标.
     *
     * @return mode.create.abstracfactory.Mouse
     * @author heyefu 下午11:05 18-8-4
     **/
    public abstract Mouse createMouse();

    /**
     * 创建键盘.
     *
     * @return mode.create.abstracfactory.Keyboard
     * @author heyefu 下午11:06 18-8-4
     **/
    public abstract Keyboard createKeyboard();

}
