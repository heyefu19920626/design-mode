package mode.create.abstracfactory;

/**
 * 戴尔键盘.
 *
 * @author heyefu
 * @date 2018-08-04-下午10:48
 **/
public class DellKeyboard implements Keyboard {

    /**
     * 按下键盘事件.
     *
     * @author heyefu 下午10:40 18-8-4
     **/
    public void keyPress() {
        System.out.println("Dell keyboard press!");
    }
}
