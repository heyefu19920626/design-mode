package mode.create.abstracfactory;

/**
 * 惠普PC.
 *
 * @author heyefu
 * @date 2018-08-04-下午11:08
 **/
public class HpPcFactory extends AbstractPcFactory {

    /**
     * 创建鼠标.
     *
     * @return mode.create.abstracfactory.Mouse
     * @author heyefu 下午11:05 18-8-4
     **/
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    /**
     * 创建键盘.
     *
     * @return mode.create.abstracfactory.Keyboard
     * @author heyefu 下午11:06 18-8-4
     **/
    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
