package mode.structure.proxy;

/**
 * Description:
 * <p>
 * 需要代理的目标对象.
 * <p>
 * 没有实现接口，可以使用Cglib代理.
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 13:01
 **/
public class StandaloneUserDao {

    public void save() {
        System.out.println("---Save---");
    }
}
