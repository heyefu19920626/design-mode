package mode.create.abstracfactory;

/**
 * 戴尔PC.
 *
 * @author heyefu
 * @date 2018-08-04-下午11:06
 **/
public class DellPcFactory extends AbstractPcFactory {

    /**
     * 创建鼠标.
     *
     * @return mode.create.abstracfactory.Mouse
     * @author heyefu 下午11:05 18-8-4
     **/
    public Mouse createMouse() {
        return new DellMouse();
    }

    /**
     * 创建键盘.
     *
     * @return mode.create.abstracfactory.Keyboard
     * @author heyefu 下午11:06 18-8-4
     **/
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
