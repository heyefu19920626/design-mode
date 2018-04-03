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
     * @param carName
     * @return simplefactory.BaseCar
     * @author heyefu 11:59 2018/4/3
     **/
    public static BaseCar getCar(String carName) {
        return null;
    }

    public static BMCar getBMCar() {
        return new BMCar();
    }

    public static DZCar getDZCar() {
        return new DZCar();
    }

}
