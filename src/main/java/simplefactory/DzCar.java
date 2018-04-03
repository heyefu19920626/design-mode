package simplefactory;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2018-04-03
 * Time: 11:49
 **/
public class DzCar extends BaseCar {

    private String name = "DZcar";

    @Override
    public void dirver() {
        System.out.println("我是DZCar!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
