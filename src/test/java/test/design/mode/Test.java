package test.design.mode;

import simplefactory.BaseCar;
import simplefactory.BmCar;
import simplefactory.CarFactory;
import simplefactory.DzCar;

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

        BaseCar dzcar = CarFactory.getCar("simplefactory.DzCar");
        dzcar.dirver();

        DzCar dzCar = (DzCar) CarFactory.getCar("simplefactory.DzCar");
        System.out.println(dzCar.getName());

    }


}
