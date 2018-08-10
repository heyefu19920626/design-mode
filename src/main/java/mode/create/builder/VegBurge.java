package mode.create.builder;

/**
 * 蔬菜汉堡.
 *
 * @auther heyefu
 * @date 2018/8/10 18:02
 */
public class VegBurge extends Burge{

    /**
     * 食物名称.
     *
     * @return java.lang.String
     **/
    public String name() {

        return "VegBurge";
    }

    /**
     * 食物价格.
     *
     * @return float
     **/
    public float price() {

        return 25.0f;
    }
}
