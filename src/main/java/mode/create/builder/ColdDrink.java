package mode.create.builder;

/**
 * 实现条目的冷饮类.
 *
 * @auther heyefu
 * @date 2018/8/10 18:01
 */
public abstract class ColdDrink implements Item {

    /**
     * 食物包装.
     *
     * @return mode.create.builder.Packing
     **/
    public Packing packing() {

        return new Bottle();
    }
}
