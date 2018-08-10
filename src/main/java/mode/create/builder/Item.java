package mode.create.builder;

/**
 * 条目接口.
 *
 * @auther heyefu
 * @date 2018/8/10 17:49
 */
public interface Item {

    /**
     * 食物名称.
     *
     * @return java.lang.String
     **/
    String name();

    /**
     * 食物包装.
     *
     * @return mode.create.builder.Packing
     **/
    Packing packing();

    /**
     * 食物价格.
     *
     * @return float
     **/
    float price();
}
