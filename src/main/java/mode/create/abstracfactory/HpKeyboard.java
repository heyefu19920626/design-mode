package mode.create.abstracfactory;

/**
 * 惠普键盘实现类.
 *
 * @author heyefu
 * @date 2018-08-04-下午10:54
 **/
public class HpKeyboard implements Keyboard {

    /**
     * 按下键盘事件.
     *
     * @author heyefu 下午10:40 18-8-4
     **/
    public void keyPress() {
        System.out.println("HP keyboard press!");
    }
}
