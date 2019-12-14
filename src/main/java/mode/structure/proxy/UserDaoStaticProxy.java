package mode.structure.proxy;

/**
 * Description:
 * <p>
 * 静态代理.
 * <p>
 * 代理对象.
 * <p>
 * 理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 *
 * @author heyefu
 * Create in: 2019-12-14
 * Time: 12:37
 **/
public class UserDaoStaticProxy implements IUserDao {

    private IUserDao userDao;

    public UserDaoStaticProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        assert userDao != null;

        System.out.println("---Start Transaction From Static---");
        userDao.save();
        System.out.println("---Commit Transaction From Static---");
    }
}
