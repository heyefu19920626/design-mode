package mode.create.builder;

/**
 * 鸡肉汉堡.
 *
 * @auther heyefu
 * @date 2018/8/10 18:04
 */
public class ChickenBurge extends Burge {

    /**
     * 食物名称.
     *
     * @return java.lang.String
     **/
    public String name() {

        return "ChickenBurge";
    }

    /**
     * 食物价格.
     *
     * @return float
     **/
    public float price() {

        return 50.0f;
    }
}
