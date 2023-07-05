package unit;

public class A {
    private static A a = new A();
    private B b = new B();

    public String funcA() {
        return b.funcB();
    }

    public String useSingle() {
        return C.getInstance().funcC();
    }

    public static A getInstance() {
        return a;
    }

    public String useCAddA() {
        return C.getInstance().funcC() + "_A";
    }
}