package simplefactory;

/**
 * Description:
 * 简单工厂模式
 *
 * @author heyefu
 * Create in: 2018-04-03
 * Time: 11:50
 **/
public class CarFactory {

    /**
     * Description:
     * 利用反射机制获取对象
     *
     * @param carName 需要获取对象的完整类名
     * @return simplefactory.BaseCar
     * @author heyefu 11:59 2018/4/3
     **/
    public static BaseCar getCar(String carName) {
        return null;
    }

    public static BmCar getBmCar() {
        return new BmCar();
    }

    public static DzCar getDzCar() {
        return new DzCar();
    }

}
