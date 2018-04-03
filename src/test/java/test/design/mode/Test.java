package test.design.mode;

import mode.create.simplefactory.BaseCar;
import mode.create.simplefactory.CarFactory;
import mode.create.simplefactory.DzCar;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2018-04-03
 * Time: 11:52
 **/
public class Test {

    @org.junit.Test
    public void simpleFactory() {

        BaseCar bmcar = CarFactory.getBmCar();
        bmcar.dirver();

        BaseCar dzcar = CarFactory.getCar("mode.create.simplefactory.DzCar");
        dzcar.dirver();

        DzCar dzCar = (DzCar) CarFactory.getCar("mode.create.simplefactory.DzCar");
        System.out.println(dzCar.getName());

    }


}
