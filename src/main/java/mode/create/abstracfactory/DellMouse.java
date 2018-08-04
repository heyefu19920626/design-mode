package mode.create.abstracfactory;

/**
 * 戴尔鼠标.
 *
 * @author heyefu
 * @date 2018-08-04-下午10:46
 **/
public class DellMouse implements Mouse {

    /**
     * 鼠标点击事件.
     *
     * @author heyefu 下午10:45 18-8-4
     **/
    public void click() {
        System.out.println("Dell Mouse click!");
    }
}
