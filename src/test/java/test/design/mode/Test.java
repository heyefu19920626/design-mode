package test.design.mode;

import mode.create.simplefactory.BaseCar;
import mode.create.simplefactory.CarFactory;
import mode.create.simplefactory.DzCar;
import mode.structure.decorator.*;

import java.io.IOException;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2018-04-03
 * Time: 11:52
 **/
public class Test {

    /**
     * 测试简单工厂模式.
     *
     **/
    @org.junit.Test
    public void simpleFactory() throws IOException {

        BaseCar bmcar = CarFactory.getBmCar();
        bmcar.dirver();

        BaseCar dzcar = CarFactory.getCar("mode.create.simplefactory.DzCar");
        dzcar.dirver();

        DzCar dzCar = (DzCar) CarFactory.getCar("mode.create.simplefactory.DzCar");
        System.out.println(dzCar.getName());

    }

    @org.junit.Test
    public void abstractFactory() {

        int i = 16;
        int j = (int) Math.sqrt(i);
        System.out.println(j);
        System.out.println(new Test().sqrt(9));

    }

    /**
     * 测试装饰器模式.
     **/
    @org.junit.Test
    public void decoratorPattern() {
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
        Shape yellowRectangle = new YelloShapeDecorator(new Rectangle());
        yellowRectangle.draw();
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();
    }

    public double sqrt(double c) {

        double e = 0.00000000001;
        double x = c;
        int i = 0;
        while (Math.abs(x - c / x) > e) {
            x = (x + c / x) / 2;
            i++;
        }
        System.out.println(i);
        return x;
    }

}
