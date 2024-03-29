package test.design.mode;

import mode.behavioral.observer.BinaryObserver;
import mode.behavioral.observer.HexaObserver;
import mode.behavioral.observer.OctalObserver;
import mode.behavioral.observer.Subject;
import mode.create.abstracfactory.AbstractPcFactory;
import mode.create.abstracfactory.DellPcFactory;
import mode.create.abstracfactory.HpPcFactory;
import mode.create.abstracfactory.Keyboard;
import mode.create.abstracfactory.Mouse;
import mode.create.builder.Meal;
import mode.create.builder.MealBuilder;
import mode.create.simplefactory.BaseCar;
import mode.create.simplefactory.CarFactory;
import mode.create.simplefactory.DzCar;
import mode.create.singleton.IdlerSingletonPattern;
import mode.create.singleton.SingletonPattern;
import mode.structure.decorator.Circle;
import mode.structure.decorator.Rectangle;
import mode.structure.decorator.RedShapeDecorator;
import mode.structure.decorator.Shape;
import mode.structure.decorator.YelloShapeDecorator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2018-04-03
 * Time: 11:52
 **/
public class TestProxyModel {

    /**
     * 测试简单工厂模式.
     **/
    @Test
    public void simpleFactory() throws IOException {

        BaseCar bmcar = CarFactory.getBmCar();
        bmcar.dirver();

        BaseCar dzcar = CarFactory.getCar("mode.create.simplefactory.DzCar");
        dzcar.dirver();

        DzCar dzCar = (DzCar) CarFactory.getCar("mode.create.simplefactory.DzCar");
        System.out.println(dzCar.getName());

    }

    /**
     * 测试抽象工厂模式.
     *
     * @author heyefu 下午11:11 18-8-4
     **/
    @Test
    public void abstractFactory() {

        AbstractPcFactory dellPcFactory = new DellPcFactory();
        Mouse dellMouse = dellPcFactory.createMouse();
        Keyboard dellKeyboard = dellPcFactory.createKeyboard();
        dellMouse.click();
        dellKeyboard.keyPress();

        AbstractPcFactory hpPcFactory = new HpPcFactory();
        Mouse hpMouse = hpPcFactory.createMouse();
        Keyboard hpKeyboard = hpPcFactory.createKeyboard();
        hpMouse.click();
        hpKeyboard.keyPress();

    }

    /**
     * 测试单例模式.
     *
     * @author heyefu 下午10:14 18-8-5
     **/
    @Test
    public void singletonPattern() {
//        饿汉式
        SingletonPattern singletonPattern = SingletonPattern.getSinletonPattern();
        singletonPattern.showMessage();

//        懒汉式，线程安全，借用classloader机制
        IdlerSingletonPattern lazySingleton = IdlerSingletonPattern.getIdlerSingletonPattern();
        lazySingleton.showMessage();

    }


    /**
     * 测试建造者模式.
     *
     * @author heyefu 下午8:53 18-8-11
     **/
    @Test
    public void builderPattern() {

        MealBuilder mealBuilder = new MealBuilder();
        Meal mealVegBurge = mealBuilder.prepareVegMeal();
        mealVegBurge.showItems();
        System.out.println(mealVegBurge.getCost());

        System.out.println("--------------------");

        Meal nonMeal = mealBuilder.prepareNonVegMeal();
        nonMeal.showItems();
        System.out.println(nonMeal.getCost());

    }

    /**
     * 测试装饰器模式.
     **/
    @Test
    public void decoratorPattern() {
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
        Shape yellowRectangle = new YelloShapeDecorator(new Rectangle());
        yellowRectangle.draw();
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();
    }

    @Test
    public void observerPattern() {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new BinaryObserver(subject);
        new OctalObserver(subject);

        System.out.println("---------------");
        subject.setState(16);
        System.out.println("--------------");
        subject.setState(8);

    }

    /**
     * 牛顿迭代法求平方根.
     *
     * @param c 需要求平方根的目标数
     * @return double 平方根
     * @author heyefu 下午11:11 18-8-4
     **/
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
