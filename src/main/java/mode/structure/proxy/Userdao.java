package mode.structure.proxy;

/**
 * Description:
 * <p>
 * 目标对象
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 12:36
 **/
public class Userdao implements IUserDao {

    @Override
    public void save() {

        System.out.println("---Save---");
    }
}
