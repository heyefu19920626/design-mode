package mode.create.builder;

/**
 * 负责创建菜单的工厂.
 * <p>
 * 建造者中有一个指导者，这到这与用户直接相连.
 * 指导者联系建造者建造最后的产品.
 * 建造者适合产品由多个部分组成.
 * <p>
 * 建造者可以校验产品顺序等.
 * <p>
 * 抽象建造者
 * 具体建造者
 * 指导者角色
 * 产品角色
 *
 * @auther heyefu
 * @date 2018/8/10 18:17
 */
public class MealBuilder {

    /**
     * 可口可乐+蔬菜汉堡.
     *
     * @return mode.create.builder.Meal
     **/
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurge());
        meal.addItem(new CokeDrink());

        return meal;
    }

    /**
     * 百事可乐+鸡肉汉堡.
     *
     * @return mode.create.builder.Meal
     **/
    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurge());
        meal.addItem(new PepsiDrink());

        return meal;
    }
}
