package mode.structure.decorator;

/**
 * 实体装饰类.
 *
 * @auther heyefu
 * @date 2018/8/3 15:14
 */
public class RedShapeDecorator extends AbstarcShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        System.out.println("I have a Red border.");
        super.draw();
    }
}
