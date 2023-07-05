package unit;

public class C {
    private static C c = new C();

    private C() {
    }

    public static C getInstance() {
        return c;
    }

    public String funcC() {
        return "c";
    }
}