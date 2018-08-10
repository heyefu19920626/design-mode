package mode.create.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 膳食菜单类.
 *
 * @auther heyefu
 * @date 2018/8/10 18:10
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    /**
     * 将点菜条目加入菜单.
     *
     * @param item
     * @return void
     **/
    public void addItem(Item item) {

        items.add(item);
    }

    /**
     * 获取总消费额.
     *
     * @return float
     **/
    public float getCost() {
        float cost = 0;

        for (Item item : items) {
            cost += item.price();
        }

        return cost;
    }

    /**
     * 展示菜单所有项目.
     *
     **/
    public void showItems() {
        for (Item item : items) {
            System.out.print("Item: " + item.name());
            System.out.print(",Packing: " + item.packing().pack());
            System.out.println(",price: " + item.price());
        }
    }

}
