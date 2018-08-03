package mode.structure.decorator;

/**
 * 实现形状接口的抽象装饰类.
 *
 * @auther heyefu
 * @date 2018/8/3 15:11
 */
public abstract class AbstarcShapeDecorator implements Shape {

    private Shape shape;

    public AbstarcShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}
