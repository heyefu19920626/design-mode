package mode.create.builder;

/**
 * 百事可乐冷饮.
 *
 * @auther heyefu
 * @date 2018/8/10 18:08
 */
public class PepsiDrink extends ColdDrink {

    /**
     * 食物名称.
     *
     * @return java.lang.String
     **/
    public String name() {

        return "PepsiDrink";
    }

    /**
     * 食物价格.
     *
     * @return float
     **/
    public float price() {

        return 35.0f;
    }
}
