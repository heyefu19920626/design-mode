package mode.structure.decorator;

/**
 * @auther heyefu
 * @date 2018/8/3 15:22
 */
public class YelloShapeDecorator extends AbstarcShapeDecorator {
    public YelloShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        System.out.println("I have a yellow border.");
        super.draw();
    }
}
