package mode.create.simplefactory;

import java.lang.reflect.Constructor;

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
     * Description:<br>
     * 利用反射机制获取对象<br>
     * 完整写法
     *
     * @param carName 需要获取对象的完整类名
     * @return BaseCar
     * @author heyefu 11:59 2018/4/3
     **/
    public static BaseCar getCar(String carName) {

        Class carclass = null;
        Constructor carConstructor;
        try {
            //获取类对象
            carclass = Class.forName(carName);
            //获取构造器
            carConstructor = carclass.getConstructor();
            //新建对象
            BaseCar car = (BaseCar) carConstructor.newInstance();
            return car;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description:<br>
     * 利用反射机制创建类对象<br>
     * 简短写法
     *
     * @param className 类全名
     * @return BaseCar
     * @author heyefu 20:36 2018/4/3
     **/
    public static BaseCar getCarByReflect(String className) {
        try {
            BaseCar car = (BaseCar) Class.forName(className).newInstance();
            return car;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Description:
     * 测试git的ssh
     *
     * @param
     * @return mode.create.simplefactory.BmCar
     * @author tang 下午1:46 18-5-1
     **/
    public static BmCar getBmCar() {
        return new BmCar();
    }

    public static DzCar getDzCar() {
        return new DzCar();
    }

}
