package mode.create.builder;

/**
 * 实现条目的汉堡抽象类.
 *
 * @auther heyefu
 * @date 2018/8/10 17:58
 */
public abstract class Burge implements Item {

    /**
     * 食物包装.
     *
     * @return mode.create.builder.Packing
     **/
    public Packing packing() {

        return new Wrapper();
    }

}
