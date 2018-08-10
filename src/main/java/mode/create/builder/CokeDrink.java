package mode.create.builder;

/**
 * 可口可乐冷饮
 *
 * @auther heyefu
 * @date 2018/8/10 18:05
 */
public class CokeDrink extends ColdDrink {

    /**
     * 食物名称.
     *
     * @return java.lang.String
     **/
    public String name() {

        return "CokeDrink";
    }

    /**
     * 食物价格.
     *
     * @return float
     **/
    public float price() {

        return 30.0f;
    }
}
