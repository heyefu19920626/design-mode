package mode.create.builder;

/**
 * 负责创建菜单的工厂.
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
