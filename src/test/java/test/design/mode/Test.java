package test.design.mode;

import simplefactory.BaseCar;
import simplefactory.CarFactory;

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

        BaseCar bmcar = CarFactory.getBMCar();
        bmcar.dirver();


    }


}
